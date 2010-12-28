package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet100 extends Packet {

    public int a;
    public int b;
    public String c;
    public int d;

    public Packet100() {}

    public Packet100(int i, int j, String s, int k) {
        a = i;
        b = j;
        c = s;
        d = k;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readByte();
        b = datainputstream.readByte();
        c = datainputstream.readUTF();
        d = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeByte(b);
        dataoutputstream.writeUTF(c);
        dataoutputstream.writeByte(d);
    }

    public int a() {
        return 3 + c.length();
    }
}

