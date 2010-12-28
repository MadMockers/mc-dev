package net.minecraft.server;


import java.util.Random;


public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        aF = "/mob/zombie.png";
        bl = 0.5F;
        e = 5;
    }

    public void D() {
        if (l.b()) {
            float f1 = b(1.0F);

            if (f1 > 0.5F && l.g(MathHelper.b(p), MathHelper.b(q), MathHelper.b(r)) && V.nextFloat() * 30F < (f1 - 0.4F) * 2.0F) {
                Y = 300;
            }
        }
        super.D();
    }

    protected String d() {
        return "mob.zombie";
    }

    protected String e() {
        return "mob.zombiehurt";
    }

    protected String f() {
        return "mob.zombiedeath";
    }

    protected int g() {
        return Item.J.aW;
    }
}

