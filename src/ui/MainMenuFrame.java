package ui;

import model.CatchEmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {

    JButton playButton;
    JButton viewHighScoreButton;
    JButton returnToHomeButton;
    JButton quitButton;
    private int highScore;
    CardLayout cl = new CardLayout();
    JPanel panelCont = new JPanel();
    MainMenuPanel mmp = new MainMenuPanel();
    HighScorePanel hsp = new HighScorePanel();
    JLabel highScoreLabel = new JLabel();




    public MainMenuFrame(int score) {
        this.highScore = score;
        panelCont.setLayout(cl);
        setUpButtons();
        setUpLabels();
        addPanels();






        //add(viewHighScore);
        this.add(panelCont);
        cl.show(panelCont, "1");



        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setUpLabels() {
        highScoreLabel.setBounds(225,150,300,100);
        highScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        highScoreLabel.setText("Your high score is: Level " + this.highScore);
        hsp.add(highScoreLabel);
    }



    private void addPanels() {
        mmp.setLayout(null);
        hsp.setLayout(null);
        mmp.setBackground(Color.PINK);
        hsp.setBackground(Color.YELLOW);
        panelCont.add(mmp, "1");
        panelCont.add(hsp, "2");
    }


    private void setUpButtons() {
        playButton = new JButton("Play Catch' em");
        viewHighScoreButton = new JButton("View High Score");
        returnToHomeButton = new JButton("Return to Main Menu");
        playButton.addActionListener(this);
        viewHighScoreButton.addActionListener(this);
        returnToHomeButton.addActionListener(this);
        playButton.setBounds(300,100,200,50);
        viewHighScoreButton.setBounds(300,300,200,50);
        returnToHomeButton.setBounds(0,0,200,50);
        mmp.add(playButton);
        mmp.add(viewHighScoreButton);
        hsp.add(returnToHomeButton);

    }

    private void setUpMainMenuPanel() {
        mmp.add(playButton);
        mmp.add(viewHighScoreButton);

    }
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            this.dispose();
            new CatchEmApp(1, 1,highScore);
        } else if (e.getSource() == viewHighScoreButton) {
            cl.show(panelCont, "2");
        } else if (e.getSource() == returnToHomeButton) {
            cl.show(panelCont, "1");
        }
    }
}
