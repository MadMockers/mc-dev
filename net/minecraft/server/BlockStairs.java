package net.minecraft.server;


import java.util.ArrayList;
import java.util.Random;


public class BlockStairs extends Block {

    private Block a;

    protected BlockStairs(int i, Block block) {
        super(i, block.bh, block.bt);
        a = block;
        c(block.bj);
        b(block.bk / 3F);
        a(block.br);
    }

    public boolean a() {
        return false;
    }

    public boolean a(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return super.a(iblockaccess, i, j, k, l);
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        int l = world.b(i, j, k);

        if (l == 0) {
            a(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        } else if (l == 1) {
            a(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
            a(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        } else if (l == 2) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        } else if (l == 3) {
            a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
            a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.a(world, i, j, k, axisalignedbb, arraylist);
        }
        a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        a.b(world, i, j, k, entityplayer);
    }

    public void a(World world, int i, int j, int k, int l) {
        a.a(world, i, j, k, l);
    }

    public float a(Entity entity) {
        return a.a(entity);
    }

    public int a(int i, Random random) {
        return a.a(i, random);
    }

    public int a(Random random) {
        return a.a(random);
    }

    public int a(int i) {
        return a.a(i);
    }

    public int b() {
        return a.b();
    }

    public void a(World world, int i, int j, int k, Entity entity, Vec3D vec3d) {
        a.a(world, i, j, k, entity, vec3d);
    }

    public boolean d() {
        return a.d();
    }

    public boolean a(int i, boolean flag) {
        return a.a(i, flag);
    }

    public boolean a(World world, int i, int j, int k) {
        return a.a(world, i, j, k);
    }

    public void e(World world, int i, int j, int k) {
        b(world, i, j, k, 0);
        a.e(world, i, j, k);
    }

    public void b(World world, int i, int j, int k) {
        a.b(world, i, j, k);
    }

    public void a(World world, int i, int j, int k, int l, float f) {
        a.a(world, i, j, k, l, f);
    }

    public void a_(World world, int i, int j, int k, int l) {
        a.a_(world, i, j, k, l);
    }

    public void b(World world, int i, int j, int k, Entity entity) {
        a.b(world, i, j, k, entity);
    }

    public void a(World world, int i, int j, int k, Random random) {
        a.a(world, i, j, k, random);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        return a.a(world, i, j, k, entityplayer);
    }

    public void c(World world, int i, int j, int k) {
        a.c(world, i, j, k);
    }

    public void a(World world, int i, int j, int k, EntityLiving entityliving) {
        int l = MathHelper.b((double) ((entityliving.v * 4F) / 360F) + 0.5D) & 3;

        if (l == 0) {
            world.b(i, j, k, 2);
        }
        if (l == 1) {
            world.b(i, j, k, 1);
        }
        if (l == 2) {
            world.b(i, j, k, 3);
        }
        if (l == 3) {
            world.b(i, j, k, 0);
        }
    }
}

