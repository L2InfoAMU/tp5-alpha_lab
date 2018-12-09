package image;

import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public interface Image {
    Color getPixelColor(Point point);
    int getWidth();
    int getHeight();
}
