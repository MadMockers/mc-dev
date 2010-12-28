package net.minecraft.server;


public class ItemTool extends Item {

    private Block bb[];
    private float bc;
    private int bd;
    protected int a;

    public ItemTool(int i, int j, int k, Block ablock[]) {
        super(i);
        bc = 4F;
        a = k;
        bb = ablock;
        aX = 1;
        aY = 32 << k;
        if (k == 3) {
            aY *= 4;
        }
        bc = (k + 1) * 2;
        bd = j + k;
    }

    public float a(ItemStack itemstack, Block block) {
        for (int i = 0; i < bb.length; i++) {
            if (bb[i] == block) {
                return bc;
            }
        }

        return 1.0F;
    }

    public void a(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.b(2);
    }

    public void a(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.b(1);
    }

    public int a(Entity entity) {
        return bd;
    }
}

