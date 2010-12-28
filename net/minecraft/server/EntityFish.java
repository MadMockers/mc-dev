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
    private int an;
    private double ao;
    private double ap;
    private double aq;
    private double ar;
    private double as;

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

    public EntityFish(World world, EntityPlayer entityplayer) {
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
        b = entityplayer;
        b.at = this;
        a(0.25F, 0.25F);
        c(entityplayer.p, (entityplayer.q + 1.6200000000000001D) - (double) entityplayer.G, entityplayer.r, entityplayer.v, entityplayer.w);
        p -= MathHelper.b((v / 180F) * 3.141593F) * 0.16F;
        q -= 0.10000000149011612D;
        r -= MathHelper.a((v / 180F) * 3.141593F) * 0.16F;
        a(p, q, r);
        G = 0.0F;
        float f1 = 0.4F;

        s = -MathHelper.a((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f1;
        u = MathHelper.b((v / 180F) * 3.141593F) * MathHelper.b((w / 180F) * 3.141593F) * f1;
        t = -MathHelper.a((w / 180F) * 3.141593F) * f1;
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
        ak = 0;
    }

    public void b_() {
        super.b_();
        if (an > 0) {
            double d1 = p + (ao - p) / (double) an;
            double d2 = q + (ap - q) / (double) an;
            double d3 = r + (aq - r) / (double) an;
            double d4;

            for (d4 = ar - (double) v; d4 < -180D; d4 += 360D) {
                ;
            }
            for (; d4 >= 180D; d4 -= 360D) {
                ;
            }
            v += d4 / (double) an;
            w += (as - (double) w) / (double) an;
            an--;
            a(d1, d2, d3);
            b(v, w);
            return;
        }
        if (!this.l.z) {
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
        double d5 = 0.0D;

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
            double d6 = vec3d.a(movingobjectposition1.f);

            if (d6 < d5 || d5 == 0.0D) {
                entity = entity1;
                d5 = d6;
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
        double d8 = 0.0D;

        for (int l = 0; l < k; l++) {
            double d9 = ((z.b + ((z.e - z.b) * (double) (l + 0)) / (double) k) - 0.125D) + 0.125D;
            double d10 = ((z.b + ((z.e - z.b) * (double) (l + 1)) / (double) k) - 0.125D) + 0.125D;
            AxisAlignedBB axisalignedbb1 = AxisAlignedBB.b(z.a, d9, z.c, z.d, d10, z.f);

            if (this.l.b(axisalignedbb1, Material.f)) {
                d8 += 1.0D / (double) k;
            }
        }

        if (d8 > 0.0D) {
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
        double d7 = d8 * 2D - 1.0D;

        t += 0.039999999105930328D * d7;
        if (d8 > 0.0D) {
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

    public int c() {
        byte byte0 = 0;

        if (c != null) {
            double d1 = b.p - p;
            double d2 = b.q - q;
            double d3 = b.r - r;
            double d4 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 0.10000000000000001D;

            c.s += d1 * d5;
            c.t += d2 * d5 + (double) MathHelper.a(d4) * 0.080000000000000002D;
            c.u += d3 * d5;
            byte0 = 3;
        } else if (am > 0) {
            EntityItem entityitem = new EntityItem(l, p, q, r, new ItemStack(Item.aS.aW));
            double d6 = b.p - p;
            double d7 = b.q - q;
            double d8 = b.r - r;
            double d9 = MathHelper.a(d6 * d6 + d7 * d7 + d8 * d8);
            double d10 = 0.10000000000000001D;

            entityitem.s = d6 * d10;
            entityitem.t = d7 * d10 + (double) MathHelper.a(d9) * 0.080000000000000002D;
            entityitem.u = d8 * d10;
            l.a(entityitem);
            byte0 = 1;
        }
        if (aj) {
            byte0 = 2;
        }
        l();
        b.at = null;
        return byte0;
    }
}

