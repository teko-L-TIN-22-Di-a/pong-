package src.main.java.ch.teko.loefflee;

import java.awt.*;

public class Paddle {
    protected int x, y;
    protected int width = 10, height = 60;
    protected int speed = 5;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Diese Methode ermöglicht es, die Höhe des Paddels zu setzen
    public void setHeight(int height) {
        this.height = height;
    }
}
