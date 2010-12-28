package net.minecraft.server;


import java.util.Random;


public class BlockSnow extends Block {

    protected BlockSnow(int i, int j) {
        super(i, j, Material.s);
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        a(true);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean a(World world, int i, int j, int k) {
        int l = world.a(i, j - 1, k);

        if (l == 0 || !Block.m[l].a()) {
            return false;
        } else {
            return world.c(i, j - 1, k).c();
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        g(world, i, j, k);
    }

    private boolean g(World world, int i, int j, int k) {
        if (!a(world, i, j, k)) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
            return false;
        } else {
            return true;
        }
    }

    public int a(int i, Random random) {
        return Item.aB.aW;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.a(EnumSkyBlock.b, i, j, k) > 11) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        Material material = iblockaccess.c(i, j, k);

        if (l == 1) {
            return true;
        }
        if (material == bs) {
            return false;
        } else {
            return super.a(iblockaccess, i, j, k, l);
        }
    }
}

