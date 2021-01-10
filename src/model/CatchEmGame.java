package model;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CatchEmGame {
    public static final int NUM_OF_BALLS = 10;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    private Catcher catcher;
    private List<Ball> listOfBalls;
    private boolean isGameOver = false;

    public CatchEmGame(double level) {
        catcher = new Catcher();
        listOfBalls = new ArrayList<>();
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
        Rectangle ballRectangle = new Rectangle((int) ball.getX() - ball.getWidth()/2,
                (int) ball.getY() - ball.getHeight()/2, ball.getWidth(), ball.getHeight());

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

    public boolean hasNoMoreBalls() {
        return (listOfBalls.isEmpty());
    }

    public void checkGameOver() {
        for (Ball next : listOfBalls) {
            if ((next.getX() + (next.getWidth() / 2)) >= WIDTH) {
                isGameOver = true;
                break;
            }
        }
    }

    public boolean isOver() {
        return isGameOver;
    }

    public void update() {
        catcher.incrementX();
        catcher.incrementY();
        checkBoundary();
        checkCollision();
        tick();
        checkGameOver();
    }

    private void checkCollision() {
        List<Ball> ballsHit = new ArrayList<Ball>();
        for (Ball next : listOfBalls) {
            if (checkBallHit(next)) {
                ballsHit.add(next);
            }
        }
        listOfBalls.removeAll(ballsHit);
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

    public void draw(Graphics g) {
        for (Ball next : listOfBalls) {
            next.draw(g);
        }
        catcher.draw(g);
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R && isGameOver) {
            restart();
        } else if (keyCode == KeyEvent.VK_SPACE && hasNoMoreBalls()) {
            nextLevel();
        }
    }


    public void restart() {

    }

    public void nextLevel(){

    }

//    public void reset() {
//        listOfBalls = new ArrayList<>();
//        level++;
//        for (int i = 0; i < 10; i++) {
//            Ball b = new Ball(level);
//            listOfBalls.add(b);
//        }
//    }

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
}
