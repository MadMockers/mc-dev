package net.minecraft.server;


public class ItemInWorldManager {

    private World b;
    public EntityPlayer a;
    private float c;
    private float d;
    private int e;
    private float f;
    private int g;
    private int h;
    private int i;

    public ItemInWorldManager(World world) {
        d = 0.0F;
        e = 0;
        f = 0.0F;
        b = world;
    }

    public void a(int j, int k, int l) {
        int i1 = b.a(j, k, l);

        if (i1 > 0 && d == 0.0F) {
            Block.n[i1].b(b, j, k, l, a);
        }
        if (i1 > 0 && Block.n[i1].a(a) >= 1.0F) {
            c(j, k, l);
        }
    }

    public void a() {
        d = 0.0F;
        e = 0;
    }

    public void a(int j, int k, int l, int i1) {
        if (e > 0) {
            e--;
            return;
        }
        if (j == g && k == h && l == i) {
            int j1 = b.a(j, k, l);

            if (j1 == 0) {
                return;
            }
            Block block = Block.n[j1];

            d += block.a(a);
            f++;
            if (d >= 1.0F) {
                c(j, k, l);
                d = 0.0F;
                c = 0.0F;
                f = 0.0F;
                e = 5;
            }
        } else {
            d = 0.0F;
            c = 0.0F;
            f = 0.0F;
            g = j;
            h = k;
            i = l;
        }
    }

    public boolean b(int j, int k, int l) {
        Block block = Block.n[b.a(j, k, l)];
        int i1 = b.b(j, k, l);
        boolean flag = b.d(j, k, l, 0);

        if (block != null && flag) {
            block.a(b, j, k, l, i1);
        }
        return flag;
    }

    public boolean c(int j, int k, int l) {
        int i1 = b.a(j, k, l);
        int j1 = b.b(j, k, l);
        boolean flag = b(j, k, l);
        ItemStack itemstack = a.G();

        if (itemstack != null) {
            itemstack.a(i1, j, k, l);
            if (itemstack.a == 0) {
                itemstack.a(a);
                a.H();
            }
        }
        if (flag && a.b(Block.n[i1])) {
            Block.n[i1].a_(b, j, k, l, j1);
        }
        return flag;
    }

    public boolean a(EntityPlayer entityplayer, World world, ItemStack itemstack, int j, int k, int l, int i1) {
        int j1 = world.a(j, k, l);

        if (j1 > 0 && Block.n[j1].a(world, j, k, l, entityplayer)) {
            return true;
        }
        if (itemstack == null) {
            return false;
        } else {
            return itemstack.a(entityplayer, world, j, k, l, i1);
        }
    }
}

