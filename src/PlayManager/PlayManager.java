package PlayManager;

import GamePanel.GamePanel;
import Mino.Mino;
import Mino.Block;
import Mino.Mino_L1;

import java.awt.*;

public class PlayManager {

    final int width = 360;
    final int height = 600;

    private int left_x;
    private int right_x;
    private int top_y;
    private int bottom_y;

    Mino currmino;
    final int mino_start_x;
    final int mino_start_y;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLeft_x() {
        return left_x;
    }

    public void setLeft_x(int left_x) {
        this.left_x = left_x;
    }

    public int getRight_x() {
        return right_x;
    }

    public void setRight_x(int right_x) {
        this.right_x = right_x;
    }

    public int getTop_y() {
        return top_y;
    }

    public void setTop_y(int top_y) {
        this.top_y = top_y;
    }

    public int getBottom_y() {
        return bottom_y;
    }

    public void setBottom_y(int bottom_y) {
        this.bottom_y = bottom_y;
    }

    //Constructor
    public PlayManager() {
        left_x = (GamePanel.width / 2) - (width/2);
        right_x = left_x + width;
        top_y = 50;
        bottom_y = top_y + height;

        mino_start_x = left_x + width/2 - Block.getSize();
        mino_start_y = top_y + Block.getSize();

        currmino = new Mino_L1();
        currmino.setXY(mino_start_x, mino_start_y);

    }

    //update() method
    public void update(){
        currmino.update();
    }

    //draw() method
    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, width+8, height + 8); //orderlist (x,y,width,height)

        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("Next", x + 60, y + 60); //orderlist (x,y)

        if (currmino != null){
            currmino.draw(g2);
        }

    }



}
