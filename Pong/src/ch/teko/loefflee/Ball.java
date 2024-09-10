package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private float x, y;
    private float dx, dy;
    private float speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;
    private static final float FRICTION = 0.995f; // Increased from 0.99f to reduce speed loss
    private static final float MIN_SPEED = 3f; // Increased from 2f
    private static final float MAX_SPEED = 18f; // Increased from 15f
    private static final float WIND_FACTOR = 0.05f;

    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        this.speed = 9f;  // Increased from 7f for faster initial speed
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }

    private void setRandomDirection() {
        Random random = new Random();
        float angle = (float) (random.nextFloat() * 2 * Math.PI);
        dx = (float) Math.cos(angle) * speed;
        dy = (float) Math.sin(angle) * speed;
    }

    public void move(Wind wind) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        float currentSpeed = elapsedTime < 1000 ? speed / 1.5f : speed;

        // Apply wind influence
        dx += wind.getX() * WIND_FACTOR;
        dy += wind.getY() * WIND_FACTOR;

        // Apply friction
        dx *= FRICTION;
        dy *= FRICTION;

        // Ensure minimum speed
        float currentVelocity = (float) Math.sqrt(dx * dx + dy * dy);
        if (currentVelocity < MIN_SPEED) {
            float scaleFactor = MIN_SPEED / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        // Limit maximum speed
        float maxSpeed = doubleBallSpeedIsOn ? MAX_SPEED * 2 : MAX_SPEED;
        if (currentVelocity > maxSpeed) {
            float scaleFactor = maxSpeed / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        x += dx;
        y += dy;

        // Update color based on time since reset
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
}