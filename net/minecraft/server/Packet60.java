package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.*;


public class Packet60 extends Packet {

    public double a;
    public double b;
    public double c;
    public float d;
    public Set e;

    public Packet60() {}

    public Packet60(double d1, double d2, double d3, float f, 
            Set set) {
        a = d1;
        b = d2;
        c = d3;
        d = f;
        e = new HashSet(set);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readDouble();
        b = datainputstream.readDouble();
        c = datainputstream.readDouble();
        d = datainputstream.readFloat();
        int i = datainputstream.readInt();

        e = new HashSet();
        int j = (int) a;
        int k = (int) b;
        int l = (int) c;

        for (int i1 = 0; i1 < i; i1++) {
            int j1 = datainputstream.readByte() + j;
            int k1 = datainputstream.readByte() + k;
            int l1 = datainputstream.readByte() + l;

            e.add(new ChunkPosition(j1, k1, l1));
        }

    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeDouble(a);
        dataoutputstream.writeDouble(b);
        dataoutputstream.writeDouble(c);
        dataoutputstream.writeFloat(d);
        dataoutputstream.writeInt(e.size());
        int i = (int) a;
        int j = (int) b;
        int k = (int) c;
        int j1;

        for (Iterator iterator = e.iterator(); iterator.hasNext(); dataoutputstream.writeByte(j1)) {
            ChunkPosition chunkposition = (ChunkPosition) iterator.next();
            int l = chunkposition.a - i;
            int i1 = chunkposition.b - j;

            j1 = chunkposition.c - k;
            dataoutputstream.writeByte(l);
            dataoutputstream.writeByte(i1);
        }

    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 32 + e.size() * 3;
    }
}

