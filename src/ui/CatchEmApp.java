package ui;

import model.Ball;
import model.CatchEmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatchEmApp extends JFrame {

    private static final int INTERVAL = 20;
    private CatchEmGame game;
    private Timer t;

    public CatchEmApp() {
        super("Catch 'em");
        game = new CatchEmGame();
        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new UserKeyAdapter());
        addPanels();
    }

    private void addTimer() {
        t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();

            }
        })
    }

    public void addPanels() {
        // add the panels in the ui class
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public static void main(String[] args) {
        new CatchEmApp();
    }

    public class UserKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    game.moveCatcher("left");
                    break;
                case KeyEvent.VK_RIGHT:
                    game.moveCatcher("right");
                    break;
                case KeyEvent.VK_UP:
                    game.moveCatcher("up");
                    break;
                case KeyEvent.VK_DOWN:
                    game.moveCatcher("down");
                    break;
            }
        }
    }
}
