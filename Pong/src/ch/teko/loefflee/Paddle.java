package ch.teko.loefflee;

import java.awt.*;

/**
 * Paddle-Klasse, die ein Paddle im Pong-Spiel repräsentiert.
 */
public class Paddle {
    private int x, y;
    private int width, height;
    private int speed;
    private Color color;
    private boolean isCpu;

    /**
     * Konstruktor für das Paddle.
     * Initialisiert Größe, Farbe, Form, Geschwindigkeit und ob es ein CPU- oder Spieler-Paddle ist.
     *
     * @param x       die X-Position des Paddles
     * @param y       die Y-Position des Paddles
     * @param width   die Breite des Paddles
     * @param height  die Höhe des Paddles
     * @param speed   die Geschwindigkeit des Paddles
     * @param color   die Farbe des Paddles
     * @param isCpu   ob das Paddle von der CPU gesteuert wird
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

    public boolean getIsCpu(){
        return isCpu;
    }

    /**
     * Bewegt das Paddle nach oben.
     */
    public void moveUp() {
        y -= speed;
    }

    /**
     * Bewegt das Paddle nach unten.
     */
    public void moveDown() {
        y += speed;
    }

    /**
     * Zeichnet das Paddle als Rechteck.
     *
     * @param g das Grafikobjekt zum Zeichnen
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
     * Bewegt das CPU-Paddle entsprechend der Y-Position des Balls.
     * Limitiert die Bewegung des Paddles, sodass es nicht über die Decke oder den Boden hinausgeht.
     *
     * @param ballY         die Y-Position des Balls
     * @param windowHeight  die Höhe des Fensters
     * @param windowWidth   die Breite des Fensters
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
     * Spezialeffekt, der die Höhe des Paddles halbiert.
     */
    public void halvedPaddleSize() {
        this.height = this.height / 2;
        setColor(Color.GRAY);
    }

    /**
     * Setzt die Größe des Paddles auf den ursprünglichen Wert zurück.
     */
    public void resetPaddleSize() {
        this.height = 60;
        setColor(Color.WHITE);
    }
}
