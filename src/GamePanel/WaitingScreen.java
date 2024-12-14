package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WaitingScreen extends JPanel {
    public WaitingScreen(ActionListener startAction, ActionListener exitAction) {
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);

        JLabel titleLabel = new JLabel("Welcome to Tetrix Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);

        StartButton startButton = new StartButton("Start Game", startAction);
        startButton.setPreferredSize(new Dimension(200, 50));

        ExitButton exitButton = new ExitButton("Exit Game", exitAction);
        exitButton.setPreferredSize(new Dimension(200, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);

        gbc.gridy = 0;
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(startButton, gbc);

        gbc.gridy = 2;
        add(exitButton, gbc);
    }
}
