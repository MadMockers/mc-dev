package net.minecraft.server;


import java.util.ArrayList;
import java.util.Random;


public class Block {

    public static final StepSound d;
    public static final StepSound e;
    public static final StepSound f;
    public static final StepSound g;
    public static final StepSound h;
    public static final StepSound i;
    public static final StepSound j;
    public static final StepSound k;
    public static final StepSound l;
    public static final Block m[];
    public static final boolean n[] = new boolean[256];
    public static final boolean o[] = new boolean[256];
    public static final boolean p[] = new boolean[256];
    public static final int q[] = new int[256];
    public static final boolean r[] = new boolean[256];
    public static final int s[] = new int[256];
    public static final Block t;
    public static final BlockGrass u;
    public static final Block v;
    public static final Block w;
    public static final Block x;
    public static final Block y;
    public static final Block z;
    public static final Block A;
    public static final Block B;
    public static final Block C;
    public static final Block D;
    public static final Block E;
    public static final Block F;
    public static final Block G;
    public static final Block H;
    public static final Block I;
    public static final Block J;
    public static final BlockLeaves K;
    public static final Block L;
    public static final Block M;
    public static final Block N = null;
    public static final Block O = null;
    public static final Block P = null;
    public static final Block Q = null;
    public static final Block R = null;
    public static final Block S = null;
    public static final Block T = null;
    public static final Block U = null;
    public static final Block V = null;
    public static final Block W = null;
    public static final Block X = null;
    public static final Block Y = null;
    public static final Block Z = null;
    public static final Block aa = null;
    public static final Block ab;
    public static final Block ac = null;
    public static final BlockFlower ad;
    public static final BlockFlower ae;
    public static final BlockFlower af;
    public static final BlockFlower ag;
    public static final Block ah;
    public static final Block ai;
    public static final Block aj;
    public static final Block ak;
    public static final Block al;
    public static final Block am;
    public static final Block an;
    public static final Block ao;
    public static final Block ap;
    public static final Block aq;
    public static final BlockFire ar;
    public static final Block as;
    public static final Block at;
    public static final Block au;
    public static final Block av;
    public static final Block aw;
    public static final Block ax;
    public static final Block ay;
    public static final Block az;
    public static final Block aA;
    public static final Block aB;
    public static final Block aC;
    public static final Block aD;
    public static final Block aE;
    public static final Block aF;
    public static final Block aG;
    public static final Block aH;
    public static final Block aI;
    public static final Block aJ;
    public static final Block aK;
    public static final Block aL;
    public static final Block aM;
    public static final Block aN;
    public static final Block aO;
    public static final Block aP;
    public static final Block aQ;
    public static final Block aR;
    public static final Block aS;
    public static final Block aT;
    public static final Block aU;
    public static final Block aV;
    public static final Block aW;
    public static final Block aX;
    public static final Block aY;
    public static final Block aZ;
    public static final Block ba;
    public static final Block bb;
    public static final Block bc;
    public static final Block bd;
    public static final BlockPortal be;
    public static final Block bf;
    public int bg;
    public final int bh;
    protected float bi;
    protected float bj;
    public double bk;
    public double bl;
    public double bm;
    public double bn;
    public double bo;
    public double bp;
    public StepSound bq;
    public float br;
    public final Material bs;
    public float bt;
    private String a;

    protected Block(int i1, Material material) {
        bq = d;
        br = 1.0F;
        bt = 0.6F;
        if (m[i1] != null) {
            throw new IllegalArgumentException((new StringBuilder()).append("Slot ").append(i1).append(" is already occupied by ").append(m[i1]).append(" when adding ").append(this).toString());
        } else {
            bs = material;
            m[i1] = this;
            bh = i1;
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            o[i1] = a();
            q[i1] = a() ? 255 : 0;
            r[i1] = f();
            p[i1] = false;
            return;
        }
    }

    protected Block(int i1, int j1, Material material) {
        this(i1, material);
        bg = j1;
    }

    protected Block a(StepSound stepsound) {
        bq = stepsound;
        return this;
    }

    protected Block c(int i1) {
        q[bh] = i1;
        return this;
    }

    protected Block a(float f1) {
        s[bh] = (int) (15F * f1);
        return this;
    }

