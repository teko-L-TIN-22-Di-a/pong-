package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

/**
 * Ball-Klasse, die den Ball im Pong-Spiel repräsentiert.
 */
public class Ball {
    private int x, y;
    private float dx, dy;
    private int speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;

    /**
     * Konstruktor für den Ball.
     * Der Ball spawnt in der Mitte des Spielfelds und wird mit Farbe, Größe und Geschwindigkeit initialisiert.
     *
     * @param windowWidth  die Breite des Fensters
     * @param windowHeight die Höhe des Fensters
     */
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

    /**
     * Setzt eine zufällige Richtung für den Ball nach dem Spawn.
     */
    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1;
        dy = random.nextBoolean() ? 1 : -1;
    }

    /**
     * Bewegt den Ball.
     * In der ersten Sekunde nach dem Spawn bewegt sich der Ball mit halber Geschwindigkeit und ist grau gefärbt.
     * Danach bewegt er sich mit normaler Geschwindigkeit und ist weiß.
     */
    public void move() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        if (elapsedTime < 1000) {
            x += dx * (speed / 2);
            y += dy * (speed / 2);
            this.color = Color.GRAY;
        } else {
            if (!this.doubleBallSpeedIsOn) {
                this.color = Color.WHITE;
            }
            x += dx * speed;
            y += dy * speed;
        }
    }

    /**
     * Zeichnet den Ball als Kreis.
     *
     * @param g das Grafikobjekt zum Zeichnen
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    /**
     * Ändert die Richtung des Balls auf der X-Achse (Einfallswinkel = Ausfallswinkel).
     */
    public void changeDirectionX() {
        dx = -dx;
    }

    /**
     * Ändert die Richtung des Balls auf der Y-Achse (Einfallswinkel = Ausfallswinkel).
     */
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

    /**
     * Manipuliert die Position des Balls.
     *
     * @param x positive Zahlen bewegen den Ball nach rechts, negative nach links
     * @param y positive Zahlen bewegen den Ball nach unten, negative nach oben
     */
    public void manipulatexy(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Wendet Windkraft auf den Ball an.
     *
     * @param windX Windstärke auf der X-Achse
     * @param windY Windstärke auf der Y-Achse
     */
    public void applyWind(float windX, float windY) {
        dx += windX;
        dy += windY;
        System.out.println("dy = " + dy);
        manipulatexy(dx, dy);
    }

    /**
     * Setzt den Ball in die Mitte des Spielfelds zurück.
     *
     * @param windowWidth  die Breite des Fensters
     * @param windowHeight die Höhe des Fensters
     */
    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }

    /**
     * Verdoppelt die Geschwindigkeit des Balls als Spezialeffekt.
     */
    public void doubleBallSpeed() {
        this.speed = this.speed * 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    /**
     * Setzt die Geschwindigkeit des Balls auf den ursprünglichen Wert zurück.
     */
    public void resetBallSpeed() {
        this.speed = 3;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }
}
