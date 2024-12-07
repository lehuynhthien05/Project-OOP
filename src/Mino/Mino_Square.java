package Mino;

import java.awt.*;

public class Mino_Square extends Mino{
    public Mino_Square(){
        create(Color.yellow);
    }

    public void setXY(int x, int y){
        b[0].setX(x);
        b[0].setY(y);
        b[1].setX(b[0].getX() + b[0].getSize());
        b[1].setY(b[0].getY());
        b[2].setX(b[0].getX());
        b[2].setY(b[0].getY() + b[0].getSize());
        b[3].setX(b[0].getX() + b[0].getSize());
        b[3].setY(b[0].getY() + b[0].getSize());
    }

    public void getDirection1() {
        // Square doesn't rotate, just keep it fixed in its position
    }

    public void getDirection2() {
        getDirection1();
    }

    public void getDirection3() {
        getDirection1();
    }

    public void getDirection4() {
        getDirection1();
    }

}
