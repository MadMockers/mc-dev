package net.minecraft.server;


public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        aF = "/mob/zombie.png";
        br = 0.5F;
        e = 50;
        aP *= 10;
        G *= 6F;
        a(H * 6F, I * 6F);
    }

    protected float a(int i, int j, int k) {
        return l.j(i, j, k) - 0.5F;
    }
}

