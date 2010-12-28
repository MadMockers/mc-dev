package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet2Handshake extends Packet {

    public String a;

    public Packet2Handshake() {}

    public Packet2Handshake(String s) {
        a = s;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readUTF();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeUTF(a);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 4 + a.length() + 4;
    }
}

