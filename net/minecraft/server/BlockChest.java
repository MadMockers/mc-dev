package net.minecraft.server;


import java.util.Random;


public class BlockChest extends BlockContainer {

    private Random a;

    protected BlockChest(int i) {
        super(i, Material.c);
        a = new Random();
        bg = 26;
    }

    public int a(int i) {
        if (i == 1) {
            return bg - 1;
        }
        if (i == 0) {
            return bg - 1;
        }
        if (i == 3) {
            return bg + 1;
        } else {
            return bg;
        }
    }

    public boolean a(World world, int i, int j, int k) {
        int l = 0;

        if (world.a(i - 1, j, k) == bh) {
            l++;
        }
        if (world.a(i + 1, j, k) == bh) {
            l++;
        }
        if (world.a(i, j, k - 1) == bh) {
            l++;
        }
        if (world.a(i, j, k + 1) == bh) {
            l++;
        }
        if (l > 1) {
            return false;
        }
        if (g(world, i - 1, j, k)) {
            return false;
        }
        if (g(world, i + 1, j, k)) {
            return false;
        }
        if (g(world, i, j, k - 1)) {
            return false;
        }
        return !g(world, i, j, k + 1);
    }

    private boolean g(World world, int i, int j, int k) {
        if (world.a(i, j, k) != bh) {
            return false;
        }
        if (world.a(i - 1, j, k) == bh) {
            return true;
        }
        if (world.a(i + 1, j, k) == bh) {
            return true;
        }
        if (world.a(i, j, k - 1) == bh) {
            return true;
        }
        return world.a(i, j, k + 1) == bh;
    }

    public void b(World world, int i, int j, int k) {
        TileEntityChest tileentitychest = (TileEntityChest) world.l(i, j, k);

        label0:
        for (int l = 0; l < tileentitychest.a(); l++) {
            ItemStack itemstack = tileentitychest.a(l);

            if (itemstack == null) {
                continue;
            }
            float f = a.nextFloat() * 0.8F + 0.1F;
            float f1 = a.nextFloat() * 0.8F + 0.1F;
            float f2 = a.nextFloat() * 0.8F + 0.1F;

            do {
                if (itemstack.a <= 0) {
                    continue label0;
                }
                int i1 = a.nextInt(21) + 10;

                if (i1 > itemstack.a) {
                    i1 = itemstack.a;
                }
                itemstack.a -= i1;
                EntityItem entityitem = new EntityItem(world, (float) i + f, (float) j + f1, (float) k + f2, new ItemStack(itemstack.c, i1, itemstack.d));
                float f3 = 0.05F;

                entityitem.s = (float) a.nextGaussian() * f3;
                entityitem.t = (float) a.nextGaussian() * f3 + 0.2F;
                entityitem.u = (float) a.nextGaussian() * f3;
                world.a(entityitem);
            } while (true);
        }

        super.b(world, i, j, k);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        Object obj = (TileEntityChest) world.l(i, j, k);

        if (world.d(i, j + 1, k)) {
            return true;
        }
        if (world.a(i - 1, j, k) == bh && world.d(i - 1, j + 1, k)) {
            return true;
        }
        if (world.a(i + 1, j, k) == bh && world.d(i + 1, j + 1, k)) {
            return true;
        }
        if (world.a(i, j, k - 1) == bh && world.d(i, j + 1, k - 1)) {
            return true;
        }
        if (world.a(i, j, k + 1) == bh && world.d(i, j + 1, k + 1)) {
            return true;
        }
        if (world.a(i - 1, j, k) == bh) {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest) world.l(i - 1, j, k), ((IInventory) (obj)));
        }
        if (world.a(i + 1, j, k) == bh) {
            obj = new InventoryLargeChest("Large chest", ((IInventory) (obj)), (TileEntityChest) world.l(i + 1, j, k));
        }
        if (world.a(i, j, k - 1) == bh) {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest) world.l(i, j, k - 1), ((IInventory) (obj)));
        }
        if (world.a(i, j, k + 1) == bh) {
            obj = new InventoryLargeChest("Large chest", ((IInventory) (obj)), (TileEntityChest) world.l(i, j, k + 1));
        }
        if (world.z) {
            return true;
        } else {
            entityplayer.a(((IInventory) (obj)));
            return true;
        }
    }

    protected TileEntity a_() {
        return new TileEntityChest();
    }
}

