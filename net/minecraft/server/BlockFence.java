package net.minecraft.server;


import java.util.ArrayList;


public class BlockFence extends Block {

    public BlockFence(int i, int j) {
        super(i, j, Material.c);
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        arraylist.add(AxisAlignedBB.b(i, j, k, i + 1, (double) j + 1.5D, k + 1));
    }

    public boolean a(World world, int i, int j, int k) {
        if (world.a(i, j - 1, k) == bh) {
            return false;
        }
        if (!world.c(i, j - 1, k).a()) {
            return false;
        } else {
            return super.a(world, i, j, k);
        }
    }

    public boolean a() {
        return false;
    }
}

