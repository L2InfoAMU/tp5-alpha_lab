package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage  {

    private List<Color> palette;
    private int[][] indexesOfColors;
    private int width;
    private int height;




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


}
