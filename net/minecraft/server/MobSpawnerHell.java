package net.minecraft.server;


public class MobSpawnerHell extends MobSpawnerBase {

    public MobSpawnerHell() {
        r = (new Class[] {
            net.minecraft.server.EntityGhast.class, net.minecraft.server.EntityPigZombie.class
        });
        s = new Class[0];
    }
}

