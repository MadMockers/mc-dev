package net.minecraft.server;


import java.util.Random;


public class BlockLog extends Block {

    protected BlockLog(int i) {
        super(i, Material.c);
        bh = 20;
    }

    public int a(Random random) {
        return 1;
    }

    public int a(int i, Random random) {
        return Block.K.bi;
    }

    public int a(int i) {
        if (i == 1) {
            return 21;
        }
        return i != 0 ? 20 : 21;
    }
}

