package net.minecraft.server;


public class MobSpawnerBase {

    public static final MobSpawnerBase a = (new MobSpawnerBase()).b(0x8fa36).a("Rainforest").a(0x1ff458);
    public static final MobSpawnerBase b = (new MobSpawnerSwamp()).b(0x7f9b2).a("Swampland").a(0x8baf48);
    public static final MobSpawnerBase c = (new MobSpawnerBase()).b(0x9be023).a("Seasonal Forest");
    public static final MobSpawnerBase d = (new MobSpawnerBase()).b(0x56621).a("Forest").a(0x4eba31);
    public static final MobSpawnerBase e = (new MobSpawnerDesert()).b(0xd9e023).a("Savanna");
    public static final MobSpawnerBase f = (new MobSpawnerBase()).b(0xa1ad20).a("Shrubland");
    public static final MobSpawnerBase g = (new MobSpawnerBase()).b(0x2eb153).a("Taiga").b().a(0x7bb731);
    public static final MobSpawnerBase h = (new MobSpawnerDesert()).b(0xfa9418).a("Desert");
    public static final MobSpawnerBase i = (new MobSpawnerDesert()).b(0xffd910).a("Plains");
    public static final MobSpawnerBase j = (new MobSpawnerDesert()).b(0xffed93).a("Ice Desert").b().a(0xc4d339);
    public static final MobSpawnerBase k = (new MobSpawnerBase()).b(0x57ebf9).a("Tundra").b().a(0xc4d339);
    public static final MobSpawnerBase l = (new MobSpawnerHell()).b(0xff0000).a("Hell");
    public String m;
    public int n;
    public byte o;
    public byte p;
    public int q;
    protected Class r[];
    protected Class s[];
    private static MobSpawnerBase t[] = new MobSpawnerBase[4096];

    public MobSpawnerBase() {
        o = (byte) Block.u.bh;
        p = (byte) Block.v.bh;
        q = 0x4ee031;
        r = (new Class[] {
            net.minecraft.server.EntityCreeper.class
        });
        s = (new Class[] {
            net.minecraft.server.EntitySheep.class, net.minecraft.server.EntityPig.class, net.minecraft.server.EntityChicken.class, net.minecraft.server.EntityCow.class
        });
    }

    public static void a() {
        for (int i1 = 0; i1 < 64; i1++) {
            for (int j1 = 0; j1 < 64; j1++) {
                t[i1 + j1 * 64] = a((float) i1 / 63F, (float) j1 / 63F);
            }

        }

        h.o = h.p = (byte) Block.E.bh;
        j.o = j.p = (byte) Block.E.bh;
    }

    protected MobSpawnerBase b() {
        return this;
    }

    protected MobSpawnerBase a(String s1) {
        m = s1;
        return this;
    }

    protected MobSpawnerBase a(int i1) {
        q = i1;
        return this;
    }

    protected MobSpawnerBase b(int i1) {
        n = i1;
        return this;
    }

    public static MobSpawnerBase a(double d1, double d2) {
        int i1 = (int) (d1 * 63D);
        int j1 = (int) (d2 * 63D);

        return t[i1 + j1 * 64];
    }

    public static MobSpawnerBase a(float f1, float f2) {
        f2 *= f1;
        if (f1 < 0.1F) {
            return k;
        }
        if (f2 < 0.2F) {
            if (f1 < 0.5F) {
                return k;
            }
            if (f1 < 0.95F) {
                return e;
            } else {
                return h;
            }
        }
        if (f2 > 0.5F && f1 < 0.7F) {
            return b;
        }
        if (f1 < 0.5F) {
            return g;
        }
        if (f1 < 0.97F) {
            if (f2 < 0.35F) {
                return f;
            } else {
                return d;
            }
        }
        if (f2 < 0.45F) {
            return i;
        }
        if (f2 < 0.9F) {
            return c;
        } else {
            return a;
        }
    }

    public Class[] a(EnumCreatureType enumcreaturetype) {
        if (enumcreaturetype == EnumCreatureType.a) {
            return r;
        }
        if (enumcreaturetype == EnumCreatureType.b) {
            return s;
        } else {
            return null;
        }
    }

    static {
        a();
    }
}

