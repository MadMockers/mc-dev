package net.minecraft.server;


import java.util.Random;


public class BlockIce extends BlockBreakable {

    public BlockIce(int i, int j) {
        super(i, j, Material.r, false);
        bt = 0.98F;
        a(true);
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return super.a(iblockaccess, i, j, k, 1 - l);
    }

    public void b(World world, int i, int j, int k) {
        Material material = world.c(i, j - 1, k);

        if (material.c() || material.d()) {
            world.d(i, j, k, Block.A.bh);
        }
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.a(EnumSkyBlock.b, i, j, k) > 11 - Block.q[bh]) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, Block.B.bh);
        }
    }
}

