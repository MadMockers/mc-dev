package net.minecraft.server;


public class BlockPumpkin extends Block {

    private boolean a;

    protected BlockPumpkin(int i, int j, boolean flag) {
        super(i, Material.w);
        bg = j;
        a(true);
        a = flag;
    }

    public int a(int i) {
        if (i == 1) {
            return bg;
        }
        if (i == 0) {
            return bg;
        }
        if (i == 3) {
            return bg + 1 + 16;
        } else {
            return bg + 16;
        }
    }

    public void e(World world, int i, int j, int k) {
        super.e(world, i, j, k);
    }

    public boolean a(World world, int i, int j, int k) {
        int l = world.a(i, j, k);

        return (l == 0 || Block.m[l].bs.d()) && world.d(i, j - 1, k);
    }

    public void a(World world, int i, int j, int k, EntityLiving entityliving) {
        int l = MathHelper.b((double) ((entityliving.v * 4F) / 360F) + 0.5D) & 3;

        world.b(i, j, k, l);
    }
}

