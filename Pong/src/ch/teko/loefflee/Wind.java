package ch.teko.loefflee;

import java.util.Random;

/**
 * Repräsentiert den Wind im Spiel, der den Ball beeinflusst.
 * Der Wind ändert sich allmählich und hat eine variierende Stärke und Richtung.
 */
public class Wind {
    private float x;
    private float y;
    private Random random;
    private static final float MAX_WIND_STRENGTH = 0.4f;
    private static final float WIND_CHANGE_RATE = 0.03f;

    /**
     * Erstellt ein neues Wind-Objekt mit zufälliger Anfangsstärke und -richtung.
     */
    public Wind() {
        random = new Random();
        x = (random.nextFloat() - 0.5f) * MAX_WIND_STRENGTH;
        y = (random.nextFloat() - 0.5f) * MAX_WIND_STRENGTH;
    }

    /**
     * Aktualisiert die Windstärke und -richtung.
     * Der Wind ändert sich allmählich und bleibt innerhalb festgelegter Grenzen.
     */
    public void update() {
        // Ändere Wind allmählich
        x += (random.nextFloat() - 0.5f) * WIND_CHANGE_RATE;
        y += (random.nextFloat() - 0.5f) * WIND_CHANGE_RATE;

        // Begrenze Windstärke
        x = Math.max(-MAX_WIND_STRENGTH, Math.min(MAX_WIND_STRENGTH, x));
        y = Math.max(-MAX_WIND_STRENGTH, Math.min(MAX_WIND_STRENGTH, y));
    }

    /**
     * Gibt die horizontale Komponente der Windstärke zurück.
     *
     * @return Die horizontale Windstärke
     */
    public float getX() {
        return x;
    }

    /**
     * Gibt die vertikale Komponente der Windstärke zurück.
     *
     * @return Die vertikale Windstärke
     */
    public float getY() {
        return y;
    }
}