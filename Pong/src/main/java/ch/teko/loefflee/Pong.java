package src.main.java.ch.teko.loefflee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends JPanel implements ActionListener, KeyListener {
    private Ball ball;
    private PlayerPaddle playerPaddle;
    private CpuPaddle cpuPaddle;
    private int playerScore;
    private int cpuScore;

    private Timer timer;
    private SpecialEffects specialEffects; // Hinzufügen der specialEffects-Instanz

    // Variable for paddle speed
    private int paddleSpeed = 2;

    public Pong() {
        setFocusable(true);
        addKeyListener(this);

        // Create the ball
        ball = new Ball(getWidth(), getHeight());

        // Initialize player and CPU paddles
        playerPaddle = new PlayerPaddle(10, 250);
        cpuPaddle = new CpuPaddle(500, 250);

        // Initialize scores
        playerScore = 0;
        cpuScore = 0;

        specialEffects = new SpecialEffects(); // Initialisieren der specialEffects-Instanz

        // Start the game timer
        timer = new Timer(10, this); // 10 milliseconds between each frame
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // Determine the width and height of the playing field based on the current window size
        int borderWidth = 0; // Border width
        int fieldWidth = getWidth() - 2 * borderWidth;
        int fieldHeight = getHeight() - 2 * borderWidth;

        // Draw the playing field with adjusted boundaries
        g.fillRect(borderWidth, borderWidth, fieldWidth, fieldHeight);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player: " + playerScore, 10, 20);
        g.drawString("CPU: " + cpuScore, getWidth() - 100, getHeight() - 20); // Score display at the bottom

        ball.draw(g);
        playerPaddle.draw(g);
        cpuPaddle.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        // Update ball position
        ball.move();

        int ballX = ball.getX();
        int ballY = ball.getY();
        int ballSize = ball.getSize(); // Get ball size

        // Check and bounce if the ball reaches the top or bottom boundaries
        if (ballY <= 0 || ballY >= getHeight() - ballSize) {
            ball.changeDirectionY();
        }

        // Check and bounce if the ball collides with the player or CPU paddle
        if (ballX <= playerPaddle.getX() + playerPaddle.getWidth() && ballY >= playerPaddle.getY() && ballY <= playerPaddle.getY() + playerPaddle.getHeight()) {
            ball.changeDirectionX();
        }

        if (ballX >= cpuPaddle.getX() - ballSize && ballY >= cpuPaddle.getY() && ballY <= cpuPaddle.getY() + cpuPaddle.getHeight()) {
            ball.changeDirectionX();
        }

        // Check and increase score as well as reset the ball if it leaves the playing field
        if (ballX < 0) {
            cpuScore++;
            ball.reset(getWidth(), getHeight());
        }

        if (ballX > getWidth() - ballSize) {
            playerScore++;
            ball.reset(getWidth(), getHeight());
        }

        // Movement of the CPU paddle
        cpuPaddle.move(ballY, getHeight(), getWidth());

        // Check for special effects activation
        specialEffects.activateRandomEffect();

        // Redraw the playing field
        repaint();
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
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setResizable(true);
        frame.add(new Pong());
        frame.setVisible(true);
    }
}
