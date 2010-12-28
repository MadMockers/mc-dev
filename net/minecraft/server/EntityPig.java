package net.minecraft.server;


public class EntityPig extends EntityAnimals {

    public boolean a;

    public EntityPig(World world) {
        super(world);
        a = false;
        aG = "/mob/pig.png";
        a(0.9F, 0.9F);
        a = false;
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Saddle", a);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        a = nbttagcompound.l("Saddle");
    }

    protected String d() {
        return "mob.pig";
    }

    protected String e() {
        return "mob.pig";
    }

    protected String f() {
        return "mob.pigdeath";
    }

    public boolean a(EntityPlayer entityplayer) {
        if (a) {
            entityplayer.e(this);
            return true;
        } else {
            return false;
        }
    }

    protected int g() {
        return Item.ao.aW;
    }
}

