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
    abstract public void setPixelsColor(Color[][] pixels);
    abstract public void setPixelsColor(Color color);

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