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
        if (this.x + velX + WIDTH/2 > CatchEmGame.WIDTH) {
            this.x = CatchEmGame.WIDTH - WIDTH;
        } else if (this.x - WIDTH/2 < 0) {
            this.x = WIDTH - WIDTH/2;
        } else {
            x += velX;
        }
    }

    public void incrementY() {
        if (this.y + velY + HEIGHT > CatchEmGame.HEIGHT) {
            this.y = CatchEmGame.HEIGHT - HEIGHT;
            velY = 0;
        } else if (this.y - HEIGHT/2 < 0) {
            this.y = HEIGHT - HEIGHT/2;
            velY = 0;
        } else {
            y += velY;
        }
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

//    public void moveLeft() {
//        if (this.x - SPEED - WIDTH/2 < 0) {
//            this.x = WIDTH/2;
//        } else {
//            this.x -= SPEED;
//        }
//    }
//
//    public void moveRight() {
//        if (this.x + SPEED + WIDTH/2 > CatchEmGame.WIDTH) {
//            this.x = CatchEmGame.WIDTH - WIDTH;
//        } else {
//            this.x += SPEED;
//        }
//    }
//
//    public void moveUp() {
//        if (this.y - SPEED - HEIGHT/2 < 0) {
//            this.y = HEIGHT/2;
//        } else {
//            this.y -= SPEED;
//        }
//    }
//
//    public void moveDown() {
//        if (this.y + SPEED + HEIGHT > CatchEmGame.HEIGHT) {
//            this.y = CatchEmGame.HEIGHT - HEIGHT;
//        } else {
//            this.y += SPEED;
//        }
//    }
}
