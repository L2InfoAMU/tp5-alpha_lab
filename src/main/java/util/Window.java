package util;

public class Window {

    public static void requiresStrictPositiveWidth(int width){
        if(width < 0)
            throw new IllegalArgumentException("width cannot be less or equal to 0");
    }

    public static void requiresStrictPositiveHeight(int height){
        if(height < 0)
            throw new IllegalArgumentException("height cannot be less or equal to 0");
    }

    public static void requiresValidCoordinates(int x, int y, int height, int width){
        if(x<0 || y<0 || x>=width || y>=height)
            throw new IllegalArgumentException("x or y outside window bounds");
    }

}
