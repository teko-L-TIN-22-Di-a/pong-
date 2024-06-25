package ch.teko.loefflee;

import java.util.Random;

/**
 * Wind-Klasse, die zufällige Windstärken für das Pong-Spiel generiert.
 */
public class Wind {
    private int x;
    private int y;

    /**
     * Generiert zufällige Windstärken für die X- und Y-Achse.
     * Die Windstärke variiert zwischen -3 und 3.
     */
    public void randomWind() {
        Random Rn = new Random();

        int randomNumberx = Rn.nextInt(-3, 3);
        int randomNumbery = Rn.nextInt(-3, 3);

        this.x = randomNumberx;
        this.y = randomNumbery;
    }

    /**
     * Gibt die Windstärke auf der X-Achse zurück.
     *
     * @return die Windstärke auf der X-Achse
     */
    public int getX() {
        return x;
    }

    /**
     * Gibt die Windstärke auf der Y-Achse zurück.
     *
     * @return die Windstärke auf der Y-Achse
     */
    public int getY() {
        return y;
    }
}
