package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet8 extends Packet {

    public int a;

    public Packet8() {}

    public Packet8(int i) {
        a = i;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeShort(a);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 2;
    }
}

