package net.minecraft.server;


import java.util.*;


public class Explosion {

    public boolean a;
    private Random b;

    public Explosion() {
        a = false;
        b = new Random();
    }

    public void a(World world, Entity entity, double d, double d1, double d2, float f) {
        world.a(d, d1, d2, "random.explode", 4F, (1.0F + (world.l.nextFloat() - world.l.nextFloat()) * 0.2F) * 0.7F);
        HashSet hashset = new HashSet();
        float f1 = f;
        int i = 16;

        for (int j = 0; j < i; j++) {
            for (int l = 0; l < i; l++) {
                label0:
                for (int j1 = 0; j1 < i; j1++) {
                    if (j != 0 && j != i - 1 && l != 0 && l != i - 1 && j1 != 0 && j1 != i - 1) {
                        continue;
                    }
                    double d3 = ((float) j / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d4 = ((float) l / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d5 = ((float) j1 / ((float) i - 1.0F)) * 2.0F - 1.0F;
                    double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);

                    d3 /= d6;
                    d4 /= d6;
                    d5 /= d6;
                    float f2 = f * (0.7F + world.l.nextFloat() * 0.6F);
                    double d7 = d;
                    double d9 = d1;
                    double d11 = d2;
                    float f3 = 0.3F;

                    do {
                        if (f2 <= 0.0F) {
                            continue label0;
                        }
                        int j2 = MathHelper.b(d7);
                        int k2 = MathHelper.b(d9);
                        int l2 = MathHelper.b(d11);
                        int i3 = world.a(j2, k2, l2);

                        if (i3 > 0) {
                            f2 -= (Block.m[i3].a(entity) + 0.3F) * f3;
                        }
                        if (f2 > 0.0F) {
                            hashset.add(new ChunkPosition(j2, k2, l2));
                        }
                        d7 += d3 * (double) f3;
                        d9 += d4 * (double) f3;
                        d11 += d5 * (double) f3;
                        f2 -= f3 * 0.75F;
                    } while (true);
                }

            }

        }

        f *= 2.0F;
        int k = MathHelper.b(d - (double) f - 1.0D);
        int i1 = MathHelper.b(d + (double) f + 1.0D);
        int k1 = MathHelper.b(d1 - (double) f - 1.0D);
        int j3 = MathHelper.b(d1 + (double) f + 1.0D);
        int k3 = MathHelper.b(d2 - (double) f - 1.0D);
        int l3 = MathHelper.b(d2 + (double) f + 1.0D);
        List list = world.b(entity, AxisAlignedBB.b(k, k1, k3, i1, j3, l3));
        Vec3D vec3d = Vec3D.b(d, d1, d2);

        for (int i4 = 0; i4 < list.size(); i4++) {
            Entity entity1 = (Entity) list.get(i4);
            double d14 = entity1.e(d, d1, d2) / (double) f;

            if (d14 <= 1.0D) {
                double d8 = entity1.p - d;
                double d10 = entity1.q - d1;
                double d12 = entity1.r - d2;
                double d15 = MathHelper.a(d8 * d8 + d10 * d10 + d12 * d12);

                d8 /= d15;
                d10 /= d15;
                d12 /= d15;
                double d17 = world.a(vec3d, entity1.z);
                double d19 = (1.0D - d14) * d17;

                entity1.a(entity, (int) (((d19 * d19 + d19) / 2D) * 8D * (double) f + 1.0D));
                double d21 = d19;

                entity1.s += d8 * d21;
                entity1.t += d10 * d21;
                entity1.u += d12 * d21;
            }
        }

        f = f1;
        ArrayList arraylist = new ArrayList();

        arraylist.addAll(hashset);
        for (int j4 = arraylist.size() - 1; j4 >= 0; j4--) {
            ChunkPosition chunkposition = (ChunkPosition) arraylist.get(j4);
            int l1 = chunkposition.a;
            int l4 = chunkposition.b;
            int j5 = chunkposition.c;
            int l5 = world.a(l1, l4, j5);

            for (int j6 = 0; j6 < 1; j6++) {
                double d13 = (float) l1 + world.l.nextFloat();
                double d16 = (float) l4 + world.l.nextFloat();
                double d18 = (float) j5 + world.l.nextFloat();
                double d20 = d13 - d;
                double d22 = d16 - d1;
                double d23 = d18 - d2;
                double d24 = MathHelper.a(d20 * d20 + d22 * d22 + d23 * d23);

                d20 /= d24;
                d22 /= d24;
                d23 /= d24;
                double d25 = 0.5D / (d24 / (double) f + 0.10000000000000001D);

                d25 *= world.l.nextFloat() * world.l.nextFloat() + 0.3F;
                d20 *= d25;
                d22 *= d25;
                d23 *= d25;
                world.a("explode", (d13 + d * 1.0D) / 2D, (d16 + d1 * 1.0D) / 2D, (d18 + d2 * 1.0D) / 2D, d20, d22, d23);
                world.a("smoke", d13, d16, d18, d20, d22, d23);
            }

            if (l5 > 0) {
                Block.m[l5].a(world, l1, l4, j5, world.b(l1, l4, j5), 0.3F);
                world.d(l1, l4, j5, 0);
                Block.m[l5].c(world, l1, l4, j5);
            }
        }

        if (a) {
            for (int k4 = arraylist.size() - 1; k4 >= 0; k4--) {
                ChunkPosition chunkposition1 = (ChunkPosition) arraylist.get(k4);
                int i2 = chunkposition1.a;
                int i5 = chunkposition1.b;
                int k5 = chunkposition1.c;
                int i6 = world.a(i2, i5, k5);
                int k6 = world.a(i2, i5 - 1, k5);

                if (i6 == 0 && Block.o[k6] && b.nextInt(3) == 0) {
                    world.d(i2, i5, k5, Block.ar.bh);
                }
            }

        }
    }
}

