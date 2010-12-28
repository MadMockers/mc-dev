package net.minecraft.server;


import java.util.Random;


public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        aQ = "/mob/zombie.png";
        bD = 0.5F;
        f = 5;
    }

    public void G() {
        if (l.b()) {
            float f1 = b(1.0F);

            if (f1 > 0.5F && l.h(MathHelper.b(p), MathHelper.b(q), MathHelper.b(r)) && W.nextFloat() * 30F < (f1 - 0.4F) * 2.0F) {
                Z = 300;
            }
        }
        super.G();
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

