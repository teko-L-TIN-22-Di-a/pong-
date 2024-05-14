package src.main.java.ch.teko.loefflee;

public class CpuPaddle extends Paddle {
    public CpuPaddle(int x, int y) {
        super(x, y);
    }

    public void move(int ballY, int windowHeight, int windowWidth) {
        int speed = 2;

        if (ballY < y + height / 2) {
            y -= speed;
        } else if (ballY > y + height / 2) {
            y += speed;
        }

        // Limit für Paddle
        if (y < 0) {
            y = 0;
        } else if (y > windowHeight - height) {
            y = windowHeight - height;
        }

        // Anpassen des Paddles basierend der Fensterbreite
        x = windowWidth - width;
    }
}
