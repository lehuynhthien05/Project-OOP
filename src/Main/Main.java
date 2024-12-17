package Main;
import javax.swing.*;
import GamePanel.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetrix Game");
        ScreenManager screenManager = new ScreenManager();

        // Tạo màn hình chơi
        GamePanel gamePanel = new GamePanel();

        // Tạo màn hình chờ
        WaitingScreen waitingScreen = new WaitingScreen(
            e -> {
                screenManager.showScreen("GamePanel");
                gamePanel.start();
                gamePanel.requestFocusInWindow(); // Đảm bảo GamePanel nhận bàn phím
            },
            e -> System.exit(0)
        );

        // Thêm các màn hình vào ScreenManager
        screenManager.addScreen("WaitingScreen", waitingScreen);
        screenManager.addScreen("GamePanel", gamePanel);

        // Cài đặt JFrame
        frame.add(screenManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GamePanel.width, GamePanel.height);
        frame.setVisible(true);

        // Hiển thị màn hình chờ
        screenManager.showScreen("WaitingScreen");
    }
}
