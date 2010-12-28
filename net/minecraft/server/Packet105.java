package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet105 extends Packet {

    public int a;
    public int b;
    public int c;

    public Packet105() {}

    public Packet105(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readByte();
        b = datainputstream.readShort();
        c = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeShort(c);
    }

    public int a() {
        return 5;
    }
}

