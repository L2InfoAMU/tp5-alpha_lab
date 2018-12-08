package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    private List<Color> palette;
    private int[][] indexesOfColors;


    public PaletteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] pixels){

        super(pixels);

    }

    public void createRepresentation(){
        palette = new ArrayList<Color>();
        indexesOfColors = new int[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y){

        Matrices.requiresInsideMatrixBonds(indexesOfColors, x, y);

        int indexOfPixel = indexesOfColors[x][y];
        return palette.get(indexOfPixel);
    }

    public void setPixelColor(Color color, int x, int y){

        requiresNonNullColor(color);
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

        for(int i=0; i<this.getWidth();i++){
            for(int j=0; j<this.getHeight();j++){
                Color currentColor = pixels[i][j];
                setPixelColor(currentColor, i,j);
            }
        }
    }

    public void setPixelsColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");

        palette.clear();
        palette.add(color);

        for(int i=0; i<this.getWidth();i++){
            for(int j = 0; j<this.getHeight(); j++){
                setPixelColor(color, i, j);
            }
        }

    }
}