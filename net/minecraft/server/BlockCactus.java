package net.minecraft.server;


import java.util.Random;


public class BlockCactus extends Block {

    protected BlockCactus(int i, int j) {
        super(i, j, Material.u);
        a(true);
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.a(i, j + 1, k) == 0) {
            int l;

            for (l = 1; world.a(i, j - l, k) == bi; l++) {
                ;
            }
            if (l < 3) {
                int i1 = world.b(i, j, k);

                if (i1 == 15) {
                    world.d(i, j + 1, k, bi);
                    world.b(i, j, k, 0);
                } else {
                    world.b(i, j, k, i1 + 1);
                }
            }
        }
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        float f1 = 0.0625F;

        return AxisAlignedBB.b((float) i + f1, j, (float) k + f1, (float) (i + 1) - f1, (float) (j + 1) - f1, (float) (k + 1) - f1);
    }

    public int a(int i) {
        if (i == 1) {
            return bh - 1;
        }
        if (i == 0) {
            return bh + 1;
        } else {
            return bh;
        }
    }

    public boolean a() {
        return false;
    }

    public boolean a(World world, int i, int j, int k) {
        if (!super.a(world, i, j, k)) {
            return false;
        } else {
            return f(world, i, j, k);
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        if (!f(world, i, j, k)) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        if (world.c(i - 1, j, k).a()) {
            return false;
        }
        if (world.c(i + 1, j, k).a()) {
            return false;
        }
        if (world.c(i, j, k - 1).a()) {
            return false;
        }
        if (world.c(i, j, k + 1).a()) {
            return false;
        } else {
            int l = world.a(i, j - 1, k);

            return l == Block.aW.bi || l == Block.F.bi;
        }
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        entity.a(null, 1);
    }
}

