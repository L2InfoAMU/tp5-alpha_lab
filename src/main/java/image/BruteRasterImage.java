package image;

import javafx.scene.paint.Color;
import util.Window;
import util.PixelColor;

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
        Window.requiresValidCoordinates(x,y,this.getHeight(),this.getWidth());
        return pixels[x][y];
    }

    public void setPixelColor(Color color, int x, int y){
        PixelColor.requiresNonNullColor(color);
        Window.requiresValidCoordinates(x,y,this.getHeight(),this.getWidth());
        pixels[x][y] = color;
    }

    public void clearPixels(){
        createRepresentation();
    }

}
