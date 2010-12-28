package net.minecraft.server;


public class ItemPickaxe extends ItemTool {

    private static Block bb[];
    private int bc;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, bb);
        bc = j;
    }

    public boolean a(Block block) {
        if (block == Block.aq) {
            return bc == 3;
        }
        if (block == Block.ay || block == Block.ax) {
            return bc >= 2;
        }
        if (block == Block.ai || block == Block.H) {
            return bc >= 2;
        }
        if (block == Block.aj || block == Block.I) {
            return bc >= 1;
        }
        if (block == Block.aO || block == Block.aP) {
            return bc >= 2;
        }
        if (block.bt == Material.d) {
            return true;
        }
        return block.bt == Material.e;
    }

    static {
        bb = (new Block[] {
            Block.x, Block.ak, Block.al, Block.u, Block.ap, Block.I, Block.aj, Block.J, Block.ai, Block.H, Block.ax, Block.ay, Block.aU, Block.bc
        });
    }
}

