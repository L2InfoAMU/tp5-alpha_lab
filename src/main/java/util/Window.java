package util;

import image.Pixel;
import image.Point;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Window {

    public static void requiresStrictPositiveWidth(int width){
        if(width < 0)
            throw new IllegalArgumentException("width cannot be less or equal to 0");
    }

    public static void requiresStrictPositiveHeight(int height){
        if(height < 0)
            throw new IllegalArgumentException("height cannot be less or equal to 0");
    }

    public static void requiresValidCoordinates(Point point, int height, int width){
        requiresNonNullPoint(point);
        if(point.x<0 || point.y<0 || point.x>=width || point.y>=height)
            throw new IllegalArgumentException("The point is outside the window boundaries");
    }

    public static void requiresValidCoordinates(Pixel pixel, int height, int width){
        requiresNonNullPixelColor(pixel);
        if(pixel.x<0 || pixel.y<0 || pixel.x>=width || pixel.y>=height)
            throw new IllegalArgumentException("The pixel is outside the window boundaries");
    }

    public static void requiresNonNullPixelColor(Pixel pixel){
        Objects.requireNonNull(pixel,"Pixel cannot be null");
        Objects.requireNonNull(pixel.getColor(),"Color of pixel cannot be null");
    }

    public static void requiresNonNullPoint(Point point){
        Objects.requireNonNull(point,"point cannot be null");
    }

    public static void requiresNonNullColor(Color color){
        Objects.requireNonNull(color,"Color cannot be null");
    }

}
