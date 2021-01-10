package ui;

import model.CatchEmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {

    JButton playCatchEmButton;
    JButton playDodgeEmButton;
    JButton viewHighScoreButton;
    JButton returnToHomeButton;
    private int catchEmHighScore;
    private int dodgeEmHighScore;
    CardLayout cl = new CardLayout();
    JPanel panelCont = new JPanel();
    MainMenuPanel mmp = new MainMenuPanel();
    HighScorePanel hsp = new HighScorePanel();

    JLabel mainMenuLabel = new JLabel();
    JLabel highScoreLabel = new JLabel();
    JLabel catchEmHSLabel = new JLabel();
    JLabel dodgeEmHSLabel = new JLabel();

    public MainMenuFrame(int cScore, int dScore) {
        super("Catch and Dodge 'em");
        catchEmHighScore = cScore;
        dodgeEmHighScore = dScore;
        panelCont.setLayout(cl);
        setUpButtons();
        addPanels();


        updateHighScore();
        this.add(panelCont);
        cl.show(panelCont, "1");

        setSize(CatchEmGame.WIDTH, CatchEmGame.HEIGHT);
        centreOnScreen();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new MainMenuFrame(0,0);
    }

    public void updateHighScore() {
        highScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        highScoreLabel.setText("Highscores");
        catchEmHSLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dodgeEmHSLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        catchEmHSLabel.setText("Catch 'em: Level " + catchEmHighScore);
        dodgeEmHSLabel.setText("Dodge 'em: Level " + dodgeEmHighScore);
        mainMenuLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        mainMenuLabel.setText("Catch and Dodge 'em");
        mainMenuLabel.setBounds(225,25,400,50);

        highScoreLabel.setBounds(300,50,200,50);
        catchEmHSLabel.setBounds(300,200,250,50);
        dodgeEmHSLabel.setBounds(300,350,250,50);
        mmp.add(mainMenuLabel);
        hsp.add(highScoreLabel);
        hsp.add(catchEmHSLabel);
        hsp.add(dodgeEmHSLabel);


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
        playCatchEmButton = new JButton("Play Catch' em");
        playDodgeEmButton = new JButton("Play Dodge' em");
        viewHighScoreButton = new JButton("View High Score");
        returnToHomeButton = new JButton("Return to Main Menu");
        playCatchEmButton.addActionListener(this);
        playDodgeEmButton.addActionListener(this);
        viewHighScoreButton.addActionListener(this);
        returnToHomeButton.addActionListener(this);
        playCatchEmButton.setBounds(300,100,200,50);
        playDodgeEmButton.setBounds(300,170,200,50);
        viewHighScoreButton.setBounds(300,300,200,50);
        returnToHomeButton.setBounds(0,0,200,50);
        mmp.add(playCatchEmButton);
        mmp.add(playDodgeEmButton);
        mmp.add(viewHighScoreButton);
        hsp.add(returnToHomeButton);

    }


    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playCatchEmButton) {
            this.dispose();
            new CatchEmApp(1, 1, catchEmHighScore, dodgeEmHighScore);
        } else if (e.getSource() == viewHighScoreButton) {
            cl.show(panelCont, "2");
        } else if (e.getSource() == returnToHomeButton) {
            cl.show(panelCont, "1");
        } else if (e.getSource() == playDodgeEmButton) {
            this.dispose();
            new DodgeEmApp(1,1, catchEmHighScore, dodgeEmHighScore);
        }
    }
}
