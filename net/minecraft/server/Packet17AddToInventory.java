package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet17AddToInventory extends Packet {

    public int a;
    public int b;
    public int c;

    public Packet17AddToInventory() {}

    public Packet17AddToInventory(ItemStack itemstack, int i) {
        a = itemstack.c;
        b = i;
        c = itemstack.d;
        if (i == 0) {
            i = 1;
        }
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readShort();
        b = datainputstream.readByte();
        c = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeShort(a);
        dataoutputstream.writeByte(b);
        dataoutputstream.writeShort(c);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 5;
    }
}

