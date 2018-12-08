package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    private List<Color> palette;
    private int[][] indexesOfColors;


    public PaletteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] pixels){
        super(pixels);
    }

    public void createRepresentation(){
        palette = new ArrayList<Color>();
        indexesOfColors = new int[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y){
        requiresValidCoordinates(x,y);
        int indexOfPixel = indexesOfColors[x][y];
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Color color, int x, int y){
        requiresNonNullColor(color);
        requiresValidCoordinates(x,y);
        if(!palette.contains(color)) palette.add(color);
        indexesOfColors[x][y] = palette.indexOf(color);
    }

    public void clearPixels(){
        palette.clear();
    }

    public void setPixelsColor(Color[][] pixels){
        super.setPixelsColor(pixels);
    }

    public void setPixelsColor(Color color){
        super.setPixelsColor(color);
        palette.add(color);
    }
}