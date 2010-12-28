package net.minecraft.server;


public final class EnumSkyBlock extends Enum {

    public static final EnumSkyBlock a;
    public static final EnumSkyBlock b;
    public final int c;
    private static final EnumSkyBlock d[]; /* synthetic field */

    public static EnumSkyBlock[] values() {
        return (EnumSkyBlock[]) d.clone();
    }

    public static EnumSkyBlock valueOf(String s) {
        return (EnumSkyBlock) Enum.valueOf(net.minecraft.server.EnumSkyBlock.class, s);
    }

    private EnumSkyBlock(String s, int i, int j) {
        super(s, i);
        c = j;
    }

    static {
        a = new EnumSkyBlock("Sky", 0, 15);
        b = new EnumSkyBlock("Block", 1, 0);
        d = (new EnumSkyBlock[] {
            a, b
        });
    }
}

