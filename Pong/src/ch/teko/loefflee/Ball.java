package ch.teko.loefflee;

import java.awt.*;
import java.util.Random;
/**
* Ball Klasse
 */
public class Ball {
    private int x, y, dx, dy;
    private int speed;
    private int size;
    private boolean doubleBallSpeedIsOn;
    private Wind wind;
    private Color color;
    private long lastResetTime;

/**
* Ball spawnt in der Mitte des Spielfeldes und gibt Farbe, Grösse und Geschwindigkeit an.
 */
    public Ball(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        this.speed = 3;
        this.size = 13;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
        this.wind = new Wind();
        lastResetTime = System.currentTimeMillis();
        setRandomDirection();
    }
    /**
    * Random Richtung nach spawn
     */
    private void setRandomDirection() {
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1;
        dy = random.nextBoolean() ? 1 : -1;
    }

    /**
    * Gibt Bewegung des Balls an.
    * 1. Sekunde nach spawn mit halber Geschwindigkeit und grau.
    * Danach Normale Geschwindigkeit und weiss.
     */
    public void move() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastResetTime;
        if (elapsedTime < 1000) {
            x += dx * (speed / 2);
            y += dy * (speed / 2);
            this.color = Color.GRAY;
        } else {
            if (this.doubleBallSpeedIsOn == false) {
                this.color = Color.WHITE;
            }
            x += dx * speed;
            y += dy * speed;
        }
    }

    /**
    * Zeichnet den Ball rund
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    /**
    * Einfallswinkel = Ausfallwinkel
     */
    public void changeDirectionX() {
        dx = -dx;
    }
    /**
    * Einfallswinkel = Ausfallwinkel
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
     *
     * @param x positive Zahlen bewegen den Ball nach rechts, negative nach links
     * @param y positive Zahlen bewegen den Ball nach unten, negative nach oben
     */
    public void manipulatexy (int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void applyWind () {
        wind.randomWind();
        manipulatexy(wind.getX(), wind.getY());
    }


    /**
    * Respawnt den ball in der Mitte des Spielfeldes
    */
    public void reset(int windowWidth, int windowHeight) {
        this.x = windowWidth / 2 - 5;
        this.y = windowHeight / 2 - 5;
        lastResetTime = System.currentTimeMillis();
        resetBallSpeed();
        setRandomDirection();
    }

    /**
    * Spezialeffekt, welche die Ballgeschwindigkeit verdoppelt
     */
    public void doubleBallSpeed() {
        this.speed = this.speed * 2;
        this.doubleBallSpeedIsOn = true;
        this.color = Color.RED;
    }
    /**
    * Setzt Ballgeschwindigkeit zurück
     */
    public void resetBallSpeed(){
        this.speed = 3;
        this.doubleBallSpeedIsOn = false;
        this.color = Color.WHITE;
    }
}
