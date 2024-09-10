package ch.teko.loefflee;

import java.util.Random;

public class Wind {
    private float x;
    private float y;
    private Random random;
    private static final float MAX_WIND_STRENGTH = 5f; // Increased from 0.05f to 0.1f
    private static final float WIND_CHANGE_RATE = 0.01f;

    public Wind() {
        random = new Random();
        x = 0;
        y = 0;
    }

    public void update() {
        // Gradually change wind
        x += (random.nextFloat() - 0.5f) * WIND_CHANGE_RATE;
        y += (random.nextFloat() - 0.518f) * WIND_CHANGE_RATE;

        // Limit wind strength
        x = Math.max(-MAX_WIND_STRENGTH, Math.min(MAX_WIND_STRENGTH, x));
        y = Math.max(-MAX_WIND_STRENGTH, Math.min(MAX_WIND_STRENGTH, y));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}


// momentan drückt der wind den ball einfach nach unten. der ball springt also einfach nach oben und sinkt wieder ab, während er sich auf eine seite bewegt. ausserdem soll der ball sich schneller bewegen
// der wind soll den ball weniger direkt nach oben oder unten pressen. mehr auch rechts & links
// wind change rate & max wind strength nur alle 8 sekunden für 3 sekunden