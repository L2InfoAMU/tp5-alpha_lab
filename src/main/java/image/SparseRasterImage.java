package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import util.Window;

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

    public Color getPixelColor(Point point)
    {
        Window.requiresValidCoordinates(point, this.getHeight(),this.getWidth());
        requiresPresenceOfPoint(point);
        return pixelsMap.get(point);
    }

    public void setPixelColor(Pixel pixel) {
        Window.requiresValidCoordinates(pixel, this.getHeight(),this.getWidth());
        Point point = new Point(pixel.x,pixel.y);
        pixelsMap.put(point,pixel.getColor());
    }

    public void clearPixels(){
        pixelsMap.clear();
    }



}
