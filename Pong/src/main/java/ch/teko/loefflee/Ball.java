package src.main.java.ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y;
    public int dx, dy;
    private int speed;
    private int size;
    private int defaultSpeed = 3; // Standardgeschwindigkeit des Balls

    public Ball(int windowWidth, int windowHeight) {
        // Startposition mittig des Fensters
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;

        setRandomDirection();

        this.speed = defaultSpeed;
        this.size = 10;
    }

    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1;
        dy = random.nextBoolean() ? 1 : -1;
    }

    public void move() {
        // Weiterführende Bewegung des Balls
        x += dx * speed;
        y += dy * speed;
    }

    public void draw(Graphics g) {
        // Erstellt den Ball
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
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
        // Reset the ball to the center of the window
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        setRandomDirection();
    }

    public void resetSpeed() {
        this.speed = defaultSpeed; // Setze die Geschwindigkeit auf die Standardgeschwindigkeit zurück
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
