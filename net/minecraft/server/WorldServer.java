package net.minecraft.server;


import java.io.File;
import java.util.*;


public class WorldServer extends World {

    public ChunkProviderServer A;
    public boolean B;
    public boolean C;

    public WorldServer(File file, String s, int i) {
        super(file, s, (new Random()).nextLong(), WorldProvider.a(i));
        B = false;
    }

    public void f() {
        super.f();
    }

    protected IChunkProvider a(File file) {
        A = new ChunkProviderServer(this, new ChunkLoader(file, true), q.c());
        return A;
    }

    public List d(int i, int j, int k, int l, int i1, int j1) {
        ArrayList arraylist = new ArrayList();

        for (int k1 = 0; k1 < c.size(); k1++) {
            TileEntity tileentity = (TileEntity) c.get(k1);

            if (tileentity.b >= i && tileentity.c >= j && tileentity.d >= k && tileentity.b < l && tileentity.c < i1 && tileentity.d < j1) {
                arraylist.add(tileentity);
            }
        }

        return arraylist;
    }
}

