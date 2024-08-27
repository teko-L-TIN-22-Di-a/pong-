package ch.teko.loefflee;

import java.util.Random;

/**
 * Wind-Klasse, die zufällige Windstärken für das Pong-Spiel generiert.
 */
public class Wind {
    private float x;
    private float y;
    private float randomNumberx;
    private float randomNumbery;

    /**
     * Generiert zufällige Windstärken für die X- und Y-Achse.
     * Die Windstärke variiert zwischen -3 und 3.
     * @param paddle
     */
    public void randomWind(Paddle paddle) {
        Random Rn = new Random();

        if (paddle.getIsCpu()) {
            randomNumberx = Rn.nextFloat((float) 0.1, (float) 0.8);
            do {
                randomNumbery = Rn.nextFloat((float) -1.3, (float) 1.3);
            } while (randomNumbery == 0);

        } else {
            randomNumberx = Rn.nextFloat((float) -0.8, (float) -0.1);
            do{
                randomNumbery = Rn.nextFloat((float) -1.3, (float) 1.3);
            } while (randomNumbery == 0);
        }
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
