package model;

import java.awt.*;

public class Ball {


    private final int MAX_SPEED = 10;
    private final int MIN_Y = 0;
    private final int MAX_Y = 800;
    private final int NEUTRAL = 0;
    private final int UP = 1;
    private final int DOWN = 2;
    private final int WIDTH = 3;
    private final int HEIGHT = 3;
    private final Color COLOR = new Color(0,255,255);
    private int minSpeed;
    private int x;
    private int y;
    private int verticalDirection;
    private int horizontalSpeed;
    private int verticalSpeed;


    public Ball(int i) {
        minSpeed = i;
        x = 0;
        y = (int) ((Math.random() * (MAX_Y - MIN_Y)) + MIN_Y);
        horizontalSpeed = (int) ((Math.random() * (MAX_SPEED - minSpeed)) + minSpeed);
        verticalSpeed = (int) ((Math.random() * (MAX_SPEED - minSpeed)) + minSpeed);
        verticalDirection = getNewVerticalDirection();
    }
//
    private int getNewVerticalDirection() {
        return (int) ((Math.random() * 3));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    public int getVerticalDirection() {
        return verticalDirection;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void bounceDown() {
        verticalDirection = DOWN;
    }

    public void bounceUp() {
        verticalDirection = UP;
    }


    public void moveUp() {
        y = y - verticalSpeed;
    }

    public void moveDown() {
        y = y + verticalSpeed;
    }

    public void moveRight() {
        x = x + horizontalSpeed;
    }


//    public void tick() {
//        if (getVerticalDirection() == UP) {
//            y = y - verticalSpeed;
//        } else if (getVerticalDirection() == DOWN) {
//            y = y + verticalSpeed;
//        }
//        x = x + horizontalSpeed;
//        verticalDirection = getNewVerticalDirection();
//    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(getX() - WIDTH/2,getY() - HEIGHT/2 , WIDTH, HEIGHT);
//
    }

}
