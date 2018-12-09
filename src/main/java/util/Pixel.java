package util;

import javafx.scene.paint.Color;

public class Pixel {

    public static void requiresNonNullColor(Color color){
        if (color == null)
            throw new NullPointerException("Color cannot be null");
    }

}
