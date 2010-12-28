package net.minecraft.server;


public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        aG = "/mob/zombie.png";
        bt = 0.5F;
        e = 50;
        aQ *= 10;
        H *= 6F;
        a(I * 6F, J * 6F);
    }

    protected float a(int i, int j, int k) {
        return l.j(i, j, k) - 0.5F;
    }
}

