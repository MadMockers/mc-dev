package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet1Login extends Packet {

    public int a;
    public String b;
    public String c;
    public long d;
    public byte e;

    public Packet1Login() {}

    public Packet1Login(String s, String s1, int i, long l, byte byte0) {
        b = s;
        c = s1;
        a = i;
        d = l;
        e = byte0;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readUTF();
        c = datainputstream.readUTF();
        d = datainputstream.readLong();
        e = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeUTF(b);
        dataoutputstream.writeUTF(c);
        dataoutputstream.writeLong(d);
        dataoutputstream.writeByte(e);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 4 + b.length() + c.length() + 4 + 5;
    }
}

