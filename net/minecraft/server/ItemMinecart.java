package net.minecraft.server;


public class ItemMinecart extends Item {

    public int a;

    public ItemMinecart(int i, int j) {
        super(i);
        aX = 1;
        a = j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);

        if (i1 == Block.aH.bi) {
            world.a(new EntityMinecart(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, a));
            itemstack.a--;
            return true;
        } else {
            return false;
        }
    }
}

