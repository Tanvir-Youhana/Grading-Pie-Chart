package sample;

import java.util.Random;
import javafx.scene.paint.Color;

// this enum represents a COLOR
public enum MyColor {
    BLACK(0,0,0), WHITE(255,255,255);

    int Red, Green, Blue;

    MyColor(int red, int green, int blue) {
        this.Red = red;
        this.Green = green;
        this.Blue = blue;
    }

    // If a custom color is set
    public Color getColor(){
        return Color.rgb(Red,Green,Blue);
    }

    //For black Color
    public static Color BLACK()
    {
        return Color.rgb(0,0,0);
    }
    //For WHITE background
    public static Color WHITE()
    {
        return Color.rgb(255,255,255);
    }
    //For green color
    public static Color Green() { return Color.rgb(0,128,0);}
    // For Red color
    public static Color Red() { return Color.rgb(255,0,0);}
    //For Yellow Color
    public static Color Yellow() { return Color.rgb(255,255,0);}
    //For Blue Color
    public static Color Blue() { return Color.rgb(0,0,255);}
    //For Purple Color
    public static Color Purple() { return Color.rgb(128,0,128);}
    //For Pink Color
    public static Color Pink() {return Color.rgb(255,192,203);}
    // For some random Color for each shape
    public static Color getRandomColor(){
        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
        return Color.rgb(r,g,b);
    }
    @Override
    public String toString(){
        return "R:" + Red + " G:" + Green + " B:" +Blue;
    }
}