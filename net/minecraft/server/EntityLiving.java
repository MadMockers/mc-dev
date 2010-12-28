package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityLiving extends Entity {

    public int au;
    public float av;
    public float aw;
    public float ax;
    public float ay;
    public float az;
    protected float aA;
    protected float aB;
    protected float aC;
    protected float aD;
    protected boolean aE;
    protected String aF;
    protected boolean aG;
    protected float aH;
    protected String aI;
    protected float aJ;
    protected int aK;
    protected float aL;
    public boolean aM;
    public float aN;
    public float aO;
    public int aP;
    public int aQ;
    private int a;
    public int aR;
    public int aS;
    public float aT;
    public int aU;
    public int aV;
    public float aW;
    public float aX;
    protected boolean aY;
    public int aZ;
    public float ba;
    public float bb;
    public float bc;
    public float bd;
    protected int be;
    protected double bf;
    protected double bg;
    protected double bh;
    protected double bi;
    protected double bj;
    float bk;
    private int b;
    protected int bl;
    protected float bm;
    protected float bn;
    protected float bo;
    protected boolean bp;
    protected float bq;
    protected float br;
    private Entity c;
    private int d;

    public EntityLiving(World world) {
        super(world);
        au = 20;
        ay = 0.0F;
        az = 0.0F;
        aE = true;
        aF = "/mob/char.png";
        aG = true;
        aH = 0.0F;
        aI = null;
        aJ = 1.0F;
        aK = 0;
        aL = 0.0F;
        aM = false;
        aT = 0.0F;
        aU = 0;
        aV = 0;
        aY = false;
        aZ = -1;
        ba = (float) (Math.random() * 0.89999997615814209D + 0.10000000149011612D);
        bk = 0.0F;
        b = 0;
        bl = 0;
        bp = false;
        bq = 0.0F;
        br = 0.7F;
        d = 0;
        aP = 10;
        i = true;
        ax = (float) (Math.random() + 1.0D) * 0.01F;
        a(p, q, r);
        av = (float) Math.random() * 12398F;
        v = (float) (Math.random() * 3.1415927410125732D * 2D);
        aw = 1.0F;
        R = 0.5F;
    }

    public boolean g(Entity entity) {
        return l.a(Vec3D.b(p, q + (double) s(), r), Vec3D.b(entity.p, entity.q + (double) entity.s(), entity.r)) == null;
    }

    public boolean c_() {
        return !F;
    }

    public boolean u() {
        return !F;
    }

    public float s() {
        return I * 0.85F;
    }

    public int b() {
        return 80;
    }

    public void m() {
        aN = aO;
        super.m();
        if (V.nextInt(1000) < a++) {
            a = -b();
            String s1 = d();

            if (s1 != null) {
                l.a(this, s1, h(), (V.nextFloat() - V.nextFloat()) * 0.2F + 1.0F);
            }
        }
        if (w() && x()) {
            a(((Entity) (null)), 1);
        }
        if (ad) {
            Y = 0;
        }
        if (w() && a(Material.f)) {
            ac--;
            if (ac == -20) {
                ac = 0;
                for (int j = 0; j < 8; j++) {
                    float f1 = V.nextFloat() - V.nextFloat();
                    float f2 = V.nextFloat() - V.nextFloat();
                    float f3 = V.nextFloat() - V.nextFloat();

                    l.a("bubble", p + (double) f1, q + (double) f2, r + (double) f3, s, t, u);
                }

                a(((Entity) (null)), 2);
            }
            Y = 0;
        } else {
            ac = Z;
        }
        aW = aX;
        if (aV > 0) {
            aV--;
        }
        if (aR > 0) {
            aR--;
        }
        if (ab > 0) {
            ab--;
        }
        if (aP <= 0) {
            aU++;
            if (aU > 20) {
                K();
                l();
                for (int k = 0; k < 20; k++) {
                    double d1 = V.nextGaussian() * 0.02D;
                    double d2 = V.nextGaussian() * 0.02D;
                    double d3 = V.nextGaussian() * 0.02D;

                    l.a("explode", (p + (double) (V.nextFloat() * H * 2.0F)) - (double) H, q + (double) (V.nextFloat() * I), (r + (double) (V.nextFloat() * H * 2.0F)) - (double) H, d1, d2, d3);
                }

            }
        }
        aD = aC;
        az = ay;
        x = v;
        y = w;
    }

    public void I() {
        for (int j = 0; j < 20; j++) {
            double d1 = V.nextGaussian() * 0.02D;
            double d2 = V.nextGaussian() * 0.02D;
            double d3 = V.nextGaussian() * 0.02D;
            double d4 = 10D;

            l.a("explode", (p + (double) (V.nextFloat() * H * 2.0F)) - (double) H - d1 * d4, (q + (double) (V.nextFloat() * I)) - d2 * d4,
                    (r + (double) (V.nextFloat() * H * 2.0F)) - (double) H - d3 * d4, d1, d2, d3);
        }

    }

    public void y() {
        super.y();
        aA = aB;
        aB = 0.0F;
    }

    public void b_() {
        super.b_();
        D();
        double d1 = p - m;
        double d2 = r - o;
        float f1 = MathHelper.a(d1 * d1 + d2 * d2);
        float f2 = ay;
        float f3 = 0.0F;

        aA = aB;
        float f4 = 0.0F;

        if (f1 > 0.05F) {
            f4 = 1.0F;
            f3 = f1 * 3F;
            f2 = ((float) Math.atan2(d2, d1) * 180F) / 3.141593F - 90F;
        }
        if (aO > 0.0F) {
            f2 = v;
        }
        if (!A) {
            f4 = 0.0F;
        }
        aB = aB + (f4 - aB) * 0.3F;
        float f5;

        for (f5 = f2 - ay; f5 < -180F; f5 += 360F) {
            ;
        }
        for (; f5 >= 180F; f5 -= 360F) {
            ;
        }
        ay += f5 * 0.3F;
        float f6;

        for (f6 = v - ay; f6 < -180F; f6 += 360F) {
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
        ay = v - f6;
        if (f6 * f6 > 2500F) {
            ay += f6 * 0.2F;
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
        for (; ay - az < -180F; az -= 360F) {
            ;
        }
        for (; ay - az >= 180F; az += 360F) {
            ;
        }
        for (; w - y < -180F; y -= 360F) {
            ;
        }
        for (; w - y >= 180F; y += 360F) {
            ;
        }
        aC += f3;
    }

    protected void a(float f1, float f2) {
        super.a(f1, f2);
    }

    public void a(int j) {
        if (aP <= 0) {
            return;
        }
        aP += j;
        if (aP > 20) {
            aP = 20;
        }
        ab = au / 2;
    }

    public boolean a(Entity entity, int j) {
        if (l.z) {
            j = 0;
        }
        bl = 0;
        if (aP <= 0) {
            return false;
        }
        bc = 1.5F;
        boolean flag = true;

        if ((float) ab > (float) au / 2.0F) {
            if (j <= b) {
                return false;
            }
            c(j - b);
            b = j;
            flag = false;
        } else {
            b = j;
            aQ = aP;
            ab = au;
            c(j);
            aR = aS = 10;
        }
        aT = 0.0F;
        if (flag) {
            if (entity != null) {
                double d1 = entity.p - p;
                double d2;

                for (d2 = entity.r - r; d1 * d1 + d2 * d2 < 0.0001D; d2 = (Math.random() - Math.random()) * 0.01D) {
                    d1 = (Math.random() - Math.random()) * 0.01D;
                }

                aT = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - v;
                a(entity, j, d1, d2);
            } else {
                aT = (int) (Math.random() * 2D) * 180;
            }
        }
        if (aP <= 0) {
            if (flag) {
                l.a(this, f(), h(), (V.nextFloat() - V.nextFloat()) * 0.2F + 1.0F);
            }
            f(entity);
        } else if (flag) {
            l.a(this, e(), h(), (V.nextFloat() - V.nextFloat()) * 0.2F + 1.0F);
        }
        return true;
    }

    protected void c(int j) {
        aP -= j;
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
        if (aK > 0 && entity != null) {
            entity.b(this, aK);
        }
        aY = true;
        int j = g();

        if (j > 0) {
            int k = V.nextInt(3);

            for (int l = 0; l < k; l++) {
                a(j, 1);
            }

        }
    }

    protected int g() {
        return 0;
    }

    protected void a(float f1) {
        int j = (int) Math.ceil(f1 - 3F);

        if (j > 0) {
            a(((Entity) (null)), j);
            int k = l.a(MathHelper.b(p), MathHelper.b(q - 0.20000000298023224D - (double) G), MathHelper.b(r));

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
                M = 0.0F;
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
        bb = bc;
        double d3 = p - m;
        double d4 = r - o;
        float f5 = MathHelper.a(d3 * d3 + d4 * d4) * 4F;

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }
        bc += (f5 - bc) * 0.4F;
        bd += bc;
    }

    public boolean d_() {
        int j = MathHelper.b(p);
        int k = MathHelper.b(z.b);
        int l = MathHelper.b(r);

        return this.l.a(j, k, l) == Block.aF.bh || this.l.a(j, k + 1, l) == Block.aF.bh;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Health", (short) aP);
        nbttagcompound.a("HurtTime", (short) aR);
        nbttagcompound.a("DeathTime", (short) aU);
        nbttagcompound.a("AttackTime", (short) aV);
    }

    public void b(NBTTagCompound nbttagcompound) {
        aP = nbttagcompound.c("Health");
        if (!nbttagcompound.a("Health")) {
            aP = 10;
        }
        aR = nbttagcompound.c("HurtTime");
        aU = nbttagcompound.c("DeathTime");
        aV = nbttagcompound.c("AttackTime");
    }

    public boolean w() {
        return !F && aP > 0;
    }

    public void D() {
        if (be > 0) {
            double d1 = p + (bf - p) / (double) be;
            double d2 = q + (bg - q) / (double) be;
            double d3 = r + (bh - r) / (double) be;
            double d4;

            for (d4 = bi - (double) v; d4 < -180D; d4 += 360D) {
                ;
            }
            for (; d4 >= 180D; d4 -= 360D) {
                ;
            }
            v += d4 / (double) be;
            w += (bj - (double) w) / (double) be;
            be--;
            a(d1, d2, d3);
            b(v, w);
        }
        if (aP <= 0) {
            bp = false;
            bm = 0.0F;
            bn = 0.0F;
            bo = 0.0F;
        } else if (!aM) {
            c();
        }
        boolean flag = r();
        boolean flag1 = t();

        if (bp) {
            if (flag) {
                t += 0.039999999105930328D;
            } else if (flag1) {
                t += 0.039999999105930328D;
            } else if (A) {
                J();
            }
        }
        bm *= 0.98F;
        bn *= 0.98F;
        bo *= 0.9F;
        c(bm, bn);
        List list = l.b(this, z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                Entity entity = (Entity) list.get(j);

                if (entity.u()) {
                    entity.c(this);
                }
            }

        }
    }

    protected void J() {
        t = 0.41999998688697815D;
    }

    protected void c() {
        bl++;
        EntityPlayer entityplayer = l.a(this, -1D);

        if (entityplayer != null) {
            double d1 = ((Entity) (entityplayer)).p - p;
            double d2 = ((Entity) (entityplayer)).q - q;
            double d3 = ((Entity) (entityplayer)).r - r;
            double d4 = d1 * d1 + d2 * d2 + d3 * d3;

            if (d4 > 16384D) {
                l();
            }
            if (bl > 600 && V.nextInt(800) == 0) {
                if (d4 < 1024D) {
                    bl = 0;
                } else {
                    l();
                }
            }
        }
        bm = 0.0F;
        bn = 0.0F;
        float f1 = 8F;

        if (V.nextFloat() < 0.02F) {
            EntityPlayer entityplayer1 = l.a(this, f1);

            if (entityplayer1 != null) {
                c = entityplayer1;
                d = 10 + V.nextInt(20);
            } else {
                bo = (V.nextFloat() - 0.5F) * 20F;
            }
        }
        if (c != null) {
            b(c, 10F);
            if (d-- <= 0 || c.F || c.b(this) > (double) (f1 * f1)) {
                c = null;
            }
        } else {
            if (V.nextFloat() < 0.05F) {
                bo = (V.nextFloat() - 0.5F) * 20F;
            }
            v += bo;
            w = bq;
        }
        boolean flag = r();
        boolean flag1 = t();

        if (flag || flag1) {
            bp = V.nextFloat() < 0.8F;
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

    public void K() {}

    public boolean a() {
        return l.a(z) && l.a(this, z).size() == 0 && !l.b(z);
    }

    protected void o() {
        a(((Entity) (null)), 4);
    }

    public Vec3D c(float f1) {
        if (f1 == 1.0F) {
            return Vec3D.b(p, q, r);
        } else {
            double d1 = m + (p - m) * (double) f1;
            double d2 = n + (q - n) * (double) f1;
            double d3 = o + (r - o) * (double) f1;

            return Vec3D.b(d1, d2, d3);
        }
    }

    public Vec3D B() {
        return d(1.0F);
    }

    public Vec3D d(float f1) {
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

    public MovingObjectPosition a(double d1, float f1) {
        Vec3D vec3d = c(f1);
        Vec3D vec3d1 = d(f1);
        Vec3D vec3d2 = vec3d.c(vec3d1.a * d1, vec3d1.b * d1, vec3d1.c * d1);

        return l.a(vec3d, vec3d2);
    }

    public int i() {
        return 4;
    }
}

