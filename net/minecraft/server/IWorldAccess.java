package net.minecraft.server;


public interface IWorldAccess {

    public abstract void a(int i, int j, int k);

    public abstract void a(int i, int j, int k, int l, int i1, int j1);

    public abstract void a(String s, double d, double d1, double d2, 
            float f, float f1);

    public abstract void a(String s, double d, double d1, double d2, 
            double d3, double d4, double d5);

    public abstract void a(Entity entity);

    public abstract void b(Entity entity);

    public abstract void a();

    public abstract void a(String s, int i, int j, int k);

    public abstract void a(int i, int j, int k, TileEntity tileentity);
}

