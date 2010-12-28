package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityGhast extends EntityFlying
        implements IMobs {

    public int a;
    public double b;
    public double c;
    public double d;
    private Entity aj;
    private int ak;
    public int e;
    public int f;

    public EntityGhast(World world) {
        super(world);
        a = 0;
        aj = null;
        ak = 0;
        e = 0;
        f = 0;
        aG = "/mob/ghast.png";
        a(4F, 4F);
        ae = true;
    }

    protected void c() {
        if (l.k == 0) {
            l();
        }
        e = f;
        double d1 = b - p;
        double d2 = c - q;
        double d3 = d - r;
        double d4 = MathHelper.a(d1 * d1 + d2 * d2 + d3 * d3);

        if (d4 < 1.0D || d4 > 60D) {
            b = p + (double) ((W.nextFloat() * 2.0F - 1.0F) * 16F);
            c = q + (double) ((W.nextFloat() * 2.0F - 1.0F) * 16F);
            d = r + (double) ((W.nextFloat() * 2.0F - 1.0F) * 16F);
        }
        if (a-- <= 0) {
            a += W.nextInt(5) + 2;
            if (a(b, c, d, d4)) {
                s += (d1 / d4) * 0.10000000000000001D;
                t += (d2 / d4) * 0.10000000000000001D;
                u += (d3 / d4) * 0.10000000000000001D;
            } else {
                b = p;
                c = q;
                d = r;
            }
        }
        if (aj != null && aj.G) {
            aj = null;
        }
        if (aj == null || ak-- <= 0) {
            aj = l.a(this, 100D);
            if (aj != null) {
                ak = 20;
            }
        }
        double d5 = 64D;

        if (aj != null && aj.b(this) < d5 * d5) {
            double d6 = aj.p - p;
            double d7 = (aj.z.b + (double) (aj.J / 2.0F)) - (q + (double) (J / 2.0F));
            double d8 = aj.r - r;

            az = v = (-(float) Math.atan2(d6, d8) * 180F) / 3.141593F;
            if (i(aj)) {
                if (f == 10) {
                    l.a(this, "mob.ghast.charge", h(), (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
                }
                f++;
                if (f == 20) {
                    l.a(this, "mob.ghast.fireball", h(), (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
                    EntityFireball entityfireball = new EntityFireball(l, this, d6, d7, d8);
                    double d9 = 4D;
                    Vec3D vec3d = c(1.0F);

                    entityfireball.p = p + vec3d.a * d9;
                    entityfireball.q = q + (double) (J / 2.0F) + 0.5D;
                    entityfireball.r = r + vec3d.c * d9;
                    l.a(entityfireball);
                    f = -40;
                }
            } else if (f > 0) {
                f--;
            }
        } else {
            az = v = (-(float) Math.atan2(s, u) * 180F) / 3.141593F;
            if (f > 0) {
                f--;
            }
        }
        aG = f <= 10 ? "/mob/ghast.png" : "/mob/ghast_fire.png";
    }

    private boolean a(double d1, double d2, double d3, double d4) {
        double d5 = (b - p) / d4;
        double d6 = (c - q) / d4;
        double d7 = (d - r) / d4;
        AxisAlignedBB axisalignedbb = z.b();

        for (int j = 1; (double) j < d4; j++) {
            axisalignedbb.d(d5, d6, d7);
            if (l.a(this, axisalignedbb).size() > 0) {
                return false;
            }
        }

        return true;
    }

    protected String d() {
        return "mob.ghast.moan";
    }

    protected String e() {
        return "mob.ghast.scream";
    }

    protected String f() {
        return "mob.ghast.death";
    }

    protected int g() {
        return Item.K.aW;
    }

    protected float h() {
        return 10F;
    }

    public boolean a() {
        return W.nextInt(20) == 0 && super.a() && l.k > 0;
    }

    public int i() {
        return 1;
    }
}

