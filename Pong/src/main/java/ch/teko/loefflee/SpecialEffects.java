package src.main.java.ch.teko.loefflee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialEffects {
    private List<Runnable> effects;
    private Random random;
    private Ball originalBallState;
    private Timers timers;

    public SpecialEffects() {
        effects = new ArrayList<>();
        effects.add(() -> BallDoubleSpeed.applyEffect(new Ball(800, 600))); // Beispielwerte für Fensterbreite und -höhe
        effects.add(() -> HalvePaddleSize.applyEffect(new Paddle(0, 0)));


        random = new Random();
        originalBallState = new Ball(800, 600); // Beispielwerte für Fensterbreite und -höhe

        timers = new Timers(this);
        timers.startEffectTimer();
    }


    public void activateRandomEffect() {
        int index = random.nextInt(effects.size());
        Runnable effect = effects.get(index);
        effect.run();
    }

    public void resetEffect() {
        originalBallState.resetSpeed(); // Zurücksetzen des Effekts
    }

}
