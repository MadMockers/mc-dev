package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class TileEntityMobSpawner extends TileEntity {

    public int e;
    public String f;
    public double g;
    public double h;

    public TileEntityMobSpawner() {
        e = -1;
        h = 0.0D;
        f = "Pig";
        e = 20;
    }

    public boolean a() {
        return a.a((double) b + 0.5D, (double) c + 0.5D, (double) d + 0.5D, 16D) != null;
    }

    public void e() {
        h = g;
        if (!a()) {
            return;
        }
        double d = (float) b + a.l.nextFloat();
        double d2 = (float) c + a.l.nextFloat();
        double d4 = (float) this.d + a.l.nextFloat();

        a.a("smoke", d, d2, d4, 0.0D, 0.0D, 0.0D);
        a.a("flame", d, d2, d4, 0.0D, 0.0D, 0.0D);
        for (g += 1000F / ((float) e + 200F); g > 360D;) {
            g -= 360D;
            h -= 360D;
        }

        if (e == -1) {
            b();
        }
        if (e > 0) {
            e--;
            return;
        }
        byte byte0 = 4;

        for (int i = 0; i < byte0; i++) {
            EntityLiving entityliving = (EntityLiving) EntityList.a(f, a);

            if (entityliving == null) {
                return;
            }
            int j = a.a(entityliving.getClass(), AxisAlignedBB.b(b, c, this.d, b + 1, c + 1, this.d + 1).b(8D, 4D, 8D)).size();

            if (j >= 6) {
                b();
                return;
            }
            if (entityliving == null) {
                continue;
            }
            double d6 = (double) b + (a.l.nextDouble() - a.l.nextDouble()) * 4D;
            double d7 = (c + a.l.nextInt(3)) - 1;
            double d8 = (double) this.d + (a.l.nextDouble() - a.l.nextDouble()) * 4D;

            entityliving.c(d6, d7, d8, a.l.nextFloat() * 360F, 0.0F);
            if (!entityliving.a()) {
                continue;
            }
            a.a(entityliving);
            for (int k = 0; k < 20; k++) {
                double d1 = (double) b + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;
                double d3 = (double) c + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;
                double d5 = (double) this.d + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;

                a.a("smoke", d1, d3, d5, 0.0D, 0.0D, 0.0D);
                a.a("flame", d1, d3, d5, 0.0D, 0.0D, 0.0D);
            }

            entityliving.O();
            b();
        }

        super.e();
    }

    private void b() {
        e = 200 + a.l.nextInt(600);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        f = nbttagcompound.h("EntityId");
        e = nbttagcompound.c("Delay");
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("EntityId", f);
        nbttagcompound.a("Delay", (short) e);
    }
}

