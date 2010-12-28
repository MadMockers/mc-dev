package net.minecraft.server;


import java.util.Arrays;


public class WorldChunkManagerHell extends WorldChunkManager {

    private MobSpawnerBase e;
    private double f;
    private double g;

    public WorldChunkManagerHell(MobSpawnerBase mobspawnerbase, double d, double d1) {
        e = mobspawnerbase;
        f = d;
        g = d1;
    }

    public MobSpawnerBase a(ChunkCoordIntPair chunkcoordintpair) {
        return e;
    }

    public MobSpawnerBase a(int i, int j) {
        return e;
    }

    public MobSpawnerBase[] a(int i, int j, int k, int l) {
        d = a(d, i, j, k, l);
        return d;
    }

    public double[] a(double ad[], int i, int j, int k, int l) {
        if (ad == null || ad.length < k * l) {
            ad = new double[k * l];
        }
        Arrays.fill(ad, 0, k * l, f);
        return ad;
    }

    public MobSpawnerBase[] a(MobSpawnerBase amobspawnerbase[], int i, int j, int k, int l) {
        if (amobspawnerbase == null || amobspawnerbase.length < k * l) {
            amobspawnerbase = new MobSpawnerBase[k * l];
            a = new double[k * l];
            b = new double[k * l];
        }
        Arrays.fill(amobspawnerbase, 0, k * l, e);
        Arrays.fill(b, 0, k * l, g);
        Arrays.fill(a, 0, k * l, f);
        return amobspawnerbase;
    }
}

