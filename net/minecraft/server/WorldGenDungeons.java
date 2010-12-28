package net.minecraft.server;


import java.util.Random;


public class WorldGenDungeons extends WorldGenerator {

    public WorldGenDungeons() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        byte byte0 = 3;
        int l = random.nextInt(2) + 2;
        int i1 = random.nextInt(2) + 2;
        int j1 = 0;

        for (int k1 = i - l - 1; k1 <= i + l + 1; k1++) {
            for (int j2 = j - 1; j2 <= j + byte0 + 1; j2++) {
                for (int i3 = k - i1 - 1; i3 <= k + i1 + 1; i3++) {
                    Material material = world.c(k1, j2, i3);

                    if (j2 == j - 1 && !material.a()) {
                        return false;
                    }
                    if (j2 == j + byte0 + 1 && !material.a()) {
                        return false;
                    }
                    if ((k1 == i - l - 1 || k1 == i + l + 1 || i3 == k - i1 - 1 || i3 == k + i1 + 1) && j2 == j && world.a(k1, j2, i3) == 0 && world.a(k1, j2 + 1, i3) == 0) {
                        j1++;
                    }
                }

            }

        }

        if (j1 < 1 || j1 > 5) {
            return false;
        }
        for (int l1 = i - l - 1; l1 <= i + l + 1; l1++) {
            for (int k2 = j + byte0; k2 >= j - 1; k2--) {
                for (int j3 = k - i1 - 1; j3 <= k + i1 + 1; j3++) {
                    if (l1 == i - l - 1 || k2 == j - 1 || j3 == k - i1 - 1 || l1 == i + l + 1 || k2 == j + byte0 + 1 || j3 == k + i1 + 1) {
                        if (k2 >= 0 && !world.c(l1, k2 - 1, j3).a()) {
                            world.d(l1, k2, j3, 0);
                            continue;
                        }
                        if (!world.c(l1, k2, j3).a()) {
                            continue;
                        }
                        if (k2 == j - 1 && random.nextInt(4) != 0) {
                            world.d(l1, k2, j3, Block.ap.bi);
                        } else {
                            world.d(l1, k2, j3, Block.x.bi);
                        }
                    } else {
                        world.d(l1, k2, j3, 0);
                    }
                }

            }

        }

        for (int i2 = 0; i2 < 2; i2++) {
            label0:
            for (int l2 = 0; l2 < 3; l2++) {
                int k3 = (i + random.nextInt(l * 2 + 1)) - l;
                int l3 = j;
                int i4 = (k + random.nextInt(i1 * 2 + 1)) - i1;

                if (world.a(k3, l3, i4) != 0) {
                    continue;
                }
                int j4 = 0;

                if (world.c(k3 - 1, l3, i4).a()) {
                    j4++;
                }
                if (world.c(k3 + 1, l3, i4).a()) {
                    j4++;
                }
                if (world.c(k3, l3, i4 - 1).a()) {
                    j4++;
                }
                if (world.c(k3, l3, i4 + 1).a()) {
                    j4++;
                }
                if (j4 != 1) {
                    continue;
                }
                world.d(k3, l3, i4, Block.av.bi);
                TileEntityChest tileentitychest = (TileEntityChest) world.k(k3, l3, i4);
                int k4 = 0;

                do {
                    if (k4 >= 8) {
                        break label0;
                    }
                    ItemStack itemstack = a(random);

                    if (itemstack != null) {
                        tileentitychest.a(random.nextInt(tileentitychest.a()), itemstack);
                    }
                    k4++;
                } while (true);
            }

        }

        world.d(i, j, k, Block.at.bi);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world.k(i, j, k);

        tileentitymobspawner.f = b(random);
        return true;
    }

    private ItemStack a(Random random) {
        int i = random.nextInt(11);

        if (i == 0) {
            return new ItemStack(Item.ay);
        }
        if (i == 1) {
            return new ItemStack(Item.m, random.nextInt(4) + 1);
        }
        if (i == 2) {
            return new ItemStack(Item.S);
        }
        if (i == 3) {
            return new ItemStack(Item.R, random.nextInt(4) + 1);
        }
        if (i == 4) {
            return new ItemStack(Item.K, random.nextInt(4) + 1);
        }
        if (i == 5) {
            return new ItemStack(Item.I, random.nextInt(4) + 1);
        }
        if (i == 6) {
            return new ItemStack(Item.au);
        }
        if (i == 7 && random.nextInt(100) == 0) {
            return new ItemStack(Item.ar);
        }
        if (i == 8 && random.nextInt(2) == 0) {
            return new ItemStack(Item.aA, random.nextInt(4) + 1);
        }
        if (i == 9 && random.nextInt(10) == 0) {
            return new ItemStack(Item.c[Item.aU.aW + random.nextInt(2)]);
        } else {
            return null;
        }
    }

    private String b(Random random) {
        int i = random.nextInt(4);

        if (i == 0) {
            return "Skeleton";
        }
        if (i == 1) {
            return "Zombie";
        }
        if (i == 2) {
            return "Zombie";
        }
        if (i == 3) {
            return "Spider";
        } else {
            return "";
        }
    }
}

