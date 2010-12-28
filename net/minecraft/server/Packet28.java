package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet28 extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet28() {}

    public Packet28(int i, double d1, double d2, double d3) {
        a = i;
        double d4 = 0.90000000000000002D;

        if (d1 < -d4) {
            d1 = -d4;
        }
        if (d2 < -d4) {
            d2 = -d4;
        }
        if (d3 < -d4) {
            d3 = -d4;
        }
        if (d1 > d4) {
            d1 = d4;
        }
        if (d2 > d4) {
            d2 = d4;
        }
        if (d3 > d4) {
            d3 = d4;
        }
        b = (int) (d1 * 32000D);
        c = (int) (d2 * 32000D);
        d = (int) (d3 * 32000D);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readShort();
        c = datainputstream.readShort();
        d = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeShort(c);
        dataoutputstream.writeShort(d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 10;
    }
}

