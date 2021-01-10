package ui;

import model.Catcher;
import model.DodgeEmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DodgeEmApp extends JFrame {

    private static final int INTERVAL = 10;
    private DodgeEmGame game;
    private Timer t;
    private GamePanel gp;
    private double difficulty;
    private int level;

    // TODO: fix is so that when you restart, it restarts the dodge game
    public DodgeEmApp(double difficulty, int level) {
        super("Dodge 'em (Level: " + level + ")");
        this.level = level;
        this.difficulty = difficulty;
        game = new DodgeEmGame(difficulty);
        gp = new GamePanel(game);
        setSize(DodgeEmGame.WIDTH, DodgeEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new UserKeyAdapter());
        addKeyListener(new KeyHandler());
        addPanels();
        addTimer();
        t.start();
    }

    private void addTimer() {
        t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                gp.repaint();
            }
        });
    }

    public void addPanels() {
        add(gp);
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public class UserKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                game.getCatcher().setVelX(-Catcher.SPEED);
            }
            if (key == KeyEvent.VK_RIGHT) {
                game.getCatcher().setVelX(Catcher.SPEED);
            }
            if (key == KeyEvent.VK_UP) {
                game.getCatcher().setVelY(-Catcher.SPEED);
            }
            if (key == KeyEvent.VK_DOWN) {
                game.getCatcher().setVelY(Catcher.SPEED);
            }
        }

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                game.getCatcher().setVelX(0);
            }
            if (key == KeyEvent.VK_RIGHT) {
                game.getCatcher().setVelX(0);
            }
            if (key == KeyEvent.VK_UP) {
                game.getCatcher().setVelY(0);
            }
            if (key == KeyEvent.VK_DOWN) {
                game.getCatcher().setVelY(0);
            }
        }
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_R && game.isOver()) {
                setVisible(false);
                new DodgeEmApp(1, 1);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE && game.hasNoMoreBalls()) {
                setVisible(false);
                new DodgeEmApp(difficulty + 0.1, level + 1);
            }
        }
    }

    // TODO: make an abstract app class for CatchEm and DodgeEm
}
