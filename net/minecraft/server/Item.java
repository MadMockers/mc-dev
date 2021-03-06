package net.minecraft.server;


import java.io.PrintStream;
import java.util.Random;


public class Item {

    protected static Random b = new Random();
    public static Item c[] = new Item[32000];
    public static Item d = (new ItemSpade(0, 2)).a(2, 5).a("shovelIron");
    public static Item e = (new ItemPickaxe(1, 2)).a(2, 6).a("pickaxeIron");
    public static Item f = (new ItemAxe(2, 2)).a(2, 7).a("hatchetIron");
    public static Item g = (new ItemFlintAndSteel(3)).a(5, 0).a("flintAndSteel");
    public static Item h = (new ItemFood(4, 4)).a(10, 0).a("apple");
    public static Item i = (new ItemBow(5)).a(5, 1).a("bow");
    public static Item j = (new Item(6)).a(5, 2).a("arrow");
    public static Item k = (new Item(7)).a(7, 0).a("coal");
    public static Item l = (new Item(8)).a(7, 3).a("emerald");
    public static Item m = (new Item(9)).a(7, 1).a("ingotIron");
    public static Item n = (new Item(10)).a(7, 2).a("ingotGold");
    public static Item o = (new ItemSword(11, 2)).a(2, 4).a("swordIron");
    public static Item p = (new ItemSword(12, 0)).a(0, 4).a("swordWood");
    public static Item q = (new ItemSpade(13, 0)).a(0, 5).a("shovelWood");
    public static Item r = (new ItemPickaxe(14, 0)).a(0, 6).a("pickaxeWood");
    public static Item s = (new ItemAxe(15, 0)).a(0, 7).a("hatchetWood");
    public static Item t = (new ItemSword(16, 1)).a(1, 4).a("swordStone");
    public static Item u = (new ItemSpade(17, 1)).a(1, 5).a("shovelStone");
    public static Item v = (new ItemPickaxe(18, 1)).a(1, 6).a("pickaxeStone");
    public static Item w = (new ItemAxe(19, 1)).a(1, 7).a("hatchetStone");
    public static Item x = (new ItemSword(20, 3)).a(3, 4).a("swordDiamond");
    public static Item y = (new ItemSpade(21, 3)).a(3, 5).a("shovelDiamond");
    public static Item z = (new ItemPickaxe(22, 3)).a(3, 6).a("pickaxeDiamond");
    public static Item A = (new ItemAxe(23, 3)).a(3, 7).a("hatchetDiamond");
    public static Item B = (new Item(24)).a(5, 3).d().a("stick");
    public static Item C = (new Item(25)).a(7, 4).a("bowl");
    public static Item D = (new ItemSoup(26, 10)).a(8, 4).a("mushroomStew");
    public static Item E = (new ItemSword(27, 0)).a(4, 4).a("swordGold");
    public static Item F = (new ItemSpade(28, 0)).a(4, 5).a("shovelGold");
    public static Item G = (new ItemPickaxe(29, 0)).a(4, 6).a("pickaxeGold");
    public static Item H = (new ItemAxe(30, 0)).a(4, 7).a("hatchetGold");
    public static Item I = (new Item(31)).a(8, 0).a("string");
    public static Item J = (new Item(32)).a(8, 1).a("feather");
    public static Item K = (new Item(33)).a(8, 2).a("sulphur");
    public static Item L = (new ItemHoe(34, 0)).a(0, 8).a("hoeWood");
    public static Item M = (new ItemHoe(35, 1)).a(1, 8).a("hoeStone");
    public static Item N = (new ItemHoe(36, 2)).a(2, 8).a("hoeIron");
    public static Item O = (new ItemHoe(37, 3)).a(3, 8).a("hoeDiamond");
    public static Item P = (new ItemHoe(38, 1)).a(4, 8).a("hoeGold");
    public static Item Q;
    public static Item R = (new Item(40)).a(9, 1).a("wheat");
    public static Item S = (new ItemFood(41, 5)).a(9, 2).a("bread");
    public static Item T = (new ItemArmor(42, 0, 0, 0)).a(0, 0).a("helmetCloth");
    public static Item U = (new ItemArmor(43, 0, 0, 1)).a(0, 1).a("chestplateCloth");
    public static Item V = (new ItemArmor(44, 0, 0, 2)).a(0, 2).a("leggingsCloth");
    public static Item W = (new ItemArmor(45, 0, 0, 3)).a(0, 3).a("bootsCloth");
    public static Item X = (new ItemArmor(46, 1, 1, 0)).a(1, 0).a("helmetChain");
    public static Item Y = (new ItemArmor(47, 1, 1, 1)).a(1, 1).a("chestplateChain");
    public static Item Z = (new ItemArmor(48, 1, 1, 2)).a(1, 2).a("leggingsChain");
    public static Item aa = (new ItemArmor(49, 1, 1, 3)).a(1, 3).a("bootsChain");
    public static Item ab = (new ItemArmor(50, 2, 2, 0)).a(2, 0).a("helmetIron");
    public static Item ac = (new ItemArmor(51, 2, 2, 1)).a(2, 1).a("chestplateIron");
    public static Item ad = (new ItemArmor(52, 2, 2, 2)).a(2, 2).a("leggingsIron");
    public static Item ae = (new ItemArmor(53, 2, 2, 3)).a(2, 3).a("bootsIron");
    public static Item af = (new ItemArmor(54, 3, 3, 0)).a(3, 0).a("helmetDiamond");
    public static Item ag = (new ItemArmor(55, 3, 3, 1)).a(3, 1).a("chestplateDiamond");
    public static Item ah = (new ItemArmor(56, 3, 3, 2)).a(3, 2).a("leggingsDiamond");
    public static Item ai = (new ItemArmor(57, 3, 3, 3)).a(3, 3).a("bootsDiamond");
    public static Item aj = (new ItemArmor(58, 1, 4, 0)).a(4, 0).a("helmetGold");
    public static Item ak = (new ItemArmor(59, 1, 4, 1)).a(4, 1).a("chestplateGold");
    public static Item al = (new ItemArmor(60, 1, 4, 2)).a(4, 2).a("leggingsGold");
    public static Item am = (new ItemArmor(61, 1, 4, 3)).a(4, 3).a("bootsGold");
    public static Item an = (new Item(62)).a(6, 0).a("flint");
    public static Item ao = (new ItemFood(63, 3)).a(7, 5).a("porkchopRaw");
    public static Item ap = (new ItemFood(64, 8)).a(8, 5).a("porkchopCooked");
    public static Item aq = (new ItemPainting(65)).a(10, 1).a("painting");
    public static Item ar = (new ItemFood(66, 42)).a(11, 0).a("appleGold");
    public static Item as = (new ItemSign(67)).a(10, 2).a("sign");
    public static Item at;
    public static Item au = (new ItemBucket(69, 0)).a(10, 4).a("bucket");
    public static Item av;
    public static Item aw;
    public static Item ax = (new ItemMinecart(72, 0)).a(7, 8).a("minecart");
    public static Item ay = (new ItemSaddle(73)).a(8, 6).a("saddle");
    public static Item az;
    public static Item aA = (new ItemRedstone(75)).a(8, 3).a("redstone");
    public static Item aB = (new ItemSnowball(76)).a(14, 0).a("snowball");
    public static Item aC = (new ItemBoat(77)).a(8, 8).a("boat");
    public static Item aD = (new Item(78)).a(7, 6).a("leather");
    public static Item aE = (new ItemBucket(79, -1)).a(13, 4).a("milk");
    public static Item aF = (new Item(80)).a(6, 1).a("brick");
    public static Item aG = (new Item(81)).a(9, 3).a("clay");
    public static Item aH;
    public static Item aI = (new Item(83)).a(10, 3).a("paper");
    public static Item aJ = (new Item(84)).a(11, 3).a("book");
    public static Item aK = (new Item(85)).a(14, 1).a("slimeball");
    public static Item aL = (new ItemMinecart(86, 1)).a(7, 9).a("minecartChest");
    public static Item aM = (new ItemMinecart(87, 2)).a(7, 10).a("minecartFurnace");
    public static Item aN = (new ItemEgg(88)).a(12, 0).a("egg");
    public static Item aO = (new Item(89)).a(6, 3).a("compass");
    public static Item aP = (new ItemFishingRod(90)).a(5, 4).a("fishingRod");
    public static Item aQ = (new Item(91)).a(6, 4).a("clock");
    public static Item aR = (new Item(92)).a(9, 4).a("yellowDust");
    public static Item aS = (new ItemFood(93, 2)).a(9, 5).a("fishRaw");
    public static Item aT = (new ItemFood(94, 5)).a(10, 5).a("fishCooked");
    public static Item aU = (new ItemRecord(2000, "13")).a(0, 15).a("record");
    public static Item aV = (new ItemRecord(2001, "cat")).a(1, 15).a("record");
    public final int aW;
    protected int aX;
    protected int aY;
    protected int aZ;
    protected boolean ba;
    private String a;

