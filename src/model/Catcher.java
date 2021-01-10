package model;

import java.awt.*;

public class Catcher {
    private int x;
    private int y;
    public static final int SPEED = 5;
    private final int WIDTH = 10;
    private final int HEIGHT = 40;
    private static final Color COLOR = new Color(0,0,0);

    private int velX;
    private int velY;

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

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void incrementX() {
        x += velX;
    }

    public void incrementY() {
        y += velY;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelX(int i) {
        velX = i;
    }

    public void setVelY(int i) {
        velY = i;
    }

    public void draw(Graphics g) {
        Color savedColour = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - WIDTH/2, getY() - HEIGHT/2, WIDTH, HEIGHT);
        g.setColor(savedColour);
    }
}
