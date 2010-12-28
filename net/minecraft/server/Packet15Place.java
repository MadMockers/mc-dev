package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet15Place extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public ItemStack e;

    public Packet15Place() {}

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.read();
        c = datainputstream.readInt();
        d = datainputstream.read();
        short word0 = datainputstream.readShort();

        if (word0 >= 0) {
            byte byte0 = datainputstream.readByte();
            byte byte1 = datainputstream.readByte();

            e = new ItemStack(word0, byte0, byte1);
        } else {
            e = null;
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.write(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
        if (e == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(e.c);
            dataoutputstream.writeByte(e.a);
            dataoutputstream.writeByte(e.d);
        }
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 14;
    }
}

