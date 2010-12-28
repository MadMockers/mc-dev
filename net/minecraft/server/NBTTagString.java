package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagString extends NBTBase {

    public String a;

    public NBTTagString() {}

    public NBTTagString(String s) {
        a = s;
        if (s == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        } else {
            return;
        }
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeUTF(a);
    }

    void a(DataInput datainput) {
        a = datainput.readUTF();
    }

    public byte a() {
        return 8;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

