package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagFloat extends NBTBase {

    public float a;

    public NBTTagFloat() {}

    public NBTTagFloat(float f) {
        a = f;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeFloat(a);
    }

    void a(DataInput datainput) {
        a = datainput.readFloat();
    }

    public byte a() {
        return 5;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

