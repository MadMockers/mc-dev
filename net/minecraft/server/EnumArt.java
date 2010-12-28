package net.minecraft.server;


public final class EnumArt extends Enum {

    public static final EnumArt a;
    public static final EnumArt b;
    public static final EnumArt c;
    public static final EnumArt d;
    public static final EnumArt e;
    public static final EnumArt f;
    public static final EnumArt g;
    public static final EnumArt h;
    public static final EnumArt i;
    public static final EnumArt j;
    public static final EnumArt k;
    public static final EnumArt l;
    public static final EnumArt m;
    public static final EnumArt n;
    public static final EnumArt o;
    public static final EnumArt p;
    public static final EnumArt q;
    public static final EnumArt r;
    public static final EnumArt s;
    public static final EnumArt t;
    public static final EnumArt u;
    public static final EnumArt v;
    public static final EnumArt w;
    public static final EnumArt x;
    public final String y;
    public final int z;
    public final int A;
    public final int B;
    public final int C;
    private static final EnumArt D[]; /* synthetic field */

    public static EnumArt[] values() {
        return (EnumArt[]) D.clone();
    }

    public static EnumArt valueOf(String s1) {
        return (EnumArt) Enum.valueOf(net.minecraft.server.EnumArt.class, s1);
    }

    private EnumArt(String s1, int i1, String s2, int j1, int k1, int l1, int i2) {
        super(s1, i1);
        y = s2;
        z = j1;
        A = k1;
        B = l1;
        C = i2;
    }

    static {
        a = new EnumArt("Kebab", 0, "Kebab", 16, 16, 0, 0);
        b = new EnumArt("Aztec", 1, "Aztec", 16, 16, 16, 0);
        c = new EnumArt("Alban", 2, "Alban", 16, 16, 32, 0);
        d = new EnumArt("Aztec2", 3, "Aztec2", 16, 16, 48, 0);
        e = new EnumArt("Bomb", 4, "Bomb", 16, 16, 64, 0);
        f = new EnumArt("Plant", 5, "Plant", 16, 16, 80, 0);
        g = new EnumArt("Wasteland", 6, "Wasteland", 16, 16, 96, 0);
        h = new EnumArt("Pool", 7, "Pool", 32, 16, 0, 32);
        i = new EnumArt("Courbet", 8, "Courbet", 32, 16, 32, 32);
        j = new EnumArt("Sea", 9, "Sea", 32, 16, 64, 32);
        k = new EnumArt("Sunset", 10, "Sunset", 32, 16, 96, 32);
        l = new EnumArt("Creebet", 11, "Creebet", 32, 16, 128, 32);
        m = new EnumArt("Wanderer", 12, "Wanderer", 16, 32, 0, 64);
        n = new EnumArt("Graham", 13, "Graham", 16, 32, 16, 64);
        o = new EnumArt("Match", 14, "Match", 32, 32, 0, 128);
        p = new EnumArt("Bust", 15, "Bust", 32, 32, 32, 128);
        q = new EnumArt("Stage", 16, "Stage", 32, 32, 64, 128);
        r = new EnumArt("Void", 17, "Void", 32, 32, 96, 128);
        s = new EnumArt("SkullAndRoses", 18, "SkullAndRoses", 32, 32, 128, 128);
        t = new EnumArt("Fighters", 19, "Fighters", 64, 32, 0, 96);
        u = new EnumArt("Pointer", 20, "Pointer", 64, 64, 0, 192);
        v = new EnumArt("Pigscene", 21, "Pigscene", 64, 64, 64, 192);
        w = new EnumArt("Skeleton", 22, "Skeleton", 64, 48, 192, 64);
        x = new EnumArt("DonkeyKong", 23, "DonkeyKong", 64, 48, 192, 112);
        D = (new EnumArt[] {
            a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x
        });
    }
}

