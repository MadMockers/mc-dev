package net.minecraft.server;


public class ItemSword extends Item {

    private int a;

    public ItemSword(int i, int j) {
        super(i);
        aX = 1;
        aY = 32 << j;
        if (j == 3) {
            aY *= 4;
        }
        a = 4 + j * 2;
    }

    public float a(ItemStack itemstack, Block block) {
        return 1.5F;
    }

    public void a(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.b(1);
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.b(2);
    }

    public int a(Entity entity) {
        return a;
    }
}

