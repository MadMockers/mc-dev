package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet38 extends Packet {

    public int a;
    public byte b;

    public Packet38() {}

    public Packet38(int i, byte byte0) {
        a = i;
        b = byte0;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(b);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 5;
    }
}

