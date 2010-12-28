package net.minecraft.server;


public class ChunkCoordIntPair {

    public int a;
    public int b;

    public ChunkCoordIntPair(int i, int j) {
        a = i;
        b = j;
    }

    public int hashCode() {
        return a << 8 | b;
    }

    public boolean equals(Object obj) {
        ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) obj;

        return chunkcoordintpair.a == a && chunkcoordintpair.b == b;
    }

    public double a(Entity entity) {
        double d = a * 16 + 8;
        double d1 = b * 16 + 8;
        double d2 = d - entity.p;
        double d3 = d1 - entity.r;

        return d2 * d2 + d3 * d3;
    }
}

