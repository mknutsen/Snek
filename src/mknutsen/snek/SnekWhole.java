package mknutsen.snek;

import mknutsen.graphicslibrary.graphicsobject.GraphicObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by mknutsen on 2/11/17.
 */
public class SnekWhole extends GraphicObject{
    private ArrayList<SnekPiece> sneks;

    public SnekWhole(SnekPiece... sneks) {
        super(0, 0, false, null);
        this.sneks = new ArrayList<>();
        for (final SnekPiece snek : sneks) {
            this.sneks.add(snek);
        }
    }

    @Override
    public boolean draw(final Graphics gr) {
        sneks.forEach(s -> s.draw(gr));
        return false;
    }
    public boolean moveSnek(final int xVel, final int yVel, SnekPiece food) {
        SnekPiece head = sneks.get(0);
        int finalX = head.getxCell() + xVel;
        int finalY = head.getyCell() + yVel;

        if (food.getxCell() == finalX && food.getyCell() == finalY) {
            sneks.add(food);
            food.setFood(false);
            return true;
        } else {
            SnekPiece tail = sneks.remove(sneks.size() - 1);
            tail.setCoordinate(finalX, finalY);
            sneks.add(0, tail);
            return false;
        }

    }
}
