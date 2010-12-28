package net.minecraft.server;


import java.util.Random;


public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity aj;
    protected boolean ak;

    public EntityCreature(World world) {
        super(world);
        ak = false;
    }

    protected void c() {
        ak = false;
        float f = 16F;

        if (aj == null) {
            aj = k();
            if (aj != null) {
                a = this.l.a(this, aj, f);
            }
        } else if (!aj.x()) {
            aj = null;
        } else {
            float f1 = aj.a(this);

            if (i(aj)) {
                a(aj, f1);
            }
        }
        if (!ak && aj != null && (a == null || W.nextInt(20) == 0)) {
            a = this.l.a(this, aj, f);
        } else if (a == null && W.nextInt(80) == 0 || W.nextInt(80) == 0) {
            boolean flag = false;
            int j = -1;
            int l = -1;
            int i1 = -1;
            float f2 = -99999F;

            for (int j1 = 0; j1 < 10; j1++) {
                int k1 = MathHelper.b((p + (double) W.nextInt(13)) - 6D);
                int l1 = MathHelper.b((q + (double) W.nextInt(7)) - 3D);
                int i2 = MathHelper.b((r + (double) W.nextInt(13)) - 6D);
                float f3 = a(k1, l1, i2);

                if (f3 > f2) {
                    f2 = f3;
                    j = k1;
                    l = l1;
                    i1 = i2;
                    flag = true;
                }
            }

            if (flag) {
                a = this.l.a(this, j, l, i1, 10F);
            }
        }
        int i = MathHelper.b(z.b);
        boolean flag1 = r();
        boolean flag2 = t();

        w = 0.0F;
        if (a == null || W.nextInt(100) == 0) {
            super.c();
            a = null;
            return;
        }
        Vec3D vec3d = a.a(this);

        for (double d = I * 2.0F; vec3d != null && vec3d.d(p, vec3d.b, r) < d * d;) {
            a.a();
            if (a.b()) {
                vec3d = null;
                a = null;
            } else {
                vec3d = a.a(this);
            }
        }

        bs = false;
        if (vec3d != null) {
            double d1 = vec3d.a - p;
            double d2 = vec3d.c - r;
            double d3 = vec3d.b - (double) i;
            float f4 = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f5 = f4 - v;

            bq = bu;
            for (; f5 < -180F; f5 += 360F) {
                ;
            }
            for (; f5 >= 180F; f5 -= 360F) {
                ;
            }
            if (f5 > 30F) {
                f5 = 30F;
            }
            if (f5 < -30F) {
                f5 = -30F;
            }
            v += f5;
            if (ak && aj != null) {
                double d4 = aj.p - p;
                double d5 = aj.r - r;
                float f7 = v;

                v = (float) ((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f6 = (((f7 - v) + 90F) * 3.141593F) / 180F;

                bp = -MathHelper.a(f6) * bq * 1.0F;
                bq = MathHelper.b(f6) * bq * 1.0F;
            }
            if (d3 > 0.0D) {
                bs = true;
            }
        }
        if (aj != null) {
            b(aj, 30F);
        }
        if (B) {
            bs = true;
        }
        if (W.nextFloat() < 0.8F && (flag1 || flag2)) {
            bs = true;
        }
    }

    protected void a(Entity entity, float f) {}

    protected float a(int i, int j, int l) {
        return 0.0F;
    }

    protected Entity k() {
        return null;
    }

    public boolean a() {
        int i = MathHelper.b(p);
        int j = MathHelper.b(z.b);
        int l = MathHelper.b(r);

        return super.a() && a(i, j, l) >= 0.0F;
    }
}

