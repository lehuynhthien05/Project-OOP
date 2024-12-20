package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ExitButton extends JButton {
    public ExitButton(String text, ActionListener action) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setFocusPainted(false);
        this.setBackground(Color.RED);
        this.setForeground(Color.BLACK);
        this.addActionListener(action);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
