package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    private Color color;
    private Point p1,p2;

    public Rectangle(int x, int y, int width, int height, Color color){
        if(color == null) throw new IllegalArgumentException("Color cannot be null");

        this.color = color;
        p1 = new Point(x,y);
        p2 = new Point(p1.x+width, p1.y + height);
    }

    public boolean contains(Point point){
        return point.x >= p1.x && point.x <= p2.x
                && point.y >= p1.y && point.y <= p2.y;
    }

    public Color getColor(){
        return this.color;
    }

}
