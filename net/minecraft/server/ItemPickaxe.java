package net.minecraft.server;


public class ItemPickaxe extends ItemTool {

    private static Block bb[];
    private int bc;

    public ItemPickaxe(int i, int j) {
        super(i, 2, j, bb);
        bc = j;
    }

    public boolean a(Block block) {
        if (block == Block.ap) {
            return bc == 3;
        }
        if (block == Block.ax || block == Block.aw) {
            return bc >= 2;
        }
        if (block == Block.ah || block == Block.G) {
            return bc >= 2;
        }
        if (block == Block.ai || block == Block.H) {
            return bc >= 1;
        }
        if (block == Block.aN || block == Block.aO) {
            return bc >= 2;
        }
        if (block.bs == Material.d) {
            return true;
        }
        return block.bs == Material.e;
    }

    static {
        bb = (new Block[] {
            Block.w, Block.aj, Block.ak, Block.t, Block.ao, Block.H, Block.ai, Block.I, Block.ah, Block.G, Block.aw, Block.ax, Block.aT, Block.bb
        });
    }
}

