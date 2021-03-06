package net.minecraft.server;


public class InventoryPlayer
        implements IInventory {

    public ItemStack a[];
    public ItemStack b[];
    public int c;
    private EntityPlayer e;
    private ItemStack f;
    public boolean d;

    public InventoryPlayer(EntityPlayer entityplayer) {
        a = new ItemStack[36];
        b = new ItemStack[4];
        c = 0;
        d = false;
        e = entityplayer;
    }

    public ItemStack e() {
        return a[c];
    }

    private int d(int k) {
        for (int l = 0; l < a.length; l++) {
            if (a[l] != null && a[l].c == k) {
                return l;
            }
        }

        return -1;
    }

    private int e(int k) {
        for (int l = 0; l < a.length; l++) {
            if (a[l] != null && a[l].c == k && a[l].a < a[l].b() && a[l].a < c()) {
                return l;
            }
        }

        return -1;
    }

    private int j() {
        for (int k = 0; k < a.length; k++) {
            if (a[k] == null) {
                return k;
            }
        }

        return -1;
    }

    private int b(int k, int l) {
        int i1 = e(k);

        if (i1 < 0) {
            i1 = j();
        }
        if (i1 < 0) {
            return l;
        }
        if (a[i1] == null) {
            a[i1] = new ItemStack(k, 0);
        }
        int j1 = l;

        if (j1 > a[i1].b() - a[i1].a) {
            j1 = a[i1].b() - a[i1].a;
        }
        if (j1 > c() - a[i1].a) {
            j1 = c() - a[i1].a;
        }
        if (j1 == 0) {
            return l;
        } else {
            l -= j1;
            a[i1].a += j1;
            a[i1].b = 5;
            return l;
        }
    }

    public void f() {
        for (int k = 0; k < a.length; k++) {
            if (a[k] != null && a[k].b > 0) {
                a[k].b--;
            }
        }

    }

    public boolean b(int k) {
        int l = d(k);

        if (l < 0) {
            return false;
        }
        if (--a[l].a <= 0) {
            a[l] = null;
        }
        return true;
    }

    public boolean a(ItemStack itemstack) {
        if (itemstack.d == 0) {
            itemstack.a = b(itemstack.c, itemstack.a);
            if (itemstack.a == 0) {
                return true;
            }
        }
        int k = j();

        if (k >= 0) {
            a[k] = itemstack;
            a[k].b = 5;
            return true;
        } else {
            return false;
        }
    }

    public ItemStack a(int k, int l) {
        ItemStack aitemstack[] = a;

        if (k >= a.length) {
            aitemstack = b;
            k -= a.length;
        }
        if (aitemstack[k] != null) {
            if (aitemstack[k].a <= l) {
                ItemStack itemstack = aitemstack[k];

                aitemstack[k] = null;
                return itemstack;
            }
            ItemStack itemstack1 = aitemstack[k].a(l);

            if (aitemstack[k].a == 0) {
                aitemstack[k] = null;
            }
            return itemstack1;
        } else {
            return null;
        }
    }

    public void a(int k, ItemStack itemstack) {
        ItemStack aitemstack[] = a;

        if (k >= aitemstack.length) {
            k -= aitemstack.length;
            aitemstack = b;
        }
        aitemstack[k] = itemstack;
    }

    public float a(Block block) {
        float f1 = 1.0F;

        if (a[c] != null) {
            f1 *= a[c].a(block);
        }
        return f1;
    }

    public NBTTagList a(NBTTagList nbttaglist) {
        for (int k = 0; k < a.length; k++) {
            if (a[k] != null) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();

                nbttagcompound.a("Slot", (byte) k);
                a[k].a(nbttagcompound);
                nbttaglist.a(nbttagcompound);
            }
        }

        for (int l = 0; l < b.length; l++) {
            if (b[l] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.a("Slot", (byte) (l + 100));
                b[l].a(nbttagcompound1);
                nbttaglist.a(nbttagcompound1);
            }
        }

        return nbttaglist;
    }

    public void b(NBTTagList nbttaglist) {
        a = new ItemStack[36];
        b = new ItemStack[4];
        for (int k = 0; k < nbttaglist.b(); k++) {
            NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglist.a(k);
            int l = nbttagcompound.b("Slot") & 0xff;
            ItemStack itemstack = new ItemStack(nbttagcompound);

            if (itemstack.a() == null) {
                continue;
            }
            if (l >= 0 && l < a.length) {
                a[l] = itemstack;
            }
            if (l >= 100 && l < b.length + 100) {
                b[l - 100] = itemstack;
            }
        }

    }

    public int a() {
        return a.length + 4;
    }

    public ItemStack a(int k) {
        ItemStack aitemstack[] = a;

        if (k >= aitemstack.length) {
            k -= aitemstack.length;
            aitemstack = b;
        }
        return aitemstack[k];
    }

    public String b() {
        return "Inventory";
    }

    public int c() {
        return 64;
    }

    public int a(Entity entity) {
        ItemStack itemstack = a(c);

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
        ItemStack itemstack = a(c);

        if (itemstack != null) {
            return itemstack.b(block);
        } else {
            return false;
        }
    }

    public int g() {
        int k = 0;
        int l = 0;
        int i1 = 0;

        for (int j1 = 0; j1 < b.length; j1++) {
            if (b[j1] != null && (b[j1].a() instanceof ItemArmor)) {
                int k1 = b[j1].c();
                int l1 = b[j1].d;
                int i2 = k1 - l1;

                l += i2;
                i1 += k1;
                int j2 = ((ItemArmor) b[j1].a()).bc;

                k += j2;
            }
        }

        if (i1 == 0) {
            return 0;
        } else {
            return ((k - 1) * l) / i1 + 1;
        }
    }

    public void c(int k) {
        for (int l = 0; l < b.length; l++) {
            if (b[l] == null || !(b[l].a() instanceof ItemArmor)) {
                continue;
            }
            b[l].b(k);
            if (b[l].a == 0) {
                b[l].a(e);
                b[l] = null;
            }
        }

    }

    public void h() {
        for (int k = 0; k < a.length; k++) {
            if (a[k] != null) {
                e.a(a[k], true);
                a[k] = null;
            }
        }

        for (int l = 0; l < b.length; l++) {
            if (b[l] != null) {
                e.a(b[l], true);
                b[l] = null;
            }
        }

    }

    public void d() {
        d = true;
    }

    public void b(ItemStack itemstack) {
        f = itemstack;
        e.a(itemstack);
    }

    public ItemStack i() {
        return f;
    }

    public boolean a_(EntityPlayer entityplayer) {
        if (e.G) {
            return false;
        }
        return entityplayer.b(e) <= 64D;
    }
}

