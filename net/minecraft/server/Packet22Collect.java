package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet22Collect extends Packet {

    public int a;
    public int b;

    public Packet22Collect() {}

    public Packet22Collect(int i, int j) {
        a = i;
        b = j;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}

