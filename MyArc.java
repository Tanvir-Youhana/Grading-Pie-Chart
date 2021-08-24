package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class MyArc extends MyShape {
    MyPoint p;
    double w;
    double l;
    double startAngle;
    double arcExtent;
    GraphicsContext graphics;

    // Constructor
    MyArc(GraphicsContext graphics, MyPoint p, double w,double l, double startAngle, double arcExtent, Color color) {
        this.p=p;
        this.w=w;
        this.l=w;
        this.startAngle= startAngle;
        this.arcExtent=arcExtent;
        this.color= color;
        this.graphics=graphics;
    }


    @Override
    public String toString()
    {
        return "The start angle is: " +  startAngle+ "\nThe end angle is: "+ arcExtent+ "\nThe width is: "+ w+ "\nThe length is: " + l;
    }

    @Override
    public void draw(GraphicsContext Graphics) {
        Graphics.setFill(color);
        Graphics.fillArc(p.getX(),p.getY(),w,l,startAngle,arcExtent, ArcType.ROUND);
    }








    @Override
    public MyRectangle getMyBoundingRectangle() {
        return null;
    }

    @Override
    public double getMyArea() {
        return 0;
    }
}
