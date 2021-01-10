package model;

import java.awt.*;

public class Catcher {
    private int x;
    private int y;
    private static final int SPEED = 10;
    private final int WIDTH = 10;
    private final int HEIGHT = 40;
    private static final Color COLOR = new Color(0,0,0);

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

    public void moveLeft() {
        if (this.x - SPEED - WIDTH/2 <= 0) {
            this.x = WIDTH/2;
        } else if (this.x > 0) {
            this.x -= SPEED;
        }
    }

    public void moveRight() {
        if (this.x + SPEED + WIDTH/2 >= CatchEmGame.WIDTH) {
            this.x = CatchEmGame.WIDTH - WIDTH;
        } else if (this.x < CatchEmGame.WIDTH) {
            this.x += SPEED;
        }
    }

    public void moveUp() {
        if (this.y - SPEED - HEIGHT/2 <= 0) {
            this.y = HEIGHT/2;
        } else if (this.y > 0) {
            this.y -= SPEED;
        }
    }

    public void moveDown() {
        if (this.y + SPEED + HEIGHT >= CatchEmGame.HEIGHT) {
            this.y = CatchEmGame.HEIGHT - HEIGHT;
        } else if (this.y < CatchEmGame.HEIGHT) {
            this.y += SPEED;
        }
    }

    public void draw(Graphics g) {
        Color savedColour = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - WIDTH/2, getY() - HEIGHT/2, WIDTH, HEIGHT);
        g.setColor(savedColour);
    }
}
