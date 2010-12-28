package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityFireball extends Entity {

    private int e;
    private int f;
    private int aj;
    private int ak;
    private boolean al;
    public int a;
    private EntityLiving am;
    private int an;
    private int ao;
    public double b;
    public double c;
    public double d;

    public EntityFireball(World world) {
        super(world);
        e = -1;
        f = -1;
        aj = -1;
        ak = 0;
        al = false;
        a = 0;
        ao = 0;
        a(1.0F, 1.0F);
    }

    public EntityFireball(World world, EntityLiving entityliving, double d1, double d2, double d3) {
        super(world);
        e = -1;
        f = -1;
        aj = -1;
        ak = 0;
        al = false;
        a = 0;
        ao = 0;
        am = entityliving;
        a(1.0F, 1.0F);
        c(entityliving.p, entityliving.q, entityliving.r, entityliving.v, entityliving.w);
        a(p, q, r);
        H = 0.0F;
        s = t = u = 0.0D;
        d1 += W.nextGaussian() * 0.40000000000000002D;
        d2 += W.nextGaussian() * 0.40000000000000002D;
        d3 += W.nextGaussian() * 0.40000000000000002D;
        double d4 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        b = (d1 / d4) * 0.10000000000000001D;
        c = (d2 / d4) * 0.10000000000000001D;
        d = (d3 / d4) * 0.10000000000000001D;
    }

    public void b_() {
        super.b_();
        Z = 10;
        if (a > 0) {
            a--;
        }
        if (al) {
            int i = l.a(e, f, aj);

            if (i != ak) {
                al = false;
                s *= W.nextFloat() * 0.2F;
                t *= W.nextFloat() * 0.2F;
                u *= W.nextFloat() * 0.2F;
                an = 0;
                ao = 0;
            } else {
                an++;
                if (an == 1200) {
                    l();
                }
                return;
            }
        } else {
            ao++;
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

            if (!entity1.c_() || entity1 == am && ao < 25) {
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
                if (!movingobjectposition.g.a(am, 0)) {
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

        if (r()) {
            for (int k = 0; k < 4; k++) {
                float f4 = 0.25F;

                l.a("bubble", p - s * (double) f4, q - t * (double) f4, r - u * (double) f4, s, t, u);
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
        nbttagcompound.a("zTile", (short) aj);
        nbttagcompound.a("inTile", (byte) ak);
        nbttagcompound.a("shake", (byte) a);
        nbttagcompound.a("inGround", (byte) (al ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        e = nbttagcompound.c("xTile");
        f = nbttagcompound.c("yTile");
        aj = nbttagcompound.c("zTile");
        ak = nbttagcompound.b("inTile") & 0xff;
        a = nbttagcompound.b("shake") & 0xff;
        al = nbttagcompound.b("inGround") == 1;
    }

    public boolean c_() {
        return true;
    }

    public boolean a(Entity entity, int i) {
        u();
        if (entity != null) {
            Vec3D vec3d = entity.C();

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

