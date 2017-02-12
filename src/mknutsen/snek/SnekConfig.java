package mknutsen.snek;

/**
 * Created by mknutsen on 2/11/17.
 */
public final class SnekConfig {

    public static final int PIXEL_WIDTH = 1000;

    public static final int PIXEL_HEIGHT = 1000;

    public static final int ROW_NUM = 50;

    public static final int COLUMN_NUM = 50;

    public static final int SNEK_WIDTH = PIXEL_WIDTH / COLUMN_NUM;

    public static final int SNEK_HEIGHT = PIXEL_HEIGHT / ROW_NUM;
    
    public static final long REPAINT_FREQ = 100;
    
    private SnekConfig() {

    }
}
