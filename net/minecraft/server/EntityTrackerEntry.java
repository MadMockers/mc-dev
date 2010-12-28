package net.minecraft.server;


import java.util.*;


public class EntityTrackerEntry {

    public Entity a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public double j;
    public double k;
    public double l;
    public int m;
    private double p;
    private double q;
    private double r;
    private boolean s;
    private boolean t;
    public boolean n;
    public Set o;

    public EntityTrackerEntry(Entity entity, int i1, int j1, boolean flag) {
        b = false;
        m = 0;
        s = false;
        n = false;
        o = new HashSet();
        a = entity;
        c = i1;
        d = j1;
        t = flag;
        e = MathHelper.b(entity.p * 32D);
        f = MathHelper.b(entity.q * 32D);
        g = MathHelper.b(entity.r * 32D);
        h = MathHelper.d((entity.v * 256F) / 360F);
        i = MathHelper.d((entity.w * 256F) / 360F);
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
        n = false;
        if (!s || a.d(p, q, r) > 16D) {
            b(list);
            p = a.p;
            q = a.q;
            r = a.r;
            s = true;
            n = true;
        }
        if (m++ % d == 0) {
            int i1 = MathHelper.b(a.p * 32D);
            int j1 = MathHelper.b(a.q * 32D);
            int k1 = MathHelper.b(a.r * 32D);
            int l1 = MathHelper.d((a.v * 256F) / 360F);
            int i2 = MathHelper.d((a.w * 256F) / 360F);
            boolean flag = i1 != e || j1 != f || k1 != g;
            boolean flag1 = l1 != h || i2 != i;
            int j2 = i1 - e;
            int k2 = j1 - f;
            int l2 = k1 - g;
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
            if (t) {
                double d1 = a.s - j;
                double d2 = a.t - k;
                double d3 = a.u - l;
                double d4 = 0.02D;
                double d5 = d1 * d1 + d2 * d2 + d3 * d3;

                if (d5 > d4 * d4 || d5 > 0.0D && a.s == 0.0D && a.t == 0.0D && a.u == 0.0D) {
                    j = a.s;
                    k = a.t;
                    l = a.u;
                    a(((Packet) (new Packet28(a.g, j, k, l))));
                }
            }
            if (obj != null) {
                a(((Packet) (obj)));
            }
            if (b && a.k == null) {
                b = false;
                a(((Packet) (new Packet18ArmAnimation(a, 3))));
            } else if (!b && a.k != null) {
                b = true;
                a(((Packet) (new Packet18ArmAnimation(a, 2))));
            }
            e = i1;
            f = j1;
            g = k1;
            h = l1;
            i = i2;
        }
    }

    public void a(Packet packet) {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = o.iterator(); iterator.hasNext(); entityplayermp.a.b(packet)) {
            entityplayermp = (EntityPlayerMP) iterator.next();
        }

    }

    public void a() {
        a(((Packet) (new Packet29DestroyEntity(a.g))));
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (entityplayermp == a) {
            return;
        }
        double d1 = entityplayermp.p - (double) (e / 32);
        double d2 = entityplayermp.r - (double) (g / 32);

        if (d1 >= (double) (-c) && d1 <= (double) c && d2 >= (double) (-c) && d2 <= (double) c) {
            if (!o.contains(entityplayermp)) {
                o.add(entityplayermp);
                entityplayermp.a.b(b());
                if (b) {
                    entityplayermp.a.b(new Packet18ArmAnimation(a, 2));
                }
                if (t) {
                    entityplayermp.a.b(new Packet28(a.g, a.s, a.t, a.u));
                }
            }
        } else if (o.contains(entityplayermp)) {
            o.remove(entityplayermp);
            entityplayermp.a.b(new Packet29DestroyEntity(a.g));
        }
    }

    public void b(List list) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            a((EntityPlayerMP) list.get(i1));
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
        } else {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(a.getClass()).append("!").toString());
        }
    }
}

