package net.minecraft.server;


public class ChunkPosition {

    public final int a;
    public final int b;
    public final int c;

    public ChunkPosition(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkPosition) {
            ChunkPosition chunkposition = (ChunkPosition) obj;

            return chunkposition.a == a && chunkposition.b == b && chunkposition.c == c;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return a * 0x88f9fa + b * 0xef88b + c;
    }
}

