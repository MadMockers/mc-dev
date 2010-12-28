package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet53BlockChange extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet53BlockChange() {
        j = true;
    }

    public Packet53BlockChange(int i, int j, int k, World world) {
        this.j = true;
        a = i;
        b = j;
        c = k;
        d = world.a(i, j, k);
        e = world.b(i, j, k);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.read();
        c = datainputstream.readInt();
        d = datainputstream.read();
        e = datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.write(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d);
        dataoutputstream.write(e);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 11;
    }
}

