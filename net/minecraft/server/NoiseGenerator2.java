package net.minecraft.server;


import java.util.Random;


public class NoiseGenerator2 {

    private static int d[][] = {
        {
            1, 1, 0
        }, {
            -1, 1, 0
        }, {
            1, -1, 0
        }, {
            -1, -1, 0
        }, {
            1, 0, 1
        }, {
            -1, 0, 1
        }, {
            1, 0, -1
        }, {
            -1, 0, -1
        }, {
            0, 1, 1
        }, {
            0, -1, 1
        }, {
            0, 1, -1
        }, {
            0, -1, -1
        }
    };
    private int e[];
    public double a;
    public double b;
    public double c;
    private static final double f = 0.5D * (Math.sqrt(3D) - 1.0D);
    private static final double g = (3D - Math.sqrt(3D)) / 6D;

    public NoiseGenerator2() {
        this(new Random());
    }

    public NoiseGenerator2(Random random) {
        e = new int[512];
        a = random.nextDouble() * 256D;
        b = random.nextDouble() * 256D;
        c = random.nextDouble() * 256D;
        for (int i = 0; i < 256; i++) {
            e[i] = i;
        }

        for (int j = 0; j < 256; j++) {
            int k = random.nextInt(256 - j) + j;
            int l = e[j];

            e[j] = e[k];
            e[k] = l;
            e[j + 256] = e[j];
        }

    }

    private static int a(double d1) {
        return d1 <= 0.0D ? (int) d1 - 1 : (int) d1;
    }

    private static double a(int ai[], double d1, double d2) {
        return (double) ai[0] * d1 + (double) ai[1] * d2;
    }

    public void a(double ad[], double d1, double d2, int i, int j, 
            double d3, double d4, double d5) {
        int k = 0;

        for (int l = 0; l < i; l++) {
            double d6 = (d1 + (double) l) * d3 + a;

            for (int i1 = 0; i1 < j; i1++) {
                double d7 = (d2 + (double) i1) * d4 + b;
                double d8 = (d6 + d7) * f;
                int j1 = a(d6 + d8);
                int k1 = a(d7 + d8);
                double d9 = (double) (j1 + k1) * g;
                double d10 = (double) j1 - d9;
                double d11 = (double) k1 - d9;
                double d12 = d6 - d10;
                double d13 = d7 - d11;
                int l1;
                int i2;

                if (d12 > d13) {
                    l1 = 1;
                    i2 = 0;
                } else {
                    l1 = 0;
                    i2 = 1;
                }
                double d14 = (d12 - (double) l1) + g;
                double d15 = (d13 - (double) i2) + g;
                double d16 = (d12 - 1.0D) + 2D * g;
                double d17 = (d13 - 1.0D) + 2D * g;
                int j2 = j1 & 0xff;
                int k2 = k1 & 0xff;
                int l2 = e[j2 + e[k2]] % 12;
                int i3 = e[j2 + l1 + e[k2 + i2]] % 12;
                int j3 = e[j2 + 1 + e[k2 + 1]] % 12;
                double d18 = 0.5D - d12 * d12 - d13 * d13;
                double d19;

                if (d18 < 0.0D) {
                    d19 = 0.0D;
                } else {
                    d18 *= d18;
                    d19 = d18 * d18 * a(d[l2], d12, d13);
                }
                double d20 = 0.5D - d14 * d14 - d15 * d15;
                double d21;

                if (d20 < 0.0D) {
                    d21 = 0.0D;
                } else {
                    d20 *= d20;
                    d21 = d20 * d20 * a(d[i3], d14, d15);
                }
                double d22 = 0.5D - d16 * d16 - d17 * d17;
                double d23;

                if (d22 < 0.0D) {
                    d23 = 0.0D;
                } else {
                    d22 *= d22;
                    d23 = d22 * d22 * a(d[j3], d16, d17);
                }
                ad[k++] += 70D * (d19 + d21 + d23) * d5;
            }

        }

    }

}

