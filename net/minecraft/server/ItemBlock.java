package net.minecraft.server;


public class ItemBlock extends Item {

    private int a;

    public ItemBlock(int i) {
        super(i);
        a = i + 256;
        a(Block.m[i + 256].a(2));
    }

    public boolean a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.a(i, j, k) == Block.aS.bh) {
            l = 0;
        } else {
            if (l == 0) {
                j--;
            }
            if (l == 1) {
                j++;
            }
            if (l == 2) {
                k--;
            }
            if (l == 3) {
                k++;
            }
            if (l == 4) {
                i--;
            }
            if (l == 5) {
                i++;
            }
        }
        if (itemstack.a == 0) {
            return false;
        }
        if (world.a(a, i, j, k, false)) {
            Block block = Block.m[a];

            if (world.d(i, j, k, a)) {
                Block.m[a].c(world, i, j, k, l);
                Block.m[a].a(world, i, j, k, entityplayer);
                world.a((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.bq.c(), (block.bq.a() + 1.0F) / 2.0F, block.bq.b() * 0.8F);
                itemstack.a--;
            }
        }
        return true;
    }

    public String a() {
        return Block.m[a].e();
    }
}

