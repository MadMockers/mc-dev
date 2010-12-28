package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet130 extends Packet {

    public int a;
    public int b;
    public int c;
    public String d[];

    public Packet130() {
        k = true;
    }

    public Packet130(int i, int j, int k, String as[]) {
        this.k = true;
        a = i;
        b = j;
        c = k;
        d = as;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readShort();
        c = datainputstream.readInt();
        d = new String[4];
        for (int i = 0; i < 4; i++) {
            d[i] = datainputstream.readUTF();
        }

    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        for (int i = 0; i < 4; i++) {
            dataoutputstream.writeUTF(d[i]);
        }

    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        int i = 0;

        for (int j = 0; j < 4; j++) {
            i += d[j].length();
        }

        return i;
    }
}

