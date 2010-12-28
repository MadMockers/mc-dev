package net.minecraft.server;


public class BlockSponge extends Block {

    protected BlockSponge(int i) {
        super(i, Material.j);
        bh = 48;
    }

    public void e(World world, int i, int j, int k) {
        byte byte0 = 2;

        for (int l = i - byte0; l <= i + byte0; l++) {
            for (int i1 = j - byte0; i1 <= j + byte0; i1++) {
                for (int j1 = k - byte0; j1 <= k + byte0; j1++) {
                    if (world.c(l, i1, j1) != Material.f) {
                        ;
                    }
                }

            }

        }

    }

    public void b(World world, int i, int j, int k) {
        byte byte0 = 2;

        for (int l = i - byte0; l <= i + byte0; l++) {
            for (int i1 = j - byte0; i1 <= j + byte0; i1++) {
                for (int j1 = k - byte0; j1 <= k + byte0; j1++) {
                    world.g(l, i1, j1, world.a(l, i1, j1));
                }

            }

        }

    }
}

