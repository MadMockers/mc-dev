package net.minecraft.server;


public class ItemSpade extends ItemTool {

    private static Block bb[];

    public ItemSpade(int i, int j) {
        super(i, 1, j, bb);
    }

    public boolean a(Block block) {
        if (block == Block.aS) {
            return true;
        }
        return block == Block.aU;
    }

    static {
        bb = (new Block[] {
            Block.u, Block.v, Block.E, Block.F, Block.aS, Block.aU, Block.aW
        });
    }
}

