package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet102 extends Packet {

    public int a;
    public int b;
    public int c;
    public short d;
    public ItemStack e;

    public Packet102() {}

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readByte();
        b = datainputstream.readShort();
        c = datainputstream.readByte();
        d = datainputstream.readShort();
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
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeByte(c);
        dataoutputstream.writeShort(d);
        if (e == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(e.c);
            dataoutputstream.writeByte(e.a);
            dataoutputstream.writeByte(e.d);
        }
    }

    public int a() {
        return 10;
    }
}

