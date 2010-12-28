package net.minecraft.server;


import java.util.Random;


public abstract class BlockFluids extends Block {

    protected BlockFluids(int j, Material material) {
        super(j, (material != Material.g ? 12 : 14) * 16 + 13, material);
        float f = 0.0F;
        float f1 = 0.0F;

        a(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
        a(true);
    }

    public static float b(int j) {
        if (j >= 8) {
            j = 0;
        }
        float f = (float) (j + 1) / 9F;

        return f;
    }

    public int a(int j) {
        if (j == 0 || j == 1) {
            return bg;
        } else {
            return bg + 1;
        }
    }

    protected int g(World world, int j, int k, int l) {
        if (world.c(j, k, l) != bs) {
            return -1;
        } else {
            return world.b(j, k, l);
        }
    }

    protected int b(IBlockAccess iblockaccess, int j, int k, int l) {
        if (iblockaccess.c(j, k, l) != bs) {
            return -1;
        }
        int i1 = iblockaccess.b(j, k, l);

        if (i1 >= 8) {
            i1 = 0;
        }
        return i1;
    }

    public boolean a() {
        return false;
    }

    public boolean a(int j, boolean flag) {
        return flag && j == 0;
    }

    public boolean a(IBlockAccess iblockaccess, int j, int k, int l, int i1) {
        Material material = iblockaccess.c(j, k, l);

        if (material == bs) {
            return false;
        }
        if (material == Material.r) {
            return false;
        }
        if (i1 == 1) {
            return true;
        } else {
            return super.a(iblockaccess, j, k, l, i1);
        }
    }

    public AxisAlignedBB d(World world, int j, int k, int l) {
        return null;
    }

    public int a(int j, Random random) {
        return 0;
    }

    public int a(Random random) {
        return 0;
    }

    private Vec3D c(IBlockAccess iblockaccess, int j, int k, int l) {
        Vec3D vec3d = Vec3D.b(0.0D, 0.0D, 0.0D);
        int i1 = b(iblockaccess, j, k, l);

        for (int j1 = 0; j1 < 4; j1++) {
            int k1 = j;
            int l1 = k;
            int i2 = l;

            if (j1 == 0) {
                k1--;
            }
            if (j1 == 1) {
                i2--;
            }
            if (j1 == 2) {
                k1++;
            }
            if (j1 == 3) {
                i2++;
            }
            int j2 = b(iblockaccess, k1, l1, i2);

            if (j2 < 0) {
                if (iblockaccess.c(k1, l1, i2).c()) {
                    continue;
                }
                j2 = b(iblockaccess, k1, l1 - 1, i2);
                if (j2 >= 0) {
                    int k2 = j2 - (i1 - 8);

                    vec3d = vec3d.c((k1 - j) * k2, (l1 - k) * k2, (i2 - l) * k2);
                }
                continue;
            }
            if (j2 >= 0) {
                int l2 = j2 - i1;

                vec3d = vec3d.c((k1 - j) * l2, (l1 - k) * l2, (i2 - l) * l2);
            }
        }

        if (iblockaccess.b(j, k, l) >= 8) {
            boolean flag = false;

            if (flag || a(iblockaccess, j, k, l - 1, 2)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j, k, l + 1, 3)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j - 1, k, l, 4)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j + 1, k, l, 5)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j, k + 1, l - 1, 2)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j, k + 1, l + 1, 3)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j - 1, k + 1, l, 4)) {
                flag = true;
            }
            if (flag || a(iblockaccess, j + 1, k + 1, l, 5)) {
                flag = true;
            }
            if (flag) {
                vec3d = vec3d.b().c(0.0D, -6D, 0.0D);
            }
        }
        vec3d = vec3d.b();
        return vec3d;
    }

    public void a(World world, int j, int k, int l, Entity entity, Vec3D vec3d) {
        Vec3D vec3d1 = c(world, j, k, l);

        vec3d.a += vec3d1.a;
        vec3d.b += vec3d1.b;
        vec3d.c += vec3d1.c;
    }

    public int b() {
        if (bs == Material.f) {
            return 5;
        }
        return bs != Material.g ? 0 : 30;
    }

    public void a(World world, int j, int k, int l, Random random) {
        super.a(world, j, k, l, random);
    }

    public void e(World world, int j, int k, int l) {
        i(world, j, k, l);
    }

    public void b(World world, int j, int k, int l, int i1) {
        i(world, j, k, l);
    }

    private void i(World world, int j, int k, int l) {
        if (world.a(j, k, l) != bh) {
            return;
        }
        if (bs == Material.g) {
            boolean flag = false;

            if (flag || world.c(j, k, l - 1) == Material.f) {
                flag = true;
            }
            if (flag || world.c(j, k, l + 1) == Material.f) {
                flag = true;
            }
            if (flag || world.c(j - 1, k, l) == Material.f) {
                flag = true;
            }
            if (flag || world.c(j + 1, k, l) == Material.f) {
                flag = true;
            }
            if (flag || world.c(j, k + 1, l) == Material.f) {
                flag = true;
            }
            if (flag) {
                int i1 = world.b(j, k, l);

                if (i1 == 0) {
                    world.d(j, k, l, Block.ap.bh);
                } else if (i1 <= 4) {
                    world.d(j, k, l, Block.w.bh);
                }
                h(world, j, k, l);
            }
        }
    }

    protected void h(World world, int j, int k, int l) {
        world.a((float) j + 0.5F, (float) k + 0.5F, (float) l + 0.5F, "random.fizz", 0.5F, 2.6F + (world.l.nextFloat() - world.l.nextFloat()) * 0.8F);
        for (int i1 = 0; i1 < 8; i1++) {
            world.a("largesmoke", (double) j + Math.random(), (double) k + 1.2D, (double) l + Math.random(), 0.0D, 0.0D, 0.0D);
        }

    }
}

