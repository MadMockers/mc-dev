package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityLiving extends Entity {

    public int av;
    public float aw;
    public float ax;
    public float ay;
    public float az;
    public float aA;
    protected float aB;
    protected float aC;
    protected float aD;
    protected float aE;
    protected boolean aF;
    protected String aG;
    protected boolean aH;
    protected float aI;
    protected String aJ;
    protected float aK;
    protected int aL;
    protected float aM;
    public boolean aN;
    public float aO;
    public float aP;
    public int aQ;
    public int aR;
    private int a;
    public int aS;
    public int aT;
    public float aU;
    public int aV;
    public int aW;
    public float aX;
    public float aY;
    protected boolean aZ;
    public int ba;
    public float bb;
    public float bc;
    public float bd;
    public float be;
    protected int bf;
    protected double bg;
    protected double bh;
    protected double bi;
    protected double bj;
    protected double bk;
    float bl;
    protected int bm;
    protected int bn;
    protected float bo;
    protected float bp;
    protected float bq;
    protected boolean br;
    protected float bs;
    protected float bt;
    private Entity b;
    private int c;

    public EntityLiving(World world) {
        super(world);
        av = 20;
        az = 0.0F;
        aA = 0.0F;
        aF = true;
        aG = "/mob/char.png";
        aH = true;
        aI = 0.0F;
        aJ = null;
        aK = 1.0F;
        aL = 0;
        aM = 0.0F;
        aN = false;
        aU = 0.0F;
        aV = 0;
        aW = 0;
        aZ = false;
        ba = -1;
        bb = (float) (Math.random() * 0.89999997615814209D + 0.10000000149011612D);
        bl = 0.0F;
        bm = 0;
        bn = 0;
        br = false;
        bs = 0.0F;
        bt = 0.7F;
        c = 0;
        aQ = 10;
        i = true;
        ay = (float) (Math.random() + 1.0D) * 0.01F;
        a(p, q, r);
        aw = (float) Math.random() * 12398F;
        v = (float) (Math.random() * 3.1415927410125732D * 2D);
        ax = 1.0F;
        S = 0.5F;
    }

    public boolean i(Entity entity) {
        return l.a(Vec3D.b(p, q + (double) s(), r), Vec3D.b(entity.p, entity.q + (double) entity.s(), entity.r)) == null;
    }

    public boolean c_() {
        return !G;
    }

    public boolean v() {
        return !G;
    }

    public float s() {
        return J * 0.85F;
    }

    public int b() {
        return 80;
    }

    public void m() {
        aO = aP;
        super.m();
        if (W.nextInt(1000) < a++) {
            a = -b();
            String s1 = d();

            if (s1 != null) {
                l.a(this, s1, h(), (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
            }
        }
        if (x() && y()) {
            a(((Entity) (null)), 1);
        }
        if (ae || l.z) {
            Z = 0;
        }
        if (x() && a(Material.f)) {
            ad--;
            if (ad == -20) {
                ad = 0;
                for (int j = 0; j < 8; j++) {
                    float f1 = W.nextFloat() - W.nextFloat();
                    float f2 = W.nextFloat() - W.nextFloat();
                    float f3 = W.nextFloat() - W.nextFloat();

                    l.a("bubble", p + (double) f1, q + (double) f2, r + (double) f3, s, t, u);
                }

                a(((Entity) (null)), 2);
            }
            Z = 0;
        } else {
            ad = aa;
        }
        aX = aY;
        if (aW > 0) {
            aW--;
        }
        if (aS > 0) {
            aS--;
        }
        if (ac > 0) {
            ac--;
        }
        if (aQ <= 0) {
            aV++;
            if (aV > 20) {
                L();
                l();
                for (int k = 0; k < 20; k++) {
                    double d1 = W.nextGaussian() * 0.02D;
                    double d2 = W.nextGaussian() * 0.02D;
                    double d3 = W.nextGaussian() * 0.02D;

                    l.a("explode", (p + (double) (W.nextFloat() * I * 2.0F)) - (double) I, q + (double) (W.nextFloat() * J), (r + (double) (W.nextFloat() * I * 2.0F)) - (double) I, d1, d2, d3);
                }

            }
        }
        aE = aD;
        aA = az;
        x = v;
        y = w;
    }

    public void J() {
        for (int j = 0; j < 20; j++) {
            double d1 = W.nextGaussian() * 0.02D;
            double d2 = W.nextGaussian() * 0.02D;
            double d3 = W.nextGaussian() * 0.02D;
            double d4 = 10D;

            l.a("explode", (p + (double) (W.nextFloat() * I * 2.0F)) - (double) I - d1 * d4, (q + (double) (W.nextFloat() * J)) - d2 * d4,
                    (r + (double) (W.nextFloat() * I * 2.0F)) - (double) I - d3 * d4, d1, d2, d3);
        }

    }

    public void z() {
        super.z();
        aB = aC;
        aC = 0.0F;
    }

    public void b_() {
        super.b_();
        E();
        double d1 = p - m;
        double d2 = r - o;
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = az;
        float f3 = 0.0F;

        aB = aC;
        float f4 = 0.0F;

        if (f1 > 0.05F) {
            f4 = 1.0F;
            f3 = f1 * 3F;
            f2 = ((float) Math.atan2(d2, d1) * 180F) / 3.141593F - 90F;
        }
        if (aP > 0.0F) {
            f2 = v;
        }
        if (!A) {
            f4 = 0.0F;
        }
        aC = aC + (f4 - aC) * 0.3F;
        float f5;

        for (f5 = f2 - az; f5 < -180F; f5 += 360F) {
            ;
        }
        for (; f5 >= 180F; f5 -= 360F) {
            ;
        }
        az += f5 * 0.3F;
        float f6;

        for (f6 = v - az; f6 < -180F; f6 += 360F) {
            ;
        }
        for (; f6 >= 180F; f6 -= 360F) {
            ;
        }
        boolean flag = f6 < -90F || f6 >= 90F;

        if (f6 < -75F) {
            f6 = -75F;
        }
        if (f6 >= 75F) {
            f6 = 75F;
        }
        az = v - f6;
        if (f6 * f6 > 2500F) {
            az += f6 * 0.2F;
        }
        if (flag) {
            f3 *= -1F;
        }
        for (; v - x < -180F; x -= 360F) {
            ;
        }
        for (; v - x >= 180F; x += 360F) {
            ;
        }
        for (; az - aA < -180F; aA -= 360F) {
            ;
        }
        for (; az - aA >= 180F; aA += 360F) {
            ;
        }
        for (; w - y < -180F; y -= 360F) {
            ;
        }
        for (; w - y >= 180F; y += 360F) {
            ;
        }
        aD += f3;
    }

    protected void a(float f1, float f2) {
        super.a(f1, f2);
    }

    public void a(int j) {
        if (aQ <= 0) {
            return;
        }
        aQ += j;
        if (aQ > 20) {
            aQ = 20;
        }
        ac = av / 2;
    }

    public boolean a(Entity entity, int j) {
        if (l.z) {
            return false;
        }
        bn = 0;
        if (aQ <= 0) {
            return false;
        }
        bd = 1.5F;
        boolean flag = true;

        if ((float) ac > (float) av / 2.0F) {
            if (j <= bm) {
                return false;
            }
            c(j - bm);
            bm = j;
            flag = false;
        } else {
            bm = j;
            aR = aQ;
            ac = av;
            c(j);
            aS = aT = 10;
        }
        aU = 0.0F;
        if (flag) {
            u();
            if (entity != null) {
                double d1 = entity.p - p;
                double d2;

                for (d2 = entity.r - r; d1 * d1 + d2 * d2 < 0.0001D; d2 = (Math.random() - Math.random()) * 0.01D) {
                    d1 = (Math.random() - Math.random()) * 0.01D;
                }

                aU = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - v;
                a(entity, j, d1, d2);
            } else {
                aU = (int) (Math.random() * 2D) * 180;
            }
        }
        if (aQ <= 0) {
            if (flag) {
                l.a(this, f(), h(), (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
            }
            f(entity);
        } else if (flag) {
            l.a(this, e(), h(), (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
        }
        return true;
    }

    protected void c(int j) {
        aQ -= j;
    }

    protected float h() {
        return 1.0F;
    }

    protected String d() {
        return null;
    }

    protected String e() {
        return "random.hurt";
    }

    protected String f() {
        return "random.hurt";
    }

    public void a(Entity entity, int j, double d1, double d2) {
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = 0.4F;

        s /= 2D;
        t /= 2D;
        u /= 2D;
        s -= (d1 / (double) f1) * (double) f2;
        t += 0.40000000596046448D;
        u -= (d2 / (double) f1) * (double) f2;
        if (t > 0.40000000596046448D) {
            t = 0.40000000596046448D;
        }
    }

    public void f(Entity entity) {
        if (aL > 0 && entity != null) {
            entity.b(this, aL);
        }
        aZ = true;
        if (!this.l.z) {
            int j = g();

            if (j > 0) {
                int k = W.nextInt(3);

                for (int l = 0; l < k; l++) {
                    a(j, 1);
                }

            }
        }
        this.l.a(this, (byte) 3);
    }

    protected int g() {
        return 0;
    }

    protected void a(float f1) {
        int j = (int) Math.ceil(f1 - 3F);

        if (j > 0) {
            a(((Entity) (null)), j);
            int k = l.a(MathHelper.b(p), MathHelper.b(q - 0.20000000298023224D - (double) H), MathHelper.b(r));

            if (k > 0) {
                StepSound stepsound = Block.m[k].bq;

                l.a(this, stepsound.c(), stepsound.a() * 0.5F, stepsound.b() * 0.75F);
            }
        }
    }

    public void c(float f1, float f2) {
        if (r()) {
            double d1 = q;

            a(f1, f2, 0.02F);
            c(s, t, u);
            s *= 0.80000001192092896D;
            t *= 0.80000001192092896D;
            u *= 0.80000001192092896D;
            t -= 0.02D;
            if (B && b(s, ((t + 0.60000002384185791D) - q) + d1, u)) {
                t = 0.30000001192092896D;
            }
        } else if (t()) {
            double d2 = q;

            a(f1, f2, 0.02F);
            c(s, t, u);
            s *= 0.5D;
            t *= 0.5D;
            u *= 0.5D;
            t -= 0.02D;
            if (B && b(s, ((t + 0.60000002384185791D) - q) + d2, u)) {
                t = 0.30000001192092896D;
            }
        } else {
            float f3 = 0.91F;

            if (A) {
                f3 = 0.5460001F;
                int j = l.a(MathHelper.b(p), MathHelper.b(z.b) - 1, MathHelper.b(r));

                if (j > 0) {
                    f3 = Block.m[j].bt * 0.91F;
                }
            }
            float f4 = 0.1627714F / (f3 * f3 * f3);

            a(f1, f2, A ? 0.1F * f4 : 0.02F);
            f3 = 0.91F;
            if (A) {
                f3 = 0.5460001F;
                int k = l.a(MathHelper.b(p), MathHelper.b(z.b) - 1, MathHelper.b(r));

                if (k > 0) {
                    f3 = Block.m[k].bt * 0.91F;
                }
            }
            if (d_()) {
                N = 0.0F;
                if (t < -0.14999999999999999D) {
                    t = -0.14999999999999999D;
                }
            }
            c(s, t, u);
            if (B && d_()) {
                t = 0.20000000000000001D;
            }
            t -= 0.080000000000000002D;
            t *= 0.98000001907348633D;
            s *= f3;
            u *= f3;
        }
        bc = bd;
        double d3 = p - m;
        double d4 = r - o;
        float f5 = MathHelper.a(d3 * d3 + d4 * d4) * 4F;

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }
        bd += (f5 - bd) * 0.4F;
        be += bd;
    }

    public boolean d_() {
        int j = MathHelper.b(p);
        int k = MathHelper.b(z.b);
        int l = MathHelper.b(r);

        return this.l.a(j, k, l) == Block.aF.bh || this.l.a(j, k + 1, l) == Block.aF.bh;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) aQ);
        nbttagcompound.a("HurtTime", (short) aS);
        nbttagcompound.a("DeathTime", (short) aV);
        nbttagcompound.a("AttackTime", (short) aW);
    }

    public void b(NBTTagCompound nbttagcompound) {
        aQ = nbttagcompound.c("Health");
        if (!nbttagcompound.a("Health")) {
            aQ = 10;
        }
        aS = nbttagcompound.c("HurtTime");
        aV = nbttagcompound.c("DeathTime");
        aW = nbttagcompound.c("AttackTime");
    }

    public boolean x() {
        return !G && aQ > 0;
    }

    public void E() {
        if (bf > 0) {
            double d1 = p + (bg - p) / (double) bf;
            double d2 = q + (bh - q) / (double) bf;
            double d3 = r + (bi - r) / (double) bf;
            double d4;

            for (d4 = bj - (double) v; d4 < -180D; d4 += 360D) {
                ;
            }
            for (; d4 >= 180D; d4 -= 360D) {
                ;
            }
            v += d4 / (double) bf;
            w += (bk - (double) w) / (double) bf;
            bf--;
            a(d1, d2, d3);
            b(v, w);
        }
        if (aQ <= 0) {
            br = false;
            bo = 0.0F;
            bp = 0.0F;
            bq = 0.0F;
        } else if (!aN) {
            c();
        }
        boolean flag = r();
        boolean flag1 = t();

        if (br) {
            if (flag) {
                t += 0.039999999105930328D;
            } else if (flag1) {
                t += 0.039999999105930328D;
            } else if (A) {
                K();
            }
        }
        bo *= 0.98F;
        bp *= 0.98F;
        bq *= 0.9F;
        c(bo, bp);
        List list = l.b(this, z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                Entity entity = (Entity) list.get(j);

                if (entity.v()) {
                    entity.c(this);
                }
            }

        }
    }

    protected void K() {
        t = 0.41999998688697815D;
    }

    protected void c() {
        bn++;
        EntityPlayer entityplayer = l.a(this, -1D);

        if (entityplayer != null) {
            double d1 = ((Entity) (entityplayer)).p - p;
            double d2 = ((Entity) (entityplayer)).q - q;
            double d3 = ((Entity) (entityplayer)).r - r;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 16384D) {
                l();
            }
            if (bn > 600 && W.nextInt(800) == 0) {
                if (d4 < 1024D) {
                    bn = 0;
                } else {
                    l();
                }
            }
        }
        bo = 0.0F;
        bp = 0.0F;
        float f1 = 8F;

        if (W.nextFloat() < 0.02F) {
            EntityPlayer entityplayer1 = l.a(this, f1);

            if (entityplayer1 != null) {
                b = entityplayer1;
                c = 10 + W.nextInt(20);
            } else {
                bq = (W.nextFloat() - 0.5F) * 20F;
            }
        }
        if (b != null) {
            b(b, 10F);
            if (c-- <= 0 || b.G || b.b(this) > (double) (f1 * f1)) {
                b = null;
            }
        } else {
            if (W.nextFloat() < 0.05F) {
                bq = (W.nextFloat() - 0.5F) * 20F;
            }
            v += bq;
            w = bs;
        }
        boolean flag = r();
        boolean flag1 = t();

        if (flag || flag1) {
            br = W.nextFloat() < 0.8F;
        }
    }

    public void b(Entity entity, float f1) {
        double d1 = entity.p - p;
        double d2 = entity.r - r;
        double d3;

        if (entity instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving) entity;

            d3 = (entityliving.q + (double) entityliving.s()) - (q + (double) s());
        } else {
            d3 = (entity.z.b + entity.z.e) / 2D - (q + (double) s());
        }
        double d4 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
        float f3 = (float) ((Math.atan2(d3, d4) * 180D) / 3.1415927410125732D);

        w = b(w, f3, f1);
        v = b(v, f2, f1);
    }

    private float b(float f1, float f2, float f3) {
        float f4;

        for (f4 = f2 - f1; f4 < -180F; f4 += 360F) {
            ;
        }
        for (; f4 >= 180F; f4 -= 360F) {
            ;
        }
        if (f4 > f3) {
            f4 = f3;
        }
        if (f4 < -f3) {
            f4 = -f3;
        }
        return f1 + f4;
    }

    public void L() {}

    public boolean a() {
        return l.a(z) && l.a(this, z).size() == 0 && !l.b(z);
    }

    protected void o() {
        a(((Entity) (null)), 4);
    }

    public Vec3D C() {
        return c(1.0F);
    }

    public Vec3D c(float f1) {
        if (f1 == 1.0F) {
            float f2 = MathHelper.b(-v * 0.01745329F - 3.141593F);
            float f4 = MathHelper.a(-v * 0.01745329F - 3.141593F);
            float f6 = -MathHelper.b(-w * 0.01745329F);
            float f8 = MathHelper.a(-w * 0.01745329F);

            return Vec3D.b(f4 * f6, f8, f2 * f6);
        } else {
            float f3 = y + (w - y) * f1;
            float f5 = x + (v - x) * f1;
            float f7 = MathHelper.b(-f5 * 0.01745329F - 3.141593F);
            float f9 = MathHelper.a(-f5 * 0.01745329F - 3.141593F);
            float f10 = -MathHelper.b(-f3 * 0.01745329F);
            float f11 = MathHelper.a(-f3 * 0.01745329F);

            return Vec3D.b(f9 * f10, f11, f7 * f10);
        }
    }

    public int i() {
        return 4;
    }
}

