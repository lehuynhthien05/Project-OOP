package Handler;

import java.awt.event.KeyListener;
import java.awt.event.*;

public class KeyHandler implements KeyListener {
    private static boolean upPressed, downPressed, leftPressed, rightPressed;

    public static boolean isUpPressed() {
        return upPressed;
    }

    public static void setUpPressed(boolean upPressed) {
        KeyHandler.upPressed = upPressed;
    }

    public static boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
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

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }
    public void keyTyped (KeyEvent e) {
    }
}
