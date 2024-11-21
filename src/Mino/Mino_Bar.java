package Mino;

import java.awt.*;
import PlayManager.PlayManager;

public class Mino_Bar extends Mino {
    public Mino_Bar() {
        create(Color.cyan);
    }

    public void setXY(int x, int y) {
        b[0].setX(x);
        b[0].setY(y);
        b[1].setX(b[0].getX());
        b[1].setY(b[0].getY() - b[0].getSize());
        b[2].setX(b[0].getX());
        b[2].setY(b[0].getY() + b[0].getSize());
        b[3].setX(b[0].getX());
        b[3].setY(b[0].getY() + b[0].getSize() * 2);
    }

    public void getDirection1() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() - b[0].getSize());
        tempB[2].setX(b[0].getX());
        tempB[2].setY(b[0].getY() + b[0].getSize());
        tempB[3].setX(b[0].getX());
        tempB[3].setY(b[0].getY() + b[0].getSize() * 2);

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(1);
        }
    }

    public void getDirection2() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX() - b[0].getSize());
        tempB[1].setY(b[0].getY());
        tempB[2].setX(b[0].getX() + b[0].getSize());
        tempB[2].setY(b[0].getY());
        tempB[3].setX(b[0].getX() + b[0].getSize() * 2);
        tempB[3].setY(b[0].getY());

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(2);
        }
    }

    public void getDirection3() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() - b[0].getSize());
        tempB[2].setX(b[0].getX());
        tempB[2].setY(b[0].getY() + b[0].getSize());
        tempB[3].setX(b[0].getX());
        tempB[3].setY(b[0].getY() + b[0].getSize() * 2);

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(3);
        }
    }

    public void getDirection4() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX() - b[0].getSize());
        tempB[1].setY(b[0].getY());
        tempB[2].setX(b[0].getX() + b[0].getSize());
        tempB[2].setY(b[0].getY());
        tempB[3].setX(b[0].getX() + b[0].getSize() * 2);
        tempB[3].setY(b[0].getY());

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(4);
        }
    }

    private boolean isOutOfBounds(Block[] blocks) {
        for (Block block : blocks) {
            if (block.getX() < PlayManager.getLeft_x() || block.getX() + Block.getSize() > PlayManager.getRight_x()) {
                return true;
            }
        }
        return false;
    }
}