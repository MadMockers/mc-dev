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

    public void b() {
        h = g;
        if (!a()) {
            return;
        }
        double d1 = (float) b + a.l.nextFloat();
        double d3 = (float) c + a.l.nextFloat();
        double d5 = (float) d + a.l.nextFloat();

        a.a("smoke", d1, d3, d5, 0.0D, 0.0D, 0.0D);
        a.a("flame", d1, d3, d5, 0.0D, 0.0D, 0.0D);
        for (g += 1000F / ((float) e + 200F); g > 360D;) {
            g -= 360D;
            h -= 360D;
        }

        if (e == -1) {
            d();
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
            int j = a.a(entityliving.getClass(), AxisAlignedBB.b(b, c, d, b + 1, c + 1, d + 1).b(8D, 4D, 8D)).size();

            if (j >= 6) {
                d();
                return;
            }
            if (entityliving == null) {
                continue;
            }
            double d7 = (double) b + (a.l.nextDouble() - a.l.nextDouble()) * 4D;
            double d8 = (c + a.l.nextInt(3)) - 1;
            double d9 = (double) d + (a.l.nextDouble() - a.l.nextDouble()) * 4D;

            entityliving.c(d7, d8, d9, a.l.nextFloat() * 360F, 0.0F);
            if (!entityliving.a()) {
                continue;
            }
            a.a(entityliving);
            for (int k = 0; k < 20; k++) {
                double d2 = (double) b + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;
                double d4 = (double) c + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;
                double d6 = (double) d + 0.5D + ((double) a.l.nextFloat() - 0.5D) * 2D;

                a.a("smoke", d2, d4, d6, 0.0D, 0.0D, 0.0D);
                a.a("flame", d2, d4, d6, 0.0D, 0.0D, 0.0D);
            }

            entityliving.K();
            d();
        }

        super.b();
    }

    private void d() {
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

