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

    public void createrepresentation()
    {
        pixelsMap = new HashMap<>();
    }

    private void requiresPresenceOfPoint(Point point){
        if(!(pixelsMap.containsKey(point)))
            throw new IllegalArgumentException(("Cannot find pixel"));
    }

    public Color getPixelColor(int x, int y)
    {
        requiresValidCoordinates(x, y);
        Point point = new Point(x,y);
        requiresPresenceOfPoint(point);
        return pixelsMap.get(point);
    }

    public void setPixelColor(Color color, int x, int y)
    {
        requiresNonNullColor(color);
        requiresValidCoordinates(x,y);
        Point point = new Point(x,y);
        pixelsMap.put(point,color);
    }

    public void setPixelsColor(Color [][] pixels) {

        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        pixelsMap.clear();

        for(int i=0; i<this.getWidth(); i++){
            for (int j=0; j<this.getHeight();j++) {
                Color currentColor = pixels[i][j];
                setPixelColor(currentColor,i,j);
            }
        }
    }

    public void setPixelsColor(Color color) {
        requiresNonNullColor(color);

        pixelsMap.clear();

        for(int i=0; i<this.getWidth();i++) {
            for(int j=0; j<this.getHeight();j++) {
                setPixelColor(color,i,j);
            }
        }
    }



}
