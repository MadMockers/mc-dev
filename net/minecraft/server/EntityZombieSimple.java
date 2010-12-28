package net.minecraft.server;


public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        aQ = "/mob/zombie.png";
        bD = 0.5F;
        f = 50;
        ba *= 10;
        H *= 6F;
        a(I * 6F, J * 6F);
    }

    protected float a(int i, int j, int k) {
        return l.k(i, j, k) - 0.5F;
    }
}

