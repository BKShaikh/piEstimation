/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lab03.service.SimulationService;
import lab03.ui.model.particle;
import lab03.ui.model.SimTable1;
/**
 *
 * @author Shaikh
 */
    
public class SimulationServiceImpl implements SimulationService {

    @Override
    public List<particle> getParticles(int SampleSize, double radius, Canvas canvas) {
        List<particle> particles = new ArrayList<>();
        double width = 2 * radius;
        double height = 2 * radius;
        double uperx = canvas.getWidth() / 2 - width/2;
        double upery = canvas.getHeight() / 2 - height/2;
        
        System.out.println(canvas);
        
        
        for (int i = 0; i < SampleSize; i++) {
            double aX = uperx;
            double bX = uperx + width;
            double x = aX + Math.random() * (bX - aX);
            
            double aY = upery;
            double bY = upery + height;
            double y = aY + Math.random() * (bY - aY);
            
            System.out.println(x + " -----       " + y);
            
            particle p = new particle(Color.RED, x, y);
            particles.add(p);
        }
        
        return particles;
    }

    @Override
    public int getHitCount(List<particle> particles, Circle circle) {
        int hitCount = 0;
        if (!particles.isEmpty()) {
            for (particle p : particles) {
                double x = p.getX();
                double y = p.getY();
                System.out.println("x"+x);
                System.out.println("y"+y);
                
                if (circle.contains(new Point2D(x, y))) {
                    hitCount++;
        
                }
            }
        }
       // System.out.println("hit count"+ hitCount);
        return hitCount;
    }

    
    @Override
    public List<SimTable1> getTableData(Circle circle, Map<Integer, List<particle>> sampleMaxp) {

        List<SimTable1> simTable = null;
        if (!sampleMaxp.isEmpty()) {
            simTable = new ArrayList<>();
            int replication = 1;
            for (Map.Entry<Integer, List<particle>> entry : sampleMaxp.entrySet()) {
                int sample = entry.getKey();
                List<particle> particles = entry.getValue();
                int hitCount = getHitCount(particles, circle);
                SimTable1 tableData = getTableDate(replication++, sample, hitCount);
                if (tableData != null) {
                    simTable.add(tableData);
                }
            }
        }
        return simTable;
    }

    @Override
    public SimTable1 getTableDate(int replication, int sampleSize, int hitCount) {
        //System.err.println("rep"+replication);
        //System.out.println("samp"+sampleSize);
        double div = ((double) hitCount / sampleSize);
        double pi = 4 * ((double) hitCount / sampleSize);
        String es = String.valueOf(pi);
        Double pii = Double.valueOf(es);

        double bernolii = Math.PI / 4.0;
        double first = ((1 - bernolii) * (1 - bernolii) * hitCount);
        double second = (sampleSize - hitCount) * ((0 - bernolii) * (0 - bernolii));
        double variance = (first + second) / (sampleSize - 1);

        double fvariance = variance * (16.0 / sampleSize);
        double sd = Math.sqrt(fvariance);
        double cilb = pi+((2.85 * sd) / Math.sqrt(sampleSize));

        double cuib = pi-((2.85 * sd) / Math.sqrt(sampleSize));
        //System.out.println("pi"+pii);       
// System.out.println("r   "+replication+"s    "+sampleSize+"h "+ hitCount+"p  "+ pii+"v   "+ variance+ "fv    "+fvariance+"sd "+ sd+ "cl  "+cilb+"ci"+cuib);
        return new SimTable1(replication, sampleSize, hitCount, pii, variance, fvariance, sd, cilb, cuib);

    }

}
