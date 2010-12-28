package net.minecraft.server;


public class BlockWorkbench extends Block {

    protected BlockWorkbench(int i) {
        super(i, Material.c);
        bg = 59;
    }

    public int a(int i) {
        if (i == 1) {
            return bg - 16;
        }
        if (i == 0) {
            return Block.x.a(0);
        }
        if (i == 2 || i == 4) {
            return bg + 1;
        } else {
            return bg;
        }
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        entityplayer.F();
        return true;
    }
}

