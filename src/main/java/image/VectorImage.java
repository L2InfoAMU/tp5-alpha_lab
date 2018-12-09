package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class VectorImage implements Image {

    private List<Shape> shapes;
    private int width, height;

    VectorImage(List<Shape> shapes, int width, int height){
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    public Color getPixelColor(int x, int y){
        Point p = new Point(x,y);
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).contains(p))
                return shapes.get(i).getColor();
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
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }


}
