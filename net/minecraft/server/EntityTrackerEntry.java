package net.minecraft.server;


import java.util.*;


public class EntityTrackerEntry {

    public Entity a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    private double l;
    private double m;
    private double n;
    private boolean o;
    public boolean j;
    public Set k;

    public EntityTrackerEntry(Entity entity, int i1, int j1) {
        i = 0;
        o = false;
        j = false;
        k = new HashSet();
        a = entity;
        b = i1;
        c = j1;
        d = MathHelper.b(entity.p * 32D);
        e = MathHelper.b(entity.q * 32D);
        f = MathHelper.b(entity.r * 32D);
        g = MathHelper.d((entity.v * 256F) / 360F);
        h = MathHelper.d((entity.w * 256F) / 360F);
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
        j = false;
        if (!o || a.d(l, m, n) > 16D) {
            b(list);
            l = a.p;
            m = a.q;
            n = a.r;
            o = true;
            j = true;
        }
        if (i++ % c == 0) {
            int i1 = MathHelper.b(a.p * 32D);
            int j1 = MathHelper.b(a.q * 32D);
            int k1 = MathHelper.b(a.r * 32D);
            int l1 = MathHelper.d((a.v * 256F) / 360F);
            int i2 = MathHelper.d((a.w * 256F) / 360F);
            boolean flag = i1 != d || j1 != e || k1 != f;
            boolean flag1 = l1 != g || i2 != h;
            int j2 = i1 - d;
            int k2 = j1 - e;
            int l2 = k1 - f;
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
            if (obj != null) {
                a(((Packet) (obj)));
            }
            d = i1;
            e = j1;
            f = k1;
            g = l1;
            h = i2;
        }
    }

    public void a(Packet packet) {
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = k.iterator(); iterator.hasNext(); entityplayermp.a.b(packet)) {
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
        double d1 = entityplayermp.p - (double) (d / 32);
        double d2 = entityplayermp.r - (double) (f / 32);

        if (d1 >= (double) (-b) && d1 <= (double) b && d2 >= (double) (-b) && d2 <= (double) b) {
            if (!k.contains(entityplayermp)) {
                k.add(entityplayermp);
                entityplayermp.a.b(b());
            }
        } else if (k.contains(entityplayermp)) {
            k.remove(entityplayermp);
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
            entityitem.s = (double) packet21pickupspawn.e / 128D;
            entityitem.t = (double) packet21pickupspawn.f / 128D;
            entityitem.u = (double) packet21pickupspawn.g / 128D;
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
            return new PacketUnusedFishing(a, 1);
        } else {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(a.getClass()).append("!").toString());
        }
    }
}

