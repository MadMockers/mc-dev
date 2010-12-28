package net.minecraft.server;


import java.util.Random;


public class MapGenBase {

    protected int a;
    protected Random b;

    public MapGenBase() {
        a = 8;
        b = new Random();
    }

    public void a(IChunkProvider ichunkprovider, World world, int i, int j, byte abyte0[]) {
        int k = a;

        b.setSeed(world.u);
        long l = (b.nextLong() / 2L) * 2L + 1L;
        long l1 = (b.nextLong() / 2L) * 2L + 1L;

        for (int i1 = i - k; i1 <= i + k; i1++) {
            for (int j1 = j - k; j1 <= j + k; j1++) {
                b.setSeed((long) i1 * l + (long) j1 * l1 ^ world.u);
                a(world, i1, j1, i, j, abyte0);
            }

        }

    }

    protected void a(World world, int i, int j, int k, int l, byte abyte0[]) {}
}

