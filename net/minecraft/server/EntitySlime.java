package net.minecraft.server;


import java.util.Random;


public class EntitySlime extends EntityLiving
        implements IMobs {

    public float a;
    public float b;
    private int d;
    public int c;

    public EntitySlime(World world) {
        super(world);
        d = 0;
        c = 1;
        aG = "/mob/slime.png";
        c = 1 << W.nextInt(3);
        H = 0.0F;
        d = W.nextInt(20) + 10;
        d(c);
    }

    public void d(int i) {
        c = i;
        a(0.6F * (float) i, 0.6F * (float) i);
        aQ = i * i;
        a(p, q, r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Size", c - 1);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        c = nbttagcompound.d("Size") + 1;
    }

    public void b_() {
        b = a;
        boolean flag = A;

        super.b_();
        if (A && !flag) {
            for (int i = 0; i < c * 8; i++) {
                float f1 = W.nextFloat() * 3.141593F * 2.0F;
                float f2 = W.nextFloat() * 0.5F + 0.5F;
                float f3 = MathHelper.a(f1) * (float) c * 0.5F * f2;
                float f4 = MathHelper.b(f1) * (float) c * 0.5F * f2;

                l.a("slime", p + (double) f3, z.b, r + (double) f4, 0.0D, 0.0D, 0.0D);
            }

            if (c > 2) {
                l.a(this, "mob.slime", h(), ((W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }
            a = -0.5F;
        }
        a = a * 0.6F;
    }

    protected void c() {
        EntityPlayer entityplayer = l.a(this, 16D);

        if (entityplayer != null) {
            b(entityplayer, 10F);
        }
        if (A && d-- <= 0) {
            d = W.nextInt(20) + 10;
            if (entityplayer != null) {
                d /= 3;
            }
            br = true;
            if (c > 1) {
                l.a(this, "mob.slime", h(), ((W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }
            a = 1.0F;
            bo = 1.0F - W.nextFloat() * 2.0F;
            bp = 1 * c;
        } else {
            br = false;
            if (A) {
                bo = bp = 0.0F;
            }
        }
    }

    public void l() {
        if (c > 1 && aQ == 0) {
            for (int i = 0; i < 4; i++) {
                float f1 = (((float) (i % 2) - 0.5F) * (float) c) / 4F;
                float f2 = (((float) (i / 2) - 0.5F) * (float) c) / 4F;
                EntitySlime entityslime = new EntitySlime(l);

                entityslime.d(c / 2);
                entityslime.c(p + (double) f1, q + 0.5D, r + (double) f2, W.nextFloat() * 360F, 0.0F);
                l.a(entityslime);
            }

        }
        super.l();
    }

    public void b(EntityPlayer entityplayer) {
        if (c > 1 && i(entityplayer) && (double) a(entityplayer) < 0.59999999999999998D * (double) c && entityplayer.a(this, c)) {
            l.a(this, "mob.slimeattack", 1.0F, (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected String e() {
        return "mob.slime";
    }

    protected String f() {
        return "mob.slime";
    }

    protected int g() {
        if (c == 1) {
            return Item.aK.aW;
        } else {
            return 0;
        }
    }

    public boolean a() {
        Chunk chunk = l.b(MathHelper.b(p), MathHelper.b(r));

        return (c == 1 || l.k > 0) && W.nextInt(10) == 0 && chunk.a(0x3ad8025fL).nextInt(10) == 0 && q < 16D;
    }

    protected float h() {
        return 0.6F;
    }
}

