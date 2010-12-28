package net.minecraft.server;


public class ItemArmor extends Item {

    private static final int be[] = {
        3, 8, 6, 3
    };
    private static final int bf[] = {
        11, 16, 15, 13
    };
    public final int a;
    public final int bb;
    public final int bc;
    public final int bd;

    public ItemArmor(int i, int j, int k, int l) {
        super(i);
        a = j;
        bb = l;
        bd = k;
        bc = be[l];
        aY = bf[l] * 3 << j;
        aX = 1;
    }

}

