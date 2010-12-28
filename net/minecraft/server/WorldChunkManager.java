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

    protected WorldChunkManager() {}

    public WorldChunkManager(World world) {
        e = new NoiseGeneratorOctaves2(new Random(world.u * 9871L), 4);
        f = new NoiseGeneratorOctaves2(new Random(world.u * 39811L), 4);
        g = new NoiseGeneratorOctaves2(new Random(world.u * 0x84a59L), 2);
    }

    public MobSpawnerBase a(ChunkCoordIntPair chunkcoordintpair) {
        return a(chunkcoordintpair.a, chunkcoordintpair.b);
    }

    public MobSpawnerBase a(int i, int j) {
        return a(i, j, 1, 1)[0];
    }

    public MobSpawnerBase[] a(int i, int j, int k, int l) {
        d = a(d, i, j, k, l);
        return d;
    }

    public double[] a(double ad[], int i, int j, int k, int l) {
        if (ad == null || ad.length < k * l) {
            ad = new double[k * l];
        }
        ad = e.a(ad, i, j, k, k, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        c = g.a(c, i, j, k, k, 0.25D, 0.25D, 0.58823529411764708D);
        int i1 = 0;

        for (int j1 = 0; j1 < k; j1++) {
            for (int k1 = 0; k1 < l; k1++) {
                double d1 = c[i1] * 1.1000000000000001D + 0.5D;
                double d2 = 0.01D;
                double d3 = 1.0D - d2;
                double d4 = (ad[i1] * 0.14999999999999999D + 0.69999999999999996D) * d3 + d1 * d2;

                d4 = 1.0D - (1.0D - d4) * (1.0D - d4);
                if (d4 < 0.0D) {
                    d4 = 0.0D;
                }
                if (d4 > 1.0D) {
                    d4 = 1.0D;
                }
                ad[i1] = d4;
                i1++;
            }

        }

        return ad;
    }

    public MobSpawnerBase[] a(MobSpawnerBase amobspawnerbase[], int i, int j, int k, int l) {
        if (amobspawnerbase == null || amobspawnerbase.length < k * l) {
            amobspawnerbase = new MobSpawnerBase[k * l];
        }
        a = e.a(a, i, j, k, k, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        b = f.a(b, i, j, k, k, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
        c = g.a(c, i, j, k, k, 0.25D, 0.25D, 0.58823529411764708D);
        int i1 = 0;

        for (int j1 = 0; j1 < k; j1++) {
            for (int k1 = 0; k1 < l; k1++) {
                double d1 = c[i1] * 1.1000000000000001D + 0.5D;
                double d2 = 0.01D;
                double d3 = 1.0D - d2;
                double d4 = (a[i1] * 0.14999999999999999D + 0.69999999999999996D) * d3 + d1 * d2;

                d2 = 0.002D;
                d3 = 1.0D - d2;
                double d5 = (b[i1] * 0.14999999999999999D + 0.5D) * d3 + d1 * d2;

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
                a[i1] = d4;
                b[i1] = d5;
                amobspawnerbase[i1++] = MobSpawnerBase.a(d4, d5);
            }

        }

        return amobspawnerbase;
    }
}

