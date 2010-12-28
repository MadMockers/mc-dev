package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet5PlayerInventory extends Packet {

    public int a;
    public ItemStack b[];

    public Packet5PlayerInventory() {}

    public Packet5PlayerInventory(int i, ItemStack aitemstack[]) {
        a = i;
        b = new ItemStack[aitemstack.length];
        for (int j = 0; j < b.length; j++) {
            b[j] = aitemstack[j] != null ? aitemstack[j].d() : null;
        }

    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readInt();
        short word0 = datainputstream.readShort();

        b = new ItemStack[word0];
        for (int i = 0; i < word0; i++) {
            short word1 = datainputstream.readShort();

            if (word1 >= 0) {
                byte byte0 = datainputstream.readByte();
                short word2 = datainputstream.readShort();

                b[i] = new ItemStack(word1, byte0, word2);
            }
        }

    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(a);
        dataoutputstream.writeShort(b.length);
        for (int i = 0; i < b.length; i++) {
            if (b[i] == null) {
                dataoutputstream.writeShort(-1);
            } else {
                dataoutputstream.writeShort((short) b[i].c);
                dataoutputstream.writeByte((byte) b[i].a);
                dataoutputstream.writeShort((short) b[i].d);
            }
        }

    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 6 + b.length * 5;
    }
}

