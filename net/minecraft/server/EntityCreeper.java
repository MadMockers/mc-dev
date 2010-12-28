package net.minecraft.server;


import java.util.Random;


public class EntityCreeper extends EntityMobs {

    int a;
    int b;
    int c;
    int d;
    int e;

    public EntityCreeper(World world) {
        super(world);
        c = 30;
        d = -1;
        e = -1;
        aH = "/mob/creeper.png";
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public void b_() {
        b = a;
        if (l.z) {
            a += d;
            if (a < 0) {
                a = 0;
            }
            if (a >= c) {
                a = c;
            }
        }
        super.b_();
    }

    protected void c() {
        if (e != d) {
            e = d;
            if (d > 0) {
                l.a(this, (byte) 4);
            } else {
                l.a(this, (byte) 5);
            }
        }
        b = a;
        if (l.z) {
            super.c();
        } else {
            if (a > 0 && d < 0) {
                a--;
            }
            if (d >= 0) {
                d = 2;
            }
            super.c();
            if (d != 1) {
                d = -1;
            }
        }
    }

    protected String e() {
        return "mob.creeper";
    }

    protected String f() {
        return "mob.creeperdeath";
    }

    public void f(Entity entity) {
        super.f(entity);
        if (entity instanceof EntitySkeleton) {
            a(Item.aU.aW + W.nextInt(2), 1);
        }
    }

    protected void a(Entity entity, float f1) {
        if (d <= 0 && f1 < 3F || d > 0 && f1 < 7F) {
            if (a == 0) {
                l.a(this, "random.fuse", 1.0F, 0.5F);
            }
            d = 1;
            a++;
            if (a == c) {
                l.a(this, p, q, r, 3F);
                l();
            }
            ak = true;
        }
    }

    protected int g() {
        return Item.K.aW;
    }
}

