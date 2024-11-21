package Mino;

import java.awt.*;
import PlayManager.PlayManager;

public class Mino_T extends Mino {
    public Mino_T() {
        create(Color.MAGENTA);
    }

    public void setXY(int x, int y) {
        b[0].setX(x);
        b[0].setY(y);
        b[1].setX(b[0].getX());
        b[1].setY(b[0].getY() - b[0].getSIZE());
        b[2].setX(b[0].getX() - b[0].getSIZE());
        b[2].setY(b[0].getY());
        b[3].setX(b[0].getX() + b[0].getSIZE());
        b[3].setY(b[0].getY());
    }

    public void getDirection1() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() - b[0].getSIZE());
        tempB[2].setX(b[0].getX() - b[0].getSIZE());
        tempB[2].setY(b[0].getY());
        tempB[3].setX(b[0].getX() + b[0].getSIZE());
        tempB[3].setY(b[0].getY());

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(1);
        }
    }

    public void getDirection2() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() - b[0].getSIZE());
        tempB[2].setX(b[0].getX());
        tempB[2].setY(b[0].getY() + b[0].getSIZE());
        tempB[3].setX(b[0].getX() - b[0].getSIZE());
        tempB[3].setY(b[0].getY());

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(2);
        }
    }

    public void getDirection3() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() - b[0].getSIZE());
        tempB[2].setX(b[0].getX() - b[0].getSIZE());
        tempB[2].setY(b[0].getY());
        tempB[3].setX(b[0].getX() + b[0].getSIZE());
        tempB[3].setY(b[0].getY());

        if (!checkRotationCollision() && !isOutOfBounds(tempB)) {
            updateXY(3);
        }
    }

    public void getDirection4() {
        tempB[0].setX(b[0].getX());
        tempB[0].setY(b[0].getY());
        tempB[1].setX(b[0].getX());
        tempB[1].setY(b[0].getY() + b[0].getSIZE());
        tempB[2].setX(b[0].getX() - b[0].getSIZE());
        tempB[2].setY(b[0].getY());
        tempB[3].setX(b[0].getX() + b[0].getSIZE());
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