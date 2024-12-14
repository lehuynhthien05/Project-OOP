package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartButton extends JButton {
    public StartButton(String text, ActionListener action) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setFocusPainted(false);
        this.setBackground(Color.GREEN);
        this.setForeground(Color.BLACK);
        this.addActionListener(action);
    }
}
