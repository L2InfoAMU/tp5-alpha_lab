package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import util.Window;

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

    public Color getPixelColor(Point point){
        Window.requiresValidCoordinates(point, this.getHeight(),this.getWidth());
        int indexOfPixel = indexesOfColors[point.x][point.y];
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Pixel pixel){
        Window.requiresNonNullPixelColor(pixel);
        Window.requiresValidCoordinates(pixel, this.getHeight(),this.getWidth());
        if(!palette.contains(pixel.getColor())) palette.add(pixel.getColor());
        indexesOfColors[pixel.x][pixel.y] = palette.indexOf(pixel.getColor());
    }

    public void clearPixels(){
        palette.clear();
    }

    public void setPixelsColor(Color color){
        super.setPixelsColor(color);
        palette.add(color);
    }
}