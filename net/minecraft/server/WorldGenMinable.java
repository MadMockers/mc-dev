package net.minecraft.server;


import java.util.Random;


public class WorldGenMinable extends WorldGenerator {

    private int a;
    private int b;

    public WorldGenMinable(int i, int j) {
        a = i;
        b = j;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        float f = random.nextFloat() * 3.141593F;
        double d = (float) (i + 8) + (MathHelper.a(f) * (float) b) / 8F;
        double d1 = (float) (i + 8) - (MathHelper.a(f) * (float) b) / 8F;
        double d2 = (float) (k + 8) + (MathHelper.b(f) * (float) b) / 8F;
        double d3 = (float) (k + 8) - (MathHelper.b(f) * (float) b) / 8F;
        double d4 = j + random.nextInt(3) + 2;
        double d5 = j + random.nextInt(3) + 2;

        for (int l = 0; l <= b; l++) {
            double d6 = d + ((d1 - d) * (double) l) / (double) b;
            double d7 = d4 + ((d5 - d4) * (double) l) / (double) b;
            double d8 = d2 + ((d3 - d2) * (double) l) / (double) b;
            double d9 = (random.nextDouble() * (double) b) / 16D;
            double d10 = (double) (MathHelper.a(((float) l * 3.141593F) / (float) b) + 1.0F) * d9 + 1.0D;
            double d11 = (double) (MathHelper.a(((float) l * 3.141593F) / (float) b) + 1.0F) * d9 + 1.0D;

            for (int i1 = (int) (d6 - d10 / 2D); i1 <= (int) (d6 + d10 / 2D); i1++) {
                for (int j1 = (int) (d7 - d11 / 2D); j1 <= (int) (d7 + d11 / 2D); j1++) {
                    for (int k1 = (int) (d8 - d10 / 2D); k1 <= (int) (d8 + d10 / 2D); k1++) {
                        double d12 = (((double) i1 + 0.5D) - d6) / (d10 / 2D);
                        double d13 = (((double) j1 + 0.5D) - d7) / (d11 / 2D);
                        double d14 = (((double) k1 + 0.5D) - d8) / (d10 / 2D);

                        if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && world.a(i1, j1, k1) == Block.u.bi) {
                            world.a(i1, j1, k1, a);
                        }
                    }

                }

            }

        }

        return true;
    }
}

