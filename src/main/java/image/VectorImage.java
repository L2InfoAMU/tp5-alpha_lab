package image;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Objects;

import util.Window;

public class VectorImage implements Image {

    private List<Shape> shapes;
    private int width, height;

    VectorImage(List<Shape> shapes, int width, int height){

        Objects.requireNonNull(shapes, "List of shapes cannot be null");
        Window.requiresStrictPositiveHeight(height);
        Window.requiresStrictPositiveWidth(width);

        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    public Color getPixelColor(Point point){

        Window.requiresValidCoordinates(point, this.getHeight(),this.getWidth());

        for (Shape shape : shapes) {
            if (shape.contains(point))
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