    protected Block b(float f1) {
        bj = f1 * 3F;
        return this;
    }

    private boolean f() {
        return false;
    }

    protected Block c(float f1) {
        bi = f1;
        if (bj < f1 * 5F) {
            bj = f1 * 5F;
        }
        return this;
    }

    protected void a(boolean flag) {
        n[bh] = flag;
    }

    public void a(float f1, float f2, float f3, float f4, float f5, float f6) {
        bk = f1;
        bl = f2;
        bm = f3;
        bn = f4;
        bo = f5;
        bp = f6;
    }

    public boolean a(IBlockAccess iblockaccess, int i1, int j1, int k1, int l1) {
        if (l1 == 0 && bl > 0.0D) {
            return true;
        }
        if (l1 == 1 && bo < 1.0D) {
            return true;
        }
        if (l1 == 2 && bm > 0.0D) {
            return true;
        }
        if (l1 == 3 && bp < 1.0D) {
            return true;
        }
        if (l1 == 4 && bk > 0.0D) {
            return true;
        }
        if (l1 == 5 && bn < 1.0D) {
            return true;
        } else {
            return !iblockaccess.d(i1, j1, k1);
        }
    }

    public int a(int i1) {
        return bg;
    }

    public void a(World world, int i1, int j1, int k1, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        AxisAlignedBB axisalignedbb1 = d(world, i1, j1, k1);

        if (axisalignedbb1 != null && axisalignedbb.a(axisalignedbb1)) {
            arraylist.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB d(World world, int i1, int j1, int k1) {
        return AxisAlignedBB.b((double) i1 + bk, (double) j1 + bl, (double) k1 + bm, (double) i1 + bn, (double) j1 + bo, (double) k1 + bp);
    }

    public boolean a() {
        return true;
    }

    public boolean a(int i1, boolean flag) {
        return d();
    }

    public boolean d() {
        return true;
    }

    public void a(World world, int i1, int j1, int k1, Random random) {}

    public void a(World world, int i1, int j1, int k1, int l1) {}

    public void b(World world, int i1, int j1, int k1, int l1) {}

    public int b() {
        return 10;
    }

    public void e(World world, int i1, int j1, int k1) {}

    public void b(World world, int i1, int j1, int k1) {}

    public int a(Random random) {
        return 1;
    }

    public int a(int i1, Random random) {
        return bh;
    }

    public float a(EntityPlayer entityplayer) {
        if (bi < 0.0F) {
            return 0.0F;
        }
        if (!entityplayer.b(this)) {
            return 1.0F / bi / 100F;
        } else {
            return entityplayer.a(this) / bi / 30F;
        }
    }

    public void a_(World world, int i1, int j1, int k1, int l1) {
        a(world, i1, j1, k1, l1, 1.0F);
    }

    public void a(World world, int i1, int j1, int k1, int l1, float f1) {
        if (world.z) {
            return;
        }
        int i2 = a(world.l);

        for (int j2 = 0; j2 < i2; j2++) {
            if (world.l.nextFloat() > f1) {
                continue;
            }
            int k2 = a(l1, world.l);

            if (k2 > 0) {
                float f2 = 0.7F;
                double d1 = (double) (world.l.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                double d2 = (double) (world.l.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                double d3 = (double) (world.l.nextFloat() * f2) + (double) (1.0F - f2) * 0.5D;
                EntityItem entityitem = new EntityItem(world, (double) i1 + d1, (double) j1 + d2, (double) k1 + d3, new ItemStack(k2));

                entityitem.c = 10;
                world.a(entityitem);
            }
        }

    }

    public float a(Entity entity) {
        return bj / 5F;
    }

    public MovingObjectPosition a(World world, int i1, int j1, int k1, Vec3D vec3d, Vec3D vec3d1) {
        a(((IBlockAccess) (world)), i1, j1, k1);
        vec3d = vec3d.c(-i1, -j1, -k1);
        vec3d1 = vec3d1.c(-i1, -j1, -k1);
        Vec3D vec3d2 = vec3d.a(vec3d1, bk);
        Vec3D vec3d3 = vec3d.a(vec3d1, bn);
        Vec3D vec3d4 = vec3d.b(vec3d1, bl);
        Vec3D vec3d5 = vec3d.b(vec3d1, bo);
        Vec3D vec3d6 = vec3d.c(vec3d1, bm);
        Vec3D vec3d7 = vec3d.c(vec3d1, bp);

        if (!a(vec3d2)) {
            vec3d2 = null;
        }
        if (!a(vec3d3)) {
            vec3d3 = null;
        }
        if (!b(vec3d4)) {
            vec3d4 = null;
        }
        if (!b(vec3d5)) {
            vec3d5 = null;
        }
        if (!c(vec3d6)) {
            vec3d6 = null;
        }
        if (!c(vec3d7)) {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;

        if (vec3d2 != null && (vec3d8 == null || vec3d.a(vec3d2) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d2;
        }
        if (vec3d3 != null && (vec3d8 == null || vec3d.a(vec3d3) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d3;
        }
        if (vec3d4 != null && (vec3d8 == null || vec3d.a(vec3d4) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d4;
        }
        if (vec3d5 != null && (vec3d8 == null || vec3d.a(vec3d5) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d5;
        }
        if (vec3d6 != null && (vec3d8 == null || vec3d.a(vec3d6) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d6;
        }
        if (vec3d7 != null && (vec3d8 == null || vec3d.a(vec3d7) < vec3d.a(vec3d8))) {
            vec3d8 = vec3d7;
        }
        if (vec3d8 == null) {
            return null;
        }
        byte byte0 = -1;

        if (vec3d8 == vec3d2) {
            byte0 = 4;
        }
        if (vec3d8 == vec3d3) {
            byte0 = 5;
        }
        if (vec3d8 == vec3d4) {
            byte0 = 0;
        }
        if (vec3d8 == vec3d5) {
            byte0 = 1;
        }
        if (vec3d8 == vec3d6) {
            byte0 = 2;
        }
        if (vec3d8 == vec3d7) {
            byte0 = 3;
        }
        return new MovingObjectPosition(i1, j1, k1, byte0, vec3d8.c(i1, j1, k1));
    }

    private boolean a(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        } else {
            return vec3d.b >= bl && vec3d.b <= bo && vec3d.c >= bm && vec3d.c <= bp;
        }
    }

    private boolean b(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        } else {
            return vec3d.a >= bk && vec3d.a <= bn && vec3d.c >= bm && vec3d.c <= bp;
        }
    }

    private boolean c(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        } else {
            return vec3d.a >= bk && vec3d.a <= bn && vec3d.b >= bl && vec3d.b <= bo;
        }
    }

    public void c(World world, int i1, int j1, int k1) {}

    public boolean a(World world, int i1, int j1, int k1) {
        int l1 = world.a(i1, j1, k1);

        return l1 == 0 || m[l1].bs.d();
    }

    public boolean a(World world, int i1, int j1, int k1, EntityPlayer entityplayer) {
        return false;
    }

    public void b(World world, int i1, int j1, int k1, Entity entity) {}

    public void c(World world, int i1, int j1, int k1, int l1) {}

    public void b(World world, int i1, int j1, int k1, EntityPlayer entityplayer) {}

    public void a(World world, int i1, int j1, int k1, Entity entity, Vec3D vec3d) {}

    public void a(IBlockAccess iblockaccess, int i1, int j1, int k1) {}

    public boolean b(IBlockAccess iblockaccess, int i1, int j1, int k1, int l1) {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void a(World world, int i1, int j1, int k1, Entity entity) {}

    public boolean d(World world, int i1, int j1, int k1, int l1) {
        return false;
    }

    public void g(World world, int i1, int j1, int k1, int l1) {
        a_(world, i1, j1, k1, l1);
    }

    public boolean f(World world, int i1, int j1, int k1) {
        return true;
    }

    public void a(World world, int i1, int j1, int k1, EntityLiving entityliving) {}

    public Block a(String s1) {
        a = (new StringBuilder()).append("tile.").append(s1).toString();
        return this;
    }

    public String e() {
        return a;
    }

    static Class _mthclass$(String s1) {
        try {
            return Class.forName(s1);
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static {
        d = new StepSound("stone", 1.0F, 1.0F);
        e = new StepSound("wood", 1.0F, 1.0F);
        f = new StepSound("gravel", 1.0F, 1.0F);
        g = new StepSound("grass", 1.0F, 1.0F);
        h = new StepSound("stone", 1.0F, 1.0F);
        i = new StepSound("stone", 1.0F, 1.5F);
        j = new StepSoundStone("stone", 1.0F, 1.0F);
        k = new StepSound("cloth", 1.0F, 1.0F);
        l = new StepSoundSand("sand", 1.0F, 1.0F);
        m = new Block[256];
        t = (new BlockStone(1, 1)).c(1.5F).b(10F).a(h).a("stone");
        u = (BlockGrass) (new BlockGrass(2)).c(0.6F).a(g).a("grass");
        v = (new BlockDirt(3, 2)).c(0.5F).a(f).a("dirt");
        w = (new Block(4, 16, Material.d)).c(2.0F).b(10F).a(h).a("stonebrick");
        x = (new Block(5, 4, Material.c)).c(2.0F).b(5F).a(e).a("wood");
        y = (new BlockSapling(6, 15)).c(0.0F).a(g).a("sapling");
        z = (new Block(7, 17, Material.d)).c(-1F).b(6000000F).a(h).a("bedrock");
        A = (new BlockFlowing(8, Material.f)).c(100F).c(3).a("water");
        B = (new BlockStationary(9, Material.f)).c(100F).c(3).a("water");
        C = (new BlockFlowing(10, Material.g)).c(0.0F).a(1.0F).c(255).a("lava");
        D = (new BlockStationary(11, Material.g)).c(100F).a(1.0F).c(255).a("lava");
        E = (new BlockSand(12, 18)).c(0.5F).a(l).a("sand");
        F = (new BlockGravel(13, 19)).c(0.6F).a(f).a("gravel");
        G = (new BlockOre(14, 32)).c(3F).b(5F).a(h).a("oreGold");
        H = (new BlockOre(15, 33)).c(3F).b(5F).a(h).a("oreIron");
        I = (new BlockOre(16, 34)).c(3F).b(5F).a(h).a("oreCoal");
        J = (new BlockLog(17)).c(2.0F).a(e).a("log");
        K = (BlockLeaves) (new BlockLeaves(18, 52)).c(0.2F).c(1).a(g).a("leaves");
        L = (new BlockSponge(19)).c(0.6F).a(g).a("sponge");
        M = (new BlockGlass(20, 49, Material.o, false)).c(0.3F).a(j).a("glass");
        ab = (new Block(35, 64, Material.k)).c(0.8F).a(k).a("cloth");
        ad = (BlockFlower) (new BlockFlower(37, 13)).c(0.0F).a(g).a("flower");
        ae = (BlockFlower) (new BlockFlower(38, 12)).c(0.0F).a(g).a("rose");
        af = (BlockFlower) (new BlockMushroom(39, 29)).c(0.0F).a(g).a(0.125F).a("mushroom");
        ag = (BlockFlower) (new BlockMushroom(40, 28)).c(0.0F).a(g).a("mushroom");
        ah = (new BlockOreBlock(41, 39)).c(3F).b(10F).a(i).a("blockGold");
        ai = (new BlockOreBlock(42, 38)).c(5F).b(10F).a(i).a("blockIron");
        aj = (new BlockStep(43, true)).c(2.0F).b(10F).a(h).a("stoneSlab");
        ak = (new BlockStep(44, false)).c(2.0F).b(10F).a(h).a("stoneSlab");
        al = (new Block(45, 7, Material.d)).c(2.0F).b(10F).a(h).a("brick");
        am = (new BlockTNT(46, 8)).c(0.0F).a(g).a("tnt");
        an = (new BlockBookshelf(47, 35)).c(1.5F).a(e).a("bookshelf");
        ao = (new Block(48, 36, Material.d)).c(2.0F).b(10F).a(h).a("stoneMoss");
        ap = (new BlockObsidian(49, 37)).c(10F).b(2000F).a(h).a("obsidian");
        aq = (new BlockTorch(50, 80)).c(0.0F).a(0.9375F).a(e).a("torch");
        ar = (BlockFire) (new BlockFire(51, 31)).c(0.0F).a(1.0F).a(e).a("fire");
        as = (new BlockMobSpawner(52, 65)).c(5F).a(i).a("mobSpawner");
        at = (new BlockStairs(53, x)).a("stairsWood");
        au = (new BlockChest(54)).c(2.5F).a(e).a("chest");
        av = (new BlockRedstoneWire(55, 84)).c(0.0F).a(d).a("redstoneDust");
        aw = (new BlockOre(56, 50)).c(3F).b(5F).a(h).a("oreDiamond");
        ax = (new BlockOreBlock(57, 40)).c(5F).b(10F).a(i).a("blockDiamond");
        ay = (new BlockWorkbench(58)).c(2.5F).a(e).a("workbench");
        az = (new BlockCrops(59, 88)).c(0.0F).a(g).a("crops");
        aA = (new BlockSoil(60)).c(0.6F).a(f).a("farmland");
        aB = (new BlockFurnace(61, false)).c(3.5F).a(h).a("furnace");
        aC = (new BlockFurnace(62, true)).c(3.5F).a(h).a(0.875F).a("furnace");
        aD = (new BlockSign(63, net.minecraft.server.TileEntitySign.class, true)).c(1.0F).a(e).a("sign");
        aE = (new BlockDoor(64, Material.c)).c(3F).a(e).a("doorWood");
        aF = (new BlockLadder(65, 83)).c(0.4F).a(e).a("ladder");
        aG = (new BlockMinecartTrack(66, 128)).c(0.7F).a(i).a("rail");
        aH = (new BlockStairs(67, w)).a("stairsStone");
        aI = (new BlockSign(68, net.minecraft.server.TileEntitySign.class, false)).c(1.0F).a(e).a("sign");
        aJ = (new BlockLever(69, 96)).c(0.5F).a(e).a("lever");
        aK = (new BlockPressurePlate(70, t.bg, EnumMobType.b)).c(0.5F).a(h).a("pressurePlate");
        aL = (new BlockDoor(71, Material.e)).c(5F).a(i).a("doorIron");
        aM = (new BlockPressurePlate(72, x.bg, EnumMobType.a)).c(0.5F).a(e).a("pressurePlate");
        aN = (new BlockRedstoneOre(73, 51, false)).c(3F).b(5F).a(h).a("oreRedstone");
        aO = (new BlockRedstoneOre(74, 51, true)).a(0.625F).c(3F).b(5F).a(h).a("oreRedstone");
        aP = (new BlockRedstoneTorch(75, 115, false)).c(0.0F).a(e).a("notGate");
        aQ = (new BlockRedstoneTorch(76, 99, true)).c(0.0F).a(0.5F).a(e).a("notGate");
        aR = (new BlockButton(77, t.bg)).c(0.5F).a(h).a("button");
        aS = (new BlockSnow(78, 66)).c(0.1F).a(k).a("snow");
        aT = (new BlockIce(79, 67)).c(0.5F).c(3).a(j).a("ice");
        aU = (new BlockSnowBlock(80, 66)).c(0.2F).a(k).a("snow");
        aV = (new BlockCactus(81, 70)).c(0.4F).a(k).a("cactus");
        aW = (new BlockClay(82, 72)).c(0.6F).a(f).a("clay");
        aX = (new BlockReed(83, 73)).c(0.0F).a(g).a("reeds");
        aY = (new BlockJukeBox(84, 74)).c(2.0F).b(10F).a(h).a("jukebox");
        aZ = (new BlockFence(85, 4)).c(2.0F).b(5F).a(e).a("fence");
        ba = (new BlockPumpkin(86, 102, false)).c(1.0F).a(e).a("pumpkin");
        bb = (new BlockBloodStone(87, 103)).c(0.4F).a(h).a("hellrock");
        bc = (new BlockSlowSand(88, 104)).c(0.5F).a(l).a("hellsand");
        bd = (new BlockLightStone(89, 105, Material.o)).c(0.3F).a(j).a(1.0F).a("lightgem");
        be = (BlockPortal) (new BlockPortal(90, 14)).c(-1F).a(j).a(0.75F).a("portal");
        bf = (new BlockPumpkin(91, 102, true)).c(1.0F).a(e).a(1.0F).a("pumpkin");
        for (int i1 = 0; i1 < 256; i1++) {
            if (m[i1] != null) {
                Item.c[i1] = new ItemBlock(i1 - 256);
            }
        }

    }
}

