package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

/**
 * Repräsentiert den Ball im Pong Spiel
 * Der Ball bewegt sich durch das Spielfelt, prallt an paddles und Wänden ab und wird vom Wind bewegt.
 */
public class Ball {
    private float x, y;
    private float dx, dy;
    private float speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;
    private static final float friction = 0.995f;
    private static final float MIN_SPEED = 3f;
    private static final float maxSpeed = 18f;
    private static final float windfactor = 0.05f;
    private static final long spawnSpeedReductionDuration = 1000; // 1 second in milliseconds

    /**
     * Konstruktor des Balls
     *
     * @param windowWidth  Die Weite des Spielfensters
     * @param windowHeight Die Höhe des Spielfensters
     */
    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        this.speed = 9f;
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }

    /**
     * Setzt eine zufällige Richtung des Balls
     */
    private void setRandomDirection() {
        Random random = new Random();
        float angle = (float) (random.nextFloat() * 2 * Math.PI);
        dx = (float) Math.cos(angle) * speed;
        dy = (float) Math.sin(angle) * speed;
    }

    /**
     * Bewegt den ball, führt Windstärke, die Reibung aus und limitiert das Tempo des Balls.
     * Die Geschwindigkeit des Balls wird halbiert für die erste Sekunde nach dem "spawn"
     *
     * @param wind verändert die Bewegung des Balls
     */
    public void move(Wind wind) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        float speedMultiplier = elapsedTime < spawnSpeedReductionDuration ? 0.5f : 1f;

        // Apply wind influence
        dx += wind.getX() * windfactor;
        dy += wind.getY() * windfactor;

        // Apply friction
        dx *= friction;
        dy *= friction;

        // Stellt minimum speed sicher
        float currentVelocity = (float) Math.sqrt(dx * dx + dy * dy);
        if (currentVelocity < MIN_SPEED * speedMultiplier) {
            float scaleFactor = (MIN_SPEED * speedMultiplier) / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        // Stellt minimum speed sicher
        float maxSpeed = doubleBallSpeedIsOn ? Ball.maxSpeed * 2 : Ball.maxSpeed;
        maxSpeed *= speedMultiplier;
        if (currentVelocity > maxSpeed) {
            float scaleFactor = maxSpeed / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        x += dx * speedMultiplier;
        y += dy * speedMultiplier;

        // Update color based on time since reset
        if (elapsedTime < spawnSpeedReductionDuration) {
            this.color = Color.GRAY;
        } else if (!this.doubleBallSpeedIsOn) {
            this.color = Color.WHITE;
        }
    }

    /**
     * Ändert die horizontale Richtung des Balls.
     */
    public void changeDirectionX() {
        dx = -dx;
    }

    /**
     * Ändert die vertikale Richtung des Balls.
     */
    public void changeDirectionY() {
        dy = -dy;
    }

    /**
     * Zeichnet den Ball
     *
     * @param g Kontext der Grafik
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, size, size);
    }

    /**
     * Gibt die x-Koordinate des balls.
     */
    public int getX() {
        return (int)x;
    }

    /**
     * Gibt die y-Koordinate des balls.
     */
    public int getY() {
        return (int)y;
    }

    /**
     * Gibt die Grösse des Balls.
     */
    public int getSize() {
        return size;
    }

    /**
     * Setzt die Ballgeschwindigkeit zurück und erstellt ihn neu in der Mitte des Spielfelds
     * @param windowWidth  Die Weite des Spielfensters
     * @param windowHeight Die Höhe des Spielfensters
     */
    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }

    /**
     * Verdoppelt die Geschwindigkeit des Balls und verändert die Farbe rot.
     */
    public void doubleBallSpeed() {
        this.speed *= 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    /**
     * Setzt die Änderungen des Balls zurück.
     */
    public void resetBallSpeed() {
        this.speed = 8;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }
}