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

/**
 * Hauptklasse für das Pong-Spiel.
 */
public class Main extends JPanel implements KeyListener {
    private Ball ball;
    private Paddle playerPaddle;
    private Paddle cpuPaddle;
    private int playerScore;
    private int cpuScore;
    private Random random;
    private Wind wind;
    private boolean effectApplied;
    private Paddle lastHitPaddle;

    /**
     * Konstruktor für die Hauptklasse.
     * Initialisiert Ball, Paddles und Scores.
     */
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

        effectApplied = false;
        wind = new Wind();
        lastHitPaddle = null;
        randyRandomEffect();
    }

    /**
     * Zeichnet das Spielfeld, Ball und Paddles.
     * Passt das Spielfeld an die Fenstergröße an und erstellt eine Punkteanzeige für beide Spieler.
     *
     * @param g das zu zeichnende Grafikobjekt
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

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

    /**
     * Aktualisiert die Position des Balls und die Logik des Spiels.
     * Lässt den Ball an Paddles, Decke und Boden abprallen, führt zufällige Effekte bei Berührung der Paddles aus,
     * erhöht die Punktzahl bei einem Tor und bewegt das CPU-Paddle entsprechend der Y-Achse des Balls.
     */
    public void updateGame() {
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
            if (!effectApplied) {
                randyRandomEffectUse(playerPaddle);
                ball.changeDirectionX();
            }
        }

        if (ballX >= cpuPaddle.getX() - ballSize && ballY >= cpuPaddle.getY() && ballY <= cpuPaddle.getY() + cpuPaddle.getHeight()) {
            if (!effectApplied) {
                randyRandomEffectUse(cpuPaddle);
                ball.changeDirectionX();
            }
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

        repaint();
    }

    /**
     * Initialisiert den Zufallsgenerator für zufällige Effekte.
     */
    public void randyRandomEffect() {
        random = new Random();
    }

    /**
     * Führt zufällige Effekte aus.
     * 25% Chance für verdoppelte Ballgeschwindigkeit,
     * 50% Chance für halbierte Paddelgröße,
     * 25% Chance für Wind.
     *
     * @param paddle das Paddle, auf das der Effekt angewendet wird
     */
    public void randyRandomEffectUse(Paddle paddle) {
        int randomNumber = random.nextInt(1);

        switch (randomNumber) {
            /*case 0:
                ball.doubleBallSpeed();
                System.out.println("BALL");
                break;
            case 1, 2:
                paddle.halvedPaddleSize();
                System.out.println("PADDLE");
                break; */
            case 0:
                wind.randomWind(paddle);
                ball.applyWind(wind.getX(), wind.getY());
                ball.resetBallSpeed();
                System.out.println("WIND");
                break;
        }
    }

    /**
     * Bewegt das Spieler-Paddle mit den Tasten "W" und "S".
     *
     * @param e das KeyEvent-Objekt
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W && playerPaddle.getY() > 0) {
            playerPaddle.moveUp();
        }

        if (keyCode == KeyEvent.VK_S && playerPaddle.getY() < getHeight() - playerPaddle.getHeight()) {
            playerPaddle.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Startet das Spiel.
     *
     * @param args die Kommandozeilenargumente
     */
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

