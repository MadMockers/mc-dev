package net.minecraft.server;


import java.io.File;


public class WorldProviderHell extends WorldProvider {

    public WorldProviderHell() {}

    public void a() {
        b = new WorldChunkManagerHell(MobSpawnerBase.l, 1.0D, 0.0D);
        c = true;
        e = -1;
    }

    protected void b() {
        float f = 0.1F;

        for (int i = 0; i <= 15; i++) {
            float f1 = 1.0F - (float) i / 15F;

            d[i] = ((1.0F - f1) / (f1 * 3F + 1.0F)) * (1.0F - f) + f;
        }

    }

    public IChunkProvider c() {
        return new ChunkProviderHell(a, a.u);
    }

    public IChunkLoader a(File file) {
        File file1 = new File(file, "DIM-1");

        file1.mkdirs();
        return new ChunkLoader(file1, true);
    }

    public boolean a(int i, int j) {
        int k = a.a(i, j);

        if (k == Block.A.bi) {
            return false;
        }
        if (k == 0) {
            return false;
        }
        return Block.p[k];
    }

    public float a(long l, float f) {
        return 0.5F;
    }
}

