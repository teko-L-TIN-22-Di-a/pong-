package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;

/**
 * Represents the ball in the Pong game.
 * The ball moves across the screen, bounces off paddles and walls, and is affected by wind.
 */
public class Ball {
    private float x, y;
    private float dx, dy;
    private float speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Color color;
    private long lastResetTime;
    private static final float FRICTION = 0.995f;
    private static final float MIN_SPEED = 3f;
    private static final float MAX_SPEED = 18f;
    private static final float WIND_FACTOR = 0.05f;
    private static final long SPAWN_SPEED_REDUCTION_DURATION = 1000; // 1 second in milliseconds

    /**
     * Constructs a new Ball object.
     *
     * @param windowWidth  The width of the game window
     * @param windowHeight The height of the game window
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
     * Sets a random direction for the ball's movement.
     */
    private void setRandomDirection() {
        Random random = new Random();
        float angle = (float) (random.nextFloat() * 2 * Math.PI);
        dx = (float) Math.cos(angle) * speed;
        dy = (float) Math.sin(angle) * speed;
    }

    /**
     * Moves the ball, applying wind influence, friction, and speed limits.
     * The ball's speed is halved for the first second after spawning.
     *
     * @param wind The current wind object affecting the ball's movement
     */
    public void move(Wind wind) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        float speedMultiplier = elapsedTime < SPAWN_SPEED_REDUCTION_DURATION ? 0.5f : 1f;

        // Apply wind influence
        dx += wind.getX() * WIND_FACTOR;
        dy += wind.getY() * WIND_FACTOR;

        // Apply friction
        dx *= FRICTION;
        dy *= FRICTION;

        // Ensure minimum speed
        float currentVelocity = (float) Math.sqrt(dx * dx + dy * dy);
        if (currentVelocity < MIN_SPEED * speedMultiplier) {
            float scaleFactor = (MIN_SPEED * speedMultiplier) / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        // Limit maximum speed
        float maxSpeed = doubleBallSpeedIsOn ? MAX_SPEED * 2 : MAX_SPEED;
        maxSpeed *= speedMultiplier;
        if (currentVelocity > maxSpeed) {
            float scaleFactor = maxSpeed / currentVelocity;
            dx *= scaleFactor;
            dy *= scaleFactor;
        }

        x += dx * speedMultiplier;
        y += dy * speedMultiplier;

        // Update color based on time since reset
        if (elapsedTime < SPAWN_SPEED_REDUCTION_DURATION) {
            this.color = Color.GRAY;
        } else if (!this.doubleBallSpeedIsOn) {
            this.color = Color.WHITE;
        }
    }

    /**
     * Changes the horizontal direction of the ball.
     */
    public void changeDirectionX() {
        dx = -dx;
    }

    /**
     * Changes the vertical direction of the ball.
     */
    public void changeDirectionY() {
        dy = -dy;
    }

    /**
     * Draws the ball on the given graphics context.
     *
     * @param g The graphics context to draw on
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x, (int)y, size, size);
    }

    /**
     * Gets the x-coordinate of the ball.
     *
     * @return The x-coordinate of the ball
     */
    public int getX() {
        return (int)x;
    }

    /**
     * Gets the y-coordinate of the ball.
     *
     * @return The y-coordinate of the ball
     */
    public int getY() {
        return (int)y;
    }

    /**
     * Gets the size of the ball.
     *
     * @return The size of the ball
     */
    public int getSize() {
        return size;
    }

    /**
     * Resets the ball to the center of the screen and resets its speed.
     *
     * @param windowWidth  The width of the game window
     * @param windowHeight The height of the game window
     */
    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }

    /**
     * Doubles the ball's speed and changes its color to red.
     */
    public void doubleBallSpeed() {
        this.speed *= 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }

    /**
     * Resets the ball's speed to its default value and color to white.
     */
    public void resetBallSpeed() {
        this.speed = 8;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }
}