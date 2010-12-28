package net.minecraft.server;


public class WorldManager
        implements IWorldAccess {

    private MinecraftServer a;

    public WorldManager(MinecraftServer minecraftserver) {
        a = minecraftserver;
    }

    public void a(String s, double d, double d1, double d2, 
            double d3, double d4, double d5) {}

    public void a(Entity entity) {
        a.k.a(entity);
    }

    public void b(Entity entity) {
        a.k.b(entity);
    }

    public void a(String s, double d, double d1, double d2, 
            float f, float f1) {}

    public void a(int i, int j, int k, int l, int i1, int j1) {}

    public void a() {}

    public void a(int i, int j, int k) {
        a.f.a(i, j, k);
    }

    public void a(String s, int i, int j, int k) {}

    public void a(int i, int j, int k, TileEntity tileentity) {
        a.f.a(i, j, k, tileentity);
    }
}

