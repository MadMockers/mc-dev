package net.minecraft.server;


import java.util.Random;


public class ItemSnowball extends Item {

    public ItemSnowball(int i) {
        super(i);
        aX = 16;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.a--;
        world.a(entityplayer, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
        if (!world.z) {
            world.a(new EntitySnowball(world, entityplayer));
        }
        return itemstack;
    }
}

