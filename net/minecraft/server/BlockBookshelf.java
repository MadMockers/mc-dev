package net.minecraft.server;


import java.util.Random;


public class BlockBookshelf extends Block {

    public BlockBookshelf(int i, int j) {
        super(i, j, Material.c);
    }

    public int a(int i) {
        if (i <= 1) {
            return 4;
        } else {
            return bh;
        }
    }

    public int a(Random random) {
        return 0;
    }
}

