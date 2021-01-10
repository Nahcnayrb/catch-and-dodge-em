package ui;

import model.CatchEmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {

    JButton playButton;
    JButton viewHighScore;
    private int highScore;
    CardLayout cl = new CardLayout();


    public MainMenuFrame(int highScore) {
        this.highScore = highScore;
        playButton = new JButton("Play Catch' em");
        viewHighScore = new JButton("View High Score");



        add(playButton);
        playButton.setBounds(300,300,30,30);
        //add(viewHighScore);
        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        playButton.addActionListener(this);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            this.dispose();
            new CatchEmApp(1);
        }
    }
}
