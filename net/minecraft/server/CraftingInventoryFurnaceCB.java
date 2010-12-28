package net.minecraft.server;


import java.util.List;


public class CraftingInventoryFurnaceCB extends CraftingInventoryCB {

    private TileEntityFurnace a;
    private int b;
    private int c;
    private int h;

    public CraftingInventoryFurnaceCB(IInventory iinventory, TileEntityFurnace tileentityfurnace) {
        b = 0;
        c = 0;
        h = 0;
        a = tileentityfurnace;
        a(new Slot(tileentityfurnace, 0, 56, 17));
        a(new Slot(tileentityfurnace, 1, 56, 53));
        a(new Slot(tileentityfurnace, 2, 116, 35));
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 9; k++) {
                a(new Slot(iinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for (int j = 0; j < 9; j++) {
            a(new Slot(iinventory, j, 8 + j * 18, 142));
        }

    }

    public void a(ICrafting icrafting) {
        super.a(icrafting);
        icrafting.a(this, 0, a.g);
        icrafting.a(this, 1, a.e);
        icrafting.a(this, 2, a.f);
    }

    public void a() {
        super.a();
        for (int i = 0; i < g.size(); i++) {
            ICrafting icrafting = (ICrafting) g.get(i);

            if (b != a.g) {
                icrafting.a(this, 0, a.g);
            }
            if (c != a.e) {
                icrafting.a(this, 1, a.e);
            }
            if (h != a.f) {
                icrafting.a(this, 2, a.f);
            }
        }

        b = a.g;
        c = a.e;
        h = a.f;
    }

    public boolean b(EntityPlayer entityplayer) {
        return a.a_(entityplayer);
    }
}

