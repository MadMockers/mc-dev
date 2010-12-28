package net.minecraft.server;


import java.util.Random;


public class NoiseGeneratorPerlin extends NoiseGenerator {

    private int d[];
    public double a;
    public double b;
    public double c;

    public NoiseGeneratorPerlin() {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random random) {
        d = new int[512];
        a = random.nextDouble() * 256D;
        b = random.nextDouble() * 256D;
        c = random.nextDouble() * 256D;
        for (int i = 0; i < 256; i++) {
            d[i] = i;
        }

        for (int j = 0; j < 256; j++) {
            int k = random.nextInt(256 - j) + j;
            int l = d[j];

            d[j] = d[k];
            d[k] = l;
            d[j + 256] = d[j];
        }

    }

    public double a(double d1, double d2, double d3) {
        double d4 = d1 + a;
        double d5 = d2 + b;
        double d6 = d3 + c;
        int i = (int) d4;
        int j = (int) d5;
        int k = (int) d6;

        if (d4 < (double) i) {
            i--;
        }
        if (d5 < (double) j) {
            j--;
        }
        if (d6 < (double) k) {
            k--;
        }
        int l = i & 0xff;
        int i1 = j & 0xff;
        int j1 = k & 0xff;

        d4 -= i;
        d5 -= j;
        d6 -= k;
        double d7 = d4 * d4 * d4 * (d4 * (d4 * 6D - 15D) + 10D);
        double d8 = d5 * d5 * d5 * (d5 * (d5 * 6D - 15D) + 10D);
        double d9 = d6 * d6 * d6 * (d6 * (d6 * 6D - 15D) + 10D);
        int k1 = d[l] + i1;
        int l1 = d[k1] + j1;
        int i2 = d[k1 + 1] + j1;
        int j2 = d[l + 1] + i1;
        int k2 = d[j2] + j1;
        int l2 = d[j2 + 1] + j1;

        return b(d9, b(d8, b(d7, a(d[l1], d4, d5, d6), a(d[k2], d4 - 1.0D, d5, d6)), b(d7, a(d[i2], d4, d5 - 1.0D, d6), a(d[l2], d4 - 1.0D, d5 - 1.0D, d6))),
                b(d8, b(d7, a(d[l1 + 1], d4, d5, d6 - 1.0D), a(d[k2 + 1], d4 - 1.0D, d5, d6 - 1.0D)), b(d7, a(d[i2 + 1], d4, d5 - 1.0D, d6 - 1.0D), a(d[l2 + 1], d4 - 1.0D, d5 - 1.0D, d6 - 1.0D))));
    }

    public final double b(double d1, double d2, double d3) {
        return d2 + d1 * (d3 - d2);
    }

    public final double a(int i, double d1, double d2) {
        int j = i & 0xf;
        double d3 = (double) (1 - ((j & 8) >> 3)) * d1;
        double d4 = j >= 4 ? j != 12 && j != 14 ? d2 : d1 : 0.0D;

        return ((j & 1) != 0 ? -d3 : d3) + ((j & 2) != 0 ? -d4 : d4);
    }

    public final double a(int i, double d1, double d2, double d3) {
        int j = i & 0xf;
        double d4 = j >= 8 ? d2 : d1;
        double d5 = j >= 4 ? j != 12 && j != 14 ? d3 : d1 : d2;

        return ((j & 1) != 0 ? -d4 : d4) + ((j & 2) != 0 ? -d5 : d5);
    }

    public double a(double d1, double d2) {
        return a(d1, d2, 0.0D);
    }

