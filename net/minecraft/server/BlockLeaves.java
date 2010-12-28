package net.minecraft.server;


import java.util.Random;


public class BlockLeaves extends BlockLeavesBase {

    private int b;
    private int c;

    protected BlockLeaves(int i, int j) {
        super(i, j, Material.h, false);
        c = 0;
        b = j;
        a(true);
    }

    public void b(World world, int i, int j, int k, int l) {
        c = 0;
        g(world, i, j, k);
        super.b(world, i, j, k, l);
    }

    public void e(World world, int i, int j, int k, int l) {
        if (world.a(i, j, k) != bh) {
            return;
        }
        int i1 = world.b(i, j, k);

        if (i1 == 0 || i1 != l - 1) {
            return;
        } else {
            g(world, i, j, k);
            return;
        }
    }

    public void g(World world, int i, int j, int k) {
        if (c++ >= 100) {
            return;
        }
        int l = world.c(i, j - 1, k).a() ? 16 : 0;
        int i1 = world.b(i, j, k);

        if (i1 == 0) {
            i1 = 1;
            world.b(i, j, k, 1);
        }
        l = f(world, i, j - 1, k, l);
        l = f(world, i, j, k - 1, l);
        l = f(world, i, j, k + 1, l);
        l = f(world, i - 1, j, k, l);
        l = f(world, i + 1, j, k, l);
        int j1 = l - 1;

        if (j1 < 10) {
            j1 = 1;
        }
        if (j1 != i1) {
            world.b(i, j, k, j1);
            e(world, i, j - 1, k, i1);
            e(world, i, j + 1, k, i1);
            e(world, i, j, k - 1, i1);
            e(world, i, j, k + 1, i1);
            e(world, i - 1, j, k, i1);
            e(world, i + 1, j, k, i1);
        }
    }

    private int f(World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);

        if (i1 == Block.J.bh) {
            return 16;
        }
        if (i1 == bh) {
            int j1 = world.b(i, j, k);

            if (j1 != 0 && j1 > l) {
                return j1;
            }
        }
        return l;
    }

    public void a(World world, int i, int j, int k, Random random) {
        int l = world.b(i, j, k);

        if (l == 0) {
            c = 0;
            g(world, i, j, k);
        } else if (l == 1) {
            h(world, i, j, k);
        } else if (random.nextInt(10) == 0) {
            g(world, i, j, k);
        }
    }

    private void h(World world, int i, int j, int k) {
        a_(world, i, j, k, world.b(i, j, k));
        world.d(i, j, k, 0);
    }

    public int a(Random random) {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int a(int i, Random random) {
        return Block.y.bh;
    }

    public boolean a() {
        return !a;
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        super.b(world, i, j, k, entity);
    }
}

