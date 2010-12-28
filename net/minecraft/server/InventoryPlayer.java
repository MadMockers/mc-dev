package net.minecraft.server;


public class InventoryPlayer
        implements IInventory {

    public ItemStack a[];
    public ItemStack b[];
    public ItemStack c[];
    public int d;
    private EntityPlayer f;
    public boolean e;

    public InventoryPlayer(EntityPlayer entityplayer) {
        a = new ItemStack[37];
        b = new ItemStack[4];
        c = new ItemStack[4];
        d = 0;
        e = false;
        f = entityplayer;
    }

    public ItemStack b() {
        return a[d];
    }

    private int d(int i) {
        for (int j = 0; j < a.length; j++) {
            if (a[j] != null && a[j].c == i) {
                return j;
            }
        }

        return -1;
    }

    private int e(int i) {
        for (int j = 0; j < a.length; j++) {
            if (a[j] != null && a[j].c == i && a[j].a < a[j].b() && a[j].a < d()) {
                return j;
            }
        }

        return -1;
    }

    private int g() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private int a(int i, int j) {
        int k = e(i);

        if (k < 0) {
            k = g();
        }
        if (k < 0) {
            return j;
        }
        if (a[k] == null) {
            a[k] = new ItemStack(i, 0);
        }
        int l = j;

        if (l > a[k].b() - a[k].a) {
            l = a[k].b() - a[k].a;
        }
        if (l > d() - a[k].a) {
            l = d() - a[k].a;
        }
        if (l == 0) {
            return j;
        } else {
            j -= l;
            a[k].a += l;
            a[k].b = 5;
            return j;
        }
    }

    public void c() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i].b > 0) {
                a[i].b--;
            }
        }

    }

    public boolean b(int i) {
        int j = d(i);

        if (j < 0) {
            return false;
        }
        if (--a[j].a <= 0) {
            a[j] = null;
        }
        return true;
    }

    public boolean a(ItemStack itemstack) {
        if (itemstack.d == 0) {
            itemstack.a = a(itemstack.c, itemstack.a);
            if (itemstack.a == 0) {
                return true;
            }
        }
        int i = g();

        if (i >= 0) {
            a[i] = itemstack;
            a[i].b = 5;
            return true;
        } else {
            return false;
        }
    }

    public void a(int i, ItemStack itemstack) {
        ItemStack aitemstack[] = a;

        if (i >= aitemstack.length) {
            i -= aitemstack.length;
            aitemstack = b;
        }
        if (i >= aitemstack.length) {
            i -= aitemstack.length;
            aitemstack = c;
        }
        aitemstack[i] = itemstack;
    }

    public float a(Block block) {
        float f1 = 1.0F;

        if (a[d] != null) {
            f1 *= a[d].a(block);
        }
        return f1;
    }

    public NBTTagList a(NBTTagList nbttaglist) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();

                nbttagcompound.a("Slot", (byte) i);
                a[i].a(nbttagcompound);
                nbttaglist.a(nbttagcompound);
            }
        }

        for (int j = 0; j < b.length; j++) {
            if (b[j] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.a("Slot", (byte) (j + 100));
                b[j].a(nbttagcompound1);
                nbttaglist.a(nbttagcompound1);
            }
        }

        for (int k = 0; k < c.length; k++) {
            if (c[k] != null) {
                NBTTagCompound nbttagcompound2 = new NBTTagCompound();

                nbttagcompound2.a("Slot", (byte) (k + 80));
                c[k].a(nbttagcompound2);
                nbttaglist.a(nbttagcompound2);
            }
        }

        return nbttaglist;
    }

    public void b(NBTTagList nbttaglist) {
        a = new ItemStack[36];
        b = new ItemStack[4];
        c = new ItemStack[4];
        for (int i = 0; i < nbttaglist.b(); i++) {
            NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglist.a(i);
            int j = nbttagcompound.b("Slot") & 0xff;

            if (j >= 0 && j < a.length) {
                a[j] = new ItemStack(nbttagcompound);
            }
            if (j >= 80 && j < c.length + 80) {
                c[j - 80] = new ItemStack(nbttagcompound);
            }
            if (j >= 100 && j < b.length + 100) {
                b[j - 100] = new ItemStack(nbttagcompound);
            }
        }

    }

    public int a() {
        return a.length + 4;
    }

    public ItemStack a(int i) {
        ItemStack aitemstack[] = a;

        if (i >= aitemstack.length) {
            i -= aitemstack.length;
            aitemstack = b;
        }
        if (i >= aitemstack.length) {
            i -= aitemstack.length;
            aitemstack = c;
        }
        return aitemstack[i];
    }

    public int d() {
        return 64;
    }

    public int a(Entity entity) {
        ItemStack itemstack = a(d);

        if (itemstack != null) {
            return itemstack.a(entity);
        } else {
            return 1;
        }
    }

    public boolean b(Block block) {
        if (block.bs != Material.d && block.bs != Material.e && block.bs != Material.t && block.bs != Material.s) {
            return true;
        }
        ItemStack itemstack = a(d);

        if (itemstack != null) {
            return itemstack.b(block);
        } else {
            return false;
        }
    }

    public int e() {
        int i = 0;
        int j = 0;
        int k = 0;

        for (int l = 0; l < b.length; l++) {
            if (b[l] != null && (b[l].a() instanceof ItemArmor)) {
                int i1 = b[l].c();
                int j1 = b[l].d;
                int k1 = i1 - j1;

                j += k1;
                k += i1;
                int l1 = ((ItemArmor) b[l].a()).bc;

                i += l1;
            }
        }

        if (k == 0) {
            return 0;
        } else {
            return ((i - 1) * j) / k + 1;
        }
    }

    public void c(int i) {
        for (int j = 0; j < b.length; j++) {
            if (b[j] == null || !(b[j].a() instanceof ItemArmor)) {
                continue;
            }
            b[j].a(i);
            if (b[j].a == 0) {
                b[j].a(f);
                b[j] = null;
            }
        }

    }

    public void f() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                f.a(a[i], true);
                a[i] = null;
            }
        }

        for (int j = 0; j < b.length; j++) {
            if (b[j] != null) {
                f.a(b[j], true);
                b[j] = null;
            }
        }

    }
}

