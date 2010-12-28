package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityFireball extends Entity {

    private int e;
    private int f;
    private int ai;
    private int aj;
    private boolean ak;
    public int a;
    private EntityLiving al;
    private int am;
    private int an;
    public double b;
    public double c;
    public double d;

    public EntityFireball(World world) {
        super(world);
        e = -1;
        f = -1;
        ai = -1;
        aj = 0;
        ak = false;
        a = 0;
        an = 0;
        a(1.0F, 1.0F);
    }

    public EntityFireball(World world, EntityLiving entityliving, double d1, double d2, double d3) {
        super(world);
        e = -1;
        f = -1;
        ai = -1;
        aj = 0;
        ak = false;
        a = 0;
        an = 0;
        al = entityliving;
        a(1.0F, 1.0F);
        c(entityliving.p, entityliving.q, entityliving.r, entityliving.v, entityliving.w);
        a(p, q, r);
        G = 0.0F;
        s = t = u = 0.0D;
        d1 += V.nextGaussian() * 0.40000000000000002D;
        d2 += V.nextGaussian() * 0.40000000000000002D;
        d3 += V.nextGaussian() * 0.40000000000000002D;
        double d4 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        b = (d1 / d4) * 0.10000000000000001D;
        c = (d2 / d4) * 0.10000000000000001D;
        d = (d3 / d4) * 0.10000000000000001D;
    }

    public void b_() {
        super.b_();
        Y = 10;
        if (a > 0) {
            a--;
        }
        if (ak) {
            int i = l.a(e, f, ai);

            if (i != aj) {
                ak = false;
                s *= V.nextFloat() * 0.2F;
                t *= V.nextFloat() * 0.2F;
                u *= V.nextFloat() * 0.2F;
                am = 0;
                an = 0;
            } else {
                am++;
                if (am == 1200) {
                    l();
                }
                return;
            }
        } else {
            an++;
        }
        Vec3D vec3d = Vec3D.b(p, q, r);
        Vec3D vec3d1 = Vec3D.b(p + s, q + t, r + u);
        MovingObjectPosition movingobjectposition = l.a(vec3d, vec3d1);

        vec3d = Vec3D.b(p, q, r);
        vec3d1 = Vec3D.b(p + s, q + t, r + u);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        Entity entity = null;
        List list = l.b(this, z.a(s, t, u).b(1.0D, 1.0D, 1.0D));
        double d1 = 0.0D;

        for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity) list.get(j);

            if (!entity1.c_() || entity1 == al && an < 25) {
                continue;
            }
            float f3 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.z.b(f3, f3, f3);
            MovingObjectPosition movingobjectposition1 = axisalignedbb.a(vec3d, vec3d1);

            if (movingobjectposition1 == null) {
                continue;
            }
            double d2 = vec3d.a(movingobjectposition1.f);

            if (d2 < d1 || d1 == 0.0D) {
                entity = entity1;
                d1 = d2;
            }
        }

        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.g != null) {
                if (!movingobjectposition.g.a(al, 0)) {
                    ;
                }
            }
            Explosion explosion = new Explosion();

            explosion.a = true;
            explosion.a(l, this, p, q, r, 1.0F);
            l();
        }
        p += s;
        q += t;
        r += u;
        float f1 = MathHelper.a(s * s + u * u);

        v = (float) ((Math.atan2(s, u) * 180D) / 3.1415927410125732D);
        for (w = (float) ((Math.atan2(t, f1) * 180D) / 3.1415927410125732D); w - y < -180F; y -= 360F) {
            ;
        }
        for (; w - y >= 180F; y += 360F) {
            ;
        }
        for (; v - x < -180F; x -= 360F) {
            ;
        }
        for (; v - x >= 180F; x += 360F) {
            ;
        }
        w = y + (w - y) * 0.2F;
        v = x + (v - x) * 0.2F;
        float f2 = 0.95F;
        float f4 = 0.006F;

        if (r()) {
            for (int k = 0; k < 4; k++) {
                float f5 = 0.25F;

                l.a("bubble", p - s * (double) f5, q - t * (double) f5, r - u * (double) f5, s, t, u);
            }

            f2 = 0.8F;
        }
        s += b;
        t += c;
        u += d;
        s *= f2;
        t *= f2;
        u *= f2;
        l.a("smoke", p, q + 0.5D, r, 0.0D, 0.0D, 0.0D);
        a(p, q, r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) e);
        nbttagcompound.a("yTile", (short) f);
        nbttagcompound.a("zTile", (short) ai);
        nbttagcompound.a("inTile", (byte) aj);
        nbttagcompound.a("shake", (byte) a);
        nbttagcompound.a("inGround", (byte) (ak ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        e = nbttagcompound.c("xTile");
        f = nbttagcompound.c("yTile");
        ai = nbttagcompound.c("zTile");
        aj = nbttagcompound.b("inTile") & 0xff;
        a = nbttagcompound.b("shake") & 0xff;
        ak = nbttagcompound.b("inGround") == 1;
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity entity, int i) {
        if (entity != null) {
            Vec3D vec3d = entity.B();

            if (vec3d != null) {
                s = vec3d.a;
                t = vec3d.b;
                u = vec3d.c;
                b = s * 0.10000000000000001D;
                c = t * 0.10000000000000001D;
                d = u * 0.10000000000000001D;
            }
            return true;
        } else {
            return false;
        }
    }
}

