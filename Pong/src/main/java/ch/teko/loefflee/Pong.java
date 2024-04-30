package ch.teko.loefflee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong extends JPanel implements ActionListener, KeyListener {
    private Ball ball;
    private PlayerPaddle playerPaddle;
    private CpuPaddle cpuPaddle;
    private int playerScore;
    private int cpuScore;
    private Timer timer;

    // Variable for paddle speed
    private int paddleSpeed = 2;

    public Pong() {
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));
        addKeyListener(this);

        // Ball starts at fixed position
        ball = new Ball(395, 295); // Adjust the position as needed

        // Initialize player and CPU paddles
        playerPaddle = new PlayerPaddle(10, 250);
        cpuPaddle = new CpuPaddle(780, 250);

        // Initialize scores
        playerScore = 0;
        cpuScore = 0;

        // Timer for game loop
        timer = new Timer(5, this);
        timer.start();

        // Randomly set initial direction of the ball
        Random random = new Random();
        int dx = random.nextBoolean() ? 1 : -1; // Either 1 (right) or -1 (left)
        int dy = random.nextBoolean() ? 1 : -1; // Either 1 (down) or -1 (up)
        ball.setDx(dx);
        ball.setDy(dy);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player: " + playerScore, 10, 20);
        g.drawString("CPU: " + cpuScore, 680, 580);

        ball.draw(g);
        playerPaddle.draw(g);
        cpuPaddle.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        ball.move();

        int ballX = ball.getX();
        int ballY = ball.getY();

        if (ballX <= playerPaddle.getX() + 10 && ballY >= playerPaddle.getY() && ballY <= playerPaddle.getY() + 60) {
            ball.changeDirectionX();
        }

        if (ballX >= cpuPaddle.getX() - 10 && ballY >= cpuPaddle.getY() && ballY <= cpuPaddle.getY() + 60) {
            ball.changeDirectionX();
        }

        if (ballY <= 0 || ballY >= 590) {
            ball.changeDirectionY();
        }

        if (ballX < 0) {
            cpuScore++;
            ball = new Ball(395, 295);
        }

        if (ballX > 790) {
            playerScore++;
            ball = new Ball(395, 295);
        }

        cpuPaddle.move(ballY);

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W && playerPaddle.getY() > 0) {
            // Increase the Y position of the player paddle
            playerPaddle.moveUp();
            // Increase the Y position of the player paddle again to increase speed
            playerPaddle.moveUp();
        }

        if (keyCode == KeyEvent.VK_S && playerPaddle.getY() < 540) {
            // Decrease the Y position of the player paddle
            playerPaddle.moveDown();
            // Decrease the Y position of the player paddle again to increase speed
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
