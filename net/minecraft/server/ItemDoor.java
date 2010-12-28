package net.minecraft.server;


public class ItemDoor extends Item {

    private Material a;

    public ItemDoor(int i, Material material) {
        super(i);
        a = material;
        aY = 64;
        aX = 1;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        }
        j++;
        Block block;

        if (a == Material.c) {
            block = Block.aE;
        } else {
            block = Block.aL;
        }
        if (!block.a(world, i, j, k)) {
            return false;
        }
        int i1 = MathHelper.b((double) (((entityplayer.v + 180F) * 4F) / 360F) - 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;

        if (i1 == 0) {
            byte1 = 1;
        }
        if (i1 == 1) {
            byte0 = -1;
        }
        if (i1 == 2) {
            byte1 = -1;
        }
        if (i1 == 3) {
            byte0 = 1;
        }
        int j1 = (world.d(i - byte0, j, k - byte1) ? 1 : 0) + (world.d(i - byte0, j + 1, k - byte1) ? 1 : 0);
        int k1 = (world.d(i + byte0, j, k + byte1) ? 1 : 0) + (world.d(i + byte0, j + 1, k + byte1) ? 1 : 0);
        boolean flag = world.a(i - byte0, j, k - byte1) == block.bh || world.a(i - byte0, j + 1, k - byte1) == block.bh;
        boolean flag1 = world.a(i + byte0, j, k + byte1) == block.bh || world.a(i + byte0, j + 1, k + byte1) == block.bh;
        boolean flag2 = false;

        if (flag && !flag1) {
            flag2 = true;
        } else if (k1 > j1) {
            flag2 = true;
        }
        if (flag2) {
            i1 = i1 - 1 & 3;
            i1 += 4;
        }
        world.d(i, j, k, block.bh);
        world.b(i, j, k, i1);
        world.d(i, j + 1, k, block.bh);
        world.b(i, j + 1, k, i1 + 8);
        itemstack.a--;
        return true;
    }
}

