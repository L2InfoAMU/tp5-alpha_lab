package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {

    private int width;
    private int height;

    protected void requiresNonNullColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");
    }

    protected void requiresStrictPositiveWidth(int width){
        if(width < 0)
            throw new IllegalArgumentException("width cannot be less or equal to 0");
    }

    protected void requiresStrictPositiveHeight(int height){
        if(height < 0)
            throw new IllegalArgumentException("height cannot be less or equal to 0");
    }

    protected void requiresValidCoordinates(int x, int y){
        if(x<0 || y<0 || x>=this.getWidth() || y>=this.getHeight())
            throw new IllegalArgumentException("x or y outside window bounds");
    }

    public RasterImage(Color color, int width, int height){
        requiresNonNullColor(color);
        requiresStrictPositiveHeight(height);
        requiresStrictPositiveWidth(width);

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
        requiresNonNullColor(color);

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
        requiresStrictPositiveWidth(width);
        this.width = width;
    }

    protected void setHeight(int height){
        requiresStrictPositiveHeight(height);
        this.height = height;
    }

}