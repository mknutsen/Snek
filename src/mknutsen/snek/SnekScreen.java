package mknutsen.snek;

import mknutsen.graphicslibrary.GraphicsComponent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by mknutsen on 2/11/17.
 */
public class SnekScreen extends GraphicsComponent implements MouseListener, KeyListener {

    private final int KEYCODE_LEFT = 37, KEYCODE_UP = 38, KEYCODE_DOWN = 40, KEYCODE_RIGHT = 39;

    private SnekPiece food;

    private int xVel = 0;

    private int yVel = 1;

    private SnekWhole snek;

    private boolean running = true;

    private Thread snekThread = new Thread(() -> {
        while(running) {
            try {
                Thread.sleep(SnekConfig.REPAINT_FREQ);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean newFood = snek.moveSnek(xVel, yVel, food);
            if (newFood) {
                Random rand = new Random();
                food = new SnekPiece(rand.nextInt(SnekConfig.COLUMN_NUM), rand.nextInt(SnekConfig.ROW_NUM), true);
            }
        }
    });

    @Override
    public void paint(final Graphics g) {
        if (food == null || snek == null) {
        } else {
            g.setColor(Color.white);
            g.fillRect(0, 0, SnekConfig.PIXEL_WIDTH, SnekConfig.PIXEL_HEIGHT);
            food.draw(g);
            snek.draw(g);
        }
        repaint();
    }


    @Override
    public void mouseClicked(final MouseEvent e) {

    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }

    @Override
    public void takeParameters(final Object[] obj) {
        Random rand = new Random();
        food = new SnekPiece(rand.nextInt(SnekConfig.COLUMN_NUM), rand.nextInt(SnekConfig.ROW_NUM), true);
        snek = new SnekWhole(
                new SnekPiece(rand.nextInt(SnekConfig.COLUMN_NUM), rand.nextInt(SnekConfig.ROW_NUM), false));

        addKeyListener(this);
        snekThread.start();
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KEYCODE_DOWN:
                xVel = 0;
                yVel = 1;
                break;
            case KEYCODE_LEFT:
                xVel = -1;
                yVel = 0;
                break;
            case KEYCODE_RIGHT:
                xVel = 1;
                yVel = 0;
                break;
            case KEYCODE_UP:
                xVel = 0;
                yVel = -1;
                break;
        }
        System.out.println("x" + xVel + " y" + yVel);
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }
}
