package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private List<Color> palette;
    private int[][] indexesOfColors;
    private int width;
    private int height;


    public PaletteRasterImage(Color color, int width, int height){

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

    public PaletteRasterImage(Color[][] pixels){

        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        setHeight(pixels[0].length);
        setWidth(pixels.length);

        createRepresentation();
        setPixelsColor(pixels);

    }

    public void createRepresentation(){
        palette = new ArrayList<Color>();
        indexesOfColors = new int[width][height];
    }

    public Color getPixelColor(int x, int y){

        Matrices.requiresInsideMatrixBonds(indexesOfColors, x, y);

        int indexOfPixel = indexesOfColors[x][y];
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Color color, int x, int y){

        if (color == null)
            throw new NullPointerException("Color cannot be null");
        Matrices.requiresInsideMatrixBonds(indexesOfColors, x, y);

        if(!palette.contains(color))
            palette.add(color);

        indexesOfColors[x][y] = palette.indexOf(color);

    }

    public void setPixelsColor(Color[][] pixels){

        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        palette.clear();

        for(int i=0; i<width;i++){
            for(int j=0; j<height;j++){
                Color currentColor = pixels[i][j];
                setPixelColor(currentColor, i,j);
            }
        }
    }

    private void setPixelsColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");

        palette.clear();
        palette.add(color);

        for(int i=0; i<width;i++){
            for(int j = 0; j<height; j++){
                setPixelColor(color, i, j);
            }
        }

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    protected void setWidth(int width){
        if(width < 0)
            throw new IllegalArgumentException("width cannot be less than 0");
        this.width = width;
    }

    protected void setHeight(int height){
        if(height < 0)
            throw new IllegalArgumentException("height cannot be less than 0");
        this.height = height;
    }

}
