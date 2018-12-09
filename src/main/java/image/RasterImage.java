package image;

import javafx.scene.paint.Color;
import util.Matrices;
import util.Window;
import util.PixelColor;

public abstract class RasterImage implements Image {

    private int width;
    private int height;


    public RasterImage(Color color, int width, int height){
        PixelColor.requiresNonNullColor(color);
        Window.requiresStrictPositiveHeight(height);
        Window.requiresStrictPositiveWidth(width);

        setHeight(height);
        setWidth(width);
        createRepresentation();
        setPixelsColor(color);
    }

    public RasterImage(Color[][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        setHeight(pixels[0].length);
        setWidth(pixels.length);
        createRepresentation();
        setPixelsColor(pixels);

    }

    abstract public void createRepresentation();
    abstract public void clearPixels();
    abstract public void setPixelColor(Color color, int x, int y);

    public void setPixelsColor(Color[][] pixels){
        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);

        clearPixels();
        for(int i=0; i<this.getWidth(); i++){
            for (int j=0; j<this.getHeight();j++) {
                Color currentColor = pixels[i][j];
                setPixelColor(currentColor,i,j);
            }
        }
    }


    public void setPixelsColor(Color color){
        PixelColor.requiresNonNullColor(color);

        clearPixels();
        for(int i=0; i<this.getWidth();i++){
            for(int j = 0; j<this.getHeight(); j++){
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
        Window.requiresStrictPositiveWidth(width);
        this.width = width;
    }

    protected void setHeight(int height){
        Window.requiresStrictPositiveHeight(height);
        this.height = height;
    }

}