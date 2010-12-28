package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagLong extends NBTBase {

    public long a;

    public NBTTagLong() {}

    public NBTTagLong(long l) {
        a = l;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeLong(a);
    }

    void a(DataInput datainput) {
        a = datainput.readLong();
    }

    public byte a() {
        return 4;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

