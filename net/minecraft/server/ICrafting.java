package net.minecraft.server;


import java.util.List;


public interface ICrafting {

    public abstract void a(CraftingInventoryCB craftinginventorycb, List list);

    public abstract void a(CraftingInventoryCB craftinginventorycb, int i, ItemStack itemstack);

    public abstract void a(CraftingInventoryCB craftinginventorycb, int i, int j);
}

