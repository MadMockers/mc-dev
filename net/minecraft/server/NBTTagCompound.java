package net.minecraft.server;


import java.io.DataInput;
import java.io.DataOutput;
import java.util.*;


public class NBTTagCompound extends NBTBase {

    private Map a;

    public NBTTagCompound() {
        a = new HashMap();
    }

    void a(DataOutput dataoutput) {
        NBTBase nbtbase;

        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); NBTBase.a(nbtbase, dataoutput)) {
            nbtbase = (NBTBase) iterator.next();
        }

        dataoutput.writeByte(0);
    }

    void a(DataInput datainput) {
        a.clear();
        NBTBase nbtbase;

        for (; (nbtbase = NBTBase.b(datainput)).a() != 0; a.put(nbtbase.c(), nbtbase)) {
            ;
        }
    }

    public byte a() {
        return 10;
    }

    public void a(String s, NBTBase nbtbase) {
        a.put(s, nbtbase.m(s));
    }

    public void a(String s, byte byte0) {
        a.put(s, (new NBTTagByte(byte0)).m(s));
    }

    public void a(String s, short word0) {
        a.put(s, (new NBTTagShort(word0)).m(s));
    }

    public void a(String s, int i1) {
        a.put(s, (new NBTTagInt(i1)).m(s));
    }

    public void a(String s, long l1) {
        a.put(s, (new NBTTagLong(l1)).m(s));
    }

    public void a(String s, float f1) {
        a.put(s, (new NBTTagFloat(f1)).m(s));
    }

    public void a(String s, double d1) {
        a.put(s, (new NBTTagDouble(d1)).m(s));
    }

    public void a(String s, String s1) {
        a.put(s, (new NBTTagString(s1)).m(s));
    }

    public void a(String s, byte abyte0[]) {
        a.put(s, (new NBTTagByteArray(abyte0)).m(s));
    }

    public void a(String s, NBTTagCompound nbttagcompound) {
        a.put(s, nbttagcompound.m(s));
    }

    public void a(String s, boolean flag) {
        a(s, ((byte) (flag ? 1 : 0)));
    }

    public boolean a(String s) {
        return a.containsKey(s);
    }

    public byte b(String s) {
        if (!a.containsKey(s)) {
            return 0;
        } else {
            return ((NBTTagByte) a.get(s)).a;
        }
    }

    public short c(String s) {
        if (!a.containsKey(s)) {
            return 0;
        } else {
            return ((NBTTagShort) a.get(s)).a;
        }
    }

    public int d(String s) {
        if (!a.containsKey(s)) {
            return 0;
        } else {
            return ((NBTTagInt) a.get(s)).a;
        }
    }

    public long e(String s) {
        if (!a.containsKey(s)) {
            return 0L;
        } else {
            return ((NBTTagLong) a.get(s)).a;
        }
    }

    public float f(String s) {
        if (!a.containsKey(s)) {
            return 0.0F;
        } else {
            return ((NBTTagFloat) a.get(s)).a;
        }
    }

    public double g(String s) {
        if (!a.containsKey(s)) {
            return 0.0D;
        } else {
            return ((NBTTagDouble) a.get(s)).a;
        }
    }

    public String h(String s) {
        if (!a.containsKey(s)) {
            return "";
        } else {
            return ((NBTTagString) a.get(s)).a;
        }
    }

    public byte[] i(String s) {
        if (!a.containsKey(s)) {
            return new byte[0];
        } else {
            return ((NBTTagByteArray) a.get(s)).a;
        }
    }

    public NBTTagCompound j(String s) {
        if (!a.containsKey(s)) {
            return new NBTTagCompound();
        } else {
            return (NBTTagCompound) a.get(s);
        }
    }

    public NBTTagList k(String s) {
        if (!a.containsKey(s)) {
            return new NBTTagList();
        } else {
            return (NBTTagList) a.get(s);
        }
    }

    public boolean l(String s) {
        return b(s) != 0;
    }

    public String toString() {
        return (new StringBuilder()).append("").append(a.size()).append(" entries").toString();
    }
}

