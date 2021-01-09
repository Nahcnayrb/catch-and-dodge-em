package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatchEmGame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Catcher catcher;

    public CatchEmGame() {
        this.catcher = new Catcher();
        // initialize the balls and stuff
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
                catcher.moveUp();
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
