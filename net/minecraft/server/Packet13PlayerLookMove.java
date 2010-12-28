package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Packet13PlayerLookMove extends Packet10Flying {

    public Packet13PlayerLookMove() {
        i = true;
        h = true;
    }

    public Packet13PlayerLookMove(double d, double d1, double d2, double d3, float f, float f1, boolean flag) {
        a = d;
        b = d1;
        this.d = d2;
        c = d3;
        e = f;
        this.f = f1;
        g = flag;
        i = true;
        h = true;
    }

    public void a(DataInputStream datainputstream) {
        a = datainputstream.readDouble();
        b = datainputstream.readDouble();
        d = datainputstream.readDouble();
        c = datainputstream.readDouble();
        e = datainputstream.readFloat();
        f = datainputstream.readFloat();
        super.a(datainputstream);
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeDouble(a);
        dataoutputstream.writeDouble(b);
        dataoutputstream.writeDouble(d);
        dataoutputstream.writeDouble(c);
        dataoutputstream.writeFloat(e);
        dataoutputstream.writeFloat(f);
        super.a(dataoutputstream);
    }

    public int a() {
        return 41;
    }
}

