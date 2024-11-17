package PlayManager;

import GamePanel.GamePanel;
import Handler.KeyHandler;
import Mino.Mino;
import Mino.Block;
import Mino.Mino_L1;
import Mino.Mino_Bar;
import Mino.Mino_Square;
import Mino.Mino_L2;
import Mino.Mino_T;
import Mino.Mino_Z1;
import Mino.Mino_Z2;



import java.awt.*;
import java.util.ArrayList;

public class  PlayManager {

    final int width = 360;
    final int height = 600;

    private static int left_x;
    private static int right_x;
    private static int top_y;
    private static int bottom_y;

    Mino currmino;
    final int mino_start_x;
    final int mino_start_y;

    //nextMino
    Mino nextMino;
    final int nextMino_start_x;
    final int nextMino_start_y;
    public static ArrayList<Block> staticBlocks = new ArrayList<Block>();

    static int dropInterval = 60; // 60 frames

    public Mino getCurrmino() {
        return currmino;
    }

    public void setCurrmino(Mino currmino) {
        this.currmino = currmino;
    }

    public int getMino_start_x() {
        return mino_start_x;
    }

    public int getMino_start_y() {
        return mino_start_y;
    }

    public static int getDropInterval() {
        return dropInterval;
    }

    public static void setDropInterval(int dropInterval) {
        PlayManager.dropInterval = dropInterval;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getLeft_x() {
        return left_x;
    }

    public void setLeft_x(int left_x) {
        this.left_x = left_x;
    }

    public static int getRight_x() {
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

    public static int getBottom_y() {
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

        nextMino_start_x = right_x + 175;
        nextMino_start_y = top_y + 500;

        currmino = pickMino() ;
        currmino.setXY(mino_start_x, mino_start_y);
        nextMino = pickMino();
        nextMino.setXY(nextMino_start_x, nextMino_start_y);

    }

    //pick Random Mino
    private Mino pickMino(){
        int random = (int)(Math.random() * 7);
        switch (random){
            case 0:
                return new Mino_L1();
            case 1:
                return new Mino_Bar();
            case 2:
                return new Mino_Square();
            case 3:
                return new Mino_L2();
            case 4:
                return new Mino_T();
            case 5:
                return new Mino_Z1();
            case 6:
                return new Mino_Z2();
        }
        return null;
    }



    //update() method
    public void update(){
        if (currmino.active == false){
            staticBlocks.add(currmino.b[0]);
            staticBlocks.add(currmino.b[1]);
            staticBlocks.add(currmino.b[2]);
            staticBlocks.add(currmino.b[3]);

            //Replace the current mino with the next mino
            currmino = nextMino;
            currmino.setXY(mino_start_x, mino_start_y);
            nextMino = pickMino();
            nextMino.setXY(nextMino_start_x, nextMino_start_y);
        }else{
            currmino.update();
        }
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

        //Draw nextMino
        nextMino.draw(g2);

        //Draw staticBlocks
        for (Block b : staticBlocks){
            b.draw(g2);
        }

        //Draw pause
        g2.setColor(Color.yellow);
        g2.setFont(g2.getFont().deriveFont(50f));
        if (KeyHandler.isPausePressed()) {
            FontMetrics fm = g2.getFontMetrics();
            String pauseText = "PAUSE";
            int textWidth = fm.stringWidth(pauseText);
            int textX = left_x + (width - textWidth) / 2;
            g2.drawString(pauseText, textX, top_y + 300);
        }
    }



}
