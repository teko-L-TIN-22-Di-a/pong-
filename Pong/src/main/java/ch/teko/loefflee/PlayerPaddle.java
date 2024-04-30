package ch.teko.loefflee;

import java.awt.*;

public class PlayerPaddle {
    private int x, y;
    private int width, height;

    public PlayerPaddle(int x, int y) {
        this.x = x;
        this.y = y;
        width = 10;
        height = 60;
    }

    public void moveUp() {
        y -= 2;
    }

    public void moveDown() {
        y += 2;
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
}
