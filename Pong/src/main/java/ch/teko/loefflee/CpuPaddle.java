package ch.teko.loefflee;
import java.awt.*;

public class CpuPaddle {
    private int x, y;
    private int width, height;

    public CpuPaddle(int x, int y) {
        this.x = x;
        this.y = y;
        width = 10;
        height = 60;
    }

    public void move(int ballY) {
        // Erhöhe die Geschwindigkeit, indem du die Bewegung um mehr als eine Einheit vergrößerst
        int speed = 3; // Beispiel: Eine schnellere Geschwindigkeit

        if (ballY < y + height / 2) {
            y -= speed;
        } else if (ballY > y + height / 2) {
            y += speed;
        }
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
