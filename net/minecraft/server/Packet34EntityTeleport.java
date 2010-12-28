package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet34EntityTeleport extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;

    public Packet34EntityTeleport() {}

    public Packet34EntityTeleport(Entity entity) {
        a = entity.g;
        b = MathHelper.b(entity.p * 32D);
        c = MathHelper.b(entity.q * 32D);
        d = MathHelper.b(entity.r * 32D);
        e = (byte) (int) ((entity.v * 256F) / 360F);
        f = (byte) (int) ((entity.w * 256F) / 360F);
    }

    public Packet34EntityTeleport(int i, int j, int k, int l, byte byte0, byte byte1) {
        a = i;
        b = j;
        c = k;
        d = l;
        e = byte0;
        f = byte1;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = (byte) datainputstream.read();
        f = (byte) datainputstream.read();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
        dataoutputstream.write(e);
        dataoutputstream.write(f);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 34;
    }
}

