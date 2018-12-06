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




}
