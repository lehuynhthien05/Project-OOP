package Handler;

import java.awt.event.KeyListener;
import java.awt.event.*;

public class KeyHandler implements KeyListener {
    private static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed;

    public static boolean isPausePressed() {
        return pausePressed;
    }

    public static void setPausePressed(boolean pausePressed) {
        KeyHandler.pausePressed = pausePressed;
    }

    public static boolean isUpPressed() {
        return upPressed;
    }

    public static void setUpPressed(boolean upPressed) {
        KeyHandler.upPressed = upPressed;
    }

    public static boolean isDownPressed() {
        return downPressed;
    }

    public static void setDownPressed(boolean downPressed) {
        KeyHandler.downPressed = downPressed;
    }

    public static boolean isLeftPressed() {
        return leftPressed;
    }

    public static void setLeftPressed(boolean leftPressed) {
        KeyHandler.leftPressed = leftPressed;
    }

    public static boolean isRightPressed() {
        return rightPressed;
    }

    public static void setRightPressed(boolean rightPressed) {
        KeyHandler.rightPressed = rightPressed;
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                pausePressed = !pausePressed;
                break;
        }

    }
    public void keyTyped (KeyEvent e) {
    }
}
