import java.awt.*;

public class Paddle {
    private int x, y;
    private int width, height;
    private int speed;
    private boolean isCpu;

    public Paddle(int x, int y, int width, int height, int speed, boolean isCpu) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.isCpu = isCpu;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void move(int ballY, int windowHeight, int windowWidth) {
        if (this.isCpu) {

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

            x = windowWidth - width;
        }
    }

    public void halvedPaddleSize{
        this.height = this.height / 2;
    }

    public void resetPaddleSize{
        this.height = 60;
    }
}