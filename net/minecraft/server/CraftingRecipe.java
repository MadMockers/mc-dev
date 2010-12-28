package net.minecraft.server;


public class CraftingRecipe {

    private int b;
    private int c;
    private int d[];
    private ItemStack e;
    public final int a;

    public CraftingRecipe(int i, int j, int ai[], ItemStack itemstack) {
        a = itemstack.c;
        b = i;
        c = j;
        d = ai;
        e = itemstack;
    }

    public boolean a(int ai[]) {
        for (int i = 0; i <= 3 - b; i++) {
            for (int j = 0; j <= 3 - c; j++) {
                if (a(ai, i, j, true)) {
                    return true;
                }
                if (a(ai, i, j, false)) {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean a(int ai[], int i, int j, boolean flag) {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int i1 = k - i;
                int j1 = l - j;
                int k1 = -1;

                if (i1 >= 0 && j1 >= 0 && i1 < b && j1 < c) {
                    if (flag) {
                        k1 = d[(b - i1 - 1) + j1 * b];
                    } else {
                        k1 = d[i1 + j1 * b];
                    }
                }
                if (ai[k + l * 3] != k1) {
                    return false;
                }
            }

        }

        return true;
    }

    public ItemStack b(int ai[]) {
        return new ItemStack(e.c, e.a);
    }

    public int a() {
        return b * c;
    }
}

