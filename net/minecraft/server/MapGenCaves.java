package net.minecraft.server;


import java.util.Random;


public class MapGenCaves extends MapGenBase {

    public MapGenCaves() {}

    protected void a(int i, int j, byte abyte0[], double d, double d1, 
            double d2) {
        a(i, j, abyte0, d, d1, d2, 1.0F + b.nextFloat() * 6F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void a(int i, int j, byte abyte0[], double d, double d1, 
            double d2, float f, float f1, float f2, int k, int l, 
            double d3) {
        double d4 = i * 16 + 8;
        double d5 = j * 16 + 8;
        float f3 = 0.0F;
        float f4 = 0.0F;
        Random random = new Random(b.nextLong());

        if (l <= 0) {
            int i1 = a * 16 - 16;

            l = i1 - random.nextInt(i1 / 4);
        }
        boolean flag = false;

        if (k == -1) {
            k = l / 2;
            flag = true;
        }
        int j1 = random.nextInt(l / 2) + l / 4;
        boolean flag1 = random.nextInt(6) == 0;

        for (; k < l; k++) {
            double d6 = 1.5D + (double) (MathHelper.a(((float) k * 3.141593F) / (float) l) * f * 1.0F);
            double d7 = d6 * d3;
            float f5 = MathHelper.b(f2);
            float f6 = MathHelper.a(f2);

            d += MathHelper.b(f1) * f5;
            d1 += f6;
            d2 += MathHelper.a(f1) * f5;
            if (flag1) {
                f2 *= 0.92F;
            } else {
                f2 *= 0.7F;
            }
            f2 += f4 * 0.1F;
            f1 += f3 * 0.1F;
            f4 *= 0.9F;
            f3 *= 0.75F;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4F;
            if (!flag && k == j1 && f > 1.0F) {
                a(i, j, abyte0, d, d1, d2, random.nextFloat() * 0.5F + 0.5F, f1 - 1.570796F, f2 / 3F, k, l, 1.0D);
                a(i, j, abyte0, d, d1, d2, random.nextFloat() * 0.5F + 0.5F, f1 + 1.570796F, f2 / 3F, k, l, 1.0D);
                return;
            }
            if (!flag && random.nextInt(4) == 0) {
                continue;
            }
            double d8 = d - d4;
            double d9 = d2 - d5;
            double d10 = l - k;
            double d11 = f + 2.0F + 16F;

            if ((d8 * d8 + d9 * d9) - d10 * d10 > d11 * d11) {
                return;
            }
            if (d < d4 - 16D - d6 * 2D || d2 < d5 - 16D - d6 * 2D || d > d4 + 16D + d6 * 2D || d2 > d5 + 16D + d6 * 2D) {
                continue;
            }
            int k1 = MathHelper.b(d - d6) - i * 16 - 1;
            int l1 = (MathHelper.b(d + d6) - i * 16) + 1;
            int i2 = MathHelper.b(d1 - d7) - 1;
            int j2 = MathHelper.b(d1 + d7) + 1;
            int k2 = MathHelper.b(d2 - d6) - j * 16 - 1;
            int l2 = (MathHelper.b(d2 + d6) - j * 16) + 1;

            if (k1 < 0) {
                k1 = 0;
            }
            if (l1 > 16) {
                l1 = 16;
            }
            if (i2 < 1) {
                i2 = 1;
            }
            if (j2 > 120) {
                j2 = 120;
            }
            if (k2 < 0) {
                k2 = 0;
            }
            if (l2 > 16) {
                l2 = 16;
            }
            boolean flag2 = false;

            for (int i3 = k1; !flag2 && i3 < l1; i3++) {
                for (int k3 = k2; !flag2 && k3 < l2; k3++) {
                    for (int l3 = j2 + 1; !flag2 && l3 >= i2 - 1; l3--) {
                        int i4 = (i3 * 16 + k3) * 128 + l3;

                        if (l3 < 0 || l3 >= 128) {
                            continue;
                        }
                        if (abyte0[i4] == Block.A.bh || abyte0[i4] == Block.B.bh) {
                            flag2 = true;
                        }
                        if (l3 != i2 - 1 && i3 != k1 && i3 != l1 - 1 && k3 != k2 && k3 != l2 - 1) {
                            l3 = i2;
                        }
                    }

                }

            }

            if (flag2) {
                continue;
            }
            for (int j3 = k1; j3 < l1; j3++) {
                double d12 = (((double) (j3 + i * 16) + 0.5D) - d) / d6;

                for (int j4 = k2; j4 < l2; j4++) {
                    double d13 = (((double) (j4 + j * 16) + 0.5D) - d2) / d6;
                    int k4 = (j3 * 16 + j4) * 128 + j2;
                    boolean flag3 = false;

                    for (int l4 = j2 - 1; l4 >= i2; l4--) {
                        double d14 = (((double) l4 + 0.5D) - d1) / d7;

                        if (d14 > -0.69999999999999996D && d12 * d12 + d14 * d14 + d13 * d13 < 1.0D) {
                            byte byte0 = abyte0[k4];

                            if (byte0 == Block.u.bh) {
                                flag3 = true;
                            }
                            if (byte0 == Block.t.bh || byte0 == Block.v.bh || byte0 == Block.u.bh) {
                                if (l4 < 10) {
                                    abyte0[k4] = (byte) Block.C.bh;
                                } else {
                                    abyte0[k4] = 0;
                                    if (flag3 && abyte0[k4 - 1] == Block.v.bh) {
                                        abyte0[k4 - 1] = (byte) Block.u.bh;
                                    }
                                }
                            }
                        }
                        k4--;
                    }

                }

            }

            if (flag) {
                break;
            }
        }

    }

    protected void a(World world, int i, int j, int k, int l, byte abyte0[]) {
        int i1 = b.nextInt(b.nextInt(b.nextInt(40) + 1) + 1);

        if (b.nextInt(15) != 0) {
            i1 = 0;
        }
        for (int j1 = 0; j1 < i1; j1++) {
            double d = i * 16 + b.nextInt(16);
            double d1 = b.nextInt(b.nextInt(120) + 8);
            double d2 = j * 16 + b.nextInt(16);
            int k1 = 1;

            if (b.nextInt(4) == 0) {
                a(k, l, abyte0, d, d1, d2);
                k1 += b.nextInt(4);
            }
            for (int l1 = 0; l1 < k1; l1++) {
                float f = b.nextFloat() * 3.141593F * 2.0F;
                float f1 = ((b.nextFloat() - 0.5F) * 2.0F) / 8F;
                float f2 = b.nextFloat() * 2.0F + b.nextFloat();

                a(k, l, abyte0, d, d1, d2, f2, f, f1, 0, 0, 1.0D);
            }

        }

    }
}

