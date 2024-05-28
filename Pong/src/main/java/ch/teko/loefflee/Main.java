/*
git add .
git commit -m "text"
git push
 */


package ch.teko.loefflee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main extends JPanel implements KeyListener {
    private Ball ball;
    private Paddle playerPaddle;
    private Paddle cpuPaddle;
    private int playerScore;
    private int cpuScore;
    private Random random;


    public Main() {
        setFocusable(true);
        addKeyListener(this);

        // Create the ball
        ball = new Ball(getWidth(), getHeight());

        Color playerColor = Color.WHITE;
        Color cpuColor = Color.WHITE;

        playerPaddle = new Paddle(0, getHeight() / 2, 8, 72, 10, playerColor, false);
        cpuPaddle = new Paddle(getWidth() - 40, getHeight() / 2, 8, 72, 10, cpuColor, true);

        // Initialize scores
        playerScore = 0;
        cpuScore = 0 - 1;

        randyRandomEffect();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // Feldgrösse = Fenstergrösse
        int borderWidth = 0;
        int fieldWidth = getWidth() - 2 * borderWidth;
        int fieldHeight = getHeight() - 2 * borderWidth;

        g.fillRect(borderWidth, borderWidth, fieldWidth, fieldHeight);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player: " + playerScore, 10, 20);
        g.drawString("CPU: " + cpuScore, getWidth() - 100, getHeight() - 20);

        ball.draw(g);
        playerPaddle.draw(g);
        cpuPaddle.draw(g);
    }

    public void updateGame() {
        // Update ball position
        ball.move();

        int ballX = ball.getX();
        int ballY = ball.getY();
        int ballSize = ball.getSize();

        // Check and bounce bei Kontakt mit Decke & Boden
        if (ballY <= 0 || ballY >= getHeight() - ballSize) {
            ball.changeDirectionY();
        }

        // Check and bounce bei Kontakt mit Paddles
        if (ballX <= playerPaddle.getX() + playerPaddle.getWidth() && ballY >= playerPaddle.getY() && ballY <= playerPaddle.getY() + playerPaddle.getHeight()) {
            randyRandomEffectUse(playerPaddle);
            ball.changeDirectionX();
        }

        if (ballX >= cpuPaddle.getX() - ballSize && ballY >= cpuPaddle.getY() && ballY <= cpuPaddle.getY() + cpuPaddle.getHeight()) {
            randyRandomEffectUse(cpuPaddle);
            ball.changeDirectionX();
        }

        if (ballX < 0) {
            cpuScore++;
            cpuPaddle.resetPaddleSize();
            playerPaddle.resetPaddleSize();
            ball.reset(getWidth(), getHeight());
        }

        if (ballX > getWidth() - ballSize) {
            playerScore++;
            cpuPaddle.resetPaddleSize();
            playerPaddle.resetPaddleSize();
            ball.reset(getWidth(), getHeight());
        }

        cpuPaddle.move(ballY, getHeight(), getWidth());

        // Redraw the playing field
        repaint();
    }


    public void randyRandomEffect() {
        random = new Random();
    }

    public void randyRandomEffectUse(Paddle paddle) {
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 0:
                ball.doubleBallSpeed();
                break;
            case 1, 2:
                paddle.halvedPaddleSize();
                break;
        }
    }


    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W && playerPaddle.getY() > 0) {
            playerPaddle.moveUp();
        }

        if (keyCode == KeyEvent.VK_S && playerPaddle.getY() < getHeight() - playerPaddle.getHeight()) {
            playerPaddle.moveDown();
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong+");
        Main game = new Main();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setResizable(true);
        frame.add(game);
        frame.setVisible(true);

        while (true) {
            game.updateGame();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






/*
todo:

 */