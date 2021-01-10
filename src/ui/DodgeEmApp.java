package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DodgeEmApp extends AbstractApp {

    public DodgeEmApp(double difficulty, int level, int cScore, int dScore) {
        super(difficulty, level, "Dodge 'em", cScore, dScore);
        addKeyListener(new KeyHandler());
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_R && game.isOver()) {
                setVisible(false);
                new DodgeEmApp(1, 1,catchEmHighScore, updateHighScore(level - 1, dodgeEmHighScore));
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE && game.hasNoMoreBalls()) {
                setVisible(false);
                new DodgeEmApp(difficulty + 0.1, level + 1, catchEmHighScore,
                        updateHighScore(level, dodgeEmHighScore));
            } else if (e.getKeyCode() == KeyEvent.VK_M && game.isOver()) {
                setVisible(false);
                new MainMenuFrame(catchEmHighScore, updateHighScore(level - 1, dodgeEmHighScore));
            } else if (e.getKeyCode() == KeyEvent.VK_M && game.hasNoMoreBalls()) {
                setVisible(false);
                new MainMenuFrame(catchEmHighScore, updateHighScore(level, dodgeEmHighScore));
            }
        }
    }
}
