package net.minecraft.server;


import java.util.Random;


public class ChunkProviderGenerate
        implements IChunkProvider {

    private Random j;
    private NoiseGeneratorOctaves k;
    private NoiseGeneratorOctaves l;
    private NoiseGeneratorOctaves m;
    private NoiseGeneratorOctaves n;
    private NoiseGeneratorOctaves o;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    public NoiseGeneratorOctaves c;
    private World p;
    private double q[];
    private double r[];
    private double s[];
    private double t[];
    private MapGenBase u;
    private MobSpawnerBase v[];
    double d[];
    double e[];
    double f[];
    double g[];
    double h[];
    int i[][];
    private double w[];

    public ChunkProviderGenerate(World world, long l1) {
        r = new double[256];
        s = new double[256];
        t = new double[256];
        u = new MapGenCaves();
        i = new int[32][32];
        p = world;
        j = new Random(l1);
        k = new NoiseGeneratorOctaves(j, 16);
        l = new NoiseGeneratorOctaves(j, 16);
        m = new NoiseGeneratorOctaves(j, 8);
        n = new NoiseGeneratorOctaves(j, 4);
        o = new NoiseGeneratorOctaves(j, 4);
        a = new NoiseGeneratorOctaves(j, 10);
        b = new NoiseGeneratorOctaves(j, 16);
        c = new NoiseGeneratorOctaves(j, 8);
    }

    public void a(int i1, int j1, byte abyte0[], MobSpawnerBase amobspawnerbase[], double ad[]) {
        byte byte0 = 4;
        byte byte1 = 64;
        int k1 = byte0 + 1;
        byte byte2 = 17;
        int l1 = byte0 + 1;

        q = a(q, i1 * byte0, 0, j1 * byte0, k1, byte2, l1);
        for (int i2 = 0; i2 < byte0; i2++) {
            for (int j2 = 0; j2 < byte0; j2++) {
                for (int k2 = 0; k2 < 16; k2++) {
                    double d1 = 0.125D;
                    double d2 = q[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d3 = q[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d4 = q[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d5 = q[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d6 = (q[((i2 + 0) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d2) * d1;
                    double d7 = (q[((i2 + 0) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d3) * d1;
                    double d8 = (q[((i2 + 1) * l1 + (j2 + 0)) * byte2 + (k2 + 1)] - d4) * d1;
                    double d9 = (q[((i2 + 1) * l1 + (j2 + 1)) * byte2 + (k2 + 1)] - d5) * d1;

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
                                double d18 = ad[(i2 * 4 + i3) * 16 + (j2 * 4 + k3)];
                                int l3 = 0;

                                if (k2 * 8 + l2 < byte1) {
                                    if (d18 < 0.5D && k2 * 8 + l2 >= byte1 - 1) {
                                        l3 = Block.aU.bi;
                                    } else {
                                        l3 = Block.C.bi;
                                    }
                                }
                                if (d16 > 0.0D) {
                                    l3 = Block.u.bi;
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

    public void a(int i1, int j1, byte abyte0[], MobSpawnerBase amobspawnerbase[]) {
        byte byte0 = 64;
        double d1 = 0.03125D;

        r = n.a(r, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1, d1, 1.0D);
        s = n.a(s, j1 * 16, 109.0134D, i1 * 16, 16, 1, 16, d1, 1.0D, d1);
        t = o.a(t, i1 * 16, j1 * 16, 0.0D, 16, 16, 1, d1 * 2D, d1 * 2D, d1 * 2D);
        for (int k1 = 0; k1 < 16; k1++) {
            for (int l1 = 0; l1 < 16; l1++) {
                MobSpawnerBase mobspawnerbase = amobspawnerbase[k1 * 16 + l1];
                boolean flag = r[k1 + l1 * 16] + j.nextDouble() * 0.20000000000000001D > 0.0D;
                boolean flag1 = s[k1 + l1 * 16] + j.nextDouble() * 0.20000000000000001D > 3D;
                int i2 = (int) (t[k1 + l1 * 16] / 3D + 3D + j.nextDouble() * 0.25D);
                int j2 = -1;
                byte byte1 = mobspawnerbase.o;
                byte byte2 = mobspawnerbase.p;

                for (int k2 = 127; k2 >= 0; k2--) {
                    int l2 = (k1 * 16 + l1) * 128 + k2;

                    if (k2 <= 0 + j.nextInt(5)) {
                        abyte0[l2] = (byte) Block.A.bi;
                        continue;
                    }
                    byte byte3 = abyte0[l2];

                    if (byte3 == 0) {
                        j2 = -1;
                        continue;
                    }
                    if (byte3 != Block.u.bi) {
                        continue;
                    }
                    if (j2 == -1) {
                        if (i2 <= 0) {
                            byte1 = 0;
                            byte2 = (byte) Block.u.bi;
                        } else if (k2 >= byte0 - 4 && k2 <= byte0 + 1) {
                            byte1 = mobspawnerbase.o;
                            byte2 = mobspawnerbase.p;
                            if (flag1) {
                                byte1 = 0;
                            }
                            if (flag1) {
                                byte2 = (byte) Block.G.bi;
                            }
                            if (flag) {
                                byte1 = (byte) Block.F.bi;
                            }
                            if (flag) {
                                byte2 = (byte) Block.F.bi;
                            }
                        }
                        if (k2 < byte0 && byte1 == 0) {
                            byte1 = (byte) Block.C.bi;
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
        j.setSeed((long) i1 * 0x4f9939f508L + (long) j1 * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        Chunk chunk = new Chunk(p, abyte0, i1, j1);

        v = p.a().a(v, i1 * 16, j1 * 16, 16, 16);
        double ad[] = p.a().a;

        a(i1, j1, abyte0, v, ad);
        a(i1, j1, abyte0, v);
        u.a(this, p, i1, j1, abyte0);
        chunk.b();
        return chunk;
    }

    private double[] a(double ad[], int i1, int j1, int k1, int l1, int i2, int j2) {
        if (ad == null) {
            ad = new double[l1 * i2 * j2];
        }
        double d1 = 684.41200000000003D;
        double d2 = 684.41200000000003D;
        double ad1[] = p.a().a;
        double ad2[] = p.a().b;

        g = a.a(g, i1, k1, l1, j2, 1.121D, 1.121D, 0.5D);
        h = b.a(h, i1, k1, l1, j2, 200D, 200D, 0.5D);
        d = m.a(d, i1, j1, k1, l1, i2, j2, d1 / 80D, d2 / 160D, d1 / 80D);
        e = k.a(e, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        f = l.a(f, i1, j1, k1, l1, i2, j2, d1, d2, d1);
        int k2 = 0;
        int l2 = 0;
        int i3 = 16 / l1;

        for (int j3 = 0; j3 < l1; j3++) {
            int k3 = j3 * i3 + i3 / 2;

            for (int l3 = 0; l3 < j2; l3++) {
                int i4 = l3 * i3 + i3 / 2;
                double d3 = ad1[k3 * 16 + i4];
                double d4 = ad2[k3 * 16 + i4] * d3;
                double d5 = 1.0D - d4;

                d5 *= d5;
                d5 *= d5;
                d5 = 1.0D - d5;
                double d6 = (g[l2] + 256D) / 512D;

                d6 *= d5;
                if (d6 > 1.0D) {
                    d6 = 1.0D;
                }
                double d7 = h[l2] / 8000D;

                if (d7 < 0.0D) {
                    d7 = -d7 * 0.29999999999999999D;
                }
                d7 = d7 * 3D - 2D;
                if (d7 < 0.0D) {
                    d7 /= 2D;
                    if (d7 < -1D) {
                        d7 = -1D;
                    }
                    d7 /= 1.3999999999999999D;
                    d7 /= 2D;
                    d6 = 0.0D;
                } else {
                    if (d7 > 1.0D) {
                        d7 = 1.0D;
                    }
                    d7 /= 8D;
                }
                if (d6 < 0.0D) {
                    d6 = 0.0D;
                }
                d6 += 0.5D;
                d7 = (d7 * (double) i2) / 16D;
                double d8 = (double) i2 / 2D + d7 * 4D;

                l2++;
                for (int j4 = 0; j4 < i2; j4++) {
                    double d9 = 0.0D;
                    double d10 = (((double) j4 - d8) * 12D) / d6;

                    if (d10 < 0.0D) {
                        d10 *= 4D;
                    }
                    double d11 = e[k2] / 512D;
                    double d12 = f[k2] / 512D;
                    double d13 = (d[k2] / 10D + 1.0D) / 2D;

                    if (d13 < 0.0D) {
                        d9 = d11;
                    } else if (d13 > 1.0D) {
                        d9 = d12;
                    } else {
                        d9 = d11 + (d12 - d11) * d13;
                    }
                    d9 -= d10;
                    if (j4 > i2 - 4) {
                        double d14 = (float) (j4 - (i2 - 4)) / 3F;

                        d9 = d9 * (1.0D - d14) + -10D * d14;
                    }
                    ad[k2] = d9;
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
        MobSpawnerBase mobspawnerbase = p.a().a(k1 + 16, l1 + 16);

        j.setSeed(p.u);
        long l2 = (j.nextLong() / 2L) * 2L + 1L;
        long l3 = (j.nextLong() / 2L) * 2L + 1L;

        j.setSeed((long) i1 * l2 + (long) j1 * l3 ^ p.u);
        double d1 = 0.25D;

        for (int i2 = 0; i2 < 8; i2++) {
            int i5 = k1 + j.nextInt(16) + 8;
            int k7 = j.nextInt(128);
            int l9 = l1 + j.nextInt(16) + 8;

            (new WorldGenDungeons()).a(p, j, i5, k7, l9);
        }

        for (int j2 = 0; j2 < 10; j2++) {
            int j5 = k1 + j.nextInt(16);
            int l7 = j.nextInt(128);
            int i10 = l1 + j.nextInt(16);

            (new WorldGenClay(32)).a(p, j, j5, l7, i10);
        }

        for (int k2 = 0; k2 < 20; k2++) {
            int k5 = k1 + j.nextInt(16);
            int i8 = j.nextInt(128);
            int j10 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.w.bi, 32)).a(p, j, k5, i8, j10);
        }

        for (int i3 = 0; i3 < 10; i3++) {
            int l5 = k1 + j.nextInt(16);
            int j8 = j.nextInt(128);
            int k10 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.G.bi, 32)).a(p, j, l5, j8, k10);
        }

        for (int j3 = 0; j3 < 20; j3++) {
            int i6 = k1 + j.nextInt(16);
            int k8 = j.nextInt(128);
            int l10 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.J.bi, 16)).a(p, j, i6, k8, l10);
        }

        for (int k3 = 0; k3 < 20; k3++) {
            int j6 = k1 + j.nextInt(16);
            int l8 = j.nextInt(64);
            int i11 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.I.bi, 8)).a(p, j, j6, l8, i11);
        }

        for (int i4 = 0; i4 < 2; i4++) {
            int k6 = k1 + j.nextInt(16);
            int i9 = j.nextInt(32);
            int j11 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.H.bi, 8)).a(p, j, k6, i9, j11);
        }

        for (int j4 = 0; j4 < 8; j4++) {
            int l6 = k1 + j.nextInt(16);
            int j9 = j.nextInt(16);
            int k11 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.aO.bi, 7)).a(p, j, l6, j9, k11);
        }

        for (int k4 = 0; k4 < 1; k4++) {
            int i7 = k1 + j.nextInt(16);
            int k9 = j.nextInt(16);
            int l11 = l1 + j.nextInt(16);

            (new WorldGenMinable(Block.ax.bi, 7)).a(p, j, i7, k9, l11);
        }

        d1 = 0.5D;
        int l4 = (int) ((c.a((double) k1 * d1, (double) l1 * d1) / 8D + j.nextDouble() * 4D + 4D) / 3D);
        int j7 = 0;

        if (j.nextInt(10) == 0) {
            j7++;
        }
        if (mobspawnerbase == MobSpawnerBase.d) {
            j7 += l4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.a) {
            j7 += l4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.c) {
            j7 += l4 + 2;
        }
        if (mobspawnerbase == MobSpawnerBase.g) {
            j7 += l4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.h) {
            j7 -= 20;
        }
        if (mobspawnerbase == MobSpawnerBase.k) {
            j7 -= 20;
        }
        if (mobspawnerbase == MobSpawnerBase.i) {
            j7 -= 20;
        }
        Object obj = new WorldGenTrees();

        if (j.nextInt(10) == 0) {
            obj = new WorldGenBigTree();
        }
        if (mobspawnerbase == MobSpawnerBase.a && j.nextInt(3) == 0) {
            obj = new WorldGenBigTree();
        }
        for (int i12 = 0; i12 < j7; i12++) {
            int i14 = k1 + j.nextInt(16) + 8;
            int l16 = l1 + j.nextInt(16) + 8;

            ((WorldGenerator) (obj)).a(1.0D, 1.0D, 1.0D);
            ((WorldGenerator) (obj)).a(p, j, i14, p.d(i14, l16), l16);
        }

        for (int j12 = 0; j12 < 2; j12++) {
            int j14 = k1 + j.nextInt(16) + 8;
            int i17 = j.nextInt(128);
            int k19 = l1 + j.nextInt(16) + 8;

            (new WorldGenFlowers(Block.ae.bi)).a(p, j, j14, i17, k19);
        }

        if (j.nextInt(2) == 0) {
            int k12 = k1 + j.nextInt(16) + 8;
            int k14 = j.nextInt(128);
            int j17 = l1 + j.nextInt(16) + 8;

            (new WorldGenFlowers(Block.af.bi)).a(p, j, k12, k14, j17);
        }
        if (j.nextInt(4) == 0) {
            int l12 = k1 + j.nextInt(16) + 8;
            int l14 = j.nextInt(128);
            int k17 = l1 + j.nextInt(16) + 8;

            (new WorldGenFlowers(Block.ag.bi)).a(p, j, l12, l14, k17);
        }
        if (j.nextInt(8) == 0) {
            int i13 = k1 + j.nextInt(16) + 8;
            int i15 = j.nextInt(128);
            int l17 = l1 + j.nextInt(16) + 8;

            (new WorldGenFlowers(Block.ah.bi)).a(p, j, i13, i15, l17);
        }
        for (int j13 = 0; j13 < 10; j13++) {
            int j15 = k1 + j.nextInt(16) + 8;
            int i18 = j.nextInt(128);
            int l19 = l1 + j.nextInt(16) + 8;

            (new WorldGenReed()).a(p, j, j15, i18, l19);
        }

        if (j.nextInt(32) == 0) {
            int k13 = k1 + j.nextInt(16) + 8;
            int k15 = j.nextInt(128);
            int j18 = l1 + j.nextInt(16) + 8;

            (new WorldGenPumpkin()).a(p, j, k13, k15, j18);
        }
        int l13 = 0;

        if (mobspawnerbase == MobSpawnerBase.h) {
            l13 += 10;
        }
        for (int l15 = 0; l15 < l13; l15++) {
            int k18 = k1 + j.nextInt(16) + 8;
            int i20 = j.nextInt(128);
            int i21 = l1 + j.nextInt(16) + 8;

            (new WorldGenCactus()).a(p, j, k18, i20, i21);
        }

        for (int i16 = 0; i16 < 50; i16++) {
            int l18 = k1 + j.nextInt(16) + 8;
            int j20 = j.nextInt(j.nextInt(120) + 8);
            int j21 = l1 + j.nextInt(16) + 8;

            (new WorldGenLiquids(Block.B.bi)).a(p, j, l18, j20, j21);
        }

        for (int j16 = 0; j16 < 20; j16++) {
            int i19 = k1 + j.nextInt(16) + 8;
            int k20 = j.nextInt(j.nextInt(j.nextInt(112) + 8) + 8);
            int k21 = l1 + j.nextInt(16) + 8;

            (new WorldGenLiquids(Block.D.bi)).a(p, j, i19, k20, k21);
        }

        w = p.a().a(w, k1 + 8, l1 + 8, 16, 16);
        for (int k16 = k1 + 8; k16 < k1 + 8 + 16; k16++) {
            for (int j19 = l1 + 8; j19 < l1 + 8 + 16; j19++) {
                int l20 = k16 - (k1 + 8);
                int l21 = j19 - (l1 + 8);
                int i22 = p.e(k16, j19);
                double d2 = w[l20 * 16 + l21] - ((double) (i22 - 64) / 64D) * 0.29999999999999999D;

                if (d2 < 0.5D && i22 > 0 && i22 < 128 && p.a(k16, i22, j19) == 0 && p.c(k16, i22 - 1, j19).c() && p.c(k16, i22 - 1, j19) != Material.r) {
                    p.d(k16, i22, j19, Block.aT.bi);
                }
            }

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

