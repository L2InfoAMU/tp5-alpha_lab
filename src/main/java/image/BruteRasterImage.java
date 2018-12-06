package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image{

    private int width;
    private int height;
    private Color[][] pixels;


    public BruteRasterImage(Color color, int width, int height){
        setHeight(height);
        setWidth(width);
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] pixels){
        setHeight(height);
        setWidth(width);
        createRepresentation();
        setPixelsColor(pixels);
    }

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
                setPixelColor(color,i,j);
            }
        }
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

}
