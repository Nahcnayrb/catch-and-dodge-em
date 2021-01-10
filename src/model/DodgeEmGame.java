package model;

import java.util.ArrayList;
import java.util.List;

public class DodgeEmGame extends Game {

    public DodgeEmGame(double difficulty) {
        super(difficulty);
    }

    public void checkCollision() {
        List<Ball> ballsOut = new ArrayList<Ball>();
        for (Ball next : listOfBalls) {
            if ((next.getX()) + next.getWidth()/2 >= WIDTH) {
                ballsOut.add(next);
            }
        }
        listOfBalls.removeAll(ballsOut);
    }

    public void checkGameOver() {
        for (Ball next : listOfBalls) {
            if (checkBallHit(next)) {
                isGameOver = true;
                break;
            }
        }
    }
}
