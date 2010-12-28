package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet23VehicleSpawn extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public Packet23VehicleSpawn() {}

    public Packet23VehicleSpawn(Entity entity, int i) {
        a = entity.g;
        b = MathHelper.b(entity.p * 32D);
        c = MathHelper.b(entity.q * 32D);
        d = MathHelper.b(entity.r * 32D);
        e = i;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        e = datainputstream.readByte();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(e);
        dataoutputstream.writeInt(b);
        dataoutputstream.writeInt(c);
        dataoutputstream.writeInt(d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 17;
    }
}

