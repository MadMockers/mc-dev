package net.minecraft.server;


import java.util.Random;


public class EntityChicken extends EntityAnimals {

    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int al;

    public EntityChicken(World world) {
        super(world);
        a = false;
        b = 0.0F;
        c = 0.0F;
        f = 1.0F;
        aQ = "/mob/chicken.png";
        a(0.3F, 0.4F);
        ba = 4;
        al = W.nextInt(6000) + 6000;
    }

    public void G() {
        super.G();
        e = b;
        d = c;
        c += (double) (A ? -1 : 4) * 0.29999999999999999D;
        if (c < 0.0F) {
            c = 0.0F;
        }
        if (c > 1.0F) {
            c = 1.0F;
        }
        if (!A && f < 1.0F) {
            f = 1.0F;
        }
        f *= 0.90000000000000002D;
        if (!A && t < 0.0D) {
            t *= 0.59999999999999998D;
        }
        b += f * 2.0F;
        if (!l.z && --al <= 0) {
            l.a(this, "mob.chickenplop", 1.0F, (W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F);
            b(Item.aN.aW, 1);
            al = W.nextInt(6000) + 6000;
        }
    }

    protected void a(float f1) {}

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected String d() {
        return "mob.chicken";
    }

    protected String e() {
        return "mob.chickenhurt";
    }

    protected String f() {
        return "mob.chickenhurt";
    }

    protected int g() {
        return Item.J.aW;
    }
}

