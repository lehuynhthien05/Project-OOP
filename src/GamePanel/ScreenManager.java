package GamePanel;

import javax.swing.*;
import java.awt.*;

public class ScreenManager extends JPanel {
    private CardLayout cardLayout;

    public ScreenManager() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
    }

    public void addScreen(String name, JPanel screen) {
        add(screen, name);
    }

    public void showScreen(String name) {
        cardLayout.show(this, name);
    }
}
