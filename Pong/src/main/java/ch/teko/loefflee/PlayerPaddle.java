package src.main.java.ch.teko.loefflee;

public class PlayerPaddle extends Paddle {
    private static PlayerPaddle instance;

    

    public PlayerPaddle(int x, int y) {
        super(x, y);
    }

    public static PlayerPaddle getInstance(int x, int y) {
        if (instance == null) {
            instance = new PlayerPaddle(x, y);
        }
        return instance;
    }

}
