package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;


public class NBTTagByteArray extends NBTBase {

    public byte a[];

    public NBTTagByteArray() {}

    public NBTTagByteArray(byte abyte0[]) {
        a = abyte0;
    }

    void a(DataOutput dataoutput) {
        dataoutput.writeInt(a.length);
        dataoutput.write(a);
    }

    void a(DataInput datainput) {
        int i = datainput.readInt();

        a = new byte[i];
        datainput.readFully(a);
    }

    public byte a() {
        return 7;
    }

    public String toString() {
        return (new StringBuilder()).append("[").append(a.length).append(" bytes]").toString();
    }
}

