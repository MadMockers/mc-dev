package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityPlayer extends EntityLiving {

    public InventoryPlayer am;
    public byte an;
    public int ao;
    public float ap;
    public float aq;
    public boolean ar;
    public int as;
    public String at;
    public int au;
    private int a;
    public EntityFish av;

    public EntityPlayer(World world) {
        super(world);
        am = new InventoryPlayer(this);
        an = 0;
        ao = 0;
        ar = false;
        as = 0;
        a = 0;
        av = null;
        H = 1.62F;
        c((double) world.m + 0.5D, world.n + 1, (double) world.o + 0.5D, 0.0F, 0.0F);
        aR = 20;
        aK = "humanoid";
        aJ = 180F;
        Y = 20;
        aH = "/mob/char.png";
    }

    public void z() {
        super.z();
        ap = aq;
        aq = 0.0F;
    }

    protected void c() {
        if (ar) {
            as++;
            if (as == 8) {
                as = 0;
                ar = false;
            }
        } else {
            as = 0;
        }
        aQ = (float) as / 8F;
    }

    public void E() {
        if (l.k == 0 && aR < 20 && (X % 20) * 4 == 0) {
            a(1);
        }
        am.c();
        ap = aq;
        super.E();
        float f1 = MathHelper.a(s * s + u * u);
        float f2 = (float) Math.atan(-t * 0.20000000298023224D) * 15F;

        if (f1 > 0.1F) {
            f1 = 0.1F;
        }
        if (!A || aR <= 0) {
            f1 = 0.0F;
        }
        if (A || aR <= 0) {
            f2 = 0.0F;
        }
        aq += (f1 - aq) * 0.4F;
        aZ += (f2 - aZ) * 0.8F;
        if (aR > 0) {
            List list = l.b(this, z.b(1.0D, 0.0D, 1.0D));

            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    j((Entity) list.get(i));
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
        if (at.equals("Notch")) {
            a(new ItemStack(Item.h, 1), true);
        }
        am.f();
        if (entity != null) {
            s = -MathHelper.b(((aV + v) * 3.141593F) / 180F) * 0.1F;
            u = -MathHelper.a(((aV + v) * 3.141593F) / 180F) * 0.1F;
        } else {
            s = u = 0.0D;
        }
        H = 0.1F;
    }

    public void b(Entity entity, int i) {
        ao += i;
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
        float f1 = am.a(block);

        if (a(Material.f)) {
            f1 /= 5F;
        }
        if (!A) {
            f1 /= 5F;
        }
        return f1;
    }

    public boolean b(Block block) {
        return am.b(block);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Inventory");

        am.b(nbttaglist);
        au = nbttagcompound.d("Dimension");
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Inventory", am.a(new NBTTagList()));
        nbttagcompound.a("Dimension", au);
    }

    public void a(IInventory iinventory) {}

    public void G() {}

    public void c(Entity entity, int i) {}

    public float s() {
        return 0.12F;
    }

    public boolean a(Entity entity, int i) {
        bo = 0;
        if (aR <= 0) {
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

    protected void c(int i) {
        int k = 25 - am.e();
        int l = i * k + a;

        am.c(i);
        i = l / 25;
        a = l % 25;
        super.c(i);
    }

    public void a(TileEntityFurnace tileentityfurnace) {}

    public void a(TileEntitySign tileentitysign) {}

    public void g(Entity entity) {
        entity.a(this);
    }

    public ItemStack H() {
        return am.b();
    }

    public void I() {
        am.a(am.d, null);
    }

    public double B() {
        return (double) (H - 0.5F);
    }

    public void F() {
        as = -1;
        ar = true;
    }

    public void h(Entity entity) {
        int i = am.a(entity);

        if (i > 0) {
            entity.a(this, i);
            ItemStack itemstack = H();

            if (itemstack != null && (entity instanceof EntityLiving)) {
                itemstack.a((EntityLiving) entity);
                if (itemstack.a <= 0) {
                    itemstack.a(this);
                    I();
                }
            }
        }
    }
}

