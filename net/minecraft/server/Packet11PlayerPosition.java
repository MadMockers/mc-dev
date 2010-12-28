package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet11PlayerPosition extends Packet10Flying {

    public Packet11PlayerPosition() {
        h = true;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readDouble();
        b = datainputstream.readDouble();
        d = datainputstream.readDouble();
        c = datainputstream.readDouble();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeDouble(a);
        dataoutputstream.writeDouble(b);
        dataoutputstream.writeDouble(d);
        dataoutputstream.writeDouble(c);
        super.a(dataoutputstream);
    }

    public int a() {
        return 33;
    }
}

