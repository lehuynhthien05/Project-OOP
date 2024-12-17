package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WaitingScreen extends JPanel {

    // Constructor for WaitingScreen, taking action listeners for Start and Exit buttons
    public WaitingScreen(ActionListener startAction, ActionListener exitAction) {
        // Set layout manager to GridBagLayout for flexible positioning
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY); // Set background color to dark gray

        // Create and configure the title label
        JLabel titleLabel = new JLabel("Welcome to Tetrix Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Set font size and style
        titleLabel.setForeground(Color.WHITE); // Set text color to white

        // Create the Start button with the provided action listener
        StartButton startButton = new StartButton("Start Game", startAction);
        startButton.setPreferredSize(new Dimension(200, 50)); // Set button size

        // Create the Exit button with the provided action listener
        ExitButton exitButton = new ExitButton("Exit Game", exitAction);
        exitButton.setPreferredSize(new Dimension(200, 50)); // Set button size

        // Create a GridBagConstraints object to manage layout of components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0); // Set space between components

        // Add title label to the panel at grid position (0, 0)
        gbc.gridy = 0;
        add(titleLabel, gbc);

        // Add Start button to the panel at grid position (1, 0)
        gbc.gridy = 1;
        add(startButton, gbc);

        // Add Exit button to the panel at grid position (2, 0)
        gbc.gridy = 2;
        add(exitButton, gbc);
    }
}
