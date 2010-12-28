package net.minecraft.server;


public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        aH = "/mob/zombie.png";
        bu = 0.5F;
        f = 50;
        aR *= 10;
        H *= 6F;
        a(I * 6F, J * 6F);
    }

    protected float a(int i, int j, int k) {
        return l.j(i, j, k) - 0.5F;
    }
}

