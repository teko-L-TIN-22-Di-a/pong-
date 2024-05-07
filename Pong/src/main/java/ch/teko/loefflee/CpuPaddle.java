package src.main.java.ch.teko.loefflee;

public class CpuPaddle extends Paddle {
    public CpuPaddle(int x, int y) {
        super(x, y);
    }

    public void move(int ballY, int windowHeight, int windowWidth) {
        int speed = 3;

        if (ballY < y + height / 2) {
            y -= speed;
        } else if (ballY > y + height / 2) {
            y += speed;
        }

        // Sicherstellen, dass das Paddle nicht über den oberen oder unteren Rand hinausgeht
        if (y < 0) {
            y = 0;
        } else if (y > windowHeight - height) {
            y = windowHeight - height;
        }

        // Anpassen der horizontalen Position des Paddles basierend auf der Fensterbreite
        x = windowWidth - width; // Das Paddle bleibt am rechten Rand des Fensters
    }
}
