package net.minecraft.server;


public class ChunkCache
        implements IBlockAccess {

    private int a;
    private int b;
    private Chunk c[][];
    private World d;

    public ChunkCache(World world, int i, int j, int k, int l, int i1, int j1) {
        d = world;
        a = i >> 4;
        b = k >> 4;
        int k1 = l >> 4;
        int l1 = j1 >> 4;

        c = new Chunk[(k1 - a) + 1][(l1 - b) + 1];
        for (int i2 = a; i2 <= k1; i2++) {
            for (int j2 = b; j2 <= l1; j2++) {
                c[i2 - a][j2 - b] = world.c(i2, j2);
            }

        }

    }

    public int a(int i, int j, int k) {
        if (j < 0) {
            return 0;
        }
        if (j >= 128) {
            return 0;
        } else {
            int l = (i >> 4) - a;
            int i1 = (k >> 4) - b;

            return c[l][i1].a(i & 0xf, j, k & 0xf);
        }
    }

    public int b(int i, int j, int k) {
        if (j < 0) {
            return 0;
        }
        if (j >= 128) {
            return 0;
        } else {
            int l = (i >> 4) - a;
            int i1 = (k >> 4) - b;

            return c[l][i1].b(i & 0xf, j, k & 0xf);
        }
    }

    public Material c(int i, int j, int k) {
        int l = a(i, j, k);

        if (l == 0) {
            return Material.a;
        } else {
            return Block.n[l].bt;
        }
    }

    public boolean d(int i, int j, int k) {
        Block block = Block.n[a(i, j, k)];

        if (block == null) {
            return false;
        } else {
            return block.a();
        }
    }
}

