package net.minecraft.server;


public class ItemAxe extends ItemTool {

    private static Block bb[];

    public ItemAxe(int i, int j) {
        super(i, 3, j, bb);
    }

    static {
        bb = (new Block[] {
            Block.y, Block.ao, Block.K, Block.av
        });
    }
}

