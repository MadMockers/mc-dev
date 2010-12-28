package net.minecraft.server;


import java.util.Random;


public class BlockGravel extends BlockSand {

    public BlockGravel(int i, int j) {
        super(i, j);
    }

    public int a(int i, Random random) {
        if (random.nextInt(10) == 0) {
            return Item.an.aW;
        } else {
            return bh;
        }
    }
}

