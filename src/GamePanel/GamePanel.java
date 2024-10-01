package GamePanel;

import javax.swing.*;
import java.awt.*;
import PlayManager.PlayManager;

public class GamePanel extends JPanel implements Runnable{
    public static final int width = 1280;
    public static final int height = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager playerManager;


    public GamePanel(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK); //Optional
        this.setLayout(null);

        playerManager = new PlayManager();
    }

    //start() method
    public void start(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //run() method
    @Override
    public void run() {
        double drawInterval = 1000000000/ FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    //update() method
    public void update(){
        playerManager.update();
    }

    //paintComponent() method
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        playerManager.draw(g2);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
