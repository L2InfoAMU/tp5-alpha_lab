package image;

import javafx.scene.paint.Color;

public class BruteRasterImage {

    private int width;
    private int height;
    private Color[][] pixels;


    public void createRepresentation(){
        pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

}
