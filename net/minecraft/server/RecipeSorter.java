package net.minecraft.server;


import java.util.Comparator;


class RecipeSorter
        implements Comparator {

    final CraftingManager a; /* synthetic field */

    RecipeSorter(CraftingManager craftingmanager) {
        a = craftingmanager;
        // super();
    }

    public int a(CraftingRecipe craftingrecipe, CraftingRecipe craftingrecipe1) {
        if (craftingrecipe1.a() < craftingrecipe.a()) {
            return -1;
        }
        return craftingrecipe1.a() <= craftingrecipe.a() ? 0 : 1;
    }

    public int compare(Object obj, Object obj1) {
        return a((CraftingRecipe) obj, (CraftingRecipe) obj1);
    }
}

