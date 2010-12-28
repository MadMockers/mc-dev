package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityMinecart extends Entity
        implements IInventory {

    private ItemStack aj[];
    public int a;
    public int b;
    public int c;
    private boolean ak;
    public int d;
    public int e;
    public double f;
    public double ai;
    private static final int al[][][] = {
        {
            {
                0, 0, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, -1, 0
            }, {
                1, 0, 0
            }
        }, {
            {
                -1, 0, 0
            }, {
                1, -1, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                0, -1, 1
            }
        }, {
            {
                0, -1, -1
            }, {
                0, 0, 1
            }
        }, {
            {
                0, 0, 1
            }, {
                1, 0, 0
            }
        }, {
            {
                0, 0, 1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                -1, 0, 0
            }
        }, {
            {
                0, 0, -1
            }, {
                1, 0, 0
            }
        }
    };
    private int am;
    private double an;
    private double ao;
    private double ap;
    private double aq;
    private double ar;

    public EntityMinecart(World world) {
        super(world);
        aj = new ItemStack[36];
        a = 0;
        b = 0;
        c = 1;
        ak = false;
        i = true;
        a(0.98F, 0.7F);
        G = I / 2.0F;
        L = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.z;
    }

    public AxisAlignedBB q() {
        return z;
    }

    public boolean u() {
        return true;
    }

    public EntityMinecart(World world, double d1, double d2, double d3, 
            int i) {
        this(world);
        a(d1, d2 + (double) G, d3);
        s = 0.0D;
        t = 0.0D;
        u = 0.0D;
        m = d1;
        n = d2;
        o = d3;
        d = i;
    }

    public double j() {
        return (double) I * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        c = -c;
        b = 10;
        a += i * 10;
        if (a > 40) {
            a(Item.ax.aW, 1, 0.0F);
            if (d == 1) {
                a(Block.av.bi, 1, 0.0F);
            } else if (d == 2) {
                a(Block.aC.bi, 1, 0.0F);
            }
            l();
        }
        return true;
    }

    public boolean c_() {
        return !F;
    }

    public void l() {
        label0:
        for (int i = 0; i < a(); i++) {
            ItemStack itemstack = a(i);

            if (itemstack == null) {
                continue;
            }
            float f1 = V.nextFloat() * 0.8F + 0.1F;
            float f2 = V.nextFloat() * 0.8F + 0.1F;
            float f3 = V.nextFloat() * 0.8F + 0.1F;

            do {
                if (itemstack.a <= 0) {
                    continue label0;
                }
                int k = V.nextInt(21) + 10;

                if (k > itemstack.a) {
                    k = itemstack.a;
                }
                itemstack.a -= k;
                EntityItem entityitem = new EntityItem(l, p + (double) f1, q + (double) f2, r + (double) f3, new ItemStack(itemstack.c, k, itemstack.d));
                float f4 = 0.05F;

                entityitem.s = (float) V.nextGaussian() * f4;
                entityitem.t = (float) V.nextGaussian() * f4 + 0.2F;
                entityitem.u = (float) V.nextGaussian() * f4;
                l.a(entityitem);
            } while (true);
        }

        super.l();
    }

    public void b_() {
        if (l.z) {
            if (am > 0) {
                double d1 = p + (an - p) / (double) am;
                double d2 = q + (ao - q) / (double) am;
                double d3 = r + (ap - r) / (double) am;
                double d4;

                for (d4 = aq - (double) v; d4 < -180D; d4 += 360D) {
                    ;
                }
                for (; d4 >= 180D; d4 -= 360D) {
                    ;
                }
                v += d4 / (double) am;
                w += (ar - (double) w) / (double) am;
                am--;
                a(d1, d2, d3);
                b(v, w);
            } else {
                a(p, q, r);
                b(v, w);
            }
            return;
        }
        if (b > 0) {
            b--;
        }
        if (a > 0) {
            a--;
        }
        m = p;
        n = q;
        o = r;
        t -= 0.039999999105930328D;
        int i = MathHelper.b(p);
        int k = MathHelper.b(q);
        int i1 = MathHelper.b(r);

        if (l.a(i, k - 1, i1) == Block.aH.bi) {
            k--;
        }
        double d6 = 0.40000000000000002D;
        boolean flag = false;
        double d5 = 0.0078125D;

        if (l.a(i, k, i1) == Block.aH.bi) {
            Vec3D vec3d = g(p, q, r);
            int j1 = l.b(i, k, i1);

            q = k;
            if (j1 >= 2 && j1 <= 5) {
                q = k + 1;
            }
            if (j1 == 2) {
                s -= d5;
            }
            if (j1 == 3) {
                s += d5;
            }
            if (j1 == 4) {
                u += d5;
            }
            if (j1 == 5) {
                u -= d5;
            }
            int ai1[][] = al[j1];
            double d7 = ai1[1][0] - ai1[0][0];
            double d8 = ai1[1][2] - ai1[0][2];
            double d9 = Math.sqrt(d7 * d7 + d8 * d8);
            double d10 = s * d7 + u * d8;

            if (d10 < 0.0D) {
                d7 = -d7;
                d8 = -d8;
            }
            double d11 = Math.sqrt(s * s + u * u);

            s = (d11 * d7) / d9;
            u = (d11 * d8) / d9;
            double d14 = 0.0D;
            double d15 = (double) i + 0.5D + (double) ai1[0][0] * 0.5D;
            double d16 = (double) i1 + 0.5D + (double) ai1[0][2] * 0.5D;
            double d17 = (double) i + 0.5D + (double) ai1[1][0] * 0.5D;
            double d18 = (double) i1 + 0.5D + (double) ai1[1][2] * 0.5D;

            d7 = d17 - d15;
            d8 = d18 - d16;
            if (d7 == 0.0D) {
                p = (double) i + 0.5D;
                d14 = r - (double) i1;
            } else if (d8 == 0.0D) {
                r = (double) i1 + 0.5D;
                d14 = p - (double) i;
            } else {
                double d19 = p - d15;
                double d21 = r - d16;
                double d23 = (d19 * d7 + d21 * d8) * 2D;

                d14 = d23;
            }
            p = d15 + d7 * d14;
            r = d16 + d8 * d14;
            a(p, q + (double) G, r);
            double d20 = s;
            double d22 = u;

            if (j != null) {
                d20 *= 0.75D;
                d22 *= 0.75D;
            }
            if (d20 < -d6) {
                d20 = -d6;
            }
            if (d20 > d6) {
                d20 = d6;
            }
            if (d22 < -d6) {
                d22 = -d6;
            }
            if (d22 > d6) {
                d22 = d6;
            }
            c(d20, 0.0D, d22);
            if (ai1[0][1] != 0 && MathHelper.b(p) - i == ai1[0][0] && MathHelper.b(r) - i1 == ai1[0][2]) {
                a(p, q + (double) ai1[0][1], r);
            } else if (ai1[1][1] != 0 && MathHelper.b(p) - i == ai1[1][0] && MathHelper.b(r) - i1 == ai1[1][2]) {
                a(p, q + (double) ai1[1][1], r);
            }
            if (j != null) {
                s *= 0.99699997901916504D;
                t *= 0.0D;
                u *= 0.99699997901916504D;
            } else {
                if (d == 2) {
                    double d24 = MathHelper.a(f * f + ai * ai);

                    if (d24 > 0.01D) {
                        flag = true;
                        f /= d24;
                        ai /= d24;
                        double d25 = 0.040000000000000001D;

                        s *= 0.80000001192092896D;
                        t *= 0.0D;
                        u *= 0.80000001192092896D;
                        s += f * d25;
                        u += ai * d25;
                    } else {
                        s *= 0.89999997615814209D;
                        t *= 0.0D;
                        u *= 0.89999997615814209D;
                    }
                }
                s *= 0.95999997854232788D;
                t *= 0.0D;
                u *= 0.95999997854232788D;
            }
            Vec3D vec3d1 = g(p, q, r);

            if (vec3d1 != null && vec3d != null) {
                double d26 = (vec3d.b - vec3d1.b) * 0.050000000000000003D;
                double d12 = Math.sqrt(s * s + u * u);

                if (d12 > 0.0D) {
                    s = (s / d12) * (d12 + d26);
                    u = (u / d12) * (d12 + d26);
                }
                a(p, vec3d1.b, r);
            }
            int k1 = MathHelper.b(p);
            int l1 = MathHelper.b(r);

            if (k1 != i || l1 != i1) {
                double d13 = Math.sqrt(s * s + u * u);

                s = d13 * (double) (k1 - i);
                u = d13 * (double) (l1 - i1);
            }
            if (d == 2) {
                double d27 = MathHelper.a(f * f + ai * ai);

                if (d27 > 0.01D && s * s + u * u > 0.001D) {
                    f /= d27;
                    ai /= d27;
                    if (f * s + ai * u < 0.0D) {
                        f = 0.0D;
                        ai = 0.0D;
                    } else {
                        f = s;
                        ai = u;
                    }
                }
            }
        } else {
            if (s < -d6) {
                s = -d6;
            }
            if (s > d6) {
                s = d6;
            }
            if (u < -d6) {
                u = -d6;
            }
            if (u > d6) {
                u = d6;
            }
            if (A) {
                s *= 0.5D;
                t *= 0.5D;
                u *= 0.5D;
            }
            c(s, t, u);
            if (!A) {
                s *= 0.94999998807907104D;
                t *= 0.94999998807907104D;
                u *= 0.94999998807907104D;
            }
        }
        w = 0.0F;
        double d28 = m - p;
        double d29 = o - r;

        if (d28 * d28 + d29 * d29 > 0.001D) {
            v = (float) ((Math.atan2(d29, d28) * 180D) / 3.1415926535897931D);
            if (ak) {
                v += 180F;
            }
        }
        double d30;

        for (d30 = v - x; d30 >= 180D; d30 -= 360D) {
            ;
        }
        for (; d30 < -180D; d30 += 360D) {
            ;
        }
        if (d30 < -170D || d30 >= 170D) {
            v += 180F;
            ak = !ak;
        }
        b(v, w);
        List list = l.b(this, z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Entity entity = (Entity) list.get(i2);

                if (entity != j && entity.u() && (entity instanceof EntityMinecart)) {
                    entity.c(this);
                }
            }

        }
        if (j != null && j.F) {
            j = null;
        }
        if (flag && V.nextInt(4) == 0) {
            e--;
            if (e < 0) {
                f = ai = 0.0D;
            }
            l.a("largesmoke", p, q + 0.80000000000000004D, r, 0.0D, 0.0D, 0.0D);
        }
    }

    public Vec3D g(double d1, double d2, double d3) {
        int i = MathHelper.b(d1);
        int k = MathHelper.b(d2);
        int i1 = MathHelper.b(d3);

        if (l.a(i, k - 1, i1) == Block.aH.bi) {
            k--;
        }
        if (l.a(i, k, i1) == Block.aH.bi) {
            int j1 = l.b(i, k, i1);

            d2 = k;
            if (j1 >= 2 && j1 <= 5) {
                d2 = k + 1;
            }
            int ai1[][] = al[j1];
            double d4 = 0.0D;
            double d5 = (double) i + 0.5D + (double) ai1[0][0] * 0.5D;
            double d6 = (double) k + 0.5D + (double) ai1[0][1] * 0.5D;
            double d7 = (double) i1 + 0.5D + (double) ai1[0][2] * 0.5D;
            double d8 = (double) i + 0.5D + (double) ai1[1][0] * 0.5D;
            double d9 = (double) k + 0.5D + (double) ai1[1][1] * 0.5D;
            double d10 = (double) i1 + 0.5D + (double) ai1[1][2] * 0.5D;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2D;
            double d13 = d10 - d7;

            if (d11 == 0.0D) {
                d1 = (double) i + 0.5D;
                d4 = d3 - (double) i1;
            } else if (d13 == 0.0D) {
                d3 = (double) i1 + 0.5D;
                d4 = d1 - (double) i;
            } else {
                double d14 = d1 - d5;
                double d15 = d3 - d7;
                double d16 = (d14 * d11 + d15 * d13) * 2D;

                d4 = d16;
            }
            d1 = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if (d12 < 0.0D) {
                d2++;
            }
            if (d12 > 0.0D) {
                d2 += 0.5D;
            }
            return Vec3D.b(d1, d2, d3);
        } else {
            return null;
        }
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Type", d);
        if (d == 2) {
            nbttagcompound.a("PushX", f);
            nbttagcompound.a("PushZ", ai);
            nbttagcompound.a("Fuel", (short) e);
        } else if (d == 1) {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 0; i < aj.length; i++) {
                if (aj[i] != null) {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                    nbttagcompound1.a("Slot", (byte) i);
                    aj[i].a(nbttagcompound1);
                    nbttaglist.a(nbttagcompound1);
                }
            }

            nbttagcompound.a("Items", nbttaglist);
        }
    }

    protected void b(NBTTagCompound nbttagcompound) {
        d = nbttagcompound.d("Type");
        if (d == 2) {
            f = nbttagcompound.g("PushX");
            ai = nbttagcompound.g("PushZ");
            e = nbttagcompound.c("Fuel");
        } else if (d == 1) {
            NBTTagList nbttaglist = nbttagcompound.k("Items");

            aj = new ItemStack[a()];
            for (int i = 0; i < nbttaglist.b(); i++) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
                int k = nbttagcompound1.b("Slot") & 0xff;

                if (k >= 0 && k < aj.length) {
                    aj[k] = new ItemStack(nbttagcompound1);
                }
            }

        }
    }

    public void c(Entity entity) {
        if (entity == j) {
            return;
        }
        if ((entity instanceof EntityLiving) && !(entity instanceof EntityPlayer) && d == 0 && s * s + u * u > 0.01D && j == null && entity.k == null) {
            entity.e(this);
        }
        double d1 = entity.p - p;
        double d2 = entity.r - r;
        double d3 = d1 * d1 + d2 * d2;

        if (d3 >= 9.9999997473787516E-005D) {
            d3 = MathHelper.a(d3);
            d1 /= d3;
            d2 /= d3;
            double d4 = 1.0D / d3;

            if (d4 > 1.0D) {
                d4 = 1.0D;
            }
            d1 *= d4;
            d2 *= d4;
            d1 *= 0.10000000149011612D;
            d2 *= 0.10000000149011612D;
            d1 *= 1.0F - T;
            d2 *= 1.0F - T;
            d1 *= 0.5D;
            d2 *= 0.5D;
            if (entity instanceof EntityMinecart) {
                double d5 = entity.s + s;
                double d6 = entity.u + u;

                if (((EntityMinecart) entity).d == 2 && d != 2) {
                    s *= 0.20000000298023224D;
                    u *= 0.20000000298023224D;
                    f(entity.s - d1, 0.0D, entity.u - d2);
                    entity.s *= 0.69999998807907104D;
                    entity.u *= 0.69999998807907104D;
                } else if (((EntityMinecart) entity).d != 2 && d == 2) {
                    entity.s *= 0.20000000298023224D;
                    entity.u *= 0.20000000298023224D;
                    entity.f(s + d1, 0.0D, u + d2);
                    s *= 0.69999998807907104D;
                    u *= 0.69999998807907104D;
                } else {
                    d5 /= 2D;
                    d6 /= 2D;
                    s *= 0.20000000298023224D;
                    u *= 0.20000000298023224D;
                    f(d5 - d1, 0.0D, d6 - d2);
                    entity.s *= 0.20000000298023224D;
                    entity.u *= 0.20000000298023224D;
                    entity.f(d5 + d1, 0.0D, d6 + d2);
                }
            } else {
                f(-d1, 0.0D, -d2);
                entity.f(d1 / 4D, 0.0D, d2 / 4D);
            }
        }
    }

    public int a() {
        return 27;
    }

    public ItemStack a(int i) {
        return aj[i];
    }

}

