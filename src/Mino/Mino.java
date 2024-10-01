package Mino;

import java.awt.*;

public class Mino {
    public Block []b = new Block[4];
    public Block []tempB = new Block[4];

    public Block[] getB() {
        return b;
    }

    public void setB(Block[] b) {
        this.b = b;
    }

    public Block[] getTempB() {
        return tempB;
    }

    public void setTempB(Block[] tempB) {
        this.tempB = tempB;
    }


    //create a block with a color
    public void create(Color c){
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }

    public void setXY(int x, int y){}
    public void updateXY(int direction){}
    public void update(){

    }

    //draw BLock method
    public void draw(Graphics2D g2) {
        g2.setColor(b[0].getColor());
        g2.fillRect(b[0].getX(), b[0].getY(), Block.getSize(), Block.getSize());

        g2.setColor(b[1].getColor());
        g2.fillRect(b[1].getX(), b[1].getY(), Block.getSize(), Block.getSize());

        g2.setColor(b[2].getColor());
        g2.fillRect(b[2].getX(), b[2].getY(), Block.getSize(), Block.getSize());

        g2.setColor(b[3].getColor());
        g2.fillRect(b[3].getX(), b[3].getY(), Block.getSize(), Block.getSize());
    }

}
