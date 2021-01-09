package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CatchEmGame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Catcher catcher;
    private List<Ball> listOfBalls;

    public CatchEmGame() {
        catcher = new Catcher();
        listOfBalls = new ArrayList<>();
        // initialize the balls and stuff
    }

    public void catcherBallCollision() {
        for (Ball next : listOfBalls) {
            if (checkBallHit(catcher)) {
                listOfBalls.remove(next);
            }
        }
    }

    private boolean checkBallHit(Catcher catcher) {

    }

    public void checkBoundary() {
        // bounce off wall if hit wall
    }

    public boolean isGameOver() {
        return false; // stub
    }

    public void update() {

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

    public class UserKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    moveCatcher("left");
                    break;
                case KeyEvent.VK_RIGHT:
                    moveCatcher("right");
                    break;
                case KeyEvent.VK_UP:
                    moveCatcher("up");
                    break;
                case KeyEvent.VK_DOWN:
                    moveCatcher("down");
                    break;
            }
        }
    }
}
