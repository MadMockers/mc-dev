package net.minecraft.server;


import java.util.Random;


public class BlockOre extends Block {

    public BlockOre(int i, int j) {
        super(i, j, Material.d);
    }

    public int a(int i, Random random) {
        if (bi == Block.J.bi) {
            return Item.k.aW;
        }
        if (bi == Block.ax.bi) {
            return Item.l.aW;
        } else {
            return bi;
        }
    }

    public int a(Random random) {
        return 1;
    }
}

