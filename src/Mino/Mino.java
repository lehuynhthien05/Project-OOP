package Mino;

import Handler.KeyHandler;
import PlayManager.PlayManager;

import java.awt.*;

public abstract class Mino {
    public Block []b = new Block[4];
    public Block []tempB = new Block[4];

    private int direction = 1;
    int autoDropCounter = 0;
    boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;


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
    abstract void getDirection1();
    abstract void getDirection2();
    abstract void getDirection3();
    abstract void getDirection4();

    public void checkMovementCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkStaticBlockCollision();

        // Left wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].getX() <= PlayManager.getLeft_x()) {
                leftCollision = true;
            }
        }

        // Right wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].getX() + Block.getSize() >= PlayManager.getRight_x()) {
                rightCollision = true;
            }
        }

        // Bottom floor
        for (int i = 0; i < b.length; i++) {
            if (b[i].getY() + Block.getSize() >= PlayManager.getBottom_y()) {
                bottomCollision = true;
            }
        }
    }

    public boolean checkRotationCollision() {
        for (Block block : tempB) {
            if (block.getX() < PlayManager.getLeft_x() ||
                    block.getX() + Block.getSize() > PlayManager.getRight_x() ||
                    block.getY() + Block.getSize() > PlayManager.getBottom_y()) {
                return true;
            }
            // Check for collision with static blocks
            for (Block staticBlock : PlayManager.staticBlocks) {
                if (block.getX() == staticBlock.getX() && block.getY() == staticBlock.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    //check Blockstatic method
    private void checkStaticBlockCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        for (Block staticBlock : PlayManager.staticBlocks) {
            for (Block block : b) {
                // Check bottom collision
                if (block.getY() + Block.getSize() == staticBlock.getY() && block.getX() == staticBlock.getX()) {
                    bottomCollision = true;
                }
                // Check left collision
                if (block.getX() - Block.getSize() == staticBlock.getX() && block.getY() == staticBlock.getY()) {
                    leftCollision = true;
                }
                // Check right collision
                if (block.getX() + Block.getSize() == staticBlock.getX() && block.getY() == staticBlock.getY()) {
                    rightCollision = true;
                }
            }
        }
    }

    public void update() {
        if (KeyHandler.isUpPressed()) {
            boolean canRotate = true;
            switch (direction) {
                case 1:
                    getDirection2();
                    break;
                case 2:
                    getDirection3();
                    break;
                case 3:
                    getDirection4();
                    break;
                case 4:
                    getDirection1();
                    break;
            }

            // Check if rotation would cause out of bounds
            for (Block block : tempB) {
                if (block.getX() < PlayManager.getLeft_x() || block.getX() + Block.getSize() > PlayManager.getRight_x()) {
                    canRotate = false;
                    break;
                }
            }
            if (canRotate && !checkRotationCollision()) {
                updateXY(direction);
            }


            if (!checkRotationCollision()) {
                updateXY(direction);
            }
            KeyHandler.setUpPressed(false);
        }

        checkStaticBlockCollision();
        checkMovementCollision();

        if (KeyHandler.isDownPressed()) {
            if (!bottomCollision) {
                for (Block block : b) {
                    block.setY(block.getY() + Block.getSize());
                }
                autoDropCounter = 0;
            }
            KeyHandler.setDownPressed(false);
        } else if (KeyHandler.isLeftPressed()) {
            if (!leftCollision) {
                for (Block block : b) {
                    block.setX(block.getX() - Block.getSize());
                }
            }
            KeyHandler.setLeftPressed(false);
        } else if (KeyHandler.isRightPressed()) {
            if (!rightCollision) {
                for (Block block : b) {
                    block.setX(block.getX() + Block.getSize());
                }
            }
            KeyHandler.setRightPressed(false);
        }

        if (bottomCollision) {
            active = false;
        } else {
            autoDropCounter++;
            if (autoDropCounter >= PlayManager.getDropInterval()) {
                for (Block block : b) {
                    block.setY(block.getY() + Block.getSize());
                }
                autoDropCounter = 0;
            }
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
