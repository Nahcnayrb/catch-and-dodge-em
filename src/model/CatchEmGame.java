package model;

import java.util.ArrayList;
import java.util.List;

public class CatchEmGame extends Game {

    public CatchEmGame(double difficulty) {
        super(difficulty, "catch");
    }

    public void checkCollision() {
        List<Ball> ballsHit = new ArrayList<Ball>();
        for (Ball next : listOfBalls) {
            if (checkBallHit(next)) {
                ballsHit.add(next);
            }
        }
        listOfBalls.removeAll(ballsHit);
    }

    public void checkGameOver() {
        for (Ball next : listOfBalls) {
            if ((next.getX() + (next.getWidth() / 2)) >= WIDTH) {
                isGameOver = true;
                break;
            }
        }
    }
}
