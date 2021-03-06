package net.minecraft.server;


import java.util.Random;


public class BlockReed extends Block {

    protected BlockReed(int i, int j) {
        super(i, Material.i);
        bg = j;
        float f1 = 0.375F;

        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 1.0F, 0.5F + f1);
        a(true);
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.e(i, j + 1, k)) {
            int l;

            for (l = 1; world.a(i, j - l, k) == bh; l++) {
                ;
            }
            if (l < 3) {
                int i1 = world.b(i, j, k);

                if (i1 == 15) {
                    world.d(i, j + 1, k, bh);
                    world.b(i, j, k, 0);
                } else {
                    world.b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public boolean a(World world, int i, int j, int k) {
        int l = world.a(i, j - 1, k);

        if (l == bh) {
            return true;
        }
        if (l != Block.u.bh && l != Block.v.bh) {
            return false;
        }
        if (world.c(i - 1, j - 1, k) == Material.f) {
            return true;
        }
        if (world.c(i + 1, j - 1, k) == Material.f) {
            return true;
        }
        if (world.c(i, j - 1, k - 1) == Material.f) {
            return true;
        }
        return world.c(i, j - 1, k + 1) == Material.f;
    }

    public void b(World world, int i, int j, int k, int l) {
        g(world, i, j, k);
    }

    protected final void g(World world, int i, int j, int k) {
        if (!f(world, i, j, k)) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        return a(world, i, j, k);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public int a(int i, Random random) {
        return Item.aH.aW;
    }

    public boolean a() {
        return false;
    }
}

