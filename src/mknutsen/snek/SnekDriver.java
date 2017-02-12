package mknutsen.snek;

import mknutsen.graphicslibrary.GraphicsComponent;
import mknutsen.graphicslibrary.GraphicsDriver;

/**
 * Created by mknutsen on 2/11/17.
 */
public class SnekDriver extends GraphicsDriver {

    public SnekDriver(final int width, final int height, final GraphicsComponent... components) {
        super(width, height, components);
    }

    public static void main(String[] args) {
        new SnekDriver(SnekConfig.PIXEL_WIDTH, SnekConfig.PIXEL_HEIGHT, new SnekScreen());
    }
}
