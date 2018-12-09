package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    private int x,y,width,height;
    private Color color;
    private Point p1,p2,p3,p4;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.color = color;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;


        p1 = new Point(x,y);
        p2 = new Point(p1.x+width, p1.y);
        p3 = new Point(p1.x, p1.y+height);
        p4 = new Point(p1.x+width, p1.y + height);

    }

    public boolean contains(Point point){
        if(point.x >= p1.x && point.x <= p2.x
                && point.y >= p1.y && point.y <= p3.y )
            return true;
        return false;
    }

    public Color getColor(){
        return this.color;
    }

}
