package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet5PlayerInventory extends Packet {

    public int a;
    public int b;
    public int c;

    public Packet5PlayerInventory() {}

    public Packet5PlayerInventory(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readShort();
        c = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeShort(c);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}

