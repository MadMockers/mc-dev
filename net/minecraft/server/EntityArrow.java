package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityArrow extends Entity {

    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    public int a;
    private EntityLiving ai;
    private int aj;
    private int ak;

    public EntityArrow(World world) {
        super(world);
        b = -1;
        c = -1;
        d = -1;
        e = 0;
        f = false;
        a = 0;
        ak = 0;
        a(0.5F, 0.5F);
    }

    public EntityArrow(World world, EntityLiving entityliving) {
        super(world);
        b = -1;
        c = -1;
        d = -1;
        e = 0;
        f = false;
        a = 0;
        ak = 0;
        ai = entityliving;
        a(0.5F, 0.5F);
        c(entityliving.p, entityliving.q, entityliving.r, entityliving.v, entityliving.w);
        p -= MathHelper.b((v / 180F) * 3.141593F) * 0.16F;
        q -= 0.10000000149011612D;
        r -= MathHelper.a((v / 180F) * 3.141593F) * 0.16F;
        a(p, q, r);
        G = 0.0F;
        s = -MathHelper.a((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F);
        u = MathHelper.b((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F);
        t = -MathHelper.a((w / 180F) * 3.141593F);
        a(s, t, u, 1.5F, 1.0F);
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2) {
        float f3 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        d1 /= f3;
        d2 /= f3;
        d3 /= f3;
        d1 += V.nextGaussian() * 0.0074999998323619366D * (double) f2;
        d2 += V.nextGaussian() * 0.0074999998323619366D * (double) f2;
        d3 += V.nextGaussian() * 0.0074999998323619366D * (double) f2;
        d1 *= f1;
        d2 *= f1;
        d3 *= f1;
        s = d1;
        t = d2;
        u = d3;
        float f4 = MathHelper.a(d1 * d1 + d3 * d3);

        x = v = (float) ((Math.atan2(d1, d3) * 180D) / 3.1415927410125732D);
        y = w = (float) ((Math.atan2(d2, f4) * 180D) / 3.1415927410125732D);
        aj = 0;
    }

    public void b_() {
        super.b_();
        if (a > 0) {
            a--;
        }
        if (f) {
            int i = l.a(b, c, d);

            if (i != e) {
                f = false;
                s *= V.nextFloat() * 0.2F;
                t *= V.nextFloat() * 0.2F;
                u *= V.nextFloat() * 0.2F;
                aj = 0;
                ak = 0;
            } else {
                aj++;
                if (aj == 1200) {
                    l();
                }
                return;
            }
        } else {
            ak++;
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

            if (!entity1.c_() || entity1 == ai && ak < 5) {
                continue;
            }
            float f4 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.z.b(f4, f4, f4);
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
                if (movingobjectposition.g.a(ai, 4)) {
                    l.a(this, "random.drr", 1.0F, 1.2F / (V.nextFloat() * 0.2F + 0.9F));
                    l();
                } else {
                    s *= -0.10000000149011612D;
                    t *= -0.10000000149011612D;
                    u *= -0.10000000149011612D;
                    v += 180F;
                    x += 180F;
                    ak = 0;
                }
            } else {
                b = movingobjectposition.b;
                c = movingobjectposition.c;
                d = movingobjectposition.d;
                e = l.a(b, c, d);
                s = (float) (movingobjectposition.f.a - p);
                t = (float) (movingobjectposition.f.b - q);
                u = (float) (movingobjectposition.f.c - r);
                float f1 = MathHelper.a(s * s + t * t + u * u);

                p -= (s / (double) f1) * 0.05000000074505806D;
                q -= (t / (double) f1) * 0.05000000074505806D;
                r -= (u / (double) f1) * 0.05000000074505806D;
                l.a(this, "random.drr", 1.0F, 1.2F / (V.nextFloat() * 0.2F + 0.9F));
                f = true;
                a = 7;
            }
        }
        p += s;
        q += t;
        r += u;
        float f2 = MathHelper.a(s * s + u * u);

        v = (float) ((Math.atan2(s, u) * 180D) / 3.1415927410125732D);
        for (w = (float) ((Math.atan2(t, f2) * 180D) / 3.1415927410125732D); w - y < -180F; y -= 360F) {
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
        float f3 = 0.99F;
        float f5 = 0.03F;

        if (r()) {
            for (int k = 0; k < 4; k++) {
                float f6 = 0.25F;

                l.a("bubble", p - s * (double) f6, q - t * (double) f6, r - u * (double) f6, s, t, u);
            }

            f3 = 0.8F;
        }
        s *= f3;
        t *= f3;
        u *= f3;
        t -= f5;
        a(p, q, r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) b);
        nbttagcompound.a("yTile", (short) c);
        nbttagcompound.a("zTile", (short) d);
        nbttagcompound.a("inTile", (byte) e);
        nbttagcompound.a("shake", (byte) a);
        nbttagcompound.a("inGround", (byte) (f ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        b = nbttagcompound.c("xTile");
        c = nbttagcompound.c("yTile");
        d = nbttagcompound.c("zTile");
        e = nbttagcompound.b("inTile") & 0xff;
        a = nbttagcompound.b("shake") & 0xff;
        f = nbttagcompound.b("inGround") == 1;
    }

    public void a(EntityPlayer entityplayer) {
        if (f && ai == entityplayer && a <= 0 && entityplayer.ak.a(new ItemStack(Item.j.aW, 1))) {
            l.a(this, "random.pop", 0.2F, ((V.nextFloat() - V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            entityplayer.c(this, 1);
            l();
        }
    }
}

