package model;

public class Catcher {
    private int x;
    private int y;
    private static final int SPEED = 2;
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;

    public Catcher(){
        this.x = CatchEmGame.WIDTH/2;
        this.y = CatchEmGame.HEIGHT/2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
