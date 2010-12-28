package net.minecraft.server;


import java.io.*;
import java.util.zip.*;


public class Packet51MapChunk extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g[];
    private int h;

    public Packet51MapChunk() {
        j = true;
    }

    public Packet51MapChunk(int i, int j, int k, int l, int i1, int j1, World world) {
        this.j = true;
        a = i;
        b = j;
        c = k;
        d = l;
        e = i1;
        f = j1;
        byte abyte0[] = world.c(i, j, k, l, i1, j1);
        Deflater deflater = new Deflater(1);

        try {
            deflater.setInput(abyte0);
            deflater.finish();
            g = new byte[(l * i1 * j1 * 5) / 2];
            h = deflater.deflate(g);
        } finally {
            deflater.end();
        }
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readShort();
        c = datainputstream.readInt();
        d = datainputstream.read() + 1;
        e = datainputstream.read() + 1;
        f = datainputstream.read() + 1;
        int i = datainputstream.readInt();
        byte abyte0[] = new byte[i];

        datainputstream.readFully(abyte0);
        g = new byte[(d * e * f * 5) / 2];
        Inflater inflater = new Inflater();

        inflater.setInput(abyte0);
        try {
            inflater.inflate(g);
        } catch (DataFormatException dataformatexception) {
            throw new IOException("Bad compressed data format");
        } finally {
            inflater.end();
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.write(d - 1);
        dataoutputstream.write(e - 1);
        dataoutputstream.write(f - 1);
        dataoutputstream.writeInt(h);
        dataoutputstream.write(g, 0, h);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 17 + h;
    }
}

