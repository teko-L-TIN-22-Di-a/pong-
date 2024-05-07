package src.main.java.ch.teko.loefflee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpecialEffects {
    private List<Runnable> effects;
    private Random random;
    private Ball originalBallState;
    private boolean effectActive;
    private Timer effectTimer;
    private Timer resetTimer;
    private int ballX, ballY; // Ballposition

    public SpecialEffects(Ball ball) {
        effects = new ArrayList<>();
        effects.add(() -> BallDoubleSpeed.applyEffect(ball));
        effects.add(() -> HalvePaddleSize.applyEffect(PlayerPaddle.getInstance(0, 0)));
        effects.add(() -> AlternateUpDownMovement.applyEffect(ball));

        random = new Random();
        originalBallState = ball; // Ursprünglichen Ballzustand speichern
        effectActive = false;
        ballX = ball.getX(); // Aktuelle Ballposition setzen
        ballY = ball.getY();

        startEffectTimer();
        startResetTimer();
    }

    private void startEffectTimer() {
        effectTimer = new Timer();
        effectTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!effectActive) {
                    int index = random.nextInt(effects.size());
                    Runnable effect = effects.get(index);
                    effect.run();
                    effectActive = true;
                }
            }
        }, 0, 10000); // 0ms Startverzögerung, 10000ms Intervall (10 Sekunden)
    }

    private void startResetTimer() {
        resetTimer = new Timer();
        resetTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetEffect();
            }
        }, 5000); // 5000ms (5 Sekunden)
    }

    private void resetEffect() {
        // Ball mit gespeicherter Position und Zustand erstellen
        Ball currentBallState = new Ball(ballX, ballY);
        currentBallState.setSpeed(originalBallState.getSpeed());
        currentBallState.setDx(originalBallState.getDx());
        currentBallState.setDy(originalBallState.getDy());

        // Paddelhöhe zurücksetzen
        PlayerPaddle.getInstance(0, 0).setHeight(60);

        effectActive = false;
    }
}
