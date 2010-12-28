package net.minecraft.server;


public class MetadataChunkBlock {

    public final EnumSkyBlock a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public MetadataChunkBlock(EnumSkyBlock enumskyblock, int i, int j, int k, int l, int i1, int j1) {
        a = enumskyblock;
        b = i;
        c = j;
        d = k;
        e = l;
        f = i1;
        g = j1;
    }

    public void a(World world) {
        int i = (e - b) + 1;
        int j = (f - c) + 1;
        int k = (g - d) + 1;
        int l = i * j * k;

        if (l > 32768) {
            return;
        }
        for (int i1 = b; i1 <= e; i1++) {
            for (int j1 = d; j1 <= g; j1++) {
                if (!world.e(i1, 0, j1)) {
                    continue;
                }
                for (int k1 = c; k1 <= f; k1++) {
                    if (k1 < 0 || k1 >= 128) {
                        continue;
                    }
                    int l1 = world.a(a, i1, k1, j1);
                    int i2 = 0;
                    int j2 = world.a(i1, k1, j1);
                    int k2 = Block.r[j2];

                    if (k2 == 0) {
                        k2 = 1;
                    }
                    int l2 = 0;

                    if (a == EnumSkyBlock.a) {
                        if (world.i(i1, k1, j1)) {
                            l2 = 15;
                        }
                    } else if (a == EnumSkyBlock.b) {
                        l2 = Block.t[j2];
                    }
                    if (k2 >= 15 && l2 == 0) {
                        i2 = 0;
                    } else {
                        int i3 = world.a(a, i1 - 1, k1, j1);
                        int k3 = world.a(a, i1 + 1, k1, j1);
                        int l3 = world.a(a, i1, k1 - 1, j1);
                        int i4 = world.a(a, i1, k1 + 1, j1);
                        int j4 = world.a(a, i1, k1, j1 - 1);
                        int k4 = world.a(a, i1, k1, j1 + 1);

                        i2 = i3;
                        if (k3 > i2) {
                            i2 = k3;
                        }
                        if (l3 > i2) {
                            i2 = l3;
                        }
                        if (i4 > i2) {
                            i2 = i4;
                        }
                        if (j4 > i2) {
                            i2 = j4;
                        }
                        if (k4 > i2) {
                            i2 = k4;
                        }
                        i2 -= k2;
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        if (l2 > i2) {
                            i2 = l2;
                        }
                    }
                    if (l1 == i2) {
                        continue;
                    }
                    world.b(a, i1, k1, j1, i2);
                    int j3 = i2 - 1;

                    if (j3 < 0) {
                        j3 = 0;
                    }
                    world.a(a, i1 - 1, k1, j1, j3);
                    world.a(a, i1, k1 - 1, j1, j3);
                    world.a(a, i1, k1, j1 - 1, j3);
                    if (i1 + 1 >= e) {
                        world.a(a, i1 + 1, k1, j1, j3);
                    }
                    if (k1 + 1 >= f) {
                        world.a(a, i1, k1 + 1, j1, j3);
                    }
                    if (j1 + 1 >= g) {
                        world.a(a, i1, k1, j1 + 1, j3);
                    }
                }

            }

        }

    }

    public boolean a(int i, int j, int k, int l, int i1, int j1) {
        if (i >= b && j >= c && k >= d && l <= e && i1 <= f && j1 <= g) {
            return true;
        }
        int k1 = 1;

        if (i >= b - k1 && j >= c - k1 && k >= d - k1 && l <= e + k1 && i1 <= f + k1 && j1 <= g + k1) {
            int l1 = e - b;
            int i2 = f - c;
            int j2 = g - d;

            if (i > b) {
                i = b;
            }
            if (j > c) {
                j = c;
            }
            if (k > d) {
                k = d;
            }
            if (l < e) {
                l = e;
            }
            if (i1 < f) {
                i1 = f;
            }
            if (j1 < g) {
                j1 = g;
            }
            int k2 = l - i;
            int l2 = i1 - j;
            int i3 = j1 - k;
            int j3 = l1 * i2 * j2;
            int k3 = k2 * l2 * i3;

            if (k3 - j3 <= 2) {
                b = i;
                c = j;
                d = k;
                e = l;
                f = i1;
                g = j1;
                return true;
            }
        }
        return false;
    }
}

