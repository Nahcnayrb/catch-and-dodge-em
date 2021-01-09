package model;

public class Ball {

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 10;
    private final int MIN_Y = 0;
    private final int MAX_Y = 800;
    private final int NEUTRAL = 0;
    private final int UP = 1;
    private final int DOWN = 2;
    private int x;
    private int y;
    private int verticalDirection;
    private int speed;


    public Ball() {
        x = 0;
        y = (int) ((Math.random() * (MAX_Y - MIN_Y)) + MIN_Y);
        speed = (int) ((Math.random() * (MAX_SPEED - MIN_SPEED)) + MIN_SPEED);
        verticalDirection = NEUTRAL;
    }

}
