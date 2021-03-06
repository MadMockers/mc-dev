package net.minecraft.server;


import java.util.Random;


public class BlockGrass extends Block {

    protected BlockGrass(int i) {
        super(i, Material.b);
        bg = 3;
        a(true);
    }

    public void a(World world, int i, int j, int k, Random random) {
        if (world.z) {
            return;
        }
        if (world.i(i, j + 1, k) < 4 && world.c(i, j + 1, k).b()) {
            if (random.nextInt(4) != 0) {
                return;
            }
            world.d(i, j, k, Block.v.bh);
        } else if (world.i(i, j + 1, k) >= 9) {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;

            if (world.a(l, i1, j1) == Block.v.bh && world.i(l, i1 + 1, j1) >= 4 && !world.c(l, i1 + 1, j1).b()) {
                world.d(l, i1, j1, Block.u.bh);
            }
        }
    }

    public int a(int i, Random random) {
        return Block.v.a(0, random);
    }
}

