package ui;

import model.CatchEmGame;
import model.Catcher;
import model.DodgeEmGame;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class AbstractApp extends JFrame{
    protected static final int INTERVAL = 10;
    protected Game game;
    protected Timer t;
    protected GamePanel gp;
    protected double difficulty;
    protected int level;

    public AbstractApp(double difficulty, int level, String type) {
        super(type + " (Level: " + level + ")");
        this.level = level;
        this.difficulty = difficulty;
        if (type.equals("Dodge 'em")) {
            game = new DodgeEmGame(difficulty);
        } else if (type.equals("Catch 'em")) {
            game = new CatchEmGame(difficulty);
        }
        gp = new GamePanel(game);
        add(gp);
        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new UserKeyAdapter());
        addTimer();
        t.start();
    }

    public void addTimer() {
        t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                gp.repaint();
            }
        });
    }

    public void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    protected class UserKeyAdapter extends KeyAdapter {

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
}
