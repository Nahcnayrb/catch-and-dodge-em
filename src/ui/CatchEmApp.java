package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatchEmApp extends AbstractApp {

    public CatchEmApp(double difficulty, int level) {
        super(difficulty, level, "Catch 'em");
        addKeyListener(new KeyHandler());
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_R && game.isOver()) {
                setVisible(false);
                new CatchEmApp(1, 1);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE && game.hasNoMoreBalls()) {
                setVisible(false);
                new CatchEmApp(difficulty + 0.1, level + 1);
            }
        }
    }
}
