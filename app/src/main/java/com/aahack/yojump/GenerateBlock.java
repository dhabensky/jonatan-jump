package com.aahack.yojump;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.aahack.yojump.gameobject.Block;

import java.util.Random;

public class GenerateBlock {
    //размеры человечка
    private int jonW = 100;
    private int jonH = 100;
    private int maxW = 300;
    private int maxJumpW = 150;
    private int maxJumpH = 300;
    private int lastX;
    private int lastY;
    private Random rand = new Random();
    private int screenH = getScreenHeight();

    int endOfFirstBlock = 1800;

    public Block createBlock(int endOfFirstBlock){
        this.endOfFirstBlock = endOfFirstBlock;
        Block block = new Block();
        int blockW = randomNum(jonW*2, maxW);

        block.setH(20);
        //нет метода, передающего цвет. Зачем кадлый раз передавать цвет, если все плашки будут черными?
        block.setDrawable(new ColorDrawable(Color.BLACK));
        block.setTag("block");
        if(lastX == 0 && lastY == 0) {
            blockW = 1800;
            int y = 750;
            block.getPos().set(0, y);
            lastX = endOfFirstBlock;
            lastY = y;
        } else {
            int x = randomNum(lastX, lastX + maxJumpW);
            int y = randomNum(lastY - maxJumpH, screenH);
            block.getPos().set(x + 100, y);
            lastX = x + blockW;
            lastY = y;
        }
        block.setW(blockW);
        return block;
    }

    private int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private int randomNum(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}