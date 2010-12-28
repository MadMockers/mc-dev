package net.minecraft.server;


public class InventoryLargeChest
        implements IInventory {

    private String a;
    private IInventory b;
    private IInventory c;

    public InventoryLargeChest(String s, IInventory iinventory, IInventory iinventory1) {
        a = s;
        b = iinventory;
        c = iinventory1;
    }

    public int a() {
        return b.a() + c.a();
    }

    public ItemStack a(int i) {
        if (i >= b.a()) {
            return c.a(i - b.a());
        } else {
            return b.a(i);
        }
    }
}

