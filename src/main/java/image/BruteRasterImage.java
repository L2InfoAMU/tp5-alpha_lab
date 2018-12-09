package image;

import javafx.scene.paint.Color;
import util.Window;

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

    public Color getPixelColor(Point point){
        Window.requiresValidCoordinates(point, this.getHeight(),this.getWidth());
        return pixels[point.x][point.y];
    }

    public void setPixelColor(Pixel pixel){
        Window.requiresValidCoordinates(pixel, this.getHeight(),this.getWidth());
        pixels[pixel.x][pixel.y] = pixel.getColor();
    }

    public void clearPixels(){
        createRepresentation();
    }

}
