package net.minecraft.server;


import java.util.Random;


public class BlockLeaves extends BlockLeavesBase {

    private int b;
    private int c;

    protected BlockLeaves(int i, int j) {
        super(i, j, Material.h, false);
        c = 0;
        b = j;
    }

    public void b(World world, int i, int j, int k, int l) {
        c = 0;
        g(world, i, j, k);
        super.b(world, i, j, k, l);
    }

    public void g(World world, int i, int j, int k) {}

    public int a(Random random) {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int a(int i, Random random) {
        return Block.z.bi;
    }

    public boolean a() {
        return !a;
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        super.b(world, i, j, k, entity);
    }
}

