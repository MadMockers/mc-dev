package net.minecraft.server;


import java.util.List;
import java.util.Random;


public abstract class EntityPlayer extends EntityLiving {

    public InventoryPlayer an;
    public CraftingInventoryCB ao;
    public CraftingInventoryCB ap;
    public byte aq;
    public int ar;
    public float as;
    public float at;
    public boolean au;
    public int av;
    public String aw;
    public int ax;
    public double ay;
    public double az;
    public double aA;
    public double aB;
    public double aC;
    public double aD;
    private int a;
    public EntityFish aE;

    public EntityPlayer(World world) {
        super(world);
        an = new InventoryPlayer(this);
        aq = 0;
        ar = 0;
        au = false;
        av = 0;
        a = 0;
        aE = null;
        ao = new CraftingInventoryPlayerCB(an, !world.z);
        ap = ao;
        H = 1.62F;
        c((double) world.m + 0.5D, world.n + 1, (double) world.o + 0.5D, 0.0F, 0.0F);
        ba = 20;
        aT = "humanoid";
        aS = 180F;
        Y = 20;
        aQ = "/mob/char.png";
    }

    public void b_() {
        super.b_();
        if (!l.z && ap != null && !ap.b(this)) {
            I();
            ap = ao;
        }
        ay = aB;
        az = aC;
        aA = aD;
        double d1 = p - aB;
        double d2 = q - aC;
        double d3 = r - aD;
        double d4 = 10D;

        if (d1 > d4) {
            ay = aB = p;
        }
        if (d3 > d4) {
            aA = aD = r;
        }
        if (d2 > d4) {
            az = aC = q;
        }
        if (d1 < -d4) {
            ay = aB = p;
        }
        if (d3 < -d4) {
            aA = aD = r;
        }
        if (d2 < -d4) {
            az = aC = q;
        }
        aB += d1 * 0.25D;
        aD += d3 * 0.25D;
        aC += d2 * 0.25D;
    }

    protected void I() {
        ap = ao;
    }

    public void z() {
        super.z();
        as = at;
        at = 0.0F;
    }

    protected void c() {
        if (au) {
            av++;
            if (av == 8) {
                av = 0;
                au = false;
            }
        } else {
            av = 0;
        }
        aZ = (float) av / 8F;
    }

    public void G() {
        if (l.k == 0 && ba < 20 && (X % 20) * 12 == 0) {
            c(1);
        }
        an.f();
        as = at;
        super.G();
        float f1 = MathHelper.a(s * s + u * u);
        float f2 = (float) Math.atan(-t * 0.20000000298023224D) * 15F;

        if (f1 > 0.1F) {
            f1 = 0.1F;
        }
        if (!A || ba <= 0) {
            f1 = 0.0F;
        }
        if (A || ba <= 0) {
            f2 = 0.0F;
        }
        at += (f1 - at) * 0.4F;
        bi += (f2 - bi) * 0.8F;
        if (ba > 0) {
            List list = l.b(this, z.b(1.0D, 0.0D, 1.0D));

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Entity entity = (Entity) list.get(i);

                    if (!entity.G) {
                        j(entity);
                    }
                }

            }
        }
    }

    private void j(Entity entity) {
        entity.b(this);
    }

    public void f(Entity entity) {
        super.f(entity);
        a(0.2F, 0.2F);
        a(p, q, r);
        t = 0.10000000149011612D;
        if (aw.equals("Notch")) {
            a(new ItemStack(Item.h, 1), true);
        }
        an.h();
        if (entity != null) {
            s = -MathHelper.b(((be + v) * 3.141593F) / 180F) * 0.1F;
            u = -MathHelper.a(((be + v) * 3.141593F) / 180F) * 0.1F;
        } else {
            s = u = 0.0D;
        }
        H = 0.1F;
    }

    public void b(Entity entity, int i) {
        ar += i;
    }

    public void L() {
        a(an.a(an.c, 1), false);
    }

    public void b(ItemStack itemstack) {
        a(itemstack, false);
    }

    public void a(ItemStack itemstack, boolean flag) {
        if (itemstack == null) {
            return;
        }
        EntityItem entityitem = new EntityItem(l, p, (q - 0.30000001192092896D) + (double) s(), r, itemstack);

        entityitem.c = 40;
        float f1 = 0.1F;

        if (flag) {
            float f3 = W.nextFloat() * 0.5F;
            float f5 = W.nextFloat() * 3.141593F * 2.0F;

            entityitem.s = -MathHelper.a(f5) * f3;
            entityitem.u = MathHelper.b(f5) * f3;
            entityitem.t = 0.20000000298023224D;
        } else {
            float f2 = 0.3F;

            entityitem.s = -MathHelper.a((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f2;
            entityitem.u = MathHelper.b((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f2;
            entityitem.t = -MathHelper.a((w / 180F) * 3.141593F) * f2 + 0.1F;
            f2 = 0.02F;
            float f4 = W.nextFloat() * 3.141593F * 2.0F;

            f2 *= W.nextFloat();
            entityitem.s += Math.cos(f4) * (double) f2;
            entityitem.t += (W.nextFloat() - W.nextFloat()) * 0.1F;
            entityitem.u += Math.sin(f4) * (double) f2;
        }
        a(entityitem);
    }

    protected void a(EntityItem entityitem) {
        l.a(entityitem);
    }

    public float a(Block block) {
        float f1 = an.a(block);

        if (a(Material.f)) {
            f1 /= 5F;
        }
        if (!A) {
            f1 /= 5F;
        }
        return f1;
    }

    public boolean b(Block block) {
        return an.b(block);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Inventory");

        an.b(nbttaglist);
        ax = nbttagcompound.d("Dimension");
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Inventory", an.a(new NBTTagList()));
        nbttagcompound.a("Dimension", ax);
    }

    public void a(IInventory iinventory) {}

    public void a(int i, int k, int i1) {}

    public void c(Entity entity, int i) {}

    public float s() {
        return 0.12F;
    }

    public boolean a(Entity entity, int i) {
        bx = 0;
        if (ba <= 0) {
            return false;
        }
        if ((entity instanceof EntityMobs) || (entity instanceof EntityArrow)) {
            if (l.k == 0) {
                i = 0;
            }
            if (l.k == 1) {
                i = i / 3 + 1;
            }
            if (l.k == 3) {
                i = (i * 3) / 2;
            }
        }
        if (i == 0) {
            return false;
        } else {
            return super.a(entity, i);
        }
    }

    protected void d(int i) {
        int k = 25 - an.g();
        int i1 = i * k + a;

        an.c(i);
        i = i1 / 25;
        a = i1 % 25;
        super.d(i);
    }

    public void a(TileEntityFurnace tileentityfurnace) {}

    public void a(TileEntitySign tileentitysign) {}

    public void g(Entity entity) {
        entity.a(this);
    }

    public ItemStack M() {
        return an.e();
    }

    public void N() {
        an.a(an.c, null);
    }

    public double B() {
        return (double) (H - 0.5F);
    }

    public void H() {
        av = -1;
        au = true;
    }

    public void h(Entity entity) {
        int i = an.a(entity);

        if (i > 0) {
            entity.a(this, i);
            ItemStack itemstack = M();

            if (itemstack != null && (entity instanceof EntityLiving)) {
                itemstack.a((EntityLiving) entity);
                if (itemstack.a <= 0) {
                    itemstack.a(this);
                    N();
                }
            }
        }
    }

    public void a(ItemStack itemstack) {}

    public void l() {
        super.l();
        ao.a(this);
        if (ap != null) {
            ap.a(this);
        }
    }
}

