package ch.teko.loefflee;

import java.util.Random;

public class Wind {
    private int x;
    private int y;

    public void randomWind() {
        Random Rn = new Random();

        int randomNumberx = Rn.nextInt(-3, 3);
        int randomNumbery = Rn.nextInt(-3, 3);

        this.x = randomNumberx;
        this.y = randomNumbery;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}



/*
werte xy von wind in im main verwendbar machen
funktion, die sich in ball befindet aufrufen können
getter

HERAUSFORDERUNG FALLS LANGWEILIG:
ball.manipulatexy (wind.getdirection())
 */