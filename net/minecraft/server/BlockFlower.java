package net.minecraft.server;


import java.util.Random;


public class BlockFlower extends Block {

    protected BlockFlower(int i, int j) {
        super(i, Material.i);
        bg = j;
        a(true);
        float f1 = 0.2F;

        a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f1 * 3F, 0.5F + f1);
    }

    public boolean a(World world, int i, int j, int k) {
        return b(world.a(i, j - 1, k));
    }

    protected boolean b(int i) {
        return i == Block.u.bh || i == Block.v.bh || i == Block.aA.bh;
    }

    public void b(World world, int i, int j, int k, int l) {
        super.b(world, i, j, k, l);
        g(world, i, j, k);
    }

    public void a(World world, int i, int j, int k, Random random) {
        g(world, i, j, k);
    }

    protected final void g(World world, int i, int j, int k) {
        if (!f(world, i, j, k)) {
            a_(world, i, j, k, world.b(i, j, k));
            world.d(i, j, k, 0);
        }
    }

    public boolean f(World world, int i, int j, int k) {
        return (world.i(i, j, k) >= 8 || world.h(i, j, k)) && b(world.a(i, j - 1, k));
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public boolean a() {
        return false;
    }
}

