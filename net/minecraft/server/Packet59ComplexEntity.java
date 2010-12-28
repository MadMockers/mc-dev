package net.minecraft.server;


import java.io.*;


public class Packet59ComplexEntity extends Packet {

    public int a;
    public int b;
    public int c;
    public byte d[];
    public NBTTagCompound e;

    public Packet59ComplexEntity() {
        j = true;
    }

    public Packet59ComplexEntity(int i, int j, int k, TileEntity tileentity) {
        this.j = true;
        a = i;
        b = j;
        c = k;
        e = new NBTTagCompound();
        tileentity.b(e);
        try {
            d = CompressedStreamTools.a(e);
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readShort();
        c = datainputstream.readInt();
        int i = datainputstream.readShort() & 0xffff;

        d = new byte[i];
        datainputstream.readFully(d);
        e = CompressedStreamTools.a(d);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeShort((short) d.length);
        dataoutputstream.write(d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return d.length + 2 + 10;
    }
}

