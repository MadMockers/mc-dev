package net.minecraft.server;


import java.util.Random;


public class BlockCrops extends BlockFlower {

    protected BlockCrops(int i, int j) {
        super(i, j);
        bg = j;
        a(true);
        float f = 0.5F;

        a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    protected boolean b(int i) {
        return i == Block.aA.bh;
    }

    public void a(World world, int i, int j, int k, Random random) {
        super.a(world, i, j, k, random);
        if (world.i(i, j + 1, k) >= 9) {
            int l = world.b(i, j, k);

            if (l < 7) {
                float f = h(world, i, j, k);

                if (random.nextInt((int) (100F / f)) == 0) {
                    l++;
                    world.b(i, j, k, l);
                }
            }
        }
    }

    private float h(World world, int i, int j, int k) {
        float f = 1.0F;
        int l = world.a(i, j, k - 1);
        int i1 = world.a(i, j, k + 1);
        int j1 = world.a(i - 1, j, k);
        int k1 = world.a(i + 1, j, k);
        int l1 = world.a(i - 1, j, k - 1);
        int i2 = world.a(i + 1, j, k - 1);
        int j2 = world.a(i + 1, j, k + 1);
        int k2 = world.a(i - 1, j, k + 1);
        boolean flag = j1 == bh || k1 == bh;
        boolean flag1 = l == bh || i1 == bh;
        boolean flag2 = l1 == bh || i2 == bh || j2 == bh || k2 == bh;

        for (int l2 = i - 1; l2 <= i + 1; l2++) {
            for (int i3 = k - 1; i3 <= k + 1; i3++) {
                int j3 = world.a(l2, j - 1, i3);
                float f1 = 0.0F;

                if (j3 == Block.aA.bh) {
                    f1 = 1.0F;
                    if (world.b(l2, j - 1, i3) > 0) {
                        f1 = 3F;
                    }
                }
                if (l2 != i || i3 != k) {
                    f1 /= 4F;
                }
                f += f1;
            }

        }

        if (flag2 || flag && flag1) {
            f /= 2.0F;
        }
        return f;
    }

    public void a(World world, int i, int j, int k, int l) {
        super.a(world, i, j, k, l);
        if (!world.z) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (world.l.nextInt(15) <= l) {
                    float f = 0.7F;
                    float f1 = world.l.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f2 = world.l.nextFloat() * f + (1.0F - f) * 0.5F;
                    float f3 = world.l.nextFloat() * f + (1.0F - f) * 0.5F;
                    EntityItem entityitem = new EntityItem(world, (float) i + f1, (float) j + f2, (float) k + f3, new ItemStack(Item.Q));

                    entityitem.c = 10;
                    world.a(entityitem);
                }
            }

        }
    }

    public int a(int i, Random random) {
        if (i == 7) {
            return Item.R.aW;
        } else {
            return -1;
        }
    }

    public int a(Random random) {
        return 1;
    }
}

