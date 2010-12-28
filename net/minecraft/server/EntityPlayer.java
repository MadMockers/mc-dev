package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityPlayer extends EntityLiving {

    public InventoryPlayer ak;
    public byte al;
    public int am;
    public float an;
    public float ao;
    public boolean ap;
    public int aq;
    public String ar;
    public int as;
    private int a;
    public EntityFish at;

    public EntityPlayer(World world) {
        super(world);
        ak = new InventoryPlayer(this);
        al = 0;
        am = 0;
        ap = false;
        aq = 0;
        a = 0;
        at = null;
        G = 1.62F;
        c((double) world.m + 0.5D, world.n + 1, (double) world.o + 0.5D, 0.0F, 0.0F);
        aP = 20;
        aI = "humanoid";
        aH = 180F;
        X = 20;
        aF = "/char.png";
    }

    public void y() {
        super.y();
        an = ao;
        ao = 0.0F;
    }

    protected void c() {
        if (ap) {
            aq++;
            if (aq == 8) {
                aq = 0;
                ap = false;
            }
        } else {
            aq = 0;
        }
        aO = (float) aq / 8F;
    }

    public void D() {
        if (l.k == 0 && aP < 20 && (W % 20) * 4 == 0) {
            a(1);
        }
        ak.c();
        an = ao;
        super.D();
        float f1 = MathHelper.a(s * s + u * u);
        float f2 = (float) Math.atan(-t * 0.20000000298023224D) * 15F;

        if (f1 > 0.1F) {
            f1 = 0.1F;
        }
        if (!A || aP <= 0) {
            f1 = 0.0F;
        }
        if (A || aP <= 0) {
            f2 = 0.0F;
        }
        ao += (f1 - ao) * 0.4F;
        aX += (f2 - aX) * 0.8F;
        if (aP > 0) {
            List list = l.b(this, z.b(1.0D, 0.0D, 1.0D));

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    h((Entity) list.get(i));
                }

            }
        }
    }

    private void h(Entity entity) {
        entity.a(this);
    }

    public void f(Entity entity) {
        a(0.2F, 0.2F);
        a(p, q, r);
        t = 0.10000000149011612D;
        if (ar.equals("Notch")) {
            a(new ItemStack(Item.h, 1), true);
        }
        ak.f();
        if (entity != null) {
            s = -MathHelper.b(((aT + v) * 3.141593F) / 180F) * 0.1F;
            u = -MathHelper.a(((aT + v) * 3.141593F) / 180F) * 0.1F;
        } else {
            s = u = 0.0D;
        }
        G = 0.1F;
    }

    public void b(Entity entity, int i) {
        am += i;
    }

    public void a(ItemStack itemstack) {
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
            float f3 = V.nextFloat() * 0.5F;
            float f5 = V.nextFloat() * 3.141593F * 2.0F;

            entityitem.s = -MathHelper.a(f5) * f3;
            entityitem.u = MathHelper.b(f5) * f3;
            entityitem.t = 0.20000000298023224D;
        } else {
            float f2 = 0.3F;

            entityitem.s = -MathHelper.a((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f2;
            entityitem.u = MathHelper.b((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f2;
            entityitem.t = -MathHelper.a((w / 180F) * 3.141593F) * f2 + 0.1F;
            f2 = 0.02F;
            float f4 = V.nextFloat() * 3.141593F * 2.0F;

            f2 *= V.nextFloat();
            entityitem.s += Math.cos(f4) * (double) f2;
            entityitem.t += (V.nextFloat() - V.nextFloat()) * 0.1F;
            entityitem.u += Math.sin(f4) * (double) f2;
        }
        a(entityitem);
    }

    protected void a(EntityItem entityitem) {
        l.a(entityitem);
    }

    public float a(Block block) {
        float f1 = ak.a(block);

        if (a(Material.f)) {
            f1 /= 5F;
        }
        if (!A) {
            f1 /= 5F;
        }
        return f1;
    }

    public boolean b(Block block) {
        return ak.b(block);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Inventory");

        ak.b(nbttaglist);
        as = nbttagcompound.d("Dimension");
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Inventory", ak.a(new NBTTagList()));
        nbttagcompound.a("Dimension", as);
    }

    public void a(IInventory iinventory) {}

    public void F() {}

    public void c(Entity entity, int i) {}

    protected float s() {
        return 0.12F;
    }

    public boolean a(Entity entity, int i) {
        bf = 0;
        if (aP <= 0) {
            return false;
        }
        if ((float) ab > (float) au / 2.0F) {
            if (aQ - i >= aP) {
                return false;
            }
            aP = aQ - i;
        } else {
            aQ = aP;
            ab = au;
            aP -= i;
            aR = aS = 10;
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
        int j = 25 - ak.e();
        int k = i * j + a;

        ak.b(i);
        i = k / 25;
        a = k % 25;
        if (i == 0) {
            return false;
        } else {
            return super.a(entity, i);
        }
    }

    public void a(TileEntityFurnace tileentityfurnace) {}

    public void a(TileEntitySign tileentitysign) {}

    public ItemStack G() {
        return ak.b();
    }

    public void H() {
        ak.a(ak.d, null);
    }

    public double A() {
        return (double) (G - 0.5F);
    }

    public void E() {
        aq = -1;
        ap = true;
    }
}

