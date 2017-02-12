package mknutsen.snek;

import mknutsen.graphicslibrary.graphicsobject.RectangleGraphicObject;

import java.awt.*;

/**
 * Created by mknutsen on 2/11/17.
 */
public class SnekPiece extends RectangleGraphicObject {

    private boolean isFood;

    private int xCell, yCell;

    public SnekPiece(final int xCell, final int yCell, final boolean isFood) {
        super(xCell * SnekConfig.SNEK_WIDTH, yCell * SnekConfig.SNEK_HEIGHT, SnekConfig.SNEK_WIDTH,
                SnekConfig.SNEK_HEIGHT, false, null);
        this.xCell = xCell;
        this.yCell = yCell;
        this.isFood = isFood;
        System.out.println(getX());
        System.out.println(getY());
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(final boolean food) {
        isFood = food;
    }

    @Override
    public boolean draw(final Graphics gr) {
        gr.setColor(isFood() ? Color.red: Color.black);
        gr.fillRect(getX(), getY(), getWidth(), getHeight());

        return true;

    }

    public int getxCell() {
        return xCell;
    }

    public int getyCell() {
        return yCell;
    }

    public void setCoordinate(int xCell, int yCell) {
        this.xCell = xCell;
        this.yCell = yCell;
        setX(xCell * SnekConfig.SNEK_WIDTH);
        setY(yCell * SnekConfig.SNEK_HEIGHT);

        System.out.println(getX());
        System.out.println(getY());
    }
}
