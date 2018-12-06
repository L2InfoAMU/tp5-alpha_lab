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

    private void setPixelsColor(Color[][] pixels){

        // TODO (?) : remove palette

        for(int i=0; i<width;i++){
            for(int j=0; j<height;j++){
                Color currentColor = getPixelColor(i,j);
                if(!palette.contains(currentColor))
                    palette.add(currentColor);
                int indexOfCurrentColor = palette.indexOf(currentColor);
                setPixelColor(currentColor, i,j);
            }
        }
    }





}
