package net.minecraft.server;


import java.util.Random;


public class EntitySheep extends EntityAnimals {

    public boolean a;

    public EntitySheep(World world) {
        super(world);
        a = false;
        aH = "/mob/sheep.png";
        a(0.9F, 1.3F);
    }

    public boolean a(Entity entity, int i) {
        if (!l.z && !a && (entity instanceof EntityLiving)) {
            a = true;
            int j = 1 + W.nextInt(3);

            for (int k = 0; k < j; k++) {
                EntityItem entityitem = a(Block.ab.bh, 1, 1.0F);

                entityitem.t += W.nextFloat() * 0.05F;
                entityitem.s += (W.nextFloat() - W.nextFloat()) * 0.1F;
                entityitem.u += (W.nextFloat() - W.nextFloat()) * 0.1F;
            }

        }
        return super.a(entity, i);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Sheared", a);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        a = nbttagcompound.l("Sheared");
    }

    protected String d() {
        return "mob.sheep";
    }

    protected String e() {
        return "mob.sheep";
    }

    protected String f() {
        return "mob.sheep";
    }
}

