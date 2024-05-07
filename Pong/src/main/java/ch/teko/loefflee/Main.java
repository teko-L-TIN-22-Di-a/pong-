package src.main.java.ch.teko.loefflee;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong+");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(815, 630);
        frame.setResizable(true);
        frame.add(new src.main.java.ch.teko.loefflee.Pong());
        frame.setVisible(true);
    }
}
