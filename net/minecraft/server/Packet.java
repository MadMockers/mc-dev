package net.minecraft.server;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


public abstract class Packet {

    private static Map a = new HashMap();
    private static Map b = new HashMap();
    public boolean j;

    public Packet() {
        j = false;
    }

    static void a(int i, Class class1) {
        if (a.containsKey(Integer.valueOf(i))) {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet id:").append(i).toString());
        }
        if (b.containsKey(class1)) {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate packet class:").append(class1).toString());
        } else {
            a.put(Integer.valueOf(i), class1);
            b.put(class1, Integer.valueOf(i));
            return;
        }
    }

    public static Packet a(int i) {
        try {
            Class class1 = (Class) a.get(Integer.valueOf(i));

            if (class1 == null) {
                return null;
            } else {
                return (Packet) class1.newInstance();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println((new StringBuilder()).append("Skipping packet with id ").append(i).toString());
        return null;
    }

    public final int b() {
        return ((Integer) b.get(getClass())).intValue();
    }

    public static Packet b(DataInputStream datainputstream) {
        int i = datainputstream.read();

        if (i == -1) {
            return null;
        }
        Packet packet = a(i);

        if (packet == null) {
            throw new IOException((new StringBuilder()).append("Bad packet id ").append(i).toString());
        } else {
            packet.a(datainputstream);
            return packet;
        }
    }

    public static void a(Packet packet, DataOutputStream dataoutputstream) {
        dataoutputstream.write(packet.b());
        packet.a(dataoutputstream);
    }

    public abstract void a(DataInputStream datainputstream);

    public abstract void a(DataOutputStream dataoutputstream);

    public abstract void a(NetHandler nethandler);

    public abstract int a();

    static Class _mthclass$(String s) {
        try {
            return Class.forName(s);
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    static {
        a(0, net.minecraft.server.Packet0KeepAlive.class);
        a(1, net.minecraft.server.Packet1Login.class);
        a(2, net.minecraft.server.Packet2Handshake.class);
        a(3, net.minecraft.server.Packet3Chat.class);
        a(4, net.minecraft.server.Packet4UpdateTime.class);
        a(5, net.minecraft.server.Packet5PlayerInventory.class);
        a(6, net.minecraft.server.Packet6SpawnPosition.class);
        a(10, net.minecraft.server.Packet10Flying.class);
        a(11, net.minecraft.server.Packet11PlayerPosition.class);
        a(12, net.minecraft.server.Packet12PlayerLook.class);
        a(13, net.minecraft.server.Packet13PlayerLookMove.class);
        a(14, net.minecraft.server.Packet14BlockDig.class);
        a(15, net.minecraft.server.Packet15Place.class);
        a(16, net.minecraft.server.Packet16BlockItemSwitch.class);
        a(17, net.minecraft.server.Packet17AddToInventory.class);
        a(18, net.minecraft.server.Packet18ArmAnimation.class);
        a(20, net.minecraft.server.Packet20NamedEntitySpawn.class);
        a(21, net.minecraft.server.Packet21PickupSpawn.class);
        a(22, net.minecraft.server.Packet22Collect.class);
        a(23, net.minecraft.server.Packet23VehicleSpawn.class);
        a(24, net.minecraft.server.Packet24MobSpawn.class);
        a(29, net.minecraft.server.Packet29DestroyEntity.class);
        a(30, net.minecraft.server.Packet30Entity.class);
        a(31, net.minecraft.server.Packet31RelEntityMove.class);
        a(32, net.minecraft.server.Packet32EntityLook.class);
        a(33, net.minecraft.server.Packet33RelEntityMoveLook.class);
        a(34, net.minecraft.server.Packet34EntityTeleport.class);
        a(50, net.minecraft.server.Packet50PreChunk.class);
        a(51, net.minecraft.server.Packet51MapChunk.class);
        a(52, net.minecraft.server.Packet52MultiBlockChange.class);
        a(53, net.minecraft.server.Packet53BlockChange.class);
        a(59, net.minecraft.server.Packet59ComplexEntity.class);
        a(255, net.minecraft.server.Packet255KickDisconnect.class);
    }
}

