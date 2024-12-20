package PlayManager;

import GamePanel.GamePanel;
import Handler.KeyHandler;
import Mino.Mino;
import Mino.Block;
import Mino.Mino_L1;
import Mino.Mino_Bar;
import Mino.Mino_Square;
import Mino.Mino_L2;
import Mino.Mino_T;
import Mino.Mino_Z1;
import Mino.Mino_Z2;

import java.awt.*;
import java.util.ArrayList;

import static GamePanel.GamePanel.music;

public class PlayManager {

    final int width = 360;
    final int height = 600;

    private static int left_x;
    private static int right_x;
    private static int top_y;
    private static int bottom_y;

    Mino currmino;
    final int mino_start_x;
    final int mino_start_y;

    // nextMino
    Mino nextMino;
    final int nextMino_start_x;
    final int nextMino_start_y;
    public static ArrayList<Block> staticBlocks = new ArrayList<Block>();

    static int dropInterval = 60; // 60 frames

    // Score
    int score;
    int lines;
    int level;

    boolean gameOver = false;

    public Mino getCurrmino() {
        return currmino;
    }

    public void setCurrmino(Mino currmino) {
        this.currmino = currmino;
    }

    public int getMino_start_x() {
        return mino_start_x;
    }

    public int getMino_start_y() {
        return mino_start_y;
    }

    public static int getDropInterval() {
        return dropInterval;
    }

