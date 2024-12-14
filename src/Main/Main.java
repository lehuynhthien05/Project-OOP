package Main;

import GamePanel.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Tạo JFrame chính
        JFrame window = new JFrame("Tetrix Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        // Tạo ScreenManager để quản lý các màn hình
        ScreenManager screenManager = new ScreenManager();

        // Tạo màn hình chờ
        WaitingScreen waitingScreen = new WaitingScreen(
            e -> {
                // Chuyển sang màn hình game
                screenManager.showScreen("GamePanel");
            },
            e -> {
                // Thoát game
                System.exit(0);
            }
        );

        // Tạo màn hình chơi game
        GamePanel gamePanel = new GamePanel();
        gamePanel.start(); // Gọi phương thức start() để bắt đầu game

        // Thêm các màn hình vào ScreenManager
        screenManager.addScreen("WaitingScreen", waitingScreen);
        screenManager.addScreen("GamePanel", gamePanel);

        // Hiển thị màn hình chờ khi khởi động
        screenManager.showScreen("WaitingScreen");

        // Thêm ScreenManager vào JFrame
        window.add(screenManager);
        window.setVisible(true); 
    }
}
