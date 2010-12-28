package net.minecraft.server;


public class BlockSlowSand extends Block {

    public BlockSlowSand(int i, int j) {
        super(i, j, Material.m);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        float f = 0.125F;

        return AxisAlignedBB.b(i, j, k, i + 1, (float) (j + 1) - f, k + 1);
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        entity.s *= 0.40000000000000002D;
        entity.u *= 0.40000000000000002D;
    }
}

