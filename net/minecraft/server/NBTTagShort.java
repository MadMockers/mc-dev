package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagShort extends NBTBase {

    public short a;

    public NBTTagShort() {}

    public NBTTagShort(short word0) {
        a = word0;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeShort(a);
    }

    void a(DataInput datainput) {
        a = datainput.readShort();
    }

    public byte a() {
        return 2;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

