package br.com.mariojp.figureeditor;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RectangleFactory {
    private static final int DEFAULT_SIZE = 60;

    public Shape getShape(double x , double y, int tipo){
        int size = Math.max(Math.min(DEFAULT_SIZE, DEFAULT_SIZE), tipo);
        Shape s = new Rectangle2D.Double(x, y, Math.max(DEFAULT_SIZE, 10), Math.max(DEFAULT_SIZE, 10));
        return s;
    }
}
