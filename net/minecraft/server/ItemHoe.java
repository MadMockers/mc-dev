package net.minecraft.server;


import java.util.Random;


public class ItemHoe extends Item {

    public ItemHoe(int i, int j) {
        super(i);
        aX = 1;
        aY = 32 << j;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.a(i, j, k);
        Material material = world.c(i, j + 1, k);

        if (!material.a() && i1 == Block.u.bh || i1 == Block.v.bh) {
            Block block = Block.aA;

            world.a((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.bq.c(), (block.bq.a() + 1.0F) / 2.0F, block.bq.b() * 0.8F);
            if (world.z) {
                return true;
            }
            world.d(i, j, k, block.bh);
            itemstack.b(1);
            if (world.l.nextInt(8) == 0 && i1 == Block.u.bh) {
                int j1 = 1;

                for (int k1 = 0; k1 < j1; k1++) {
                    float f = 0.7F;
                    float f1 = world.l.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f2 = 1.2F;
                    float f3 = world.l.nextFloat() * f + (1.0F - f) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (float) i + f1, (float) j + f2, (float) k + f3, new ItemStack(Item.Q));

                    entityitem.c = 10;
                    world.a(entityitem);
                }

            }
            return true;
        } else {
            return false;
        }
    }
}

