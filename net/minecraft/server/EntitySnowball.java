package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntitySnowball extends Entity {

    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    public int a;
    private EntityLiving ai;
    private int aj;
    private int ak;

    public EntitySnowball(World world) {
        super(world);
        b = -1;
        c = -1;
        d = -1;
        e = 0;
        f = false;
        a = 0;
        ak = 0;
        a(0.25F, 0.25F);
    }

    public void b_() {
        super.b_();
        if (a > 0) {
            a--;
        }
        if (f) {
            int i = this.l.a(b, c, d);

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

            if (!entity1.c_() || entity1 == ai && ak < 5) {
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
                if (!movingobjectposition.g.a(ai, 0)) {
                    ;
                }
            }
            for (int k = 0; k < 8; k++) {
                this.l.a("snowballpoof", p, q, r, 0.0D, 0.0D, 0.0D);
            }

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
        float f2 = 0.99F;
        float f4 = 0.03F;

        if (r()) {
            for (int l = 0; l < 4; l++) {
                float f5 = 0.25F;

                this.l.a("bubble", p - s * (double) f5, q - t * (double) f5, r - u * (double) f5, s, t, u);
            }

            f2 = 0.8F;
        }
        s *= f2;
        t *= f2;
        u *= f2;
        t -= f4;
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

