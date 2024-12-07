package Handler;

import java.awt.event.KeyListener;
import java.awt.event.*;

import static GamePanel.GamePanel.music;

public class KeyHandler implements KeyListener {
    private static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed, spacePressed;

    public static void setUpPressed(boolean upPressed) {
        KeyHandler.upPressed = upPressed;
    }

    public static void setDownPressed(boolean downPressed) {
        KeyHandler.downPressed = downPressed;
    }

    public static void setLeftPressed(boolean leftPressed) {
        KeyHandler.leftPressed = leftPressed;
    }

    public static void setRightPressed(boolean rightPressed) {
        KeyHandler.rightPressed = rightPressed;
    }

    public static void setPausePressed(boolean pausePressed) {
        KeyHandler.pausePressed = pausePressed;
    }

    public static void setSpacePressed(boolean spacePressed) {
        KeyHandler.spacePressed = spacePressed;
    }

    public static boolean isPausePressed() {
        return pausePressed;
    }

    public static boolean isSpacePressed() {
        return spacePressed;
    }

    public static boolean isUpPressed() {
        return upPressed;
    }

    public static boolean isDownPressed() {
        return downPressed;
    }

    public static boolean isLeftPressed() {
        return leftPressed;
    }

    public static boolean isRightPressed() {
        return rightPressed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W: // W key for "up"
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S: // S key for "down"
                downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A: // A key for "left"
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: // D key for "right"
                rightPressed = true;
                break;
            case KeyEvent.VK_P:
                pausePressed = !pausePressed;
                if (pausePressed) {
                    music.stopBackgroundMusic();
                } else {
                    music.playBackgroundMusic("/music.wav");
                }
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W: // W key for "up"
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S: // S key for "down"
                downPressed = false;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A: // A key for "left"
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: // D key for "right"
                rightPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                spacePressed = false;
                break;
        }
    }


    public void keyTyped(KeyEvent e) {
    }
}