package model;

import java.awt.*;

public class Ball {

    private final int MIN_Y = 0;
    private final int MAX_Y = CatchEmGame.HEIGHT;
    private final int UP = 1;
    private final int DOWN = 2;
    private final int WIDTH = 8;
    private final int HEIGHT = 8;
    private final Color COLOR = new Color(255, 0, 0);
    private double x;
    private double y;
    private int verticalDirection;
    private double horizontalSpeed;
    private double verticalSpeed;


    public Ball(double i) {
        x = 0;
        y = (Math.random() * (MAX_Y - MIN_Y)) + MIN_Y;
        horizontalSpeed = Math.random()*(i - 1) + 1;
        verticalSpeed = Math.random()*(i - 1) + 1;
        verticalDirection = getNewVerticalDirection();
    }
//
    private int getNewVerticalDirection() {
        return (int) ((Math.random() * 3));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public double getVerticalSpeed() {
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
        g.fillOval((int) getX() - WIDTH/2,(int) getY() - HEIGHT/2 , WIDTH, HEIGHT);
//
    }

}
