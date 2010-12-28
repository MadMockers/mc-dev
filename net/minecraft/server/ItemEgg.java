package net.minecraft.server;


import java.util.Random;


public class ItemEgg extends Item {

    public ItemEgg(int i) {
        super(i);
        aX = 16;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.a--;
        world.a(entityplayer, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
        if (!world.z) {
            world.a(new EntityEgg(world, entityplayer));
        }
        return itemstack;
    }
}