    public void a(double ad[], double d1, double d2, double d3, 
            int i, int j, int k, double d4, double d5, 
            double d6, double d7) {
        if (j == 1) {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag6 = false;
            double d8 = 0.0D;
            double d10 = 0.0D;
            double d11 = 0.0D;
            double d14 = 0.0D;
            int j3 = 0;
            double d16 = 1.0D / d7;

            for (int k3 = 0; k3 < i; k3++) {
                double d17 = (d1 + (double) k3) * d4 + a;
                int l3 = (int) d17;

                if (d17 < (double) l3) {
                    l3--;
                }
                int i4 = l3 & 0xff;

                d17 -= l3;
                double d18 = d17 * d17 * d17 * (d17 * (d17 * 6D - 15D) + 10D);

                for (int k4 = 0; k4 < k; k4++) {
                    double d19 = (d3 + (double) k4) * d6 + c;
                    int l4 = (int) d19;

                    if (d19 < (double) l4) {
                        l4--;
                    }
                    int i5 = l4 & 0xff;

                    d19 -= l4;
                    double d20 = d19 * d19 * d19 * (d19 * (d19 * 6D - 15D) + 10D);
                    int l = d[i4] + 0;
                    int j1 = d[l] + i5;
                    int k1 = d[l + 1] + i5;
                    int l1 = d[i4 + 1] + 0;
                    int j2 = d[l1] + i5;
                    int l2 = d[l1 + 1] + i5;
                    double d9 = b(d18, a(d[j1], d17, d19), a(d[j2], d17 - 1.0D, 0.0D, d19));
                    double d12 = b(d18, a(d[j1 + 1], d17, 0.0D, d19 - 1.0D), a(d[j2 + 1], d17 - 1.0D, 0.0D, d19 - 1.0D));
                    double d21 = b(d20, d9, d12);

                    ad[j3++] += d21 * d16;
                }

            }

            return;
        }
        int i1 = 0;
        double d22 = 1.0D / d7;
        int i2 = -1;
        boolean flag5 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        boolean flag10 = false;
        boolean flag11 = false;
        double d13 = 0.0D;
        double d15 = 0.0D;
        double d23 = 0.0D;
        double d24 = 0.0D;

        for (int k6 = 0; k6 < i; k6++) {
            double d25 = (d1 + (double) k6) * d4 + a;
            int j4 = (int) d25;

            if (d25 < (double) j4) {
                j4--;
            }
            int l6 = j4 & 0xff;

            d25 -= j4;
            double d26 = d25 * d25 * d25 * (d25 * (d25 * 6D - 15D) + 10D);

            for (int i7 = 0; i7 < k; i7++) {
                double d27 = (d3 + (double) i7) * d6 + c;
                int j5 = (int) d27;

                if (d27 < (double) j5) {
                    j5--;
                }
                int j7 = j5 & 0xff;

                d27 -= j5;
                double d28 = d27 * d27 * d27 * (d27 * (d27 * 6D - 15D) + 10D);

                for (int k7 = 0; k7 < j; k7++) {
                    double d29 = (d2 + (double) k7) * d5 + b;
                    int l7 = (int) d29;

                    if (d29 < (double) l7) {
                        l7--;
                    }
                    int i8 = l7 & 0xff;

                    d29 -= l7;
                    double d30 = d29 * d29 * d29 * (d29 * (d29 * 6D - 15D) + 10D);

                    if (k7 == 0 || i8 != i2) {
                        i2 = i8;
                        int k2 = d[l6] + i8;
                        int i3 = d[k2] + j7;
                        int k5 = d[k2 + 1] + j7;
                        int l5 = d[l6 + 1] + i8;
                        int i6 = d[l5] + j7;
                        int j6 = d[l5 + 1] + j7;

                        d13 = b(d26, a(d[i3], d25, d29, d27), a(d[i6], d25 - 1.0D, d29, d27));
                        d15 = b(d26, a(d[k5], d25, d29 - 1.0D, d27), a(d[j6], d25 - 1.0D, d29 - 1.0D, d27));
                        d23 = b(d26, a(d[i3 + 1], d25, d29, d27 - 1.0D), a(d[i6 + 1], d25 - 1.0D, d29, d27 - 1.0D));
                        d24 = b(d26, a(d[k5 + 1], d25, d29 - 1.0D, d27 - 1.0D), a(d[j6 + 1], d25 - 1.0D, d29 - 1.0D, d27 - 1.0D));
                    }
                    double d31 = b(d30, d13, d15);
                    double d32 = b(d30, d23, d24);
                    double d33 = b(d28, d31, d32);

                    ad[i1++] += d33 * d22;
                }

            }

        }

    }
}

