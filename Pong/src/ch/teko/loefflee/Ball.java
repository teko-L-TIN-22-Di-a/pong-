package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

public class Ball {
    private float x, y;
    private float dx, dy;
    private int speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;
    private static final float FRICTION = 0.99f;
    private static final float MIN_HORIZONTAL_SPEED = 0.5f;
    private static final float WIND_FACTOR = 0.3f;
    private static final float WIND_SPEED_BOOST = 1.2f;


    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        this.speed = 2;
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }

    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextFloat() * 2 - 1; // Random float between -1 and 1
        dy = random.nextFloat() * 2 - 1; // Random float between -1 and 1
        normalizeSpeed();
    }

    private void normalizeSpeed() {
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        if (length != 0) {
            dx = dx / length * speed;
            dy = dy / length * speed;
        }
    }

    public void move(Wind wind) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        float currentSpeed = elapsedTime < 1000 ? speed / 2f : speed;

        // Apply wind as acceleration

        float windX = wind.getX();
        float windY = wind.getY();
        dx += windX * WIND_FACTOR;
        dy += windY * WIND_FACTOR;

        // Apply wind speed boost
        float windStrength = (float) Math.sqrt(windX * windX + windY * windY);
        float speedBoost = 1 + (windStrength * WIND_SPEED_BOOST);

        // Apply friction
        dx *= FRICTION;
        dy *= FRICTION;

        // Ensure minimum horizontal speed
        if (Math.abs(dx) < MIN_HORIZONTAL_SPEED) {
            dx = dx < 0 ? -MIN_HORIZONTAL_SPEED : MIN_HORIZONTAL_SPEED;
        }

        // Limit maximum speed
        float maxSpeed = (doubleBallSpeedIsOn ? currentSpeed * 2 : currentSpeed) * speedBoost;
        float currentVelocity = (float) Math.sqrt(dx * dx + dy * dy);
        if (currentVelocity > maxSpeed) {
            dx = (dx / currentVelocity) * maxSpeed;
            dy = (dy / currentVelocity) * maxSpeed;
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
        normalizeSpeed(); // Ensure consistent speed after bouncing
    }

    public void changeDirectionY() {
        dy = -dy;
        normalizeSpeed(); // Ensure consistent speed after bouncing
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
        this.speed = this.speed * 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    public void resetBallSpeed() {
        this.speed = 3;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }

    // Removed manipulatexy and applyWind methods as they're no longer needed
}