package net.minecraft.server;


import java.util.Random;


public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        if (bh == Block.I.bh) {
            return Item.k.aW;
        }
        if (bh == Block.aw.bh) {
            return Item.l.aW;
        } else {
            return bh;
        }
    }

    public int a(Random random) {
        return 1;
    }
}

