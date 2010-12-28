package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet106 extends Packet {

    public int a;
    public short b;
    public boolean c;

    public Packet106() {}

    public Packet106(int i, short word0, boolean flag) {
        a = i;
        b = word0;
        c = flag;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readByte();
        b = datainputstream.readShort();
        c = datainputstream.readByte() != 0;
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeByte(c ? 1 : 0);
    }

    public int a() {
        return 4;
    }
}

