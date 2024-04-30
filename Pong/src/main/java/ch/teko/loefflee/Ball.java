package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int x, y;
    private int dx, dy;
    private int speed;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 2;
        setRandomDirection();
    }

    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1; // Either 1 (right) or -1 (left)
        dy = random.nextBoolean() ? 1 : -1; // Either 1 (down) or -1 (up)
    }

    public void move() {
        x += dx * speed;
        y += dy * speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 10, 10);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
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
}
