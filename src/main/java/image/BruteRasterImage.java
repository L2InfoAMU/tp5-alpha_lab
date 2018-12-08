package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage{

    private Color[][] pixels;


    public BruteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] pixels){
        super(pixels);
    }

    public void createRepresentation(){
        pixels = new Color[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y){
        requiresValidCoordinates(x,y);
        return pixels[x][y];
    }

    public void setPixelColor(Color color, int x, int y){
        requiresNonNullColor(color);
        requiresValidCoordinates(x,y);
        pixels[x][y] = color;
    }

    public void clearPixels(){
        createRepresentation();
    }

    public void setPixelsColor(Color[][] pixels){
        super.setPixelsColor(pixels);
    }

    public void setPixelsColor(Color color){
        super.setPixelsColor(color);
    }

}
