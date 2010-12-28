package net.minecraft.server;


import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class TileEntity {

    private static Map e = new HashMap();
    private static Map f = new HashMap();
    public World a;
    public int b;
    public int c;
    public int d;

    public TileEntity() {}

    private static void a(Class class1, String s) {
        if (f.containsKey(s)) {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate id: ").append(s).toString());
        } else {
            e.put(s, class1);
            f.put(class1, s);
            return;
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        b = nbttagcompound.d("x");
        c = nbttagcompound.d("y");
        d = nbttagcompound.d("z");
    }

    public void b(NBTTagCompound nbttagcompound) {
        String s = (String) f.get(getClass());

        if (s == null) {
            throw new RuntimeException((new StringBuilder()).append(getClass()).append(" is missing a mapping! This is a bug!").toString());
        } else {
            nbttagcompound.a("id", s);
            nbttagcompound.a("x", b);
            nbttagcompound.a("y", c);
            nbttagcompound.a("z", d);
            return;
        }
    }

    public void e() {}

    public static TileEntity c(NBTTagCompound nbttagcompound) {
        TileEntity tileentity = null;

        try {
            Class class1 = (Class) e.get(nbttagcompound.h("id"));

            if (class1 != null) {
                tileentity = (TileEntity) class1.newInstance();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (tileentity != null) {
            tileentity.a(nbttagcompound);
        } else {
            System.out.println((new StringBuilder()).append("Skipping TileEntity with id ").append(nbttagcompound.h("id")).toString());
        }
        return tileentity;
    }

    public void d() {
        if (a != null) {
            a.b(b, c, d, this);
        }
    }

    public Packet f() {
        return null;
    }

    static Class _mthclass$(String s) {
        try {
            return Class.forName(s);
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static {
        a(net.minecraft.server.TileEntityFurnace.class, "Furnace");
        a(net.minecraft.server.TileEntityChest.class, "Chest");
        a(net.minecraft.server.TileEntitySign.class, "Sign");
        a(net.minecraft.server.TileEntityMobSpawner.class, "MobSpawner");
    }
}

