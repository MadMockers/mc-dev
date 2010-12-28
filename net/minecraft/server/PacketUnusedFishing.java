// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) deadcode fieldsfirst nonlb 
// Source File Name:   SourceFile

package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


// Referenced classes of package net.minecraft.server:
// Packet, Entity, MathHelper, NetHandler

public class PacketUnusedFishing extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;

    public PacketUnusedFishing() {}

    public PacketUnusedFishing(Entity entity, int i) {
        a = entity.g;
        b = MathHelper.b(entity.p * 32D);
        c = MathHelper.b(entity.q * 32D);
        d = MathHelper.b(entity.r * 32D);
        e = (byte) (int) (entity.s * 128D);
        f = (byte) (int) (entity.t * 128D);
        g = (byte) (int) (entity.u * 128D);
        h = i;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        h = datainputstream.readByte();
        b = datainputstream.readInt();
        c = datainputstream.readInt();
        d = datainputstream.readInt();
        e = datainputstream.readByte();
        f = datainputstream.readByte();
        g = datainputstream.readByte();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeByte(h);
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
        return 20;
    }
}
