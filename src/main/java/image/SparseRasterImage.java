package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import util.Window;
import util.Pixel;

public class SparseRasterImage extends RasterImage {

    private Map<Point, Color> pixelsMap;

    public SparseRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] pixels){
        super(pixels);
    }

    public void createRepresentation()
    {
        pixelsMap = new HashMap<>();
    }

    private void requiresPresenceOfPoint(Point point){
        if(!(pixelsMap.containsKey(point)))
            throw new IllegalArgumentException(("Cannot find pixel"));
    }

    public Color getPixelColor(int x, int y)
    {
        Window.requiresValidCoordinates(x,y, this.getHeight(),this.getWidth());
        Point point = new Point(x,y);
        requiresPresenceOfPoint(point);
        return pixelsMap.get(point);
    }

    public void setPixelColor(Color color, int x, int y) {
        Pixel.requiresNonNullColor(color);
        Window.requiresValidCoordinates(x,y,this.getHeight(),this.getWidth());
        Point point = new Point(x,y);
        pixelsMap.put(point,color);
    }

    public void clearPixels(){
        pixelsMap.clear();
    }



}
