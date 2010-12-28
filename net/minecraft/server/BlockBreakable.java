package net.minecraft.server;


public class BlockBreakable extends Block {

    private boolean a;

    protected BlockBreakable(int i, int j, Material material, boolean flag) {
        super(i, j, material);
        a = flag;
    }

    public boolean a() {
        return false;
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        int i1 = iblockaccess.a(i, j, k);

        if (!a && i1 == bh) {
            return false;
        } else {
            return super.a(iblockaccess, i, j, k, l);
        }
    }
}

