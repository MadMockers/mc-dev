package net.minecraft.server;


public interface IChunkProvider {

    public abstract boolean a(int i, int j);

    public abstract Chunk b(int i, int j);

    public abstract void a(IChunkProvider ichunkprovider, int i, int j);

    public abstract boolean a(boolean flag, IProgressUpdate iprogressupdate);

    public abstract boolean a();

    public abstract boolean b();
}

