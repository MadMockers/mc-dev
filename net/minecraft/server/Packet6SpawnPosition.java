package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet6SpawnPosition extends Packet {

    public int a;
    public int b;
    public int c;

    public Packet6SpawnPosition() {}

    public Packet6SpawnPosition(int i, int j, int k) {
        a = i;
        b = j;
        c = k;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 12;
    }
}

