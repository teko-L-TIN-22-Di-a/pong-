package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

/**
 * Repräsentiert den Ball im Pong-Spiel.
 * Der Ball bewegt sich über das Spielfeld und wird von Wind beeinflusst.
 */
public class Ball {
    private float x, y;
    private float dx, dy;
    private float speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;
    private static final float FRICTION = 0.999f;
    private static final float MIN_SPEED = 5f;
    private static final float MAX_SPEED = 15f;
    private static final float WIND_FACTOR = 0.1f;

    /**
     * Erstellt einen neuen Ball mit einer zufälligen Startrichtung.
     *
     * @param windowWidth  Die Breite des Spielfensters
     * @param windowHeight Die Höhe des Spielfensters
     */
    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2f - 5;
        this.y = windowHeight / 2f - 5;
        this.speed = 7f;
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }

    /**
     * Setzt eine zufällige Bewegungsrichtung für den Ball.
     */
    private void setRandomDirection() {
        Random random = new Random();
        float angle = (float) (random.nextFloat() * Math.PI / 2 + Math.PI / 4);
        if (random.nextBoolean()) angle += Math.PI;
        dx = (float) Math.cos(angle) * speed;
        dy = (float) Math.sin(angle) * speed;
    }

    /**
     * Bewegt den Ball und wendet Windeinfluss an.
     *
     * @param wind Das Wind-Objekt, das den aktuellen Windstatus repräsentiert
     * @param windowWidth Die Breite des Spielfensters
     * @param windowHeight Die Höhe des Spielfensters
     */
    public void move(Wind wind, int windowWidth, int windowHeight) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        float speedMultiplier = elapsedTime < 1000 ? 0.5f : 1f;

        // Wende Windeinfluss an
        dx += wind.getX() * WIND_FACTOR;
        dy += wind.getY() * WIND_FACTOR;

        // Wende Reibung an
        dx *= FRICTION;
        dy *= FRICTION;

        // Stelle Mindestgeschwindigkeit sicher
        float currentVelocity = (float) Math.sqrt(dx * dx + dy * dy);
        if (currentVelocity < MIN_SPEED) {
            float scaleFactor = MIN_SPEED / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        // Begrenze Maximalgeschwindigkeit
        float maxSpeed = doubleBallSpeedIsOn ? MAX_SPEED * 2 : MAX_SPEED;
        if (currentVelocity > maxSpeed) {
            float scaleFactor = maxSpeed / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        x += dx * speedMultiplier;
        y += dy * speedMultiplier;

        // Prüfe auf Kollisionen mit den Spielfeldrändern
        if (x < 0 || x > windowWidth - size) {
            dx = -dx;
            x = Math.max(0, Math.min(x, windowWidth - size));
        }
        if (y < 0 || y > windowHeight - size) {
            dy = -dy;
            y = Math.max(0, Math.min(y, windowHeight - size));
        }

        // Aktualisiere Farbe basierend auf der Zeit seit dem letzten Reset
        if (elapsedTime < 1000) {
            this.color = Color.GRAY;
        } else if (!this.doubleBallSpeedIsOn) {
            this.color = Color.WHITE;
        }
    }

    public void changeDirectionX() {
        dx = -dx;
    }

    public void changeDirectionY() {
        dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, size, size);
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public int getSize() {
        return size;
    }

    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }

    public void doubleBallSpeed() {
        this.speed *= 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    public void resetBallSpeed() {
        this.speed = 8;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }

    public float getDx() {
        return dx;
    }
}