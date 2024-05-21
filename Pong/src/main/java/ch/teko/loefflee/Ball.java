import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y;
    private int speed;
    private int size;
    private string color;

    public Ball(int x, int y) {
        this.x = x / 2 - 5;
        this.y = y / 2 - 5;
        this.speed = 3;
        this.size = 10;
        this.color = Color.WHITE
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
        g.fillOval(x, y, size, size);
    }

    public void setColor(String color) {
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
        // Reset the ball to the center of the window
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        setRandomDirection();
    }

    public void resetSpeed() {
        this.speed = defaultSpeed; // Setzt die Geschwindigkeit auf die Standardgeschwindigkeit zurück
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void doubleBallSpeed{
        this.speed = this.speed * 2;
    }

    public void resetBallSpeed(){
        this.speed = 3;
    }
}