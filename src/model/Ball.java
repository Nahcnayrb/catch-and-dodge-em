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
    private int horizontalSpeed;
    private int verticalSpeed;


    public Ball() {
        x = 0;
        y = (int) ((Math.random() * (MAX_Y - MIN_Y)) + MIN_Y);
        horizontalSpeed = (int) ((Math.random() * (MAX_SPEED - MIN_SPEED)) + MIN_SPEED);
        verticalSpeed = (int) ((Math.random() * (MAX_SPEED - MIN_SPEED)) + MIN_SPEED);
        verticalDirection = NEUTRAL;
    }

    private int getNewVerticalDirection() {
        return (int) ((Math.random() * 3));


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public int getVerticalSpeed() {
        return verticalSpeed;
    }

    public int getVerticalDirection() {
        return verticalDirection;
    }

    public void tick() {
        if (getVerticalDirection() == UP) {
            y = y - verticalSpeed;
        } else if (getVerticalDirection() == DOWN) {
            y = y + verticalSpeed;
        }
        x = x + horizontalSpeed;
        verticalDirection = getNewVerticalDirection();
    }

}
