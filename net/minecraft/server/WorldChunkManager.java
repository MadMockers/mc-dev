package net.minecraft.server;


import java.util.Random;


public class WorldChunkManager {

    private NoiseGeneratorOctaves2 e;
    private NoiseGeneratorOctaves2 f;
    private NoiseGeneratorOctaves2 g;
    public double a[];
    public double b[];
    public double c[];
    public MobSpawnerBase d[];
    private static double h = 0.5D;
    private static double i = 0.5D;

    protected WorldChunkManager() {}

    public WorldChunkManager(World world) {
        e = new NoiseGeneratorOctaves2(new Random(world.u * 9871L), 4);
        f = new NoiseGeneratorOctaves2(new Random(world.u * 39811L), 4);
        g = new NoiseGeneratorOctaves2(new Random(world.u * 0x84a59L), 2);
    }

    public MobSpawnerBase a(ChunkCoordIntPair chunkcoordintpair) {
        return a(chunkcoordintpair.a, chunkcoordintpair.b);
    }

    public MobSpawnerBase a(int j, int k) {
        return a(j, k, 1, 1)[0];
    }

    public MobSpawnerBase[] a(int j, int k, int l, int i1) {
        d = a(d, j, k, l, i1);
        return d;
    }

    public double[] a(double ad[], int j, int k, int l, int i1) {
        if (ad == null || ad.length < l * i1) {
            ad = new double[l * i1];
        }
        ad = e.a(ad, j, k, l, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        c = g.a(c, j, k, l, l, 0.25D, 0.25D, 0.58823529411764708D);
        int j1 = 0;

        for (int k1 = 0; k1 < l; k1++) {
            for (int l1 = 0; l1 < i1; l1++) {
                double d1 = c[j1] * 1.1000000000000001D + 0.5D;
                double d2 = 0.01D;
                double d3 = 1.0D - d2;
                double d4 = (ad[j1] * 0.14999999999999999D + 0.69999999999999996D) * d3 + d1 * d2;

                d4 = 1.0D - (1.0D - d4) * (1.0D - d4);
                if (d4 < 0.0D) {
                    d4 = 0.0D;
                }
                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }
                ad[j1] = d4;
                j1++;
            }

        }

        return ad;
    }

    public MobSpawnerBase[] a(MobSpawnerBase amobspawnerbase[], int j, int k, int l, int i1) {
        if (amobspawnerbase == null || amobspawnerbase.length < l * i1) {
            amobspawnerbase = new MobSpawnerBase[l * i1];
        }
        a = e.a(a, j, k, l, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        b = f.a(b, j, k, l, l, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
        c = g.a(c, j, k, l, l, 0.25D, 0.25D, 0.58823529411764708D);
        int j1 = 0;

        for (int k1 = 0; k1 < l; k1++) {
            for (int l1 = 0; l1 < i1; l1++) {
                double d1 = c[j1] * 1.1000000000000001D + 0.5D;
                double d2 = 0.01D;
                double d3 = 1.0D - d2;
                double d4 = (a[j1] * 0.14999999999999999D + 0.69999999999999996D) * d3 + d1 * d2;

                d2 = 0.002D;
                d3 = 1.0D - d2;
                double d5 = (b[j1] * 0.14999999999999999D + 0.5D) * d3 + d1 * d2;

                d4 = 1.0D - (1.0D - d4) * (1.0D - d4);
                if (d4 < 0.0D) {
                    d4 = 0.0D;
                }
                if (d5 < 0.0D) {
                    d5 = 0.0D;
                }
                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }
                if (d5 > 1.0D) {
                    d5 = 1.0D;
                }
                a[j1] = d4;
                b[j1] = d5;
                amobspawnerbase[j1++] = MobSpawnerBase.a(d4, d5);
            }

        }

        return amobspawnerbase;
    }

}

