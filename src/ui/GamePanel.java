package ui;

import model.CatchEmGame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "Press R to replay!";
    private CatchEmGame game;

    public GamePanel(CatchEmGame game) {
        setPreferredSize(new Dimension(CatchEmGame.WIDTH, CatchEmGame.HEIGHT));
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

        if (game.isOver()) {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {

    }

    private void drawGame(Graphics g) {
        game.draw(g);
    }
}
