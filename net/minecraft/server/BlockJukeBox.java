package net.minecraft.server;


import java.util.Random;


public class BlockJukeBox extends Block {

    protected BlockJukeBox(int i, int j) {
        super(i, j, Material.c);
    }

    public int a(int i) {
        return bg + (i != 1 ? 0 : 1);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        int l = world.b(i, j, k);

        if (l > 0) {
            f(world, i, j, k, l);
            return true;
        } else {
            return false;
        }
    }

    public void f(World world, int i, int j, int k, int l) {
        world.a(null, i, j, k);
        world.b(i, j, k, 0);
        int i1 = (Item.aU.aW + l) - 1;
        float f1 = 0.7F;
        double d = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.5D;
        double d1 = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.20000000000000001D + 0.59999999999999998D;
        double d2 = (double) (world.l.nextFloat() * f1) + (double) (1.0F - f1) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double) i + d, (double) j + d1, (double) k + d2, new ItemStack(i1));

        entityitem.c = 10;
        world.a(entityitem);
    }

    public void a(World world, int i, int j, int k, int l, float f1) {
        if (world.z) {
            return;
        }
        if (l > 0) {
            f(world, i, j, k, l);
        }
        super.a(world, i, j, k, l, f1);
    }
}

