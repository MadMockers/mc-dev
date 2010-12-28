package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet12PlayerLook extends Packet10Flying {

    public Packet12PlayerLook() {
        i = true;
    }

    public void a(DataInputStream datainputstream) {
        e = datainputstream.readFloat();
        f = datainputstream.readFloat();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeFloat(e);
        dataoutputstream.writeFloat(f);
        super.a(dataoutputstream);
    }

    public int a() {
        return 9;
    }
}

