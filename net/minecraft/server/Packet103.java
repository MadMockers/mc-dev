package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet103 extends Packet {

    public int a;
    public int b;
    public ItemStack c;

    public Packet103() {}

    public Packet103(int i, int j, ItemStack itemstack) {
        a = i;
        b = j;
        c = itemstack != null ? itemstack.d() : itemstack;
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readByte();
        b = datainputstream.readShort();
        short word0 = datainputstream.readShort();

        if (word0 >= 0) {
            byte byte0 = datainputstream.readByte();
            byte byte1 = datainputstream.readByte();

            c = new ItemStack(word0, byte0, byte1);
        } else {
            c = null;
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(a);
        dataoutputstream.writeShort(b);
        if (c == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(c.c);
            dataoutputstream.writeByte(c.a);
            dataoutputstream.writeByte(c.d);
        }
    }

    public int a() {
        return 7;
    }
}

