package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y, dx, dy;
    private int speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;


    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        this.speed = 3;
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }

    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1;
        dy = random.nextBoolean() ? 1 : -1;
    }

    public void move() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        if (elapsedTime < 1000) {
            x += dx * (speed / 2);
            y += dy * (speed / 2);
            this.color = Color.GRAY;
        } else {
            if (this.doubleBallSpeedIsOn == false) {
                this.color = Color.WHITE;
            }
            x += dx * speed;
            y += dy * speed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeDirectionX() {
        dx = -dx;
    }

    public void changeDirectionY() {
        dy = -dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }


    public void doubleBallSpeed() {
        this.speed = this.speed * 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    public void resetBallSpeed(){
        this.speed = 3;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }
}
