package Mino;

import Handler.KeyHandler;
import PlayManager.PlayManager;

import java.awt.*;

public class Mino {
    public Block []b = new Block[4];
    public Block []tempB = new Block[4];

    private int direction = 1;
    int autoDropCounter = 0;

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
    public void updateXY(int direction){
        this.direction = direction;
        b[0].setX(tempB[0].getX());
        b[0].setY(tempB[0].getY());

        b[1].setX(tempB[1].getX());
        b[1].setY(tempB[1].getY());

        b[2].setX(tempB[2].getX());
        b[2].setY(tempB[2].getY());

        b[3].setX(tempB[3].getX());
        b[3].setY(tempB[3].getY());
    }
    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}
    public void update(){
        if (KeyHandler.isDownPressed()){
            b[0].setY(b[0].getY() + Block.getSize());
            b[1].setY(b[1].getY() + Block.getSize());
            b[2].setY(b[2].getY() + Block.getSize());
            b[3].setY(b[3].getY() + Block.getSize());

            //Move down, reset the autoDropCounter
            autoDropCounter = 0;
            KeyHandler.setLeftPressed(false);
        } else if (KeyHandler.isLeftPressed()){
            b[0].setX(b[0].getX() - Block.getSize());
            b[1].setX(b[1].getX() - Block.getSize());
            b[2].setX(b[2].getX() - Block.getSize());
            b[3].setX(b[3].getX() - Block.getSize());

            KeyHandler.setLeftPressed(false);
        } else if (KeyHandler.isRightPressed()){
            b[0].setX(b[0].getX() + Block.getSize());
            b[1].setX(b[1].getX() + Block.getSize());
            b[2].setX(b[2].getX() + Block.getSize());
            b[3].setX(b[3].getX() + Block.getSize());

            KeyHandler.setRightPressed(false);
        }else if (KeyHandler.isUpPressed()){
            direction = (direction % 4) + 1; // Cập nhật hướng
            if (direction == 1) {
                getDirection1();
            } else if (direction == 2) {
                getDirection2();
            } else if (direction == 3) {
                getDirection3();
            } else if (direction == 4) {
                getDirection4();
            }
            KeyHandler.setUpPressed(false);
            KeyHandler.setUpPressed(false);
        }

        autoDropCounter++;
        if (autoDropCounter == PlayManager.getDropInterval()){
            b[0].setY(b[0].getY() + Block.getSize());
            b[1].setY(b[1].getY() + Block.getSize());
            b[2].setY(b[2].getY() + Block.getSize());
            b[3].setY(b[3].getY() + Block.getSize());
            autoDropCounter = 0;
        }
    }

    //draw BLock method
    public void draw(Graphics2D g2) {
        int margin = 2;

        g2.setColor(b[0].getColor());
        g2.fillRect(b[0].getX()+margin, b[0].getY()+margin, Block.getSize()-(margin*2), Block.getSize()-(margin*2));

        g2.setColor(b[1].getColor());
        g2.fillRect(b[1].getX()+margin, b[1].getY()+margin, Block.getSize()-(margin*2), Block.getSize()-(margin*2));

        g2.setColor(b[2].getColor());
        g2.fillRect(b[2].getX()+margin, b[2].getY()+margin, Block.getSize()-(margin*2), Block.getSize()-(margin*2));

        g2.setColor(b[3].getColor());
        g2.fillRect(b[3].getX()+margin, b[3].getY()+margin, Block.getSize()-(margin*2), Block.getSize()-(margin*2));
    }

}
