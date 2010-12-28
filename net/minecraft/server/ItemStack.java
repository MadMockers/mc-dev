package net.minecraft.server;


public final class ItemStack {

    public int a;
    public int b;
    public int c;
    public int d;

    public ItemStack(Block block) {
        this(block, 1);
    }

    public ItemStack(Block block, int i) {
        this(block.bh, i);
    }

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int i) {
        this(item.aW, i);
    }

    public ItemStack(int i) {
        this(i, 1);
    }

    public ItemStack(int i, int j) {
        a = 0;
        c = i;
        a = j;
    }

    public ItemStack(int i, int j, int k) {
        a = 0;
        c = i;
        a = j;
        d = k;
    }

    public ItemStack(NBTTagCompound nbttagcompound) {
        a = 0;
        b(nbttagcompound);
    }

    public Item a() {
        return Item.c[c];
    }

    public boolean a(EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        return a().a(this, entityplayer, world, i, j, k, l);
    }

    public float a(Block block) {
        return a().a(this, block);
    }

    public ItemStack a(World world, EntityPlayer entityplayer) {
        return a().a(this, world, entityplayer);
    }

    public NBTTagCompound a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("id", (short) c);
        nbttagcompound.a("Count", (byte) a);
        nbttagcompound.a("Damage", (short) d);
        return nbttagcompound;
    }

    public void b(NBTTagCompound nbttagcompound) {
        c = nbttagcompound.c("id");
        a = nbttagcompound.b("Count");
        d = nbttagcompound.c("Damage");
    }

    public int b() {
        return a().a();
    }

    public int c() {
        return Item.c[c].b();
    }

    public void a(int i) {
        d += i;
        if (d > c()) {
            a--;
            if (a < 0) {
                a = 0;
            }
            d = 0;
        }
    }

    public void a(EntityLiving entityliving) {
        Item.c[c].a(this, entityliving);
    }

    public void a(int i, int j, int k, int l) {
        Item.c[c].a(this, i, j, k, l);
    }

    public int a(Entity entity) {
        return Item.c[c].a(entity);
    }

    public boolean b(Block block) {
        return Item.c[c].a(block);
    }

    public void a(EntityPlayer entityplayer) {}

    public ItemStack d() {
        return new ItemStack(c, a, d);
    }
}

