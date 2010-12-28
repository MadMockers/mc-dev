package net.minecraft.server;


import java.io.File;


public class WorldProvider {

    public World a;
    public WorldChunkManager b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float f[];
    public int g;
    private float h[];

    public WorldProvider() {
        c = false;
        d = false;
        e = false;
        f = new float[16];
        g = 0;
        h = new float[4];
    }

    public final void a(World world) {
        a = world;
        a();
        b();
    }

    protected void b() {
        float f1 = 0.05F;

        for (int i = 0; i <= 15; i++) {
            float f2 = 1.0F - (float) i / 15F;

            f[i] = ((1.0F - f2) / (f2 * 3F + 1.0F)) * (1.0F - f1) + f1;
        }

    }

    protected void a() {
        b = new WorldChunkManager(a);
    }

    public IChunkProvider c() {
        return new ChunkProviderGenerate(a, a.u);
    }

    public IChunkLoader a(File file) {
        return new ChunkLoader(file, true);
    }

    public boolean a(int i, int j) {
        int k = a.a(i, j);

        return k == Block.E.bh;
    }

    public float a(long l, float f1) {
        int i = (int) (l % 24000L);
        float f2 = ((float) i + f1) / 24000F - 0.25F;

        if (f2 < 0.0F) {
            f2++;
        }
        if (f2 > 1.0F) {
            f2--;
        }
        float f3 = f2;

        f2 = 1.0F - (float) ((Math.cos((double) f2 * 3.1415926535897931D) + 1.0D) / 2D);
        f2 = f3 + (f2 - f3) / 3F;
        return f2;
    }

    public static WorldProvider a(int i) {
        if (i == 0) {
            return new WorldProvider();
        }
        if (i == -1) {
            return new WorldProviderHell();
        } else {
            return null;
        }
    }
}

