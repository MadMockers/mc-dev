package net.minecraft.server;


public class TileEntityChest extends TileEntity
        implements IInventory {

    private ItemStack e[];

    public TileEntityChest() {
        e = new ItemStack[36];
    }

    public int a() {
        return 27;
    }

    public ItemStack a(int i) {
        return e[i];
    }

    public void a(int i, ItemStack itemstack) {
        e[i] = itemstack;
        if (itemstack != null && itemstack.a > d()) {
            itemstack.a = d();
        }
        c();
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Items");

        e = new ItemStack[a()];
        for (int i = 0; i < nbttaglist.b(); i++) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
            int j = nbttagcompound1.b("Slot") & 0xff;

            if (j >= 0 && j < e.length) {
                e[j] = new ItemStack(nbttagcompound1);
            }
        }

    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < e.length; i++) {
            if (e[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.a("Slot", (byte) i);
                e[i].a(nbttagcompound1);
                nbttaglist.a(nbttagcompound1);
            }
        }

        nbttagcompound.a("Items", nbttaglist);
    }

    public int d() {
        return 64;
    }
}

