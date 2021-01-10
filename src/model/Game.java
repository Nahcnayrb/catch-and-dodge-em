package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    public static final int NUM_OF_BALLS = 10;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    protected Catcher catcher;
    protected List<Ball> listOfBalls;
    protected boolean isGameOver = false;

    public Game(double difficulty) {
        catcher = new Catcher();
        listOfBalls = new ArrayList<>();
        for (int i = 0; i < NUM_OF_BALLS; i++) {
            listOfBalls.add(new Ball(difficulty));
        }
    }

    public List<Ball> getBalls() {
        return listOfBalls;
    }

    public Catcher getCatcher() {
        return catcher;
    }

    public boolean hasNoMoreBalls() {
        return listOfBalls.isEmpty();
    }

    public boolean isOver() {
        return isGameOver;
    }

    public void draw(Graphics g) {
        for (Ball next : listOfBalls) {
            next.draw(g);
        }
        catcher.draw(g);
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

    public void checkBoundary() {
        for (Ball b : listOfBalls) {
            if (b.getY() <= (b.getHeight() / 2)) {
                b.bounceDown();
            } else if (b.getY() >= (HEIGHT - b.getHeight() * 4)) {
                b.bounceUp();
            }
        }
    }

    public boolean checkBallHit(Ball ball) {
        Rectangle catcherRectangle = new Rectangle(catcher.getX() - catcher.getWidth()/2,
                catcher.getY() - catcher.getHeight()/2, catcher.getWidth(), catcher.getHeight());
        Rectangle ballRectangle = new Rectangle((int) ball.getX() - ball.getWidth()/2,
                (int) ball.getY() - ball.getHeight()/2, ball.getWidth(), ball.getHeight());

        return catcherRectangle.intersects(ballRectangle);
    }

    public abstract void checkCollision();

    public abstract void checkGameOver();
}
