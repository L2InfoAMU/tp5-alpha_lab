package image;

import javafx.scene.paint.Color;

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





}