    protected Item(int i1) {
        aX = 64;
        aY = 32;
        ba = false;
        aW = 256 + i1;
        if (c[256 + i1] != null) {
            System.out.println((new StringBuilder()).append("CONFLICT @ ").append(i1).toString());
        }
        c[256 + i1] = this;
    }

    public Item a(int i1) {
        aZ = i1;
        return this;
    }

    public Item a(int i1, int j1) {
        aZ = i1 + j1 * 16;
        return this;
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i1, int j1, int k1, int l1) {
        return false;
    }

    public float a(ItemStack itemstack, Block block) {
        return 1.0F;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        return itemstack;
    }

    public int b() {
        return aX;
    }

    public int c() {
        return aY;
    }

    public void a(ItemStack itemstack, EntityLiving entityliving) {}

    public void a(ItemStack itemstack, int i1, int j1, int k1, int l1) {}

    public int a(Entity entity) {
        return 1;
    }

    public boolean a(Block block) {
        return false;
    }

    public void b(ItemStack itemstack, EntityLiving entityliving) {}

    public Item d() {
        ba = true;
        return this;
    }

    public Item a(String s1) {
        a = (new StringBuilder()).append("item.").append(s1).toString();
        return this;
    }

    public String a() {
        return a;
    }

    static {
        Q = (new ItemSeeds(39, Block.az.bh)).a(9, 0).a("seeds");
        at = (new ItemDoor(68, Material.c)).a(11, 2).a("doorWood");
        av = (new ItemBucket(70, Block.A.bh)).a(11, 4).a("bucketWater");
        aw = (new ItemBucket(71, Block.C.bh)).a(12, 4).a("bucketLava");
        az = (new ItemDoor(74, Material.e)).a(12, 2).a("doorIron");
        aH = (new ItemReed(82, Block.aX)).a(11, 1).a("reeds");
    }
}

