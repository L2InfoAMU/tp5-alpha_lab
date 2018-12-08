package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.HashMap;
import java.util.Map;

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
        requiresValidCoordinates(x,y);
        Point point = new Point(x,y);
        requiresPresenceOfPoint(point);
        return pixelsMap.get(point);
    }

    public Color getPixel(int x, int y){
        Point point = new Point(x,y);
        requiresPresenceOfPoint(point);
        return pixelsMap.get(point);
    }

    public void setPixelColor(Color color, int x, int y) {
        requiresNonNullColor(color);
        requiresValidCoordinates(x,y);
        Point point = new Point(x,y);
        pixelsMap.put(point,color);
    }

    public void clearPixels(){
        pixelsMap.clear();
    }

    public void setPixelsColor(Color [][] pixels) {
        super.setPixelsColor(pixels);
    }

    public void setPixelsColor(Color color) {
        super.setPixelsColor(color);
    }



}
