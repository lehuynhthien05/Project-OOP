package Main;

import javax.swing.*;
import GamePanel.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetrix Game");
        ScreenManager screenManager = new ScreenManager();

        // Create the game panel
        GamePanel gamePanel = new GamePanel();

        // Create the waiting screen
        WaitingScreen waitingScreen = new WaitingScreen(
                e -> {
                    screenManager.showScreen("GamePanel");
                    gamePanel.start();
                    gamePanel.requestFocusInWindow(); // Ensure GamePanel receives keyboard focus
                },
                e -> System.exit(0) // Exit the game
        );

        // Add screens to the ScreenManager
        screenManager.addScreen("WaitingScreen", waitingScreen);
        screenManager.addScreen("GamePanel", gamePanel);

        // Setup JFrame
        frame.add(screenManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GamePanel.width, GamePanel.height);
        frame.setVisible(true);

        // Display the waiting screen
        screenManager.showScreen("WaitingScreen");
    }
}
