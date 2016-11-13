/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.service;

import java.util.List;
import java.util.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import lab03.ui.model.SimTable1;
import lab03.ui.model.particle;

/**
 *
 * @author Shaikh
 */
public interface SimulationService {

    List<particle> getParticles(int SampleSize, double radius, Canvas canvas);

    int getHitCount(List<particle> particles, Circle circle);

    List<SimTable1> getTableData(Circle circle, Map<Integer, List<particle>> sampleMaxp);

    SimTable1 getTableDate(int replication, int sampleSize, int hitCount);

}
