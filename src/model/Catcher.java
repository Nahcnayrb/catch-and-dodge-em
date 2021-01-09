package model;

import java.awt.*;

public class Catcher {
    private int x;
    private int y;
    private static final int SPEED = 2;
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 10;
    private static final Color COLOR = new Color(255,255,255);

    public Catcher(){
        this.x = CatchEmGame.WIDTH/2;
        this.y = CatchEmGame.HEIGHT/2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        Color savedColour = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - SIZE_X/2, getY() - SIZE_Y/2, SIZE_X, SIZE_Y);
        g.setColor(savedColour);
    }
}
