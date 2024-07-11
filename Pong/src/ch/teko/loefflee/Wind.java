package ch.teko.loefflee;

import java.util.Random;

/**
 * Wind-Klasse, die zufällige Windstärken für das Pong-Spiel generiert.
 */
public class Wind {
    private float x;
    private float y;

    /**
     * Generiert zufällige Windstärken für die X- und Y-Achse.
     * Die Windstärke variiert zwischen -3 und 3.
     */
    public void randomWind() {
        Random Rn = new Random();

        float randomNumberx = Rn.nextFloat((float) -1.5, (float)1.5);
        float randomNumbery = Rn.nextFloat((float) -2.2, (float) 2.2);

        this.x = randomNumberx;
        this.y = randomNumbery;
    }

    /**
     * Gibt die Windstärke auf der X-Achse zurück.
     *
     * @return die Windstärke auf der X-Achse
     */
    public float getX() {
        return x;
    }

    /**
     * Gibt die Windstärke auf der Y-Achse zurück.
     *
     * @return die Windstärke auf der Y-Achse
     */
    public float getY() {
        return y;
    }
}
