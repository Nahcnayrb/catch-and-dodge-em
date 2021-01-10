package model;

import java.util.ArrayList;
import java.util.List;

public class DodgeEmGame extends Game {

    public DodgeEmGame(double difficulty) {
        super(difficulty + 1, "dodge");
    }

    public void checkBoundary() {
        for (Ball b : listOfBalls) {
            if (b.getY() <= (b.getHeight() / 2)) {
                b.bounceDown();
            } else if (b.getY() >= (HEIGHT - b.getHeight() * 2.75)) {
                b.bounceUp();
            }
        }
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
                listOfBalls.add(new Ball());
                break;
            }
        }
    }
}
