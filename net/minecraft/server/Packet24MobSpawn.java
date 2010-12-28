package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet24MobSpawn extends Packet {

    public int a;
    public byte b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;

    public Packet24MobSpawn() {}

    public Packet24MobSpawn(EntityLiving entityliving) {
        a = entityliving.g;
        b = (byte) EntityList.a(entityliving);
        c = MathHelper.b(entityliving.p * 32D);
        d = MathHelper.b(entityliving.q * 32D);
        e = MathHelper.b(entityliving.r * 32D);
        f = (byte) (int) ((entityliving.v * 256F) / 360F);
        g = (byte) (int) ((entityliving.w * 256F) / 360F);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readByte();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readInt();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.writeInt(e);
        dataoutputstream.writeByte(f);
        dataoutputstream.writeByte(g);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 19;
    }
}

