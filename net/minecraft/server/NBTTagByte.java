package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagByte extends NBTBase {

    public byte a;

    public NBTTagByte() {}

    public NBTTagByte(byte byte0) {
        a = byte0;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeByte(a);
    }

    void a(DataInput datainput) {
        a = datainput.readByte();
    }

    public byte a() {
        return 1;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

