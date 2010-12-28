package net.minecraft.server;


import java.util.*;


public class EntityPainting extends Entity {

    private int c;
    public int a;
    private int d;
    private int e;
    private int f;
    public EnumArt b;

    public EntityPainting(World world) {
        super(world);
        c = 0;
        a = 0;
        H = 0.0F;
        a(0.5F, 0.5F);
    }

    public EntityPainting(World world, int i, int j, int k, int l) {
        this(world);
        d = i;
        e = j;
        f = k;
        ArrayList arraylist = new ArrayList();
        EnumArt aenumart[] = EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; j1++) {
            EnumArt enumart = aenumart[j1];

            b = enumart;
            a(l);
            if (c()) {
                arraylist.add(enumart);
            }
        }

        if (arraylist.size() > 0) {
            b = (EnumArt) arraylist.get(W.nextInt(arraylist.size()));
        }
        a(l);
    }

    public void a(int i) {
        a = i;
        x = v = i * 90;
        float f1 = b.z;
        float f2 = b.A;
        float f3 = b.z;

        if (i == 0 || i == 2) {
            f3 = 0.5F;
        } else {
            f1 = 0.5F;
        }
        f1 /= 32F;
        f2 /= 32F;
        f3 /= 32F;
        float f4 = (float) d + 0.5F;
        float f5 = (float) e + 0.5F;
        float f6 = (float) f + 0.5F;
        float f7 = 0.5625F;

        if (i == 0) {
            f6 -= f7;
        }
        if (i == 1) {
            f4 -= f7;
        }
        if (i == 2) {
            f6 += f7;
        }
        if (i == 3) {
            f4 += f7;
        }
        if (i == 0) {
            f4 -= c(b.z);
        }
        if (i == 1) {
            f6 += c(b.z);
        }
        if (i == 2) {
            f4 += c(b.z);
        }
        if (i == 3) {
            f6 -= c(b.z);
        }
        f5 += c(b.A);
        a(f4, f5, f6);
        float f8 = -0.00625F;

        z.c(f4 - f1 - f8, f5 - f2 - f8, f6 - f3 - f8, f4 + f1 + f8, f5 + f2 + f8, f6 + f3 + f8);
    }

    private float c(int i) {
        if (i == 32) {
            return 0.5F;
        }
        return i != 64 ? 0.0F : 0.5F;
    }

    public void b_() {
        if (c++ == 100 && !c()) {
            c = 0;
            l();
            l.a(new EntityItem(l, p, q, r, new ItemStack(Item.aq)));
        }
    }

    public boolean c() {
        if (this.l.a(this, z).size() > 0) {
            return false;
        }
        int i = b.z / 16;
        int j = b.A / 16;
        int k = d;
        int l = e;
        int i1 = f;

        if (a == 0) {
            k = MathHelper.b(p - (double) ((float) b.z / 32F));
        }
        if (a == 1) {
            i1 = MathHelper.b(r - (double) ((float) b.z / 32F));
        }
        if (a == 2) {
            k = MathHelper.b(p - (double) ((float) b.z / 32F));
        }
        if (a == 3) {
            i1 = MathHelper.b(r - (double) ((float) b.z / 32F));
        }
        l = MathHelper.b(q - (double) ((float) b.A / 32F));
        for (int j1 = 0; j1 < i; j1++) {
            for (int k1 = 0; k1 < j; k1++) {
                Material material;

                if (a == 0 || a == 2) {
                    material = this.l.c(k + j1, l + k1, f);
                } else {
                    material = this.l.c(d, l + k1, i1 + j1);
                }
                if (!material.a()) {
                    return false;
                }
            }

        }

        List list = this.l.b(this, z);

        for (int l1 = 0; l1 < list.size(); l1++) {
            if (list.get(l1) instanceof EntityPainting) {
                return false;
            }
        }

        return true;
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity entity, int i) {
        l();
        u();
        l.a(new EntityItem(l, p, q, r, new ItemStack(Item.aq)));
        return true;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Dir", (byte) a);
        nbttagcompound.a("Motive", b.y);
        nbttagcompound.a("TileX", d);
        nbttagcompound.a("TileY", e);
        nbttagcompound.a("TileZ", f);
    }

    public void b(NBTTagCompound nbttagcompound) {
        a = nbttagcompound.b("Dir");
        d = nbttagcompound.d("TileX");
        e = nbttagcompound.d("TileY");
        f = nbttagcompound.d("TileZ");
        String s = nbttagcompound.h("Motive");
        EnumArt aenumart[] = EnumArt.values();
        int i = aenumart.length;

        for (int j = 0; j < i; j++) {
            EnumArt enumart = aenumart[j];

            if (enumart.y.equals(s)) {
                b = enumart;
            }
        }

        if (b == null) {
            b = EnumArt.a;
        }
        a(a);
    }
}

