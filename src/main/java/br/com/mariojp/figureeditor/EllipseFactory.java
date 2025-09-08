package br.com.mariojp.figureeditor;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseFactory {
    private static final int DEFAULT_SIZE = 60;

    public Shape getShape(double x , double y, int tipo){
        int size = Math.max(Math.min(DEFAULT_SIZE, DEFAULT_SIZE), tipo);
        Shape s = new Ellipse2D.Double(x, y, size, size);
        return s;
    }
}
