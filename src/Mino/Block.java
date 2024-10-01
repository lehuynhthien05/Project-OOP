package Mino;

import java.awt.*;

public class Block {
    private int x;
    private int y;
    private static final int SIZE = 30;
    private Color color;

    //Constructor, getter and setter
    public Block(Color c) {
        color = c;
    }

    public static int getSize(){
        return SIZE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSIZE() {
        return SIZE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //draw() method
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        g2.fillRect(getX(), getY(), SIZE, SIZE);
    }
}
