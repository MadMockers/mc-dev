package net.minecraft.server;


import java.util.Random;


public class BlockSoil extends Block {

    protected BlockSoil(int i) {
        super(i, Material.b);
        bg = 87;
        a(true);
        a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        c(255);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return AxisAlignedBB.b(i + 0, j + 0, k + 0, i + 1, j + 1, k + 1);
    }

    public boolean a() {
        return false;
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (random.nextInt(5) == 0) {
            if (h(world, i, j, k)) {
                world.b(i, j, k, 7);
            } else {
                int l = world.b(i, j, k);

                if (l > 0) {
                    world.b(i, j, k, l - 1);
                } else if (!g(world, i, j, k)) {
                    world.d(i, j, k, Block.v.bh);
                }
            }
        }
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        if (world.l.nextInt(4) == 0) {
            world.d(i, j, k, Block.v.bh);
        }
    }

    private boolean g(World world, int i, int j, int k) {
        int l = 0;

        for (int i1 = i - l; i1 <= i + l; i1++) {
            for (int j1 = k - l; j1 <= k + l; j1++) {
                if (world.a(i1, j + 1, j1) == Block.az.bh) {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean h(World world, int i, int j, int k) {
        for (int l = i - 4; l <= i + 4; l++) {
            for (int i1 = j; i1 <= j + 1; i1++) {
                for (int j1 = k - 4; j1 <= k + 4; j1++) {
                    if (world.c(l, i1, j1) == Material.f) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void b(World world, int i, int j, int k, int l) {
        super.b(world, i, j, k, l);
        Material material = world.c(i, j + 1, k);

        if (material.a()) {
            world.d(i, j, k, Block.v.bh);
        }
    }

    public int a(int i, Random random) {
        return Block.v.a(0, random);
    }
}

