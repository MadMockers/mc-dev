package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityBoat extends Entity {

    public int a;
    public int b;
    public int c;

    public EntityBoat(World world) {
        super(world);
        a = 0;
        b = 0;
        c = 1;
        i = true;
        a(1.5F, 0.6F);
        G = I / 2.0F;
        L = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.z;
    }

    public AxisAlignedBB q() {
        return z;
    }

    public boolean u() {
        return true;
    }

    public double j() {
        return (double) I * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        c = -c;
        b = 10;
        a += i * 10;
        if (a > 40) {
            for (int k = 0; k < 3; k++) {
                a(Block.y.bi, 1, 0.0F);
            }

            for (int l = 0; l < 2; l++) {
                a(Item.B.aW, 1, 0.0F);
            }

            l();
        }
        return true;
    }

    public boolean c_() {
        return !F;
    }

    public void b_() {
        super.b_();
        if (b > 0) {
            b--;
        }
        if (a > 0) {
            a--;
        }
        m = p;
        n = q;
        o = r;
        int i = 5;
        double d1 = 0.0D;

        for (int k = 0; k < i; k++) {
            double d2 = (z.b + ((z.e - z.b) * (double) (k + 0)) / (double) i) - 0.125D;
            double d3 = (z.b + ((z.e - z.b) * (double) (k + 1)) / (double) i) - 0.125D;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.b(z.a, d2, z.c, z.d, d3, z.f);

            if (this.l.b(axisalignedbb, Material.f)) {
                d1 += 1.0D / (double) i;
            }
        }

        double d4 = d1 * 2D - 1.0D;

        t += 0.039999999105930328D * d4;
        if (j != null) {
            s += j.s * 0.20000000000000001D;
            u += j.u * 0.20000000000000001D;
        }
        double d5 = 0.40000000000000002D;

        if (s < -d5) {
            s = -d5;
        }
        if (s > d5) {
            s = d5;
        }
        if (u < -d5) {
            u = -d5;
        }
        if (u > d5) {
            u = d5;
        }
        if (A) {
            s *= 0.5D;
            t *= 0.5D;
            u *= 0.5D;
        }
        c(s, t, u);
        double d6 = Math.sqrt(s * s + u * u);

        if (d6 > 0.14999999999999999D) {
            double d7 = Math.cos(((double) v * 3.1415926535897931D) / 180D);
            double d9 = Math.sin(((double) v * 3.1415926535897931D) / 180D);

            for (int l = 0; (double) l < 1.0D + d6 * 60D; l++) {
                double d11 = V.nextFloat() * 2.0F - 1.0F;
                double d12 = (double) (V.nextInt(2) * 2 - 1) * 0.69999999999999996D;

                if (V.nextBoolean()) {
                    double d13 = (p - d7 * d11 * 0.80000000000000004D) + d9 * d12;
                    double d15 = r - d9 * d11 * 0.80000000000000004D - d7 * d12;

                    this.l.a("splash", d13, q - 0.125D, d15, s, t, u);
                } else {
                    double d14 = p + d7 + d9 * d11 * 0.69999999999999996D;
                    double d16 = (r + d9) - d7 * d11 * 0.69999999999999996D;

                    this.l.a("splash", d14, q - 0.125D, d16, s, t, u);
                }
            }

        }
        if (B && d6 > 0.14999999999999999D) {
            l();
            for (int i1 = 0; i1 < 3; i1++) {
                a(Block.y.bi, 1, 0.0F);
            }

            for (int j1 = 0; j1 < 2; j1++) {
                a(Item.B.aW, 1, 0.0F);
            }

        } else {
            s *= 0.99000000953674316D;
            t *= 0.94999998807907104D;
            u *= 0.99000000953674316D;
        }
        w = 0.0F;
        double d8 = v;
        double d10 = m - p;
        double d17 = o - r;

        if (d10 * d10 + d17 * d17 > 0.001D) {
            d8 = (float) ((Math.atan2(d17, d10) * 180D) / 3.1415926535897931D);
        }
        double d18;

        for (d18 = d8 - (double) v; d18 >= 180D; d18 -= 360D) {
            ;
        }
        for (; d18 < -180D; d18 += 360D) {
            ;
        }
        if (d18 > 20D) {
            d18 = 20D;
        }
        if (d18 < -20D) {
            d18 = -20D;
        }
        v += d18;
        b(v, w);
        List list = this.l.b(this, z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int k1 = 0; k1 < list.size(); k1++) {
                Entity entity = (Entity) list.get(k1);

                if (entity != j && entity.u() && (entity instanceof EntityBoat)) {
                    entity.c(this);
                }
            }

        }
        if (j != null && j.F) {
            j = null;
        }
    }

    protected void z() {
        double d1 = Math.cos(((double) v * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
        double d2 = Math.sin(((double) v * 3.1415926535897931D) / 180D) * 0.40000000000000002D;

        j.a(p + d1, q + j() + j.A(), r + d2);
    }

    protected void a(NBTTagCompound nbttagcompound) {}

    protected void b(NBTTagCompound nbttagcompound) {}
}

