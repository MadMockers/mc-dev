package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet14BlockDig extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet14BlockDig() {}

    public void a(DataInputStream datainputstream) {
        e = datainputstream.read();
        a = datainputstream.readInt();
        b = datainputstream.read();
        c = datainputstream.readInt();
        d = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.write(e);
        dataoutputstream.writeInt(a);
        dataoutputstream.write(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 11;
    }
}

