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


    public CatchEmApp() {
        super("Catch 'em");
        game = new CatchEmGame();
        gp = new GamePanel(game);
        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new UserKeyAdapter());
        addPanels();
        addTimer();
        t.start();
    }

    public static void main(String[] args) {
        new CatchEmApp();
    }

    private void addTimer() {
        t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.isOver()) {
                    t.stop();
                    promptReset();
                }
                game.update();
                gp.repaint();
            }
        });
    }

    private void promptReset() {
        JOptionPane.showMessageDialog(this, "Game Over! Click 'OK' to restart");
        setVisible(false);
        new CatchEmApp();
    }

    public void addPanels() {
        add(gp);
        // add the panels in the ui class
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
}
