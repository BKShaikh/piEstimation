/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.ui.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Shaikh
 */
public class SimTable1 {

     public final IntegerProperty replicationProperty() {
		return this.replication;
	}
    
    public final int getReplication() {
        return this.replicationProperty().get();
    }

    public void setReplication(final int replication) {
        this.replicationProperty().set(replication);
        }

   
    public final IntegerProperty sampleSizeProperty() {
		return this.sampleSize;
	}

	public final int getSampleSize() {
		return this.sampleSizeProperty().get();
	}

	public final void setSampleSize(final int sampleSize) {
		this.sampleSizeProperty().set(sampleSize);
	}
    
         public final IntegerProperty hitCountProperty() {
		return this.hitCount;
	}

	public final int getHitCount() {
		return this.hitCountProperty().get();
                
	}
	public final void setHitCount(final int hitCount) {
		this.hitCountProperty().set(hitCount);
	}
        
        
        
        
        
        public final DoubleProperty estimatedPiProperty() {
		return this.estimatedPi;
	}

	public final double getEstimatedPi() {
		return this.estimatedPiProperty().get();
	}

	public final void setEstimatedPi(final double estimatedPi) {
		this.estimatedPiProperty().set(estimatedPi);
	}
        
        public final DoubleProperty varianceProperty() {
		return this.variance;
	}

	public final double getVariance() {
		return this.varianceProperty().get();
	}

	public final void setVariance(final double variance) {
		this.varianceProperty().set(variance);
	}
    
public final DoubleProperty cilbProperty() {
		return this.cilb;
	}

	public final double getCilb() {
		return this.cilbProperty().get();
	}

	public final void setCilb(final double cilb) {
		this.cilbProperty().set(cilb);
	}
        
public final DoubleProperty finalVarianceProperty() {
		return this.finalVariance;
	}

	public final double getFinalVariance() {
		return this.finalVarianceProperty().get();
	}

	public final void setFinalVariance(final double finalVariance) {
		this.finalVarianceProperty().set(finalVariance);
	}
    
        public final DoubleProperty standardDeviationProperty() {
		return this.standardDeviation;
	}

	public final double getStandardDeviation() {
		return this.standardDeviationProperty().get();
	}

	public final void setstandardDeviation(final double standardDeviation) {
		this.standardDeviationProperty().set(standardDeviation);
	}
                               
        public final DoubleProperty ciubProperty() {
		return this.ciub;
	}

	public final double getCiub() {
		return this.ciubProperty().get();
	}

	public final void setCiub(final double ciub) {
		this.ciubProperty().set(ciub);
	}
        
    private IntegerProperty replication = new SimpleIntegerProperty();
    private IntegerProperty sampleSize = new SimpleIntegerProperty();
   private IntegerProperty hitCount = new SimpleIntegerProperty();
    private DoubleProperty estimatedPi = new SimpleDoubleProperty();
    private DoubleProperty variance = new SimpleDoubleProperty();
    private DoubleProperty finalVariance = new SimpleDoubleProperty();
   private DoubleProperty standardDeviation = new SimpleDoubleProperty();
    private DoubleProperty cilb = new SimpleDoubleProperty();
    private DoubleProperty ciub = new SimpleDoubleProperty();
    
    
    
    public SimTable1(int replication , int sampleSize, int hitCount , double estimatedPi,double variance,double finalVariance,double standardDeviation,double cilb,double ciub) 
    {
         super();
         this.replication.set(replication);
         this.cilb.set(cilb);
         this.ciub.set(ciub);
         this.estimatedPi.set(estimatedPi);
         this.finalVariance.set(finalVariance);
         this.hitCount.set(hitCount);
         this.sampleSize.set(sampleSize);
         this.standardDeviation.set(standardDeviation);
         this.variance.set(variance);
         
         
    }
    
    
    
}
