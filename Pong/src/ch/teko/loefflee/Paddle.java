package ch.teko.loefflee;

import java.awt.*;

/**
* Paddle Klasse
 */
public class Paddle {
    private int x, y;
    private int width, height;
    private int speed;
    private Color color;
    private boolean isCpu;

/**
* Paddle Konstruktor
 * Grösse, Farbe, Form, Geschwindigkeit, CPU/Player
 */
    public Paddle(int x, int y, int width, int height, int speed, Color color, boolean isCpu) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
        this.isCpu = isCpu;
    }

    /**
    * Geschwindigkeit der Paddles
     */
    public void moveUp() {
        y -= speed;
    }

    /**
    * Geschwindigkeit der Paddles
     */
    public void moveDown() {
        y += speed;
    }

    /**
    * Zeichnet das rechteckige Paddle
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
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

    public void setColor(Color color) {
        this.color = color;
    }

    /**
    * Unterscheidet zwischen CPU und Player Paddle
    * Limitiert die Bewegung der Paddles -> Decke und Boden
     */
    public void move(int ballY, int windowHeight, int windowWidth) {
        if (this.isCpu) {

            int speed = 3;

            if (ballY < y + height / 2) {
                y -= speed;
            } else if (ballY > y + height / 2) {
                y += speed;
            }

            // Limit für Paddle
            if (y < 0) {
                y = 0;
            } else if (y > windowHeight - height) {
                y = windowHeight - height;
            }

            x = windowWidth - width;
        }
    }

    /**
    * Spezialeffekt, der die Höhe des Paddles halbiert
     */
    public void halvedPaddleSize() {
        this.height = this.height / 2;
        setColor(Color.GRAY);
    }

    /**
    * Setzt die Grösse zurück
     */
    public void resetPaddleSize() {
        this.height = 60;
        setColor(Color.WHITE);
    }
}