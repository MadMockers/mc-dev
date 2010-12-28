package net.minecraft.server;


public class SlotCrafting extends Slot {

    private final IInventory a;

    public SlotCrafting(IInventory iinventory, IInventory iinventory1, int i, int j, int k) {
        super(iinventory1, i, j, k);
        a = iinventory;
    }

    public boolean a(ItemStack itemstack) {
        return false;
    }

    public void b() {
        for (int i = 0; i < a.a(); i++) {
            if (a.a(i) != null) {
                a.a(i, 1);
            }
        }

    }
}

