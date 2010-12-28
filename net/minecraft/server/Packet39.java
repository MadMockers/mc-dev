package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet39 extends Packet {

    public int a;
    public int b;

    public Packet39() {}

    public Packet39(Entity entity, Entity entity1) {
        a = entity.g;
        b = entity1 == null ? -1 : entity1.g;
    }

    public int a() {
        return 8;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        b = datainputstream.readInt();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeInt(b);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }
}

