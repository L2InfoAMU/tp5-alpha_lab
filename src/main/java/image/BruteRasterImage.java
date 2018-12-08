package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage{

    private Color[][] pixels;


    public BruteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] pixels){
        super(pixels);
    }

    public void createRepresentation(){
        pixels = new Color[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y){
        Matrices.requiresInsideMatrixBonds(pixels, x, y);
        return pixels[x][y];
    }

    public void setPixelColor(Color color, int x, int y){
        requiresNonNullColor(color);
        Matrices.requiresInsideMatrixBonds(pixels, x, y);
        pixels[x][y] = color;
    }

    public void setPixelsColor(Color[][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        this.pixels = pixels.clone();
    }

    public void setPixelsColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");

        for(int i=0; i<this.getWidth();i++){
            for(int j=0; j<this.getHeight();j++){
                setPixelColor(color,i,j);
            }
        }
    }

}
