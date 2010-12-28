package net.minecraft.server;


import java.util.*;


public class EntityPlayerMP extends EntityPlayer {

    public NetServerHandler a;
    public MinecraftServer b;
    public ItemInWorldManager c;
    public double d;
    public double e;
    public List f;
    public Set ai;
    public double aj;

    public EntityPlayerMP(MinecraftServer minecraftserver, World world, String s1, ItemInWorldManager iteminworldmanager) {
        super(world);
        f = new LinkedList();
        ai = new HashSet();
        int i = world.m;
        int j = world.o;
        int l = world.n;

        if (!world.q.c) {
            i += V.nextInt(20) - 10;
            l = world.e(i, j);
            j += V.nextInt(20) - 10;
        }
        c((double) i + 0.5D, l, (double) j + 0.5D, 0.0F, 0.0F);
        b = minecraftserver;
        R = 0.0F;
        iteminworldmanager.a = this;
        ar = s1;
        c = iteminworldmanager;
        G = 0.0F;
    }

    public void b_() {}

    public void f(Entity entity) {}

    public boolean a(Entity entity, int i) {
        return false;
    }

    public void a(int i) {}

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
    }

    public void D() {
        s = t = u = 0.0D;
        bj = false;
        super.D();
    }

    public void c(Entity entity, int i) {
        if (!entity.F && (entity instanceof EntityItem)) {
            a.b(new Packet17AddToInventory(((EntityItem) entity).a, i));
            b.k.a(entity, new Packet22Collect(entity.g, g));
        }
        super.c(entity, i);
    }

    public void E() {
        if (!ap) {
            aq = -1;
            ap = true;
            b.k.a(this, new Packet18ArmAnimation(this, 1));
        }
    }

    protected float s() {
        return 1.62F;
    }
}

