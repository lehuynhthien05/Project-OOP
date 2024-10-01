package Mino;

import java.awt.*;

public class Mino_L1 extends Mino{
    // Create a L1 shaped mino
    public Mino_L1(){
        create(Color.orange);
    }

    public void setXY(int x, int y) {
        b[0].setX(x);
        b[0].setY(y);

        b[1].setX(b[0].getX());
        b[1].setY(b[0].getY() - b[0].getSize());

        b[2].setX(b[0].getX());
        b[2].setY(b[0].getY() + b[0].getSize());

        b[3].setX(b[0].getX() + b[0].getSize());
        b[3].setY(b[0].getY() + b[0].getSize());
    }


}
