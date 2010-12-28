package net.minecraft.server;


import java.util.Random;


public class EntitySpider extends EntityMobs {

    public EntitySpider(World world) {
        super(world);
        aF = "/mob/spider.png";
        a(1.4F, 0.9F);
        bl = 0.8F;
    }

    public double j() {
        return (double) I * 0.75D - 0.5D;
    }

    protected Entity k() {
        float f1 = b(1.0F);

        if (f1 < 0.5F) {
            double d1 = 16D;

            return l.a(this, d1);
        } else {
            return null;
        }
    }

    protected String d() {
        return "mob.spider";
    }

    protected String e() {
        return "mob.spider";
    }

    protected String f() {
        return "mob.spiderdeath";
    }

    protected void a(Entity entity, float f1) {
        float f2 = b(1.0F);

        if (f2 > 0.5F && V.nextInt(100) == 0) {
            f = null;
            return;
        }
        if (f1 > 2.0F && f1 < 6F && V.nextInt(10) == 0) {
            if (A) {
                double d1 = entity.p - p;
                double d2 = entity.r - r;
                float f3 = MathHelper.a(d1 * d1 + d2 * d2);

                s = (d1 / (double) f3) * 0.5D * 0.80000001192092896D + s * 0.20000000298023224D;
                u = (d2 / (double) f3) * 0.5D * 0.80000001192092896D + u * 0.20000000298023224D;
                t = 0.40000000596046448D;
            }
        } else {
            super.a(entity, f1);
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.I.aW;
    }
}