    public static void setDropInterval(int dropInterval) {
        PlayManager.dropInterval = dropInterval;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getLeft_x() {
        return left_x;
    }

    public void setLeft_x(int left_x) {
        this.left_x = left_x;
    }
 
    public static int getRight_x() {
        return right_x;
    }

    public void setRight_x(int right_x) {
        this.right_x = right_x;
    }

    public int getTop_y() {
        return top_y;
    }

    public void setTop_y(int top_y) {
        this.top_y = top_y;
    }

    public static int getBottom_y() {
        return bottom_y;
    }

    public void setBottom_y(int bottom_y) {
        this.bottom_y = bottom_y;
    }

    // Constructor
    public PlayManager() {
        left_x = (GamePanel.width / 2) - (width / 2);
        right_x = left_x + width;
        top_y = 50;
        bottom_y = top_y + height;

        mino_start_x = left_x + width / 2 - Block.getSize();
        mino_start_y = top_y + Block.getSize();

        nextMino_start_x = right_x + 175;
        nextMino_start_y = top_y + 500;

        currmino = pickMino();
        currmino.setXY(mino_start_x, mino_start_y);
        nextMino = pickMino();
        nextMino.setXY(nextMino_start_x, nextMino_start_y);
    }

    // pick Random Mino
    private Mino pickMino() {
        int random = (int) (Math.random() * 7);
        switch (random) {
            case 0:
                return new Mino_L1();
            case 1:
                return new Mino_Bar();
            case 2:
                return new Mino_Square();
            case 3:
                return new Mino_L2();
            case 4:
                return new Mino_T();
            case 5:
                return new Mino_Z1();
            case 6:
                return new Mino_Z2();
        }
        return null;
    }

    // update() method
    public void update() {
        if (gameOver) {
            music.stopBackgroundMusic();
            if (KeyHandler.isSpacePressed()) {
                resetGame();
            }
            return;
        }

        if (KeyHandler.isPausePressed()) {
            return; // Pause the game
        }

        if (!currmino.active) {
            staticBlocks.add(currmino.b[0]);
            staticBlocks.add(currmino.b[1]);
            staticBlocks.add(currmino.b[2]);
            staticBlocks.add(currmino.b[3]);

            // Check for game over condition
            for (Block block : staticBlocks) {
                if (block.getY() <= top_y) {
                    gameOver = true;
                    return;
                }
            }

            // Replace the current mino with the next mino
            currmino = nextMino;
            currmino.setXY(mino_start_x, mino_start_y);
            nextMino = pickMino();
            nextMino.setXY(nextMino_start_x, nextMino_start_y);

            checkDelete();
        } else {
            currmino.update();
        }
    }

    public void checkDelete() {
        int x = left_x;
        int y = top_y;
        int blockCount = 0;

        while (x < right_x && y < bottom_y) {
            for (int i = 0; i < staticBlocks.size(); i++) {
                if (staticBlocks.get(i).getX() == x && staticBlocks.get(i).getY() == y) {
                    blockCount++;
                }
            }

            x += Block.getSize();

            if (x == right_x) {
                if (blockCount == 12) {
                    for (int i = staticBlocks.size() - 1; i > -1; i--) {
                        if (staticBlocks.get(i).getY() == y) {
                            staticBlocks.remove(i);
                        }
                    }

                    // Music when a row is deleted
                    music.playEffectSound("/clear.wav");

                    lines++;
                    score += 50;

                    // Change drop speed based on level
                    if (lines % 5 == 0 && dropInterval > 1) {
                        level += 1;

                        if (dropInterval % 5 == 0 && dropInterval > 10) {
                            dropInterval -= 10;
                        } else {
                            dropInterval -= 1;
                        }
                        setDropInterval(dropInterval);
                    }

                    // move lines above the deleted line down
                    for (int i = 0; i < staticBlocks.size(); i++) {
                        if (staticBlocks.get(i).getY() < y) {
                            staticBlocks.get(i).setY(staticBlocks.get(i).getY() + Block.getSize());
                        }
                    }
                }
                blockCount = 0;
                x = left_x;
                y += Block.getSize();
            }
        }
    }

    // Add a method to reset the game state
    public void resetGame() {
        staticBlocks.clear();
        score = 0;
        lines = 0;
        level = 0;
        gameOver = false;
        dropInterval = 60;

        currmino = pickMino();
        currmino.setXY(mino_start_x, mino_start_y);
        nextMino = pickMino();
        nextMino.setXY(nextMino_start_x, nextMino_start_y);
        music.playBackgroundMusic("/music.wav");
    }

    // draw() method
    public void draw(Graphics2D g2) {
        // Draw Play Area Frame
        g2.setColor(new Color(0xFFFFFF));
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, width + 8, height + 8); // orderlist (x,y,width,height)

        // Draw grid for the Play Area
        g2.setColor(new Color(255, 255, 255, 80));
        g2.setStroke(new BasicStroke(2.5f));

        // Draw vertical grid lines
        for (int x = left_x; x <= right_x; x += Block.getSize()) {
            g2.drawLine(x, top_y, x, bottom_y);
        }

        // Draw horizontal grid lines
        for (int y = top_y; y <= bottom_y; y += Block.getSize()) {
            g2.drawLine(left_x, y, right_x, y);
        }

        // Draw Next Mino Frame
        g2.setColor(new Color(0xFFFFFF));
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("Next", x + 70, y + 50); // order list (x,y)

        // Draw Score Frame
        g2.setColor(new Color(0xFFFFFF));
        g2.drawRect(70, y, 300, 200);
        g2.drawString("LEVEL: " + level,  130, y + 60);
        g2.drawString("SCORE: " + score,  130, y + 110);
        g2.drawString("LINES: " + lines,  130, y + 160);

        // Draw the current mino
        if (currmino != null) {
            currmino.draw(g2);
        }

        // Draw nextMino
        nextMino.draw(g2);

        // Draw staticBlocks
        for (Block b : staticBlocks) {
            b.draw(g2);
        }

        // Draw pause
        g2.setColor(Color.yellow);
        g2.setFont(g2.getFont().deriveFont(50f));
        if (KeyHandler.isPausePressed()) {
            FontMetrics fm = g2.getFontMetrics();
            String pauseText = "PAUSE";
            int textWidth = fm.stringWidth(pauseText);
            int textX = left_x + (width - textWidth) / 2;
            g2.drawString(pauseText, textX, top_y + 300);
        }

        // Draw game over
        if (gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(g2.getFont().deriveFont(50f));
            FontMetrics fm = g2.getFontMetrics();
            String gameOverText = "GAME OVER";
            int textX = 50;
            g2.drawString(gameOverText, textX, top_y + 300);
        }
    }
}