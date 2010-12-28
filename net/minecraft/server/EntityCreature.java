package net.minecraft.server;


import java.util.Random;


public class EntityCreature extends EntityLiving {

    private PathEntity a;
    protected Entity f;
    protected boolean aj;

    public EntityCreature(World world) {
        super(world);
        aj = false;
    }

    protected void c() {
        aj = false;
        float f1 = 16F;

        if (f == null) {
            f = k();
            if (f != null) {
                a = this.l.a(this, f, f1);
            }
        } else if (!f.x()) {
            f = null;
        } else {
            float f2 = f.a(this);

            if (i(f)) {
                a(f, f2);
            }
        }
        if (!aj && f != null && (a == null || W.nextInt(20) == 0)) {
            a = this.l.a(this, f, f1);
        } else if (a == null && W.nextInt(80) == 0 || W.nextInt(80) == 0) {
            boolean flag = false;
            int j = -1;
            int l = -1;
            int i1 = -1;
            float f3 = -99999F;

            for (int j1 = 0; j1 < 10; j1++) {
                int k1 = MathHelper.b((p + (double) W.nextInt(13)) - 6D);
                int l1 = MathHelper.b((q + (double) W.nextInt(7)) - 3D);
                int i2 = MathHelper.b((r + (double) W.nextInt(13)) - 6D);
                float f4 = a(k1, l1, i2);

                if (f4 > f3) {
                    f3 = f4;
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

        br = false;
        if (vec3d != null) {
            double d1 = vec3d.a - p;
            double d2 = vec3d.c - r;
            double d3 = vec3d.b - (double) i;
            float f5 = (float) ((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f6 = f5 - v;

            bp = bt;
            for (; f6 < -180F; f6 += 360F) {
                ;
            }
            for (; f6 >= 180F; f6 -= 360F) {
                ;
            }
            if (f6 > 30F) {
                f6 = 30F;
            }
            if (f6 < -30F) {
                f6 = -30F;
            }
            v += f6;
            if (aj && f != null) {
                double d4 = f.p - p;
                double d5 = f.r - r;
                float f8 = v;

                v = (float) ((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f7 = (((f8 - v) + 90F) * 3.141593F) / 180F;

                bo = -MathHelper.a(f7) * bp * 1.0F;
                bp = MathHelper.b(f7) * bp * 1.0F;
            }
            if (d3 > 0.0D) {
                br = true;
            }
        }
        if (f != null) {
            b(f, 30F);
        }
        if (B) {
            br = true;
        }
        if (W.nextFloat() < 0.8F && (flag1 || flag2)) {
            br = true;
        }
    }

    protected void a(Entity entity, float f1) {}

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

