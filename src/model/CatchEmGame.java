package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatchEmGame {
    public static final int NUM_OF_BALLS = 10;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Catcher catcher;
    private List<Ball> listOfBalls;
    private boolean isGameOver = false;
    private int level;

    public CatchEmGame() {
        catcher = new Catcher();
        listOfBalls = new ArrayList<>();
        level = 1;
        for (int i = 0; i <= 9; i++) {
            listOfBalls.add(new Ball(level));
        }
    }

    public List<Ball> getBalls() {
        return listOfBalls;
    }

    public Catcher getCatcher() {
        return catcher;
    }

    public void catcherBallCollision() {
        for (Ball next : listOfBalls) {
            if (checkBallHit(next)) {
                listOfBalls.remove(next);
            }
        }
    }

    private boolean checkBallHit(Ball ball) {
        Rectangle catcherRectangle = new Rectangle(catcher.getX() - catcher.getWidth(),
                catcher.getY() - catcher.getHeight(), catcher.getWidth(), catcher.getHeight());
        Rectangle ballRectangle = new Rectangle(ball.getX() - ball.getWidth(),
                ball.getY() - ball.getHeight(), ball.getWidth(), ball.getHeight());

        return catcherRectangle.intersects(ballRectangle);
    }

    // bounce off wall if hit wall
    public void checkBoundary() {
        for (Ball b : listOfBalls) {
            if (b.getY() == (b.getHeight() / 2)) {
                b.bounceDown();
            } else if (b.getY() == (HEIGHT - (b.getHeight() / 2))) {
                b.bounceUp();
            }
        }
    }

    public void isGameOver() {
        for (Ball next : listOfBalls) {
            if ((next.getX() + (next.getWidth() / 2)) >= WIDTH) {
                isGameOver = true;
            }
        }
    }

    public boolean isOver() {
        return isGameOver;
    }

    public void update() {
        if (isGameOver) {
            reset();
        }
        checkBoundary();
        catcherBallCollision();
        tick();
    }

    public void reset() {
        listOfBalls = new ArrayList<>();
        level++;
        for (int i = 0; i < 10; i++) {
            Ball b = new Ball(level);
            listOfBalls.add(b);
        }
        catcher = new Catcher();

    }

    public void tick() {
        checkBoundary();
        for (Ball b : listOfBalls) {
            if (b.getVerticalDirection() == 1) {
                b.moveUp();
            } else if (b.getVerticalDirection() == 2) {
                b.moveDown();
            }
            b.moveRight();
        }
    }

    public void moveCatcher(String dir) {
        switch (dir) {
            case "left":
                catcher.moveLeft();
                break;
            case "right":
                catcher.moveRight();
                break;
            case "up":
                catcher.moveUp();
                break;
            case "down":
                catcher.moveDown();
                break;
        }
    }

    public void draw(Graphics g) {
        for (Ball next : listOfBalls) {
            next.draw(g);
        }
        catcher.draw(g);
    }

}
