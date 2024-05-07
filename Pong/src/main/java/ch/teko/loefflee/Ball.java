package src.main.java.ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y;
    private int dx, dy;
    private int speed;
    private int size; // Variable for the size of the ball

    public Ball(int windowWidth, int windowHeight) {
        // Set the starting position of the ball to the center of the window
        this.x = windowWidth / 2 - 5; // Half of the window width minus half of the ball size
        this.y = windowHeight / 2 - 5; // Half of the window height minus half of the ball size

        // Set random starting movement direction of the ball
        setRandomDirection();

        // Set ball speed
        this.speed = 2;
        this.size = 10; // Default size of the ball
    }

    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1; // Either 1 (right) or -1 (left)
        dy = random.nextBoolean() ? 1 : -1; // Either 1 (down) or -1 (up)
    }

    public void move() {
        // Move the ball based on the current speed and direction
        x += dx * speed;
        y += dy * speed;
    }

    public void draw(Graphics g) {
        // Draw the ball
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);
    }

    // Additional methods to manage ball movement and direction...

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
        // Reset the ball to the center of the window
        this.x = windowWidth / 2 - 5; // Half of the window width minus half of the ball size
        this.y = windowHeight / 2 - 5; // Half of the window height minus half of the ball size
        setRandomDirection();
    }


    // New methods added:
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDx() {
        return dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDy() {
        return dy;
    }
}
