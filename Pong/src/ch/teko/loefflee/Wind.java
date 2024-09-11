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
    private static final float maxWindStrength = 0.4f;
    private static final float windChangeRate = 0.03f;

    /**
     * Erstellt ein neues Wind-Objekt mit zufälliger Anfangsstärke und -richtung.
     */
    public Wind() {
        random = new Random();
        x = (random.nextFloat() - 0.5f) * maxWindStrength;
        y = (random.nextFloat() - 0.5f) * maxWindStrength;
    }

    /**
     * Aktualisiert die Windstärke und -richtung.
     * Der Wind ändert sich allmählich und bleibt innerhalb festgelegter Grenzen.
     */
    public void update() {
        // Ändere Wind allmählich
        x += (random.nextFloat() - 0.5f) * windChangeRate;
        y += (random.nextFloat() - 0.5f) * windChangeRate;

        // Begrenze Windstärke
        x = Math.max(-maxWindStrength, Math.min(maxWindStrength, x));
        y = Math.max(-maxWindStrength, Math.min(maxWindStrength, y));
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