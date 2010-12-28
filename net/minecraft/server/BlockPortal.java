package net.minecraft.server;


import java.io.PrintStream;
import java.util.Random;


public class BlockPortal extends BlockBreakable {

    public BlockPortal(int i, int j) {
        super(i, j, Material.x, false);
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        return null;
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        if (iblockaccess.a(i - 1, j, k) == bi || iblockaccess.a(i + 1, j, k) == bi) {
            float f = 0.5F;
            float f2 = 0.125F;

            a(0.5F - f, 0.0F, 0.5F - f2, 0.5F + f, 1.0F, 0.5F + f2);
        } else {
            float f1 = 0.125F;
            float f3 = 0.5F;

            a(0.5F - f1, 0.0F, 0.5F - f3, 0.5F + f1, 1.0F, 0.5F + f3);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean a_(World world, int i, int j, int k) {
        int l = 0;
        int i1 = 0;

        if (world.a(i - 1, j, k) == Block.aq.bi || world.a(i + 1, j, k) == Block.aq.bi) {
            l = 1;
        }
        if (world.a(i, j, k - 1) == Block.aq.bi || world.a(i, j, k + 1) == Block.aq.bi) {
            i1 = 1;
        }
        System.out.println((new StringBuilder()).append(l).append(", ").append(i1).toString());
        if (l == i1) {
            return false;
        }
        if (world.a(i - l, j, k - i1) == 0) {
            i -= l;
            k -= i1;
        }
        for (int j1 = -1; j1 <= 2; j1++) {
            for (int l1 = -1; l1 <= 3; l1++) {
                boolean flag = j1 == -1 || j1 == 2 || l1 == -1 || l1 == 3;

                if ((j1 == -1 || j1 == 2) && (l1 == -1 || l1 == 3)) {
                    continue;
                }
                int j2 = world.a(i + l * j1, j + l1, k + i1 * j1);

                if (flag) {
                    if (j2 != Block.aq.bi) {
                        return false;
                    }
                    continue;
                }
                if (j2 != 0 && j2 != Block.as.bi) {
                    return false;
                }
            }

        }

        world.i = true;
        for (int k1 = 0; k1 < 2; k1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                world.d(i + l * k1, j + i2, k + i1 * k1, Block.bf.bi);
            }

        }

        world.i = false;
        return true;
    }

    public void b(World world, int i, int j, int k, int l) {
        int i1 = 0;
        int j1 = 1;

        if (world.a(i - 1, j, k) == bi || world.a(i + 1, j, k) == bi) {
            i1 = 1;
            j1 = 0;
        }
        int k1;

        for (k1 = j; world.a(i, k1 - 1, k) == bi; k1--) {
            ;
        }
        if (world.a(i, k1 - 1, k) != Block.aq.bi) {
            world.d(i, j, k, 0);
            return;
        }
        int l1;

        for (l1 = 1; l1 < 4 && world.a(i, k1 + l1, k) == bi; l1++) {
            ;
        }
        if (l1 != 3 || world.a(i, k1 + l1, k) != Block.aq.bi) {
            world.d(i, j, k, 0);
            return;
        }
        boolean flag = world.a(i - 1, j, k) == bi || world.a(i + 1, j, k) == bi;
        boolean flag1 = world.a(i, j, k - 1) == bi || world.a(i, j, k + 1) == bi;

        if (flag && flag1) {
            world.d(i, j, k, 0);
            return;
        }
        if ((world.a(i + i1, j, k + j1) != Block.aq.bi || world.a(i - i1, j, k - j1) != bi) && (world.a(i - i1, j, k - j1) != Block.aq.bi || world.a(i + i1, j, k + j1) != bi)) {
            world.d(i, j, k, 0);
            return;
        } else {
            return;
        }
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return true;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World world, int i, int j, int k, Entity entity) {
        if (world.z) {
            return;
        } else {
            entity.C();
            return;
        }
    }
}

