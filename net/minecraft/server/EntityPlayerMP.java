package net.minecraft.server;


import java.util.*;


public class EntityPlayerMP extends EntityPlayer {

    public NetServerHandler a;
    public MinecraftServer b;
    public ItemInWorldManager c;
    public double d;
    public double e;
    public List f;
    public Set aj;
    public double ak;
    public boolean al;
    private int bv;

    public EntityPlayerMP(MinecraftServer minecraftserver, World world, String s1, ItemInWorldManager iteminworldmanager) {
        super(world);
        f = new LinkedList();
        aj = new HashSet();
        al = false;
        bv = 0xfa0a1f01;
        int i = world.m;
        int j = world.o;
        int l = world.n;

        if (!world.q.e) {
            i += W.nextInt(20) - 10;
            l = world.e(i, j);
            j += W.nextInt(20) - 10;
        }
        c((double) i + 0.5D, l, (double) j + 0.5D, 0.0F, 0.0F);
        b = minecraftserver;
        S = 0.0F;
        iteminworldmanager.a = this;
        at = s1;
        c = iteminworldmanager;
        H = 0.0F;
    }

    public void b_() {}

    public void f(Entity entity) {
        am.f();
    }

    public boolean a(Entity entity, int i) {
        if (!b.n) {
            if (entity instanceof EntityPlayer) {
                return false;
            }
            if (entity instanceof EntityArrow) {
                EntityArrow entityarrow = (EntityArrow) entity;

                if (entityarrow.b instanceof EntityPlayer) {
                    return false;
                }
            }
        }
        return super.a(entity, i);
    }

    public void a(int i) {
        super.a(i);
    }

    public void k() {
        super.b_();
        ChunkCoordIntPair chunkcoordintpair = null;
        double d1 = 0.0D;

        for (int i = 0; i < f.size(); i++) {
            ChunkCoordIntPair chunkcoordintpair1 = (ChunkCoordIntPair) f.get(i);
            double d2 = chunkcoordintpair1.a(this);

            if (i == 0 || d2 < d1) {
                chunkcoordintpair = chunkcoordintpair1;
                d1 = chunkcoordintpair1.a(this);
            }
        }

        if (chunkcoordintpair != null) {
            boolean flag = false;

            if (d1 < 1024D) {
                flag = true;
            }
            if (a.b() < 2) {
                flag = true;
            }
            if (flag) {
                f.remove(chunkcoordintpair);
                a.b(new Packet51MapChunk(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, 16, 128, 16, b.e));
                List list = b.e.d(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 16, 128, chunkcoordintpair.b * 16 + 16);

                for (int j = 0; j < list.size(); j++) {
                    TileEntity tileentity = (TileEntity) list.get(j);

                    a.b(new Packet59ComplexEntity(tileentity.b, tileentity.c, tileentity.d, tileentity));
                }

            }
        }
        if (aR != bv) {
            a.b(new Packet8(aR));
            bv = aR;
        }
    }

    public void E() {
        s = t = u = 0.0D;
        bs = false;
        super.E();
    }

    public void c(Entity entity, int i) {
        if (!entity.G) {
            if (entity instanceof EntityItem) {
                a.b(new Packet17AddToInventory(((EntityItem) entity).a, i));
                b.k.a(entity, new Packet22Collect(entity.g, g));
            }
            if (entity instanceof EntityArrow) {
                a.b(new Packet17AddToInventory(new ItemStack(Item.j), 1));
                b.k.a(entity, new Packet22Collect(entity.g, g));
            }
        }
        super.c(entity, i);
    }

    public void F() {
        if (!ar) {
            as = -1;
            ar = true;
            b.k.a(this, new Packet18ArmAnimation(this, 1));
        }
    }

    public float s() {
        return 1.62F;
    }

    public void e(Entity entity) {
        super.e(entity);
        a.b(new Packet39(this, k));
        a.a(p, q, r, v, w);
    }

    protected void a(double d1, boolean flag) {}

    public void b(double d1, boolean flag) {
        super.a(d1, flag);
    }

    public boolean p() {
        return al;
    }
}

