package net.minecraft.server;


import java.util.Random;


public class ChunkProviderHell
        implements IChunkProvider {

    private Random h;
    private NoiseGeneratorOctaves i;
    private NoiseGeneratorOctaves j;
    private NoiseGeneratorOctaves k;
    private NoiseGeneratorOctaves l;
    private NoiseGeneratorOctaves m;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    private World n;
    private double o[];
    private double p[];
    private double q[];
    private double r[];
    private MapGenBase s;
    double c[];
    double d[];
    double e[];
    double f[];
    double g[];

    public ChunkProviderHell(World world, long l1) {
        p = new double[256];
        q = new double[256];
        r = new double[256];
        s = new MapGenCavesHell();
        n = world;
        h = new Random(l1);
        i = new NoiseGeneratorOctaves(h, 16);
        j = new NoiseGeneratorOctaves(h, 16);
        k = new NoiseGeneratorOctaves(h, 8);
        l = new NoiseGeneratorOctaves(h, 4);
        m = new NoiseGeneratorOctaves(h, 4);
        a = new NoiseGeneratorOctaves(h, 10);
        b = new NoiseGeneratorOctaves(h, 16);
    }

    public void a(int i1, int j1, byte abyte0[]) {
        byte byte0 = 4;
        byte byte1 = 32;
        int k1 = byte0 + 1;
        byte byte2 = 17;
        int l1 = byte0 + 1;

        o = a(o, i1 * byte0, 0, j1 * byte0, k1, byte2, l1);
        for (int i2 = 0; i2 < byte0; i2++) {
            for (int j2 = 0; j2 < byte0; j2++) {
                for (int k2 = 0; k2 < 16; k2++) {
                    double d1 = 0.125D;
                    double d2 = o[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d3 = o[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d4 = o[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d5 = o[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d6 = (o[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d2) * d1;
                    double d7 = (o[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d3) * d1;
                    double d8 = (o[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d4) * d1;
                    double d9 = (o[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d5) * d1;

                    for (int l2 = 0; l2 < 8; l2++) {
                        double d10 = 0.25D;
                        double d11 = d2;
                        double d12 = d3;
                        double d13 = (d4 - d2) * d10;
                        double d14 = (d5 - d3) * d10;

                        for (int i3 = 0; i3 < 4; i3++) {
                            int j3 = i3 + i2 * 4 << 11 | 0 + j2 * 4 << 7 | k2 * 8 + l2;
                            char c1 = '\200';
                            double d15 = 0.25D;
                            double d16 = d11;
                            double d17 = (d12 - d11) * d15;

                            for (int k3 = 0; k3 < 4; k3++) {
                                int l3 = 0;

                                if (k2 * 8 + l2 < byte1) {
                                    l3 = Block.D.bh;
                                }
                                if (d16 > 0.0D) {
                                    l3 = Block.bb.bh;
                                }
                                abyte0[j3] = (byte) l3;
                                j3 += c1;
                                d16 += d17;
                            }

                            d11 += d13;
                            d12 += d14;
                        }

                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }

                }

            }

        }

    }

    public void b(int i1, int j1, byte abyte0[]) {
        byte byte0 = 64;
        double d1 = 0.03125D;

        p = l.a(p, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1, d1, 1.0D);
        q = l.a(q, j1 * 16, 109.0134D, i1 * 16, 16, 1, 16, d1, 1.0D, d1);
        r = m.a(r, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1 * 2D, d1 * 2D, d1 * 2D);
        for (int k1 = 0; k1 < 16; k1++) {
            for (int l1 = 0; l1 < 16; l1++) {
                boolean flag = p[k1 + l1 * 16] + h.nextDouble() * 0.20000000000000001D > 0.0D;
                boolean flag1 = q[k1 + l1 * 16] + h.nextDouble() * 0.20000000000000001D > 0.0D;
                int i2 = (int) (r[k1 + l1 * 16] / 3D + 3D + h.nextDouble() * 0.25D);
                int j2 = -1;
                byte byte1 = (byte) Block.bb.bh;
                byte byte2 = (byte) Block.bb.bh;

                for (int k2 = 127; k2 >= 0; k2--) {
                    int l2 = (k1 * 16 + l1) * 128 + k2;

                    if (k2 >= 127 - h.nextInt(5)) {
                        abyte0[l2] = (byte) Block.z.bh;
                        continue;
                    }
                    if (k2 <= 0 + h.nextInt(5)) {
                        abyte0[l2] = (byte) Block.z.bh;
                        continue;
                    }
                    byte byte3 = abyte0[l2];

                    if (byte3 == 0) {
                        j2 = -1;
                        continue;
                    }
                    if (byte3 != Block.bb.bh) {
                        continue;
                    }
                    if (j2 == -1) {
                        if (i2 <= 0) {
                            byte1 = 0;
                            byte2 = (byte) Block.bb.bh;
                        } else if (k2 >= byte0 - 4 && k2 <= byte0 + 1) {
                            byte1 = (byte) Block.bb.bh;
                            byte2 = (byte) Block.bb.bh;
                            if (flag1) {
                                byte1 = (byte) Block.F.bh;
                            }
                            if (flag1) {
                                byte2 = (byte) Block.bb.bh;
                            }
                            if (flag) {
                                byte1 = (byte) Block.bc.bh;
                            }
                            if (flag) {
                                byte2 = (byte) Block.bc.bh;
                            }
                        }
                        if (k2 < byte0 && byte1 == 0) {
                            byte1 = (byte) Block.D.bh;
                        }
                        j2 = i2;
                        if (k2 >= byte0 - 1) {
                            abyte0[l2] = byte1;
                        } else {
                            abyte0[l2] = byte2;
                        }
                        continue;
                    }
                    if (j2 > 0) {
                        j2--;
                        abyte0[l2] = byte2;
                    }
                }

            }

        }

    }

    public Chunk b(int i1, int j1) {
        h.setSeed((long) i1 * 0x4f9939f508L + (long) j1 * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];

        a(i1, j1, abyte0);
        b(i1, j1, abyte0);
        s.a(this, n, i1, j1, abyte0);
        Chunk chunk = new Chunk(n, abyte0, i1, j1);

        chunk.b();
        chunk.c();
        return chunk;
    }

    private double[] a(double ad[], int i1, int j1, int k1, int l1, int i2, int j2) {
        if (ad == null) {
            ad = new double[l1 * i2 * j2];
        }
        double d1 = 684.41200000000003D;
        double d2 = 2053.2359999999999D;

        f = a.a(f, i1, j1, k1, l1, 1, j2, 1.0D, 0.0D, 1.0D);
        g = b.a(g, i1, j1, k1, l1, 1, j2, 100D, 0.0D, 100D);
        c = k.a(c, i1, j1, k1, l1, i2, j2, d1 / 80D, d2 / 60D, d1 / 80D);
        d = i.a(d, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        e = j.a(e, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        int k2 = 0;
        int l2 = 0;
        double ad1[] = new double[i2];

        for (int i3 = 0; i3 < i2; i3++) {
            ad1[i3] = Math.cos(((double) i3 * 3.1415926535897931D * 6D) / (double) i2) * 2D;
            double d3 = i3;

            if (i3 > i2 / 2) {
                d3 = i2 - 1 - i3;
            }
            if (d3 < 4D) {
                d3 = 4D - d3;
                ad1[i3] -= d3 * d3 * d3 * 10D;
            }
        }

        for (int j3 = 0; j3 < l1; j3++) {
            for (int k3 = 0; k3 < j2; k3++) {
                double d4 = (f[l2] + 256D) / 512D;

                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }
                double d5 = 0.0D;
                double d6 = g[l2] / 8000D;

                if (d6 < 0.0D) {
                    d6 = -d6;
                }
                d6 = d6 * 3D - 3D;
                if (d6 < 0.0D) {
                    d6 /= 2D;
                    if (d6 < -1D) {
                        d6 = -1D;
                    }
                    d6 /= 1.3999999999999999D;
                    d6 /= 2D;
                    d4 = 0.0D;
                } else {
                    if (d6 > 1.0D) {
                        d6 = 1.0D;
                    }
                    d6 /= 6D;
                }
                d4 += 0.5D;
                d6 = (d6 * (double) i2) / 16D;
                l2++;
                for (int l3 = 0; l3 < i2; l3++) {
                    double d7 = 0.0D;
                    double d8 = ad1[l3];
                    double d9 = d[k2] / 512D;
                    double d10 = e[k2] / 512D;
                    double d11 = (c[k2] / 10D + 1.0D) / 2D;

                    if (d11 < 0.0D) {
                        d7 = d9;
                    } else if (d11 > 1.0D) {
                        d7 = d10;
                    } else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (l3 > i2 - 4) {
                        double d12 = (float) (l3 - (i2 - 4)) / 3F;

                        d7 = d7 * (1.0D - d12) + -10D * d12;
                    }
                    if ((double) l3 < d5) {
                        double d13 = (d5 - (double) l3) / 4D;

                        if (d13 < 0.0D) {
                            d13 = 0.0D;
                        }
                        if (d13 > 1.0D) {
                            d13 = 1.0D;
                        }
                        d7 = d7 * (1.0D - d13) + -10D * d13;
                    }
                    ad[k2] = d7;
                    k2++;
                }

            }

        }

        return ad;
    }

    public boolean a(int i1, int j1) {
        return true;
    }

    public void a(IChunkProvider ichunkprovider, int i1, int j1) {
        BlockSand.a = true;
        int k1 = i1 * 16;
        int l1 = j1 * 16;

        for (int i2 = 0; i2 < 8; i2++) {
            int k2 = k1 + h.nextInt(16) + 8;
            int i4 = h.nextInt(120) + 4;
            int k5 = l1 + h.nextInt(16) + 8;

            (new WorldGenHellLava(Block.C.bh)).a(n, h, k2, i4, k5);
        }

        int j2 = h.nextInt(h.nextInt(10) + 1) + 1;

        for (int l2 = 0; l2 < j2; l2++) {
            int j4 = k1 + h.nextInt(16) + 8;
            int l5 = h.nextInt(120) + 4;
            int i7 = l1 + h.nextInt(16) + 8;

            (new WorldGenFire()).a(n, h, j4, l5, i7);
        }

        j2 = h.nextInt(h.nextInt(10) + 1);
        for (int i3 = 0; i3 < j2; i3++) {
            int k4 = k1 + h.nextInt(16) + 8;
            int i6 = h.nextInt(120) + 4;
            int j7 = l1 + h.nextInt(16) + 8;

            (new WorldGenLightStone1()).a(n, h, k4, i6, j7);
        }

        for (int j3 = 0; j3 < 10; j3++) {
            int l4 = k1 + h.nextInt(16) + 8;
            int j6 = h.nextInt(128);
            int k7 = l1 + h.nextInt(16) + 8;

            (new WorldGenLightStone2()).a(n, h, l4, j6, k7);
        }

        if (h.nextInt(1) == 0) {
            int k3 = k1 + h.nextInt(16) + 8;
            int i5 = h.nextInt(128);
            int k6 = l1 + h.nextInt(16) + 8;

            (new WorldGenFlowers(Block.af.bh)).a(n, h, k3, i5, k6);
        }
        if (h.nextInt(1) == 0) {
            int l3 = k1 + h.nextInt(16) + 8;
            int j5 = h.nextInt(128);
            int l6 = l1 + h.nextInt(16) + 8;

            (new WorldGenFlowers(Block.ag.bh)).a(n, h, l3, j5, l6);
        }
        BlockSand.a = false;
    }

    public boolean a(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }
}

