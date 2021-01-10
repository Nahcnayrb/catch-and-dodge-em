package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatchEmGame {
    public static final int NUM_OF_BALLS = 10;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
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

    private boolean checkBallHit(Ball ball) {
        Rectangle catcherRectangle = new Rectangle(catcher.getX() - catcher.getWidth()/2,
                catcher.getY() - catcher.getHeight()/2, catcher.getWidth(), catcher.getHeight());
        Rectangle ballRectangle = new Rectangle(ball.getX() - ball.getWidth()/2,
                ball.getY() - ball.getHeight()/2, ball.getWidth(), ball.getHeight());

        return catcherRectangle.intersects(ballRectangle);
    }

    // bounce off wall if hit wall
    public void checkBoundary() {
        for (Ball b : listOfBalls) {
            if (b.getY() <= (b.getHeight() / 2)) {
                b.bounceDown();
            } else if (b.getY() >= (HEIGHT - b.getHeight()*4)) {
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
        // TODO
        catcher.incrementX();
        catcher.incrementY();
        checkBoundary();
        checkCollision();
        tick();
    }

    private void checkCollision() {
        List<Ball> ballsHit = new ArrayList<Ball>();
        for (Ball next : listOfBalls) {
            catcherBallCollision(ballsHit);
        }
        listOfBalls.removeAll(ballsHit);
    }

    public void catcherBallCollision(List<Ball> ballsHit) {
        for (Ball next : listOfBalls) {
            if (checkBallHit(next)) {
                ballsHit.add(next);
            }
        }
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

//    public void moveCatcher(String dir) {
//        if (dir.equals("left")) {
//            catcher.moveLeft();
//        }
//        if (dir.equals("right")) {
//            catcher.moveRight();
//        }
//        if (dir.equals("up")) {
//            catcher.moveUp();
//        }
//        if (dir.equals("down")) {
//            catcher.moveDown();
//        }
//    }

    public void draw(Graphics g) {
        for (Ball next : listOfBalls) {
            next.draw(g);
        }
        catcher.draw(g);
    }

}
