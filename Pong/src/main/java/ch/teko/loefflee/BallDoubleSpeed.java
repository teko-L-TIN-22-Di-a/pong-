package src.main.java.ch.teko.loefflee;

public class BallDoubleSpeed {
    public static void applyEffect(Ball ball) {
        ball.setSpeed((int) (ball.getSpeed() * 2));
    }
}
