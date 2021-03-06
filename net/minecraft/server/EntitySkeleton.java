package net.minecraft.server;


import java.util.Random;


public class EntitySkeleton extends EntityMobs {

    private static final ItemStack a;

    public EntitySkeleton(World world) {
        super(world);
        aQ = "/mob/skeleton.png";
    }

    protected String d() {
        return "mob.skeleton";
    }

    protected String e() {
        return "mob.skeletonhurt";
    }

    protected String f() {
        return "mob.skeletonhurt";
    }

    public void G() {
        if (l.b()) {
            float f1 = b(1.0F);

            if (f1 > 0.5F && l.h(MathHelper.b(p), MathHelper.b(q), MathHelper.b(r)) && W.nextFloat() * 30F < (f1 - 0.4F) * 2.0F) {
                Z = 300;
            }
        }
        super.G();
    }

    protected void a(Entity entity, float f1) {
        if (f1 < 10F) {
            double d1 = entity.p - p;
            double d2 = entity.r - r;

            if (bg == 0) {
                EntityArrow entityarrow = new EntityArrow(l, this);

                entityarrow.q += 1.3999999761581421D;
                double d3 = entity.q - 0.20000000298023224D - entityarrow.q;
                float f2 = MathHelper.a(d1 * d1 + d2 * d2) * 0.2F;

                l.a(this, "random.bow", 1.0F, 1.0F / (W.nextFloat() * 0.4F + 0.8F));
                l.a(entityarrow);
                entityarrow.a(d1, d3 + (double) f2, d2, 0.6F, 12F);
                bg = 30;
            }
            v = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            ak = true;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected int g() {
        return Item.j.aW;
    }

    static {
        a = new ItemStack(Item.i, 1);
    }
}

