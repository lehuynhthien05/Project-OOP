package Main;

import GamePanel.GamePanel;

import javax.swing.*;

import static java.awt.SystemColor.window;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.start();
    }
}