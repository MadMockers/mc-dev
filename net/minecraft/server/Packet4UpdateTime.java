package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet4UpdateTime extends Packet {

    public long a;

    public Packet4UpdateTime() {}

    public Packet4UpdateTime(long l) {
        a = l;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readLong();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeLong(a);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}

