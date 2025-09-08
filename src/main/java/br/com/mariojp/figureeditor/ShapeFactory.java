package br.com.mariojp.figureeditor;

import java.awt.Shape;

public class ShapeFactory {

    public Shape getShape(double x, double y, int tipo) {
       if(tipo == 1){
        return new EllipseFactory().getShape(x, y, tipo);
       } else {
        return new RectangleFactory().getShape(x, y, tipo);
       }
    }
    
} 
