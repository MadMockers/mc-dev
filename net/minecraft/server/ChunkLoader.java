package net.minecraft.server;


import java.io.*;
import java.util.*;


public class ChunkLoader
        implements IChunkLoader {

    private File a;
    private boolean b;

    public ChunkLoader(File file, boolean flag) {
        a = file;
        b = flag;
    }

    private File a(int i, int j) {
        String s = (new StringBuilder()).append("c.").append(Integer.toString(i, 36)).append(".").append(Integer.toString(j, 36)).append(".dat").toString();
        String s1 = Integer.toString(i & 0x3f, 36);
        String s2 = Integer.toString(j & 0x3f, 36);
        File file = new File(a, s1);

        if (!file.exists()) {
            if (b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        file = new File(file, s2);
        if (!file.exists()) {
            if (b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        file = new File(file, s);
        if (!file.exists() && !b) {
            return null;
        } else {
            return file;
        }
    }

    public Chunk a(World world, int i, int j) {
        File file = a(i, j);

        if (file != null && file.exists()) {
            try {
                FileInputStream fileinputstream = new FileInputStream(file);
                NBTTagCompound nbttagcompound = CompressedStreamTools.a(fileinputstream);

                if (!nbttagcompound.a("Level")) {
                    System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is missing level data, skipping").toString());
                    return null;
                }
                if (!nbttagcompound.j("Level").a("Blocks")) {
                    System.out.println((new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is missing block data, skipping").toString());
                    return null;
                }
                Chunk chunk = a(world, nbttagcompound.j("Level"));

                if (!chunk.a(i, j)) {
                    System.out.println(
                            (new StringBuilder()).append("Chunk file at ").append(i).append(",").append(j).append(" is in the wrong location; relocating. (Expected ").append(i).append(", ").append(j).append(", got ").append(chunk.j).append(", ").append(chunk.k).append(")").toString());
                    nbttagcompound.a("xPos", i);
                    nbttagcompound.a("zPos", j);
                    chunk = a(world, nbttagcompound.j("Level"));
                }
                return chunk;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void a(World world, Chunk chunk) {
        world.h();
        File file = a(chunk.j, chunk.k);

        if (file.exists()) {
            world.v -= file.length();
        }
        try {
            File file1 = new File(a, "tmp_chunk.dat");
            FileOutputStream fileoutputstream = new FileOutputStream(file1);
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            nbttagcompound.a("Level", nbttagcompound1);
            a(chunk, world, nbttagcompound1);
            CompressedStreamTools.a(nbttagcompound, fileoutputstream);
            fileoutputstream.close();
            if (file.exists()) {
                file.delete();
            }
            file1.renameTo(file);
            world.v += file.length();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(Chunk chunk, World world, NBTTagCompound nbttagcompound) {
        world.h();
        nbttagcompound.a("xPos", chunk.j);
        nbttagcompound.a("zPos", chunk.k);
        nbttagcompound.a("LastUpdate", world.e);
        nbttagcompound.a("Blocks", chunk.b);
        nbttagcompound.a("Data", chunk.e.a);
        nbttagcompound.a("SkyLight", chunk.f.a);
        nbttagcompound.a("BlockLight", chunk.g.a);
        nbttagcompound.a("HeightMap", chunk.h);
        nbttagcompound.a("TerrainPopulated", chunk.n);
        chunk.r = false;
        NBTTagList nbttaglist = new NBTTagList();

        label0:
        for (int i = 0; i < chunk.m.length; i++) {
            Iterator iterator = chunk.m[i].iterator();

            do {
                if (!iterator.hasNext()) {
                    continue label0;
                }
                Entity entity = (Entity) iterator.next();

                chunk.r = true;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                if (entity.c(nbttagcompound1)) {
                    nbttaglist.a(nbttagcompound1);
                }
            } while (true);
        }

        nbttagcompound.a("Entities", nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();
        NBTTagCompound nbttagcompound2;

        for (Iterator iterator1 = chunk.l.values().iterator(); iterator1.hasNext(); nbttaglist1.a(nbttagcompound2)) {
            TileEntity tileentity = (TileEntity) iterator1.next();

            nbttagcompound2 = new NBTTagCompound();
            tileentity.b(nbttagcompound2);
        }

        nbttagcompound.a("TileEntities", nbttaglist1);
    }

    public static Chunk a(World world, NBTTagCompound nbttagcompound) {
        int i = nbttagcompound.d("xPos");
        int j = nbttagcompound.d("zPos");
        Chunk chunk = new Chunk(world, i, j);

        chunk.b = nbttagcompound.i("Blocks");
        chunk.e = new NibbleArray(nbttagcompound.i("Data"));
        chunk.f = new NibbleArray(nbttagcompound.i("SkyLight"));
        chunk.g = new NibbleArray(nbttagcompound.i("BlockLight"));
        chunk.h = nbttagcompound.i("HeightMap");
        chunk.n = nbttagcompound.l("TerrainPopulated");
        if (!chunk.e.a()) {
            chunk.e = new NibbleArray(chunk.b.length);
        }
        if (chunk.h == null || !chunk.f.a()) {
            chunk.h = new byte[256];
            chunk.f = new NibbleArray(chunk.b.length);
            chunk.b();
        }
        if (!chunk.g.a()) {
            chunk.g = new NibbleArray(chunk.b.length);
            chunk.a();
        }
        NBTTagList nbttaglist = nbttagcompound.k("Entities");

        if (nbttaglist != null) {
            for (int k = 0; k < nbttaglist.b(); k++) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(k);
                Entity entity = EntityList.a(nbttagcompound1, world);

                chunk.r = true;
                if (entity != null) {
                    chunk.a(entity);
                }
            }

        }
        NBTTagList nbttaglist1 = nbttagcompound.k("TileEntities");

        if (nbttaglist1 != null) {
            for (int l = 0; l < nbttaglist1.b(); l++) {
                NBTTagCompound nbttagcompound2 = (NBTTagCompound) nbttaglist1.a(l);
                TileEntity tileentity = TileEntity.c(nbttagcompound2);

                if (tileentity != null) {
                    chunk.a(tileentity);
                }
            }

        }
        return chunk;
    }

    public void a() {}

    public void b() {}

    public void b(World world, Chunk chunk) {}
}

