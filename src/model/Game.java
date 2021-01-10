package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    protected Catcher catcher;
    protected List<Ball> listOfBalls;
    protected boolean isGameOver = false;

    public Game(double difficulty, String type) {
        catcher = new Catcher();
        listOfBalls = new ArrayList<>();
        if (type.equals("catch")) {
            for (int i = 0; i < 10; i++) {
                listOfBalls.add(new Ball(difficulty, "catch"));
            }
        } else if (type.equals("dodge")) {
            for (int i = 0; i < 15; i++) {
                listOfBalls.add(new Ball(difficulty, "dodge"));
            }

        }
    }

    public List<Ball> getBalls() {
        return listOfBalls;
    }

    public Catcher getCatcher() {
        return catcher;
    }

    public void update() {
        catcher.incrementX();
        catcher.incrementY();
        checkBoundary();
        checkCollision();
        tick();
        checkGameOver();
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

    public boolean checkBallHit(Ball ball) {
        Rectangle catcherRectangle = new Rectangle(catcher.getX() - catcher.getWidth()/2,
                catcher.getY() - catcher.getHeight()/2, catcher.getWidth(), catcher.getHeight());
        Rectangle ballRectangle = new Rectangle((int) ball.getX() - ball.getWidth()/2,
                (int) ball.getY() - ball.getHeight()/2, ball.getWidth(), ball.getHeight());

        return catcherRectangle.intersects(ballRectangle);
    }

    public abstract void checkCollision();

    public abstract void checkGameOver();

    public abstract void checkBoundary();
}
