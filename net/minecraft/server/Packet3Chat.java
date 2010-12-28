package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet3Chat extends Packet {

    public String a;

    public Packet3Chat() {}

    public Packet3Chat(String s) {
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
        return a.length();
    }
}

