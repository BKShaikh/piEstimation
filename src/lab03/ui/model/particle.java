/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.ui.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

/**
 *
 * @author Sahar
 */
public class particle extends Circle {

    double x;
    double y;
    double angle = 0.0;
    double speed = 0.0;
    double mass = 1;
    boolean selected = false;

    public particle(Color color, double x, double y) {
        super(x, y, 2);
        this.x = x;
        this.y = y;
        setFill(color.deriveColor(1, 1, 1, 0.5));
        setStroke(color);
        setStrokeWidth(2);
        setStrokeType(StrokeType.INSIDE);

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
