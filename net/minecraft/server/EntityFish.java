package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityFish extends Entity {

    private int d;
    private int e;
    private int f;
    private int ai;
    private boolean aj;
    public int a;
    public EntityPlayer b;
    private int ak;
    private int al;
    private int am;
    public Entity c;

    public EntityFish(World world) {
        super(world);
        d = -1;
        e = -1;
        f = -1;
        ai = 0;
        aj = false;
        a = 0;
        al = 0;
        am = 0;
        c = null;
        a(0.25F, 0.25F);
    }

    public void b_() {
        super.b_();
        ItemStack itemstack = b.G();

        if (b.F || !b.w() || itemstack == null || itemstack.a() != Item.aP || b(b) > 1024D) {
            l();
            b.at = null;
            return;
        }
        if (c != null) {
            if (c.F) {
                c = null;
            } else {
                p = c.p;
                q = c.z.b + (double) c.I * 0.80000000000000004D;
                r = c.r;
                return;
            }
        }
        if (a > 0) {
            a--;
        }
        if (aj) {
            int i = this.l.a(d, e, f);

            if (i != ai) {
                aj = false;
                s *= V.nextFloat() * 0.2F;
                t *= V.nextFloat() * 0.2F;
                u *= V.nextFloat() * 0.2F;
                ak = 0;
                al = 0;
            } else {
                ak++;
                if (ak == 1200) {
                    l();
                }
                return;
            }
        } else {
            al++;
        }
        Vec3D vec3d = Vec3D.b(p, q, r);
        Vec3D vec3d1 = Vec3D.b(p + s, q + t, r + u);
        MovingObjectPosition movingobjectposition = this.l.a(vec3d, vec3d1);

        vec3d = Vec3D.b(p, q, r);
        vec3d1 = Vec3D.b(p + s, q + t, r + u);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.b(movingobjectposition.f.a, movingobjectposition.f.b, movingobjectposition.f.c);
        }
        Entity entity = null;
        List list = this.l.b(this, z.a(s, t, u).b(1.0D, 1.0D, 1.0D));
        double d1 = 0.0D;

        for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity) list.get(j);

            if (!entity1.c_() || entity1 == b && al < 5) {
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
                if (movingobjectposition.g.a(b, 0)) {
                    c = movingobjectposition.g;
                }
            } else {
                aj = true;
            }
        }
        if (aj) {
            return;
        }
        c(s, t, u);
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
        float f2 = 0.92F;

        if (A || B) {
            f2 = 0.5F;
        }
        int k = 5;
        double d4 = 0.0D;

        for (int l = 0; l < k; l++) {
            double d5 = ((z.b + ((z.e - z.b) * (double) (l + 0)) / (double) k) - 0.125D) + 0.125D;
            double d6 = ((z.b + ((z.e - z.b) * (double) (l + 1)) / (double) k) - 0.125D) + 0.125D;
            AxisAlignedBB axisalignedbb1 = AxisAlignedBB.b(z.a, d5, z.c, z.d, d6, z.f);

            if (this.l.b(axisalignedbb1, Material.f)) {
                d4 += 1.0D / (double) k;
            }
        }

        if (d4 > 0.0D) {
            if (am > 0) {
                am--;
            } else if (V.nextInt(500) == 0) {
                am = V.nextInt(30) + 10;
                t -= 0.20000000298023224D;
                this.l.a(this, "random.splash", 0.25F, 1.0F + (V.nextFloat() - V.nextFloat()) * 0.4F);
                float f4 = MathHelper.b(z.b);

                for (int i1 = 0; (float) i1 < 1.0F + H * 20F; i1++) {
                    float f5 = (V.nextFloat() * 2.0F - 1.0F) * H;
                    float f7 = (V.nextFloat() * 2.0F - 1.0F) * H;

                    this.l.a("bubble", p + (double) f5, f4 + 1.0F, r + (double) f7, s, t - (double) (V.nextFloat() * 0.2F), u);
                }

                for (int j1 = 0; (float) j1 < 1.0F + H * 20F; j1++) {
                    float f6 = (V.nextFloat() * 2.0F - 1.0F) * H;
                    float f8 = (V.nextFloat() * 2.0F - 1.0F) * H;

                    this.l.a("splash", p + (double) f6, f4 + 1.0F, r + (double) f8, s, t, u);
                }

            }
        }
        if (am > 0) {
            t -= (double) (V.nextFloat() * V.nextFloat() * V.nextFloat()) * 0.20000000000000001D;
        }
        double d3 = d4 * 2D - 1.0D;

        t += 0.039999999105930328D * d3;
        if (d4 > 0.0D) {
            f2 = (float) ((double) f2 * 0.90000000000000002D);
            t *= 0.80000000000000004D;
        }
        s *= f2;
        t *= f2;
        u *= f2;
        a(p, q, r);
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("xTile", (short) d);
        nbttagcompound.a("yTile", (short) e);
        nbttagcompound.a("zTile", (short) f);
        nbttagcompound.a("inTile", (byte) ai);
        nbttagcompound.a("shake", (byte) a);
        nbttagcompound.a("inGround", (byte) (aj ? 1 : 0));
    }

    public void b(NBTTagCompound nbttagcompound) {
        d = nbttagcompound.c("xTile");
        e = nbttagcompound.c("yTile");
        f = nbttagcompound.c("zTile");
        ai = nbttagcompound.b("inTile") & 0xff;
        a = nbttagcompound.b("shake") & 0xff;
        aj = nbttagcompound.b("inGround") == 1;
    }
}

