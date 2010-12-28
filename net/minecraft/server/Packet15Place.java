package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet15Place extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet15Place() {}

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readShort();
        b = datainputstream.readInt();
        c = datainputstream.read();
        d = datainputstream.readInt();
        e = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeShort(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.write(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.write(e);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 12;
    }
}

