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

    public Color getPixelColor(int x, int y){
        return pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
        this.pixels = pixels;
    }

    private void setPixelsColor(Color color){
        for(int i=0; i<width;i++){
            for(int j=0; j<height;j++){
                pixels[i][j] = color;
            }
        }
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }


}
