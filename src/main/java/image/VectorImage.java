package image;

import javafx.scene.paint.Color;

import java.util.List;
import util.Window;

public class VectorImage implements Image {

    private List<Shape> shapes;
    private int width, height;

    VectorImage(List<Shape> shapes, int width, int height){

        if(shapes == null) throw new
                IllegalArgumentException("Shapes cannot be null");
        Window.requiresStrictPositiveHeight(height);
        Window.requiresStrictPositiveWidth(width);

        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    public Color getPixelColor(int x, int y){
        Window.requiresValidCoordinates(x,y,this.getHeight(),this.getWidth());
        Point p = new Point(x,y);
        for (Shape shape : shapes) {
            if (shape.contains(p))
                return shape.getColor();
        }
        return Color.WHITE;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    protected void setWidth(int width){
        Window.requiresStrictPositiveWidth(width);
        this.width = width;
    }

    protected void setHeight(int height){
        Window.requiresStrictPositiveHeight(height);
        this.height = height;
    }


}
