package net.minecraft.server;


final class ChunkCoordinates {

    public final int a;
    public final int b;

    public ChunkCoordinates(int i, int j) {
        a = i;
        b = j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkCoordinates) {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates) obj;

            return a == chunkcoordinates.a && b == chunkcoordinates.b;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return a << 16 ^ b;
    }
}

