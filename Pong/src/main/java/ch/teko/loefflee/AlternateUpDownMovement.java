package src.main.java.ch.teko.loefflee;

public class AlternateUpDownMovement {
    private static boolean moveUp = true;

    public static void applyEffect(Ball ball) {
        if (moveUp) {
            ball.setDy(-1);
        } else {
            ball.setDy(1);
        }
        moveUp = !moveUp;
    }
}
