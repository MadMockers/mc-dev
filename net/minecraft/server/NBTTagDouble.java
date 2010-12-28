package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagDouble extends NBTBase {

    public double a;

    public NBTTagDouble() {}

    public NBTTagDouble(double d) {
        a = d;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeDouble(a);
    }

    void a(DataInput datainput) {
        a = datainput.readDouble();
    }

    public byte a() {
        return 6;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a).toString();
    }
}

