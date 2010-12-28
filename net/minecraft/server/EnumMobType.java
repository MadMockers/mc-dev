package net.minecraft.server;


public final class EnumMobType extends Enum {

    public static final EnumMobType a;
    public static final EnumMobType b;
    public static final EnumMobType c;
    private static final EnumMobType d[]; /* synthetic field */

    public static EnumMobType[] values() {
        return (EnumMobType[]) d.clone();
    }

    public static EnumMobType valueOf(String s) {
        return (EnumMobType) Enum.valueOf(net.minecraft.server.EnumMobType.class, s);
    }

    private EnumMobType(String s, int i) {
        super(s, i);
    }

    static {
        a = new EnumMobType("everything", 0);
        b = new EnumMobType("mobs", 1);
        c = new EnumMobType("players", 2);
        d = (new EnumMobType[] {
            a, b, c
        });
    }
}

