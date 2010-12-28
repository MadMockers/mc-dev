package net.minecraft.server;


import java.util.*;


public class EntityTrackerEntry {

    public Entity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public double l;
    public double m;
    public double n;
    public int o;
    private double r;
    private double s;
    private double t;
    private boolean u;
    private boolean v;
    public boolean p;
    public Set q;

    public EntityTrackerEntry(Entity entity, int i1, int j1, boolean flag) {
        b = false;
        c = false;
        d = false;
        o = 0;
        u = false;
        p = false;
        q = new HashSet();
        a = entity;
        e = i1;
        f = j1;
        v = flag;
        g = MathHelper.b(entity.p * 32D);
        h = MathHelper.b(entity.q * 32D);
        i = MathHelper.b(entity.r * 32D);
        j = MathHelper.d((entity.v * 256F) / 360F);
        k = MathHelper.d((entity.w * 256F) / 360F);
    }

    public boolean equals(Object obj) {
        if (obj instanceof EntityTrackerEntry) {
            return ((EntityTrackerEntry) obj).a.g == a.g;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return a.g;
    }

    public void a(List list) {
        p = false;
        if (!u || a.d(r, s, t) > 16D) {
            r = a.p;
            s = a.q;
            t = a.r;
            u = true;
            p = true;
            b(list);
        }
        if (o++ % f == 0) {
            int i1 = MathHelper.b(a.p * 32D);
            int j1 = MathHelper.b(a.q * 32D);
            int k1 = MathHelper.b(a.r * 32D);
            int l1 = MathHelper.d((a.v * 256F) / 360F);
            int i2 = MathHelper.d((a.w * 256F) / 360F);
            boolean flag = i1 != g || j1 != h || k1 != i;
            boolean flag1 = l1 != j || i2 != k;
            int j2 = i1 - g;
            int k2 = j1 - h;
            int l2 = k1 - i;
            Object obj = null;

            if (j2 < -128 || j2 >= 128 || k2 < -128 || k2 >= 128 || l2 < -128 || l2 >= 128) {
                obj = new Packet34EntityTeleport(a.g, i1, j1, k1, (byte) l1, (byte) i2);
            } else if (flag && flag1) {
                obj = new Packet33RelEntityMoveLook(a.g, (byte) j2, (byte) k2, (byte) l2, (byte) l1, (byte) i2);
            } else if (flag) {
                obj = new Packet31RelEntityMove(a.g, (byte) j2, (byte) k2, (byte) l2);
            } else if (flag1) {
                obj = new Packet32EntityLook(a.g, (byte) l1, (byte) i2);
            } else {
                obj = new Packet30Entity(a.g);
            }
            if (v) {
                double d1 = a.s - l;
                double d2 = a.t - m;
                double d3 = a.u - n;
                double d4 = 0.02D;
                double d5 = d1 * d1 + d2 * d2 + d3 * d3;

                if (d5 > d4 * d4 || d5 > 0.0D && a.s == 0.0D && a.t == 0.0D && a.u == 0.0D) {
                    l = a.s;
                    m = a.t;
                    n = a.u;
                    a(((Packet) (new Packet28(a.g, l, m, n))));
                }
            }
            if (obj != null) {
                a(((Packet) (obj)));
            }
            if (b && a.k == null) {
                b = false;
                b(new Packet18ArmAnimation(a, 101));
            } else if (!b && a.k != null) {
                b = true;
                b(new Packet18ArmAnimation(a, 100));
            }
            if (a instanceof EntityLiving) {
                if (d && !a.p()) {
                    d = false;
                    b(new Packet18ArmAnimation(a, 105));
                } else if (!d && a.p()) {
                    d = true;
                    b(new Packet18ArmAnimation(a, 104));
                }
            }
            if (c && a.Z <= 0) {
                c = false;
                b(new Packet18ArmAnimation(a, 103));
            } else if (!c && a.Z > 0) {
                c = true;
                b(new Packet18ArmAnimation(a, 102));
            }
            g = i1;
            h = j1;
            i = k1;
            j = l1;
            k = i2;
        }
        if (a.E) {
            b(new Packet28(a));
            a.E = false;
        }
    }

    public void a(Packet packet) {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = q.iterator(); iterator.hasNext(); entityplayermp.a.b(packet)) {
            entityplayermp = (EntityPlayerMP) iterator.next();
        }

    }

    public void b(Packet packet) {
        a(packet);
        if (a instanceof EntityPlayerMP) {
            ((EntityPlayerMP) a).a.b(packet);
        }
    }

    public void a() {
        a(((Packet) (new Packet29DestroyEntity(a.g))));
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (q.contains(entityplayermp)) {
            q.remove(entityplayermp);
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        if (entityplayermp == a) {
            return;
        }
        double d1 = entityplayermp.p - (double) (g / 32);
        double d2 = entityplayermp.r - (double) (i / 32);

        if (d1 >= (double) (-e) && d1 <= (double) e && d2 >= (double) (-e) && d2 <= (double) e) {
            if (!q.contains(entityplayermp)) {
                q.add(entityplayermp);
                entityplayermp.a.b(b());
                if (d) {
                    entityplayermp.a.b(new Packet18ArmAnimation(a, 104));
                }
                if (b) {
                    entityplayermp.a.b(new Packet18ArmAnimation(a, 100));
                }
                if (c) {
                    entityplayermp.a.b(new Packet18ArmAnimation(a, 102));
                }
                if (v) {
                    entityplayermp.a.b(new Packet28(a.g, a.s, a.t, a.u));
                }
            }
        } else if (q.contains(entityplayermp)) {
            q.remove(entityplayermp);
            entityplayermp.a.b(new Packet29DestroyEntity(a.g));
        }
    }

    public void b(List list) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            b((EntityPlayerMP) list.get(i1));
        }

    }

    private Packet b() {
        if (a instanceof EntityItem) {
            EntityItem entityitem = (EntityItem) a;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);

            entityitem.p = (double) packet21pickupspawn.b / 32D;
            entityitem.q = (double) packet21pickupspawn.c / 32D;
            entityitem.r = (double) packet21pickupspawn.d / 32D;
            return packet21pickupspawn;
        }
        if (a instanceof EntityPlayerMP) {
            return new Packet20NamedEntitySpawn((EntityPlayer) a);
        }
        if (a instanceof EntityMinecart) {
            EntityMinecart entityminecart = (EntityMinecart) a;

            if (entityminecart.d == 0) {
                return new Packet23VehicleSpawn(a, 10);
            }
            if (entityminecart.d == 1) {
                return new Packet23VehicleSpawn(a, 11);
            }
            if (entityminecart.d == 2) {
                return new Packet23VehicleSpawn(a, 12);
            }
        }
        if (a instanceof EntityBoat) {
            return new Packet23VehicleSpawn(a, 1);
        }
        if (a instanceof IAnimals) {
            return new Packet24MobSpawn((EntityLiving) a);
        }
        if (a instanceof EntityFish) {
            return new Packet23VehicleSpawn(a, 90);
        }
        if (a instanceof EntityArrow) {
            return new Packet23VehicleSpawn(a, 60);
        }
        if (a instanceof EntitySnowball) {
            return new Packet23VehicleSpawn(a, 61);
        }
        if (a instanceof EntityTNTPrimed) {
            return new Packet23VehicleSpawn(a, 50);
        } else {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(a.getClass()).append("!").toString());
        }
    }

    public void c(EntityPlayerMP entityplayermp) {
        if (q.contains(entityplayermp)) {
            q.remove(entityplayermp);
            entityplayermp.a.b(new Packet29DestroyEntity(a.g));
        }
    }
}

