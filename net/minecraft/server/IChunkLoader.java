package net.minecraft.server;


public interface IChunkLoader {

    public abstract Chunk a(World world, int i, int j);

    public abstract void a(World world, Chunk chunk);

    public abstract void b(World world, Chunk chunk);

    public abstract void a();

    public abstract void b();
}

