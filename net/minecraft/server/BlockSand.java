package net.minecraft.server;


import java.util.Random;


public class BlockSand extends Block {

    public static boolean a = false;

    public BlockSand(int i, int j) {
        super(i, j, Material.m);
    }

    public void e(World world, int i, int j, int k) {
        world.h(i, j, k, bh);
    }

    public void b(World world, int i, int j, int k, int l) {
        world.h(i, j, k, bh);
    }

    public void a(World world, int i, int j, int k, Random random) {
        h(world, i, j, k);
    }

    private void h(World world, int i, int j, int k) {
        int l = i;
        int i1 = j;
        int j1 = k;

        if (g(world, l, i1 - 1, j1) && i1 >= 0) {
            EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, bh);

            if (a) {
                while (!entityfallingsand.G) { 
                    entityfallingsand.b_();
                }
            } else {
                world.a(entityfallingsand);
            }
        }
    }

    public int b() {
        return 3;
    }

    public static boolean g(World world, int i, int j, int k) {
        int l = world.a(i, j, k);

        if (l == 0) {
            return true;
        }
        if (l == Block.ar.bh) {
            return true;
        }
        Material material = Block.m[l].bs;

        if (material == Material.f) {
            return true;
        }
        return material == Material.g;
    }

}

