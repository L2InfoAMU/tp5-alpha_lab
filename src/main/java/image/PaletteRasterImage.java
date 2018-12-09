package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import util.Window;
import util.PixelColor;

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
        palette = new ArrayList<>();
        indexesOfColors = new int[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y){
        Window.requiresValidCoordinates(x,y, this.getHeight(),this.getWidth());
        int indexOfPixel = indexesOfColors[x][y];
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Color color, int x, int y){
        PixelColor.requiresNonNullColor(color);
        Window.requiresValidCoordinates(x,y,this.getHeight(),this.getWidth());
        if(!palette.contains(color)) palette.add(color);
        indexesOfColors[x][y] = palette.indexOf(color);
    }

    public void clearPixels(){
        palette.clear();
    }

    public void setPixelsColor(Color color){
        super.setPixelsColor(color);
        palette.add(color);
    }
}