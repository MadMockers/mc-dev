package net.minecraft.server;


import java.io.*;
import java.util.*;


public class World
        implements IBlockAccess {

    public boolean a;
    private List A;
    public List b;
    private List B;
    private TreeSet C;
    private Set D;
    public List c;
    public List d;
    public long e;
    private long E;
    public int f;
    protected int g;
    protected int h;
    public boolean i;
    private long F;
    protected int j;
    public int k;
    public Random l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public final WorldProvider q;
    protected List r;
    private IChunkProvider G;
    public File s;
    public File t;
    public long u;
    private NBTTagCompound H;
    public long v;
    public final String w;
    public boolean x;
    private ArrayList I;
    private int J;
    static int y = 0;
    private Set K;
    private int L;
    private List M;
    public boolean z;

    public WorldChunkManager a() {
        return q.b;
    }

    public World(File file, String s1, long l1, WorldProvider worldprovider) {
        a = false;
        A = new ArrayList();
        b = new ArrayList();
        B = new ArrayList();
        C = new TreeSet();
        D = new HashSet();
        c = new ArrayList();
        d = new ArrayList();
        e = 0L;
        E = 0xffffffL;
        f = 0;
        g = (new Random()).nextInt();
        h = 0x3c6ef35f;
        i = false;
        F = System.currentTimeMillis();
        j = 40;
        l = new Random();
        p = false;
        r = new ArrayList();
        u = 0L;
        v = 0L;
        I = new ArrayList();
        J = 0;
        K = new HashSet();
        L = l.nextInt(12000);
        M = new ArrayList();
        z = false;
        s = file;
        w = s1;
        file.mkdirs();
        t = new File(file, s1);
        t.mkdirs();
        try {
            File file1 = new File(t, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file1));

            try {
                dataoutputstream.writeLong(F);
            } finally {
                dataoutputstream.close();
            }
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
        Object obj = new WorldProvider();
        File file2 = new File(t, "level.dat");

        p = !file2.exists();
        if (file2.exists()) {
            try {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a(new FileInputStream(file2));
                NBTTagCompound nbttagcompound1 = nbttagcompound.j("Data");

                u = nbttagcompound1.e("RandomSeed");
                m = nbttagcompound1.d("SpawnX");
                n = nbttagcompound1.d("SpawnY");
                o = nbttagcompound1.d("SpawnZ");
                e = nbttagcompound1.e("Time");
                v = nbttagcompound1.e("SizeOnDisk");
                if (nbttagcompound1.a("Player")) {
                    H = nbttagcompound1.j("Player");
                    int i1 = H.d("Dimension");

                    if (i1 == -1) {
                        obj = new WorldProviderHell();
                    }
                }
            } catch (Exception exception1) {
                exception1.printStackTrace();
            }
        }
        if (worldprovider != null) {
            obj = worldprovider;
        }
        boolean flag = false;

        if (u == 0L) {
            u = l1;
            flag = true;
        }
        q = ((WorldProvider) (obj));
        q.a(this);
        G = a(t);
        if (flag) {
            x = true;
            m = 0;
            n = 64;
            for (o = 0; !q.a(m, o); o += l.nextInt(64) - l.nextInt(64)) {
                m += l.nextInt(64) - l.nextInt(64);
            }

            x = false;
        }
        e();
    }

    protected IChunkProvider a(File file) {
        return new ChunkProviderLoadOrGenerate(this, q.a(file), q.c());
    }

    public int a(int i1, int j1) {
        int k1;

        for (k1 = 63; a(i1, k1 + 1, j1) != 0; k1++) {
            ;
        }
        return a(i1, k1, j1);
    }

    public void a(boolean flag, IProgressUpdate iprogressupdate) {
        if (!G.b()) {
            return;
        }
        if (iprogressupdate != null) {
            iprogressupdate.a("Saving level");
        }
        i();
        if (iprogressupdate != null) {
            iprogressupdate.b("Saving chunks");
        }
        G.a(flag, iprogressupdate);
    }

    private void i() {
        h();
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        nbttagcompound.a("RandomSeed", u);
        nbttagcompound.a("SpawnX", m);
        nbttagcompound.a("SpawnY", n);
        nbttagcompound.a("SpawnZ", o);
        nbttagcompound.a("Time", e);
        nbttagcompound.a("SizeOnDisk", v);
        nbttagcompound.a("LastPlayed", System.currentTimeMillis());
        EntityPlayer entityplayer = null;

        if (d.size() > 0) {
            entityplayer = (EntityPlayer) d.get(0);
        }
        if (entityplayer != null) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            entityplayer.d(nbttagcompound1);
            nbttagcompound.a("Player", nbttagcompound1);
        }
        NBTTagCompound nbttagcompound2 = new NBTTagCompound();

        nbttagcompound2.a("Data", nbttagcompound);
        try {
            File file = new File(t, "level.dat_new");
            File file1 = new File(t, "level.dat_old");
            File file2 = new File(t, "level.dat");

            CompressedStreamTools.a(nbttagcompound2, new FileOutputStream(file));
            if (file1.exists()) {
                file1.delete();
            }
            file2.renameTo(file1);
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int a(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 0;
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            return 0;
        } else {
            return c(i1 >> 4, k1 >> 4).a(i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public boolean e(int i1, int j1, int k1) {
        if (j1 < 0 || j1 >= 128) {
            return false;
        } else {
            return f(i1 >> 4, k1 >> 4);
        }
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2, int j2) {
        if (i2 < 0 || j1 >= 128) {
            return false;
        }
        i1 >>= 4;
        j1 >>= 4;
        k1 >>= 4;
        l1 >>= 4;
        i2 >>= 4;
        j2 >>= 4;
        for (int k2 = i1; k2 <= l1; k2++) {
            for (int l2 = k1; l2 <= j2; l2++) {
                if (!f(k2, l2)) {
                    return false;
                }
            }

        }

        return true;
    }

    private boolean f(int i1, int j1) {
        return G.a(i1, j1);
    }

    public Chunk b(int i1, int j1) {
        return c(i1 >> 4, j1 >> 4);
    }

    public Chunk c(int i1, int j1) {
        return G.b(i1, j1);
    }

    public boolean a(int i1, int j1, int k1, int l1, int i2) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            return chunk.a(i1 & 0xf, j1, k1 & 0xf, l1, i2);
        }
    }

    public boolean a(int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            return chunk.a(i1 & 0xf, j1, k1 & 0xf, l1);
        }
    }

    public Material c(int i1, int j1, int k1) {
        int l1 = a(i1, j1, k1);

        if (l1 == 0) {
            return Material.a;
        } else {
            return Block.m[l1].bs;
        }
    }

    public int b(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 0;
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            return 0;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.b(i1, j1, k1);
        }
    }

    public void b(int i1, int j1, int k1, int l1) {
        if (c(i1, j1, k1, l1)) {
            e(i1, j1, k1, a(i1, j1, k1));
        }
    }

    public boolean c(int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return false;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            chunk.b(i1, j1, k1, l1);
            return true;
        }
    }

    public boolean d(int i1, int j1, int k1, int l1) {
        if (a(i1, j1, k1, l1)) {
            e(i1, j1, k1, l1);
            return true;
        } else {
            return false;
        }
    }

    public boolean b(int i1, int j1, int k1, int l1, int i2) {
        if (a(i1, j1, k1, l1, i2)) {
            e(i1, j1, k1, l1);
            return true;
        } else {
            return false;
        }
    }

    public void f(int i1, int j1, int k1) {
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(i1, j1, k1);
        }

    }

    protected void e(int i1, int j1, int k1, int l1) {
        f(i1, j1, k1);
        g(i1, j1, k1, l1);
    }

    public void f(int i1, int j1, int k1, int l1) {
        if (k1 > l1) {
            int i2 = l1;

            l1 = k1;
            k1 = i2;
        }
        b(i1, k1, j1, i1, l1, j1);
    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2) {
        for (int k2 = 0; k2 < r.size(); k2++) {
            ((IWorldAccess) r.get(k2)).a(i1, j1, k1, l1, i2, j2);
        }

    }

    public void g(int i1, int j1, int k1, int l1) {
        k(i1 - 1, j1, k1, l1);
        k(i1 + 1, j1, k1, l1);
        k(i1, j1 - 1, k1, l1);
        k(i1, j1 + 1, k1, l1);
        k(i1, j1, k1 - 1, l1);
        k(i1, j1, k1 + 1, l1);
    }

    private void k(int i1, int j1, int k1, int l1) {
        if (i || z) {
            return;
        }
        Block block = Block.m[a(i1, j1, k1)];

        if (block != null) {
            block.b(this, i1, j1, k1, l1);
        }
    }

    public boolean g(int i1, int j1, int k1) {
        return c(i1 >> 4, k1 >> 4).c(i1 & 0xf, j1, k1 & 0xf);
    }

    public int h(int i1, int j1, int k1) {
        return a(i1, j1, k1, true);
    }

    public int a(int i1, int j1, int k1, boolean flag) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return 15;
        }
        if (flag) {
            int l1 = a(i1, j1, k1);

            if (l1 == Block.ak.bh || l1 == Block.aA.bh) {
                int j2 = a(i1, j1 + 1, k1, false);
                int k2 = a(i1 + 1, j1, k1, false);
                int l2 = a(i1 - 1, j1, k1, false);
                int i3 = a(i1, j1, k1 + 1, false);
                int j3 = a(i1, j1, k1 - 1, false);

                if (k2 > j2) {
                    j2 = k2;
                }
                if (l2 > j2) {
                    j2 = l2;
                }
                if (i3 > j2) {
                    j2 = i3;
                }
                if (j3 > j2) {
                    j2 = j3;
                }
                return j2;
            }
        }
        if (j1 < 0) {
            return 0;
        }
        if (j1 >= 128) {
            int i2 = 15 - f;

            if (i2 < 0) {
                i2 = 0;
            }
            return i2;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.c(i1, j1, k1, f);
        }
    }

    public boolean i(int i1, int j1, int k1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return false;
        }
        if (j1 < 0) {
            return false;
        }
        if (j1 >= 128) {
            return true;
        }
        if (!f(i1 >> 4, k1 >> 4)) {
            return false;
        } else {
            Chunk chunk = c(i1 >> 4, k1 >> 4);

            i1 &= 0xf;
            k1 &= 0xf;
            return chunk.c(i1, j1, k1);
        }
    }

    public int d(int i1, int j1) {
        if (i1 < 0xfe17b800 || j1 < 0xfe17b800 || i1 >= 0x1e84800 || j1 > 0x1e84800) {
            return 0;
        }
        if (!f(i1 >> 4, j1 >> 4)) {
            return 0;
        } else {
            Chunk chunk = c(i1 >> 4, j1 >> 4);

            return chunk.b(i1 & 0xf, j1 & 0xf);
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1) {
        if (q.e && enumskyblock == EnumSkyBlock.a) {
            return;
        }
        if (!e(i1, j1, k1)) {
            return;
        }
        if (enumskyblock == EnumSkyBlock.a) {
            if (i(i1, j1, k1)) {
                l1 = 15;
            }
        } else if (enumskyblock == EnumSkyBlock.b) {
            int i2 = a(i1, j1, k1);

            if (Block.s[i2] > l1) {
                l1 = Block.s[i2];
            }
        }
        if (a(enumskyblock, i1, j1, k1) != l1) {
            a(enumskyblock, i1, j1, k1, i1, j1, k1);
        }
    }

    public int a(EnumSkyBlock enumskyblock, int i1, int j1, int k1) {
        if (j1 < 0 || j1 >= 128 || i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return enumskyblock.c;
        }
        int l1 = i1 >> 4;
        int i2 = k1 >> 4;

        if (!f(l1, i2)) {
            return 0;
        } else {
            Chunk chunk = c(l1, i2);

            return chunk.a(enumskyblock, i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public void b(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1) {
        if (i1 < 0xfe17b800 || k1 < 0xfe17b800 || i1 >= 0x1e84800 || k1 > 0x1e84800) {
            return;
        }
        if (j1 < 0) {
            return;
        }
        if (j1 >= 128) {
            return;
        }
        if (!f(i1 >> 4, k1 >> 4)) {
            return;
        }
        Chunk chunk = c(i1 >> 4, k1 >> 4);

        chunk.a(enumskyblock, i1 & 0xf, j1, k1 & 0xf, l1);
        for (int i2 = 0; i2 < r.size(); i2++) {
            ((IWorldAccess) r.get(i2)).a(i1, j1, k1);
        }

    }

    public float j(int i1, int j1, int k1) {
        return q.f[h(i1, j1, k1)];
    }

    public boolean b() {
        return f < 4;
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1) {
        return a(vec3d, vec3d1, false);
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1, boolean flag) {
        if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
            return null;
        }
        if (Double.isNaN(vec3d1.a) || Double.isNaN(vec3d1.b) || Double.isNaN(vec3d1.c)) {
            return null;
        }
        int i1 = MathHelper.b(vec3d1.a);
        int j1 = MathHelper.b(vec3d1.b);
        int k1 = MathHelper.b(vec3d1.c);
        int l1 = MathHelper.b(vec3d.a);
        int i2 = MathHelper.b(vec3d.b);
        int j2 = MathHelper.b(vec3d.c);

        for (int k2 = 200; k2-- >= 0;) {
            if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
                return null;
            }
            if (l1 == i1 && i2 == j1 && j2 == k1) {
                return null;
            }
            double d1 = 999D;
            double d2 = 999D;
            double d3 = 999D;

            if (i1 > l1) {
                d1 = (double) l1 + 1.0D;
            }
            if (i1 < l1) {
                d1 = (double) l1 + 0.0D;
            }
            if (j1 > i2) {
                d2 = (double) i2 + 1.0D;
            }
            if (j1 < i2) {
                d2 = (double) i2 + 0.0D;
            }
            if (k1 > j2) {
                d3 = (double) j2 + 1.0D;
            }
            if (k1 < j2) {
                d3 = (double) j2 + 0.0D;
            }
            double d4 = 999D;
            double d5 = 999D;
            double d6 = 999D;
            double d7 = vec3d1.a - vec3d.a;
            double d8 = vec3d1.b - vec3d.b;
            double d9 = vec3d1.c - vec3d.c;

            if (d1 != 999D) {
                d4 = (d1 - vec3d.a) / d7;
            }
            if (d2 != 999D) {
                d5 = (d2 - vec3d.b) / d8;
            }
            if (d3 != 999D) {
                d6 = (d3 - vec3d.c) / d9;
            }
            byte byte0 = 0;

            if (d4 < d5 && d4 < d6) {
                if (i1 > l1) {
                    byte0 = 4;
                } else {
                    byte0 = 5;
                }
                vec3d.a = d1;
                vec3d.b += d8 * d4;
                vec3d.c += d9 * d4;
            } else if (d5 < d6) {
                if (j1 > i2) {
                    byte0 = 0;
                } else {
                    byte0 = 1;
                }
                vec3d.a += d7 * d5;
                vec3d.b = d2;
                vec3d.c += d9 * d5;
            } else {
                if (k1 > j2) {
                    byte0 = 2;
                } else {
                    byte0 = 3;
                }
                vec3d.a += d7 * d6;
                vec3d.b += d8 * d6;
                vec3d.c = d3;
            }
            Vec3D vec3d2 = Vec3D.b(vec3d.a, vec3d.b, vec3d.c);

            l1 = (int) (vec3d2.a = MathHelper.b(vec3d.a));
            if (byte0 == 5) {
                l1--;
                vec3d2.a++;
            }
            i2 = (int) (vec3d2.b = MathHelper.b(vec3d.b));
            if (byte0 == 1) {
                i2--;
                vec3d2.b++;
            }
            j2 = (int) (vec3d2.c = MathHelper.b(vec3d.c));
            if (byte0 == 3) {
                j2--;
                vec3d2.c++;
            }
            int l2 = a(l1, i2, j2);
            int i3 = b(l1, i2, j2);
            Block block = Block.m[l2];

            if (l2 > 0 && block.a(i3, flag)) {
                MovingObjectPosition movingobjectposition = block.a(this, l1, i2, j2, vec3d, vec3d1);

                if (movingobjectposition != null) {
                    return movingobjectposition;
                }
            }
        }

        return null;
    }

    public void a(Entity entity, String s1, float f1, float f2) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, entity.p, entity.q - (double) entity.G, entity.r, f1, f2);
        }

    }

    public void a(double d1, double d2, double d3, String s1, 
            float f1, float f2) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, d1, d2, d3, f1, f2);
        }

    }

    public void a(String s1, int i1, int j1, int k1) {
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(s1, i1, j1, k1);
        }

    }

    public void a(String s1, double d1, double d2, double d3, 
            double d4, double d5, double d6) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(s1, d1, d2, d3, d4, d5, d6);
        }

    }

    public boolean a(Entity entity) {
        int i1 = MathHelper.b(entity.p / 16D);
        int j1 = MathHelper.b(entity.r / 16D);
        boolean flag = false;

        if (entity instanceof EntityPlayer) {
            flag = true;
        }
        if (flag || f(i1, j1)) {
            if (entity instanceof EntityPlayer) {
                d.add((EntityPlayer) entity);
                System.out.println((new StringBuilder()).append("Player count: ").append(d.size()).toString());
            }
            c(i1, j1).a(entity);
            b.add(entity);
            b(entity);
            return true;
        } else {
            return false;
        }
    }

    protected void b(Entity entity) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).a(entity);
        }

    }

    protected void c(Entity entity) {
        for (int i1 = 0; i1 < r.size(); i1++) {
            ((IWorldAccess) r.get(i1)).b(entity);
        }

    }

    public void d(Entity entity) {
        entity.l();
        if (entity instanceof EntityPlayer) {
            d.remove((EntityPlayer) entity);
            System.out.println((new StringBuilder()).append("Player count: ").append(d.size()).toString());
        }
    }

    public void a(IWorldAccess iworldaccess) {
        r.add(iworldaccess);
    }

    public List a(Entity entity, AxisAlignedBB axisalignedbb) {
        I.clear();
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = i2; l2 < j2; l2++) {
                if (!e(k2, 64, l2)) {
                    continue;
                }
                for (int i3 = k1 - 1; i3 < l1; i3++) {
                    Block block = Block.m[a(k2, i3, l2)];

                    if (block != null) {
                        block.a(this, k2, i3, l2, axisalignedbb, I);
                    }
                }

            }

        }

        double d1 = 0.25D;
        List list = b(entity, axisalignedbb.b(d1, d1, d1));

        for (int j3 = 0; j3 < list.size(); j3++) {
            AxisAlignedBB axisalignedbb1 = ((Entity) list.get(j3)).q();

            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                I.add(axisalignedbb1);
            }
            axisalignedbb1 = entity.d((Entity) list.get(j3));
            if (axisalignedbb1 != null && axisalignedbb1.a(axisalignedbb)) {
                I.add(axisalignedbb1);
            }
        }

        return I;
    }

    public int a(float f1) {
        float f2 = b(f1);
        float f3 = 1.0F - (MathHelper.b(f2 * 3.141593F * 2.0F) * 2.0F + 0.5F);

        if (f3 < 0.0F) {
            f3 = 0.0F;
        }
        if (f3 > 1.0F) {
            f3 = 1.0F;
        }
        return (int) (f3 * 11F);
    }

    public float b(float f1) {
        return q.a(e, f1);
    }

    public int e(int i1, int j1) {
        Chunk chunk = b(i1, j1);
        int k1;

        for (k1 = 127; c(i1, k1, j1).c() && k1 > 0; k1--) {
            ;
        }
        i1 &= 0xf;
        j1 &= 0xf;
        while (k1 > 0) {
            int l1 = chunk.a(i1, k1, j1);

            if (l1 == 0 || !Block.m[l1].bs.c() && !Block.m[l1].bs.d()) {
                k1--;
            } else {
                return k1 + 1;
            }
        }
        return -1;
    }

    public void h(int i1, int j1, int k1, int l1) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(i1, j1, k1, l1);
        byte byte0 = 8;

        if (a) {
            if (a(nextticklistentry.a - byte0, nextticklistentry.b - byte0, nextticklistentry.c - byte0, nextticklistentry.a + byte0, nextticklistentry.b + byte0, nextticklistentry.c + byte0)) {
                int i2 = a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

                if (i2 == nextticklistentry.d && i2 > 0) {
                    Block.m[i2].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, l);
                }
            }
            return;
        }
        if (a(i1 - byte0, j1 - byte0, k1 - byte0, i1 + byte0, j1 + byte0, k1 + byte0)) {
            if (l1 > 0) {
                nextticklistentry.a((long) Block.m[l1].b() + e);
            }
            if (!D.contains(nextticklistentry)) {
                D.add(nextticklistentry);
                C.add(nextticklistentry);
            }
        }
    }

    public void c() {
        b.removeAll(B);
        for (int i1 = 0; i1 < B.size(); i1++) {
            Entity entity = (Entity) B.get(i1);
            int i2 = entity.af;
            int k2 = entity.ah;

            if (entity.ae && f(i2, k2)) {
                c(i2, k2).b(entity);
            }
        }

        for (int j1 = 0; j1 < B.size(); j1++) {
            c((Entity) B.get(j1));
        }

        B.clear();
        for (int k1 = 0; k1 < b.size(); k1++) {
            Entity entity1 = (Entity) b.get(k1);

            if (entity1.k != null) {
                if (!entity1.k.F && entity1.k.j == entity1) {
                    continue;
                }
                entity1.k.j = null;
                entity1.k = null;
            }
            if (!entity1.F) {
                e(entity1);
            }
            if (!entity1.F) {
                continue;
            }
            int j2 = entity1.af;
            int l2 = entity1.ah;

            if (entity1.ae && f(j2, l2)) {
                c(j2, l2).b(entity1);
            }
            b.remove(k1--);
            c(entity1);
        }

        for (int l1 = 0; l1 < c.size(); l1++) {
            TileEntity tileentity = (TileEntity) c.get(l1);

            tileentity.b();
        }

    }

    public void e(Entity entity) {
        a(entity, true);
    }

    public void a(Entity entity, boolean flag) {
        int i1 = MathHelper.b(entity.p);
        int j1 = MathHelper.b(entity.r);
        byte byte0 = 16;

        if (!flag && !a(i1 - byte0, 0, j1 - byte0, i1 + byte0, 128, j1 + byte0)) {
            return;
        }
        entity.N = entity.p;
        entity.O = entity.q;
        entity.P = entity.r;
        entity.x = entity.v;
        entity.y = entity.w;
        if (flag && entity.ae) {
            if (entity.k != null) {
                entity.y();
            } else {
                entity.b_();
            }
        }
        int k1 = MathHelper.b(entity.p / 16D);
        int l1 = MathHelper.b(entity.q / 16D);
        int i2 = MathHelper.b(entity.r / 16D);

        if (!entity.ae || entity.af != k1 || entity.ag != l1 || entity.ah != i2) {
            if (entity.ae && f(entity.af, entity.ah)) {
                c(entity.af, entity.ah).a(entity, entity.ag);
            }
            if (f(k1, i2)) {
                entity.ae = true;
                c(k1, i2).a(entity);
            } else {
                entity.ae = false;
            }
        }
        if (flag && entity.ae && entity.j != null) {
            if (entity.j.F || entity.j.k != entity) {
                entity.j.k = null;
                entity.j = null;
            } else {
                e(entity.j);
            }
        }
        if (Double.isNaN(entity.p) || Double.isInfinite(entity.p)) {
            entity.p = entity.N;
        }
        if (Double.isNaN(entity.q) || Double.isInfinite(entity.q)) {
            entity.q = entity.O;
        }
        if (Double.isNaN(entity.r) || Double.isInfinite(entity.r)) {
            entity.r = entity.P;
        }
        if (Double.isNaN(entity.w) || Double.isInfinite(entity.w)) {
            entity.w = entity.y;
        }
        if (Double.isNaN(entity.v) || Double.isInfinite(entity.v)) {
            entity.v = entity.x;
        }
    }

    public boolean a(AxisAlignedBB axisalignedbb) {
        List list = b(((Entity) (null)), axisalignedbb);

        for (int i1 = 0; i1 < list.size(); i1++) {
            Entity entity = (Entity) list.get(i1);

            if (!entity.F && entity.i) {
                return false;
            }
        }

        return true;
    }

    public boolean b(AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        if (axisalignedbb.a < 0.0D) {
            i1--;
        }
        if (axisalignedbb.b < 0.0D) {
            k1--;
        }
        if (axisalignedbb.c < 0.0D) {
            i2--;
        }
        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.m[a(k2, l2, i3)];

                    if (block != null && block.bs.d()) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean c(AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    int j3 = a(k2, l2, i3);

                    if (j3 == Block.ar.bh || j3 == Block.C.bh || j3 == Block.D.bh) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material, Entity entity) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);
        boolean flag = false;
        Vec3D vec3d = Vec3D.b(0.0D, 0.0D, 0.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.m[a(k2, l2, i3)];

                    if (block == null || block.bs != material) {
                        continue;
                    }
                    double d1 = (float) (l2 + 1) - BlockFluids.b(b(k2, l2, i3));

                    if ((double) l1 >= d1) {
                        flag = true;
                        block.a(this, k2, l2, i3, entity, vec3d);
                    }
                }

            }

        }

        if (vec3d.c() > 0.0D) {
            vec3d = vec3d.b();
            double d2 = 0.0040000000000000001D;

            entity.s += vec3d.a * d2;
            entity.t += vec3d.b * d2;
            entity.u += vec3d.c * d2;
        }
        return flag;
    }

    public boolean a(AxisAlignedBB axisalignedbb, Material material) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.m[a(k2, l2, i3)];

                    if (block != null && block.bs == material) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public boolean b(AxisAlignedBB axisalignedbb, Material material) {
        int i1 = MathHelper.b(axisalignedbb.a);
        int j1 = MathHelper.b(axisalignedbb.d + 1.0D);
        int k1 = MathHelper.b(axisalignedbb.b);
        int l1 = MathHelper.b(axisalignedbb.e + 1.0D);
        int i2 = MathHelper.b(axisalignedbb.c);
        int j2 = MathHelper.b(axisalignedbb.f + 1.0D);

        for (int k2 = i1; k2 < j1; k2++) {
            for (int l2 = k1; l2 < l1; l2++) {
                for (int i3 = i2; i3 < j2; i3++) {
                    Block block = Block.m[a(k2, l2, i3)];

                    if (block == null || block.bs != material) {
                        continue;
                    }
                    int j3 = b(k2, l2, i3);
                    double d1 = l2 + 1;

                    if (j3 < 8) {
                        d1 = (double) (l2 + 1) - (double) j3 / 8D;
                    }
                    if (d1 >= axisalignedbb.b) {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void a(Entity entity, double d1, double d2, double d3, 
            float f1) {
        (new Explosion()).a(this, entity, d1, d2, d3, f1);
    }

    public float a(Vec3D vec3d, AxisAlignedBB axisalignedbb) {
        double d1 = 1.0D / ((axisalignedbb.d - axisalignedbb.a) * 2D + 1.0D);
        double d2 = 1.0D / ((axisalignedbb.e - axisalignedbb.b) * 2D + 1.0D);
        double d3 = 1.0D / ((axisalignedbb.f - axisalignedbb.c) * 2D + 1.0D);
        int i1 = 0;
        int j1 = 0;

        for (float f1 = 0.0F; f1 <= 1.0F; f1 = (float) ((double) f1 + d1)) {
            for (float f2 = 0.0F; f2 <= 1.0F; f2 = (float) ((double) f2 + d2)) {
                for (float f3 = 0.0F; f3 <= 1.0F; f3 = (float) ((double) f3 + d3)) {
                    double d4 = axisalignedbb.a + (axisalignedbb.d - axisalignedbb.a) * (double) f1;
                    double d5 = axisalignedbb.b + (axisalignedbb.e - axisalignedbb.b) * (double) f2;
                    double d6 = axisalignedbb.c + (axisalignedbb.f - axisalignedbb.c) * (double) f3;

                    if (a(Vec3D.b(d4, d5, d6), vec3d) == null) {
                        i1++;
                    }
                    j1++;
                }

            }

        }

        return (float) i1 / (float) j1;
    }

    public TileEntity k(int i1, int j1, int k1) {
        Chunk chunk = c(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            return chunk.d(i1 & 0xf, j1, k1 & 0xf);
        } else {
            return null;
        }
    }

    public void a(int i1, int j1, int k1, TileEntity tileentity) {
        Chunk chunk = c(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            chunk.a(i1 & 0xf, j1, k1 & 0xf, tileentity);
        }
    }

    public void l(int i1, int j1, int k1) {
        Chunk chunk = c(i1 >> 4, k1 >> 4);

        if (chunk != null) {
            chunk.e(i1 & 0xf, j1, k1 & 0xf);
        }
    }

    public boolean d(int i1, int j1, int k1) {
        Block block = Block.m[a(i1, j1, k1)];

        if (block == null) {
            return false;
        } else {
            return block.a();
        }
    }

    public boolean d() {
        if (J >= 50) {
            return false;
        }
        J++;
        try {
            int i1 = 5000;

            for (; A.size() > 0; ((MetadataChunkBlock) A.remove(A.size() - 1)).a(this)) {
                if (--i1 <= 0) {
                    boolean flag = true;

                    return flag;
                }
            }

            boolean flag1 = false;

            return flag1;
        } finally {
            J--;
        }
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1, int i2, int j2) {
        a(enumskyblock, i1, j1, k1, l1, i2, j2, true);
    }

    public void a(EnumSkyBlock enumskyblock, int i1, int j1, int k1, int l1, int i2, int j2, 
            boolean flag) {
        if (q.e && enumskyblock == EnumSkyBlock.a) {
            return;
        }
        y++;
        if (y == 50) {
            y--;
            return;
        }
        int k2 = (l1 + i1) / 2;
        int l2 = (j2 + k1) / 2;

        if (!e(k2, 64, l2)) {
            y--;
            return;
        }
        int i3 = A.size();

        if (flag) {
            int j3 = 4;

            if (j3 > i3) {
                j3 = i3;
            }
            for (int k3 = 0; k3 < j3; k3++) {
                MetadataChunkBlock metadatachunkblock = (MetadataChunkBlock) A.get(A.size() - k3 - 1);

                if (metadatachunkblock.a == enumskyblock && metadatachunkblock.a(i1, j1, k1, l1, i2, j2)) {
                    y--;
                    return;
                }
            }

        }
        A.add(new MetadataChunkBlock(enumskyblock, i1, j1, k1, l1, i2, j2));
        if (A.size() > 0x186a0) {
            A.clear();
        }
        y--;
    }

    public void e() {
        int i1 = a(1.0F);

        if (i1 != f) {
            f = i1;
        }
    }

    public void f() {
        SpawnerAnimals.a(this);
        G.a();
        int i1 = a(1.0F);

        if (i1 != f) {
            f = i1;
            for (int j1 = 0; j1 < r.size(); j1++) {
                ((IWorldAccess) r.get(j1)).a();
            }

        }
        e++;
        if (e % (long) j == 0L) {
            a(false, ((IProgressUpdate) (null)));
        }
        a(false);
        g();
    }

    protected void g() {
        K.clear();
        for (int i1 = 0; i1 < d.size(); i1++) {
            EntityPlayer entityplayer = (EntityPlayer) d.get(i1);
            int j1 = MathHelper.b(entityplayer.p / 16D);
            int l1 = MathHelper.b(entityplayer.r / 16D);
            byte byte0 = 9;

            for (int j2 = -byte0; j2 <= byte0; j2++) {
                for (int i3 = -byte0; i3 <= byte0; i3++) {
                    K.add(new ChunkCoordIntPair(j2 + j1, i3 + l1));
                }

            }

        }

        if (L > 0) {
            L--;
        }
        for (Iterator iterator = K.iterator(); iterator.hasNext();) {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();
            int k1 = chunkcoordintpair.a * 16;
            int i2 = chunkcoordintpair.b * 16;
            Chunk chunk = c(chunkcoordintpair.a, chunkcoordintpair.b);

            if (L == 0) {
                g = g * 3 + h;
                int k2 = g >> 2;
                int j3 = k2 & 0xf;
                int l3 = k2 >> 8 & 0xf;
                int j4 = k2 >> 16 & 0x7f;
                int l4 = chunk.a(j3, j4, l3);

                j3 += k1;
                l3 += i2;
                if (l4 == 0 && h(j3, j4, l3) <= l.nextInt(8) && a(EnumSkyBlock.a, j3, j4, l3) <= 0) {
                    EntityPlayer entityplayer1 = a((double) j3 + 0.5D, (double) j4 + 0.5D, (double) l3 + 0.5D, 8D);

                    if (entityplayer1 != null && entityplayer1.d((double) j3 + 0.5D, (double) j4 + 0.5D, (double) l3 + 0.5D) > 4D) {
                        a((double) j3 + 0.5D, (double) j4 + 0.5D, (double) l3 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + l.nextFloat() * 0.2F);
                        L = l.nextInt(12000) + 6000;
                    }
                }
            }
            int l2 = 0;

            while (l2 < 80) {
                g = g * 3 + h;
                int k3 = g >> 2;
                int i4 = k3 & 0xf;
                int k4 = k3 >> 8 & 0xf;
                int i5 = k3 >> 16 & 0x7f;
                byte byte1 = chunk.b[i4 << 11 | k4 << 7 | i5];

                if (Block.n[byte1]) {
                    Block.m[byte1].a(this, i4 + k1, i5, k4 + i2, l);
                }
                l2++;
            }
        }

    }

    public boolean a(boolean flag) {
        int i1 = C.size();

        if (i1 != D.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (i1 > 1000) {
            i1 = 1000;
        }
        for (int j1 = 0; j1 < i1; j1++) {
            NextTickListEntry nextticklistentry = (NextTickListEntry) C.first();

            if (!flag && nextticklistentry.e > e) {
                break;
            }
            C.remove(nextticklistentry);
            D.remove(nextticklistentry);
            byte byte0 = 8;

            if (!a(nextticklistentry.a - byte0, nextticklistentry.b - byte0, nextticklistentry.c - byte0, nextticklistentry.a + byte0, nextticklistentry.b + byte0, nextticklistentry.c + byte0)) {
                continue;
            }
            int k1 = a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);

            if (k1 == nextticklistentry.d && k1 > 0) {
                Block.m[k1].a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, l);
            }
        }

        return C.size() != 0;
    }

    public List b(Entity entity, AxisAlignedBB axisalignedbb) {
        M.clear();
        int i1 = MathHelper.b((axisalignedbb.a - 2D) / 16D);
        int j1 = MathHelper.b((axisalignedbb.d + 2D) / 16D);
        int k1 = MathHelper.b((axisalignedbb.c - 2D) / 16D);
        int l1 = MathHelper.b((axisalignedbb.f + 2D) / 16D);

        for (int i2 = i1; i2 <= j1; i2++) {
            for (int j2 = k1; j2 <= l1; j2++) {
                if (f(i2, j2)) {
                    c(i2, j2).a(entity, axisalignedbb, M);
                }
            }

        }

        return M;
    }

    public List a(Class class1, AxisAlignedBB axisalignedbb) {
        int i1 = MathHelper.b((axisalignedbb.a - 2D) / 16D);
        int j1 = MathHelper.b((axisalignedbb.d + 2D) / 16D);
        int k1 = MathHelper.b((axisalignedbb.c - 2D) / 16D);
        int l1 = MathHelper.b((axisalignedbb.f + 2D) / 16D);
        ArrayList arraylist = new ArrayList();

        for (int i2 = i1; i2 <= j1; i2++) {
            for (int j2 = k1; j2 <= l1; j2++) {
                if (f(i2, j2)) {
                    c(i2, j2).a(class1, axisalignedbb, arraylist);
                }
            }

        }

        return arraylist;
    }

    public void b(int i1, int j1, int k1, TileEntity tileentity) {
        if (e(i1, j1, k1)) {
            b(i1, k1).f();
        }
        for (int l1 = 0; l1 < r.size(); l1++) {
            ((IWorldAccess) r.get(l1)).a(i1, j1, k1, tileentity);
        }

    }

    public int a(Class class1) {
        int i1 = 0;

        for (int j1 = 0; j1 < b.size(); j1++) {
            Entity entity = (Entity) b.get(j1);

            if (class1.isAssignableFrom(entity.getClass())) {
                i1++;
            }
        }

        return i1;
    }

    public void a(List list) {
        b.addAll(list);
        for (int i1 = 0; i1 < list.size(); i1++) {
            b((Entity) list.get(i1));
        }

    }

    public void b(List list) {
        B.addAll(list);
    }

    public boolean a(int i1, int j1, int k1, int l1, boolean flag) {
        int i2 = a(j1, k1, l1);
        Block block = Block.m[i2];
        Block block1 = Block.m[i1];
        AxisAlignedBB axisalignedbb = block1.d(this, j1, k1, l1);

        if (flag) {
            axisalignedbb = null;
        }
        if (axisalignedbb != null && !a(axisalignedbb)) {
            return false;
        }
        if (block == Block.A || block == Block.B || block == Block.C || block == Block.D || block == Block.ar || block == Block.aS) {
            return true;
        }
        return i1 > 0 && block == null && block1.a(this, j1, k1, l1);
    }

    public PathEntity a(Entity entity, Entity entity1, float f1) {
        int i1 = MathHelper.b(entity.p);
        int j1 = MathHelper.b(entity.q);
        int k1 = MathHelper.b(entity.r);
        int l1 = (int) (f1 + 16F);
        int i2 = i1 - l1;
        int j2 = j1 - l1;
        int k2 = k1 - l1;
        int l2 = i1 + l1;
        int i3 = j1 + l1;
        int j3 = k1 + l1;
        ChunkCache chunkcache = new ChunkCache(this, i2, j2, k2, l2, i3, j3);

        return (new Pathfinder(chunkcache)).a(entity, entity1, f1);
    }

    public PathEntity a(Entity entity, int i1, int j1, int k1, float f1) {
        int l1 = MathHelper.b(entity.p);
        int i2 = MathHelper.b(entity.q);
        int j2 = MathHelper.b(entity.r);
        int k2 = (int) (f1 + 8F);
        int l2 = l1 - k2;
        int i3 = i2 - k2;
        int j3 = j2 - k2;
        int k3 = l1 + k2;
        int l3 = i2 + k2;
        int i4 = j2 + k2;
        ChunkCache chunkcache = new ChunkCache(this, l2, i3, j3, k3, l3, i4);

        return (new Pathfinder(chunkcache)).a(entity, i1, j1, k1, f1);
    }

    public boolean i(int i1, int j1, int k1, int l1) {
        int i2 = a(i1, j1, k1);

        if (i2 == 0) {
            return false;
        } else {
            return Block.m[i2].d(this, i1, j1, k1, l1);
        }
    }

    public boolean m(int i1, int j1, int k1) {
        if (i(i1, j1 - 1, k1, 0)) {
            return true;
        }
        if (i(i1, j1 + 1, k1, 1)) {
            return true;
        }
        if (i(i1, j1, k1 - 1, 2)) {
            return true;
        }
        if (i(i1, j1, k1 + 1, 3)) {
            return true;
        }
        if (i(i1 - 1, j1, k1, 4)) {
            return true;
        }
        return i(i1 + 1, j1, k1, 5);
    }

    public boolean j(int i1, int j1, int k1, int l1) {
        if (d(i1, j1, k1)) {
            return m(i1, j1, k1);
        }
        int i2 = a(i1, j1, k1);

        if (i2 == 0) {
            return false;
        } else {
            return Block.m[i2].b(this, i1, j1, k1, l1);
        }
    }

    public boolean n(int i1, int j1, int k1) {
        if (j(i1, j1 - 1, k1, 0)) {
            return true;
        }
        if (j(i1, j1 + 1, k1, 1)) {
            return true;
        }
        if (j(i1, j1, k1 - 1, 2)) {
            return true;
        }
        if (j(i1, j1, k1 + 1, 3)) {
            return true;
        }
        if (j(i1 - 1, j1, k1, 4)) {
            return true;
        }
        return j(i1 + 1, j1, k1, 5);
    }

    public EntityPlayer a(Entity entity, double d1) {
        return a(entity.p, entity.q, entity.r, d1);
    }

    public EntityPlayer a(double d1, double d2, double d3, double d4) {
        double d5 = -1D;
        EntityPlayer entityplayer = null;

        for (int i1 = 0; i1 < d.size(); i1++) {
            EntityPlayer entityplayer1 = (EntityPlayer) d.get(i1);
            double d6 = entityplayer1.d(d1, d2, d3);

            if ((d4 < 0.0D || d6 < d4 * d4) && (d5 == -1D || d6 < d5)) {
                d5 = d6;
                entityplayer = entityplayer1;
            }
        }

        return entityplayer;
    }

    public byte[] c(int i1, int j1, int k1, int l1, int i2, int j2) {
        byte abyte0[] = new byte[(l1 * i2 * j2 * 5) / 2];
        int k2 = i1 >> 4;
        int l2 = k1 >> 4;
        int i3 = (i1 + l1) - 1 >> 4;
        int j3 = (k1 + j2) - 1 >> 4;
        int k3 = 0;
        int l3 = j1;
        int i4 = j1 + i2;

        if (l3 < 0) {
            l3 = 0;
        }
        if (i4 > 128) {
            i4 = 128;
        }
        for (int j4 = k2; j4 <= i3; j4++) {
            int k4 = i1 - j4 * 16;
            int l4 = (i1 + l1) - j4 * 16;

            if (k4 < 0) {
                k4 = 0;
            }
            if (l4 > 16) {
                l4 = 16;
            }
            for (int i5 = l2; i5 <= j3; i5++) {
                int j5 = k1 - i5 * 16;
                int k5 = (k1 + j2) - i5 * 16;

                if (j5 < 0) {
                    j5 = 0;
                }
                if (k5 > 16) {
                    k5 = 16;
                }
                k3 = c(j4, i5).a(abyte0, k4, l3, j5, l4, i4, k5, k3);
            }

        }

        return abyte0;
    }

    public void h() {
        try {
            File file = new File(t, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));

            try {
                if (datainputstream.readLong() != F) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            } finally {
                datainputstream.close();
            }
        } catch (IOException ioexception) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public boolean a(EntityPlayer entityplayer, int i1, int j1, int k1) {
        return true;
    }

}

