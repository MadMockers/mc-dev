package net.minecraft.server;


public class BlockWorkbench extends Block {

    protected BlockWorkbench(int i) {
        super(i, Material.c);
        bh = 59;
    }

    public int a(int i) {
        if (i == 1) {
            return bh - 16;
        }
        if (i == 0) {
            return Block.y.a(0);
        }
        if (i == 2 || i == 4) {
            return bh + 1;
        } else {
            return bh;
        }
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        entityplayer.F();
        return true;
    }
}

