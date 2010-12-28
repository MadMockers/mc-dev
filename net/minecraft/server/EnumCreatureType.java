package net.minecraft.server;


public final class EnumCreatureType extends Enum {

    public static final EnumCreatureType a;
    public static final EnumCreatureType b;
    public final Class c;
    public final int d;
    private static final EnumCreatureType e[]; /* synthetic field */

    public static EnumCreatureType[] values() {
        return (EnumCreatureType[]) e.clone();
    }

    public static EnumCreatureType valueOf(String s) {
        return (EnumCreatureType) Enum.valueOf(net.minecraft.server.EnumCreatureType.class, s);
    }

    private EnumCreatureType(String s, int i, Class class1, int j) {
        super(s, i);
        c = class1;
        d = j;
    }

    static {
        a = new EnumCreatureType("monster", 0, net.minecraft.server.IMobs.class, 200);
        b = new EnumCreatureType("creature", 1, net.minecraft.server.EntityAnimals.class, 50);
        e = (new EnumCreatureType[] {
            a, b
        });
    }
}

