package net.minecraft.server;


import java.io.IOException;


public class ChunkProviderLoadOrGenerate
        implements IChunkProvider {

    private Chunk c;
    private IChunkProvider d;
    private IChunkLoader e;
    private Chunk f[];
    private World g;
    int a;
    int b;
    private Chunk h;

    public ChunkProviderLoadOrGenerate(World world, IChunkLoader ichunkloader, IChunkProvider ichunkprovider) {
        f = new Chunk[1024];
        a = 0xc4653601;
        b = 0xc4653601;
        c = new Chunk(world, new byte[32768], 0, 0);
        c.q = true;
        c.p = true;
        g = world;
        e = ichunkloader;
        d = ichunkprovider;
    }

    public boolean a(int i, int j) {
        if (i == a && j == b && h != null) {
            return true;
        } else {
            int k = i & 0x1f;
            int l = j & 0x1f;
            int i1 = k + l * 32;

            return f[i1] != null && (f[i1] == c || f[i1].a(i, j));
        }
    }

    public Chunk b(int i, int j) {
        if (i == a && j == b && h != null) {
            return h;
        }
        int k = i & 0x1f;
        int l = j & 0x1f;
        int i1 = k + l * 32;

        if (!a(i, j)) {
            if (f[i1] != null) {
                f[i1].e();
                b(f[i1]);
                a(f[i1]);
            }
            Chunk chunk = c(i, j);

            if (chunk == null) {
                if (d == null) {
                    chunk = c;
                } else {
                    chunk = d.b(i, j);
                }
            }
            f[i1] = chunk;
            chunk.c();
            if (f[i1] != null) {
                f[i1].d();
            }
            if (!f[i1].n && a(i + 1, j + 1) && a(i, j + 1) && a(i + 1, j)) {
                a(this, i, j);
            }
            if (a(i - 1, j) && !b(i - 1, j).n && a(i - 1, j + 1) && a(i, j + 1) && a(i - 1, j)) {
                a(this, i - 1, j);
            }
            if (a(i, j - 1) && !b(i, j - 1).n && a(i + 1, j - 1) && a(i, j - 1) && a(i + 1, j)) {
                a(this, i, j - 1);
            }
            if (a(i - 1, j - 1) && !b(i - 1, j - 1).n && a(i - 1, j - 1) && a(i, j - 1) && a(i - 1, j)) {
                a(this, i - 1, j - 1);
            }
        }
        a = i;
        b = j;
        h = f[i1];
        return f[i1];
    }

    private Chunk c(int i, int j) {
        if (e == null) {
            return null;
        }
        try {
            Chunk chunk = e.a(g, i, j);

            if (chunk != null) {
                chunk.s = g.e;
            }
            return chunk;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void a(Chunk chunk) {
        if (e == null) {
            return;
        }
        try {
            e.b(g, chunk);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(Chunk chunk) {
        if (e == null) {
            return;
        }
        try {
            chunk.s = g.e;
            e.a(g, chunk);
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    public void a(IChunkProvider ichunkprovider, int i, int j) {
        Chunk chunk = b(i, j);

        if (!chunk.n) {
            chunk.n = true;
            if (d != null) {
                d.a(ichunkprovider, i, j);
                chunk.f();
            }
        }
    }

    public boolean a(boolean flag, IProgressUpdate iprogressupdate) {
        int i = 0;
        int j = 0;

        if (iprogressupdate != null) {
            for (int k = 0; k < f.length; k++) {
                if (f[k] != null && f[k].a(flag)) {
                    j++;
                }
            }

        }
        int l = 0;

        for (int i1 = 0; i1 < f.length; i1++) {
            if (f[i1] == null) {
                continue;
            }
            if (flag && !f[i1].p) {
                a(f[i1]);
            }
            if (!f[i1].a(flag)) {
                continue;
            }
            b(f[i1]);
            f[i1].o = false;
            if (++i == 2 && !flag) {
                return false;
            }
            if (iprogressupdate != null && ++l % 10 == 0) {
                iprogressupdate.a((l * 100) / j);
            }
        }

        if (flag) {
            if (e == null) {
                return true;
            }
            e.b();
        }
        return true;
    }

    public boolean a() {
        if (e != null) {
            e.a();
        }
        return d.a();
    }

    public boolean b() {
        return true;
    }
}

