package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private List<Color> palette;
    private int[][] indexesOfColors;
    private int width;
    private int height;


    public PaletteRasterImage(Color color, int width, int height){

        setHeight(height);
        setWidth(width);
        createRepresentation();
        setPixelsColor(color);

    }

    public PaletteRasterImage(Color[][] pixels){

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
        int indexOfPixel = indexesOfColors[x][y];
        if(indexOfPixel >= palette.size())
            return null;
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Color color, int x, int y){

        if(!palette.contains(color))
            palette.add(color);

        indexesOfColors[x][y] = palette.indexOf(color);

    }

    public void setPixelsColor(Color[][] pixels){

        // TODO (?) : remove palette

        for(int i=0; i<width;i++){
            for(int j=0; j<height;j++){
                Color currentColor = getPixelColor(i,j);
        //        if(!palette.contains(currentColor))
        //            palette.add(currentColor);
        //        int indexOfCurrentColor = palette.indexOf(currentColor);
                setPixelColor(currentColor, i,j);
            }
        }
    }

    private void setPixelsColor(Color color){

        // TODO (?) : remove palette (if so, remove "if")

        if(!palette.contains(color))
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
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }

}
