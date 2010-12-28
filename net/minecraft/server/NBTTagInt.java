package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagInt extends NBTBase {

    public int a;

    public NBTTagInt() {}

    public NBTTagInt(int i) {
        a = i;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeInt(a);
    }

    void a(DataInput datainput) {
        a = datainput.readInt();
    }

    public byte a() {
        return 3;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

