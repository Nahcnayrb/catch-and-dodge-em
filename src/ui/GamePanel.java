package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "Press R to replay!";
    private static final String NEXT = "Press Spacebar for the next level!";
    private static final String MAIN = "Press M to return to the main menu!";
    private Game game;

    public GamePanel(Game game) {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);

        if (game.isOver()) {
            gameOver(g);
        } else if (game.hasNoMoreBalls()) {
            nextLevel(g);
        }
    }

    private void nextLevel(Graphics g) {
        Color c = g.getColor();
        g.setColor(new Color(0, 0 ,0));
        g.setFont(new Font("Times New Roman", 1, 30));
        FontMetrics fm = g.getFontMetrics();
        centreString(NEXT, g, fm, Game.HEIGHT/2 - 20);
        centreString(MAIN, g, fm, Game.HEIGHT/2 + 20);
        g.setColor(c);
    }

    private void gameOver(Graphics g) {
        Color c = g.getColor();
        g.setColor(new Color( 0, 0, 0));
        g.setFont(new Font("Times New Roman", 1, 30));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, Game.HEIGHT / 2 - 40);
        centreString(REPLAY, g, fm, Game.HEIGHT / 2);
        centreString(MAIN, g, fm, Game.HEIGHT/2 + 40);
        g.setColor(c);
    }

    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, yPos);
    }

    private void drawGame(Graphics g) {
        game.draw(g);
    }
}
