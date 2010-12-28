package net.minecraft.server;


import java.lang.reflect.Constructor;
import java.util.*;


public final class SpawnerAnimals {

    private static Set a = new HashSet();

    public SpawnerAnimals() {}

    protected static ChunkPosition a(World world, int i, int j) {
        int k = i + world.l.nextInt(16);
        int l = world.l.nextInt(128);
        int i1 = j + world.l.nextInt(16);

        return new ChunkPosition(k, l, i1);
    }

    public static final int a(World world) {
        a.clear();

        for (int i = 0; i < world.k.size(); ++i) {
            EntityPlayer entityplayer = (EntityPlayer) world.k.get(i);
            int l = MathHelper.b(entityplayer.l / 16.0D);
            int i1 = MathHelper.b(entityplayer.n / 16.0D);
            byte byte0 = 8;

            for (int j = -byte0; j <= byte0; ++j) {
                for (int k = -byte0; k <= byte0; ++k) {
                    a.add(new ChunkCoordIntPair(j + l, k + i1));
                }
            }
        }

        int i = 0;

        for (int k = 0; k < EnumCreatureType.values().length; ++k) {
            EnumCreatureType enumcreaturetype = EnumCreatureType.values()[k];

            if (world.a(enumcreaturetype.c) <= enumcreaturetype.d * a.size() / 256) {
                Iterator iterator = a.iterator();

                label90:
                while (iterator.hasNext()) {
                    ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();

                    if (world.m.nextInt(50) == 0) {
                        MobSpawnerBase mobspawnerbase = world.a().a(chunkcoordintpair);
                        Class[] aclass = mobspawnerbase.a(enumcreaturetype);

                        if (aclass != null && aclass.length != 0) {
                            int l1 = world.m.nextInt(aclass.length);
                            ChunkPosition chunkposition = a(world, chunkcoordintpair.a * 16, chunkcoordintpair.b * 16);
                            int i1 = chunkposition.a;
                            int j1 = chunkposition.b;
                            int k1 = chunkposition.c;

                            if (!world.d(i1, j1, k1) && world.c(i1, j1, k1) == Material.a) {
                                int j = 0;

                                for (int l2 = 0; l2 < 3; ++l2) {
                                    int i2 = i1;
                                    int j2 = j1;
                                    int k2 = k1;
                                    byte byte0 = 6;

                                    for (int l3 = 0; l3 < 4; ++l3) {
                                        i2 += world.m.nextInt(byte0) - world.m.nextInt(byte0);
                                        j2 += world.m.nextInt(1) - world.m.nextInt(1);
                                        k2 += world.m.nextInt(byte0) - world.m.nextInt(byte0);
                                        if (world.d(i2, j2 - 1, k2) && !world.d(i2, j2, k2) && !world.c(i2, j2, k2).d() && !world.d(i2, j2 + 1, k2)) {
                                            float f = (float) i2 + 0.5F;
                                            float f1 = (float) j2;
                                            float f2 = (float) k2 + 0.5F;

                                            if (world.a((double) f, (double) f1, (double) f2, 24.0D) == null) {
                                                float f3 = f - (float) world.m;
                                                float f4 = f1 - (float) world.n;
                                                float f5 = f2 - (float) world.o;
                                                float f6 = f3 * f3 + f4 * f4 + f5 * f5;

                                                if (f6 >= 576.0F) {
                                                    EntityLiving entityliving;

                                                    try {
                                                        entityliving = (EntityLiving) aclass[l1].getConstructor(new Class[] { World.class}).newInstance(new Object[] { world});
                                                    } catch (Exception exception) {
                                                        exception.printStackTrace();
                                                        return i;
                                                    }

                                                    entityliving.c((double) f, (double) f1, (double) f2, world.m.nextFloat() * 360.0F, 0.0F);
                                                    if (entityliving.a()) {
                                                        ++j;
                                                        world.a(entityliving);
                                                        if (entityliving instanceof EntitySpider && world.m.nextInt(100) == 0) {
                                                            EntitySkeleton entityskeleton = new EntitySkeleton(world);

                                                            entityskeleton.c((double) f, (double) f1, (double) f2, entityliving.r, 0.0F);
                                                            world.a(entityskeleton);
                                                            entityskeleton.e(entityliving);
                                                        }

                                                        if (j >= entityliving.i()) {
                                                            continue label90;
                                                        }
                                                    }

                                                    i += j;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

}

