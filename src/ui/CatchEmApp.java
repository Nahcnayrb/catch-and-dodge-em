package ui;

import model.CatchEmGame;
import model.Catcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatchEmApp extends JFrame {

    private static final int INTERVAL = 10;
    private CatchEmGame game;
    private Timer t;
    private GamePanel gp;
    private double difficulty;
    private int level;
    private int highscore;



    public CatchEmApp(double difficulty, int level,int highscore) {
        super("Catch 'em (Level: " + level + ")");
        this.highscore = highscore;
        this.level = level;
        this.difficulty = difficulty;
        game = new CatchEmGame(difficulty, level);
        gp = new GamePanel(game);
        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
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

    public static void main(String[] args) {
        new MainMenuFrame(0);
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

    private int highScoreUpdate(int l, int h) {
        if (l > h) {
            return l;
        } else {
            return h;
        }
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_R && game.isOver()) {
                setVisible(false);
                new CatchEmApp(1, 1, highScoreUpdate(level - 1, highscore));
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE && game.hasNoMoreBalls()) {
                setVisible(false);
                new CatchEmApp(difficulty + 0.1, level + 1, highScoreUpdate(level, highscore));
            } else if (e.getKeyCode() == KeyEvent.VK_M && game.isOver()) {
                setVisible(false);
                new MainMenuFrame(highScoreUpdate(level - 1, highscore));
            } else if (e.getKeyCode() == KeyEvent.VK_M && game.hasNoMoreBalls()) {
                setVisible(false);
                new MainMenuFrame(highScoreUpdate(level, highscore));
            }
        }
    }
}
