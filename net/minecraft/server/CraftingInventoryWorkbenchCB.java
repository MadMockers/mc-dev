package net.minecraft.server;


public class CraftingInventoryWorkbenchCB extends CraftingInventoryCB {

    public InventoryCrafting a;
    public IInventory b;
    private World c;
    private int h;
    private int i;
    private int j;

    public CraftingInventoryWorkbenchCB(InventoryPlayer inventoryplayer, World world, int k, int l, int i1) {
        a = new InventoryCrafting(this, 3, 3);
        b = new InventoryCraftResult();
        c = world;
        h = k;
        i = l;
        j = i1;
        a(new SlotCrafting(a, b, 0, 124, 35));
        for (int j1 = 0; j1 < 3; j1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                a(new Slot(a, i2 + j1 * 3, 30 + i2 * 18, 17 + j1 * 18));
            }

        }

        for (int k1 = 0; k1 < 3; k1++) {
            for (int j2 = 0; j2 < 9; j2++) {
                a(new Slot(inventoryplayer, j2 + k1 * 9 + 9, 8 + j2 * 18, 84 + k1 * 18));
            }

        }

        for (int l1 = 0; l1 < 9; l1++) {
            a(new Slot(inventoryplayer, l1, 8 + l1 * 18, 142));
        }

        a(a);
    }

    public void a(IInventory iinventory) {
        int ai[] = new int[9];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int i1 = k + l * 3;
                ItemStack itemstack = a.a(i1);

                if (itemstack == null) {
                    ai[i1] = -1;
                } else {
                    ai[i1] = itemstack.c;
                }
            }

        }

        b.a(0, CraftingManager.a().a(ai));
    }

    public void a(EntityPlayer entityplayer) {
        super.a(entityplayer);
        for (int k = 0; k < 9; k++) {
            ItemStack itemstack = a.a(k);

            if (itemstack != null) {
                entityplayer.b(itemstack);
            }
        }

    }

    public boolean b(EntityPlayer entityplayer) {
        if (c.a(h, i, j) != Block.ay.bh) {
            return false;
        }
        return entityplayer.d((double) h + 0.5D, (double) i + 0.5D, (double) j + 0.5D) <= 64D;
    }
}

