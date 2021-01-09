package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatchEmGame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Catcher catcher;

    public void moveCatcher(String dir) {
        if (dir.equals("left")) {
            catcher.moveLeft();
        } else if (dir.equals("right")) {
            catcher.moveRight();
        } else if (dir.equals("up")) {
            catcher.moveUp();
        } else if (dir.equals("down")) {
            catcher.moveUp();
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
