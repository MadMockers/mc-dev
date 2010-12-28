package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet21PickupSpawn extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;
    public int i;

    public Packet21PickupSpawn() {}

    public Packet21PickupSpawn(EntityItem entityitem) {
        a = entityitem.g;
        h = entityitem.a.c;
        i = entityitem.a.a;
        b = MathHelper.b(entityitem.p * 32D);
        c = MathHelper.b(entityitem.q * 32D);
        d = MathHelper.b(entityitem.r * 32D);
        e = (byte) (int) (entityitem.s * 128D);
        f = (byte) (int) (entityitem.t * 128D);
        g = (byte) (int) (entityitem.u * 128D);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        h = datainputstream.readShort();
        i = datainputstream.readByte();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readByte();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(h);
        dataoutputstream.writeByte(i);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeByte(e);
        dataoutputstream.writeByte(f);
        dataoutputstream.writeByte(g);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 22;
    }
}

