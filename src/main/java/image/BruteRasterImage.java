package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image{

    private int width;
    private int height;
    private Color[][] pixels;


    public BruteRasterImage(Color color, int width, int height){

        if(width < 0)
            throw new IllegalArgumentException("width cannot be less than 0");
        if(height < 0)
            throw new IllegalArgumentException("height cannot be less than 0");
        if (color == null)
            throw new NullPointerException("Color cannot be null");

        setHeight(height);
        setWidth(width);

        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] pixels){

        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        setHeight(pixels[0].length);
        setWidth(pixels.length);

        createRepresentation();
        setPixelsColor(pixels);
    }

    public void createRepresentation(){
        pixels = new Color[width][height];
    }

    public Color getPixelColor(int x, int y){
        if(x<0 || y<0 || x>=pixels.length || y>=pixels[0].length)
            throw new IllegalArgumentException("x or y cannot be outside the array bonds");
        return pixels[x][y];
    }

    public void setPixelColor(Color color, int x, int y){
        if (color == null)
            throw new NullPointerException("Color cannot be null");
        if(x<0 || y<0 || x>=pixels.length || y>=pixels[0].length)
            throw new IllegalArgumentException("x or y cannot be outside the array bonds");
        pixels[x][y] = color;
    }

    private void setPixelsColor(Color[][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        this.pixels = pixels.clone();
    }

    private void setPixelsColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");

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
        if(width < 0)
            throw new IllegalArgumentException("width cannot be less than 0");
        this.width = width;
    }

    protected void setHeight(int height){
        if(height < 0)
            throw new IllegalArgumentException("Height cannot be less than 0");
        this.height = height;
    }

}
