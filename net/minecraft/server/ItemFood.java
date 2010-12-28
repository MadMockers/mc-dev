package net.minecraft.server;


public class ItemFood extends Item {

    private int a;

    public ItemFood(int i, int j) {
        super(i);
        a = j;
        aX = 1;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.a--;
        entityplayer.c(a);
        return itemstack;
    }
}

