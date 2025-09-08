package br.com.mariojp.figureeditor;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Factory {
    private static final int DEFAULT_SIZE = 60;

    public static Shape getShape(double x , double y, int tipo){
        int size = Math.max(Math.min(DEFAULT_SIZE, DEFAULT_SIZE), tipo);
        Shape s;
        if(tipo == 1){
            s = new Ellipse2D.Double(x, y, size, size);
        }else{
            s = new Rectangle2D.Double(x, y, Math.max(DEFAULT_SIZE, 10), Math.max(DEFAULT_SIZE, 10));
        }
        return s;
    }
}
