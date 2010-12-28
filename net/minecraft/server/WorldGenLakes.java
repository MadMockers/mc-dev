package net.minecraft.server;


import java.util.Random;


public class WorldGenLakes extends WorldGenerator {

    private int a;

    public WorldGenLakes(int i) {
        a = i;
    }

    public boolean a(World world, Random random, int i, int j, int k) {
        i -= 8;
        for (k -= 8; j > 0 && world.a(i, j, k) == 0; j--) {
            ;
        }
        j -= 4;
        boolean aflag[] = new boolean[2048];
        int l = random.nextInt(4) + 4;

        for (int i1 = 0; i1 < l; i1++) {
            double d = random.nextDouble() * 6D + 3D;
            double d1 = random.nextDouble() * 4D + 2D;
            double d2 = random.nextDouble() * 6D + 3D;
            double d3 = random.nextDouble() * (16D - d - 2D) + 1.0D + d / 2D;
            double d4 = random.nextDouble() * (8D - d1 - 4D) + 2D + d1 / 2D;
            double d5 = random.nextDouble() * (16D - d2 - 2D) + 1.0D + d2 / 2D;

            for (int i2 = 1; i2 < 15; i2++) {
                for (int j2 = 1; j2 < 15; j2++) {
                    for (int k2 = 1; k2 < 7; k2++) {
                        double d6 = ((double) i2 - d3) / (d / 2D);
                        double d7 = ((double) k2 - d4) / (d1 / 2D);
                        double d8 = ((double) j2 - d5) / (d2 / 2D);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                        if (d9 < 1.0D) {
                            aflag[(i2 * 16 + j2) * 8 + k2] = true;
                        }
                    }

                }

            }

        }

        for (int j1 = 0; j1 < 16; j1++) {
            for (int l2 = 0; l2 < 16; l2++) {
                for (int k3 = 0; k3 < 8; k3++) {
                    boolean flag = !aflag[(j1 * 16 + l2) * 8 + k3]
                            && (j1 < 15 && aflag[((j1 + 1) * 16 + l2) * 8 + k3] || j1 > 0 && aflag[((j1 - 1) * 16 + l2) * 8 + k3] || l2 < 15 && aflag[(j1 * 16 + (l2 + 1)) * 8 + k3]
                            || l2 > 0 && aflag[(j1 * 16 + (l2 - 1)) * 8 + k3] || k3 < 7 && aflag[(j1 * 16 + l2) * 8 + (k3 + 1)] || k3 > 0 && aflag[(j1 * 16 + l2) * 8 + (k3 - 1)]);

                    if (!flag) {
                        continue;
                    }
                    Material material = world.c(i + j1, j + k3, k + l2);

                    if (k3 >= 4 && material.d()) {
                        return false;
                    }
                    if (k3 < 4 && !material.a() && world.a(i + j1, j + k3, k + l2) != a) {
                        return false;
                    }
                }

            }

        }

        for (int k1 = 0; k1 < 16; k1++) {
            for (int i3 = 0; i3 < 16; i3++) {
                for (int l3 = 0; l3 < 8; l3++) {
                    if (aflag[(k1 * 16 + i3) * 8 + l3]) {
                        world.d(i + k1, j + l3, k + i3, l3 < 4 ? a : 0);
                    }
                }

            }

        }

        for (int l1 = 0; l1 < 16; l1++) {
            for (int j3 = 0; j3 < 16; j3++) {
                for (int i4 = 4; i4 < 8; i4++) {
                    if (aflag[(l1 * 16 + j3) * 8 + i4] && world.a(i + l1, (j + i4) - 1, k + j3) == Block.v.bh && world.a(EnumSkyBlock.a, i + l1, j + i4, k + j3) > 0) {
                        world.d(i + l1, (j + i4) - 1, k + j3, Block.u.bh);
                    }
                }

            }

        }

        return true;
    }
}

