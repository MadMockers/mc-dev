package net.minecraft.server;


import java.util.Random;


public class EntityChicken extends EntityAnimals {

    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float aj;
    public int ak;

    public EntityChicken(World world) {
        super(world);
        a = false;
        b = 0.0F;
        c = 0.0F;
        aj = 1.0F;
        aF = "/mob/chicken.png";
        a(0.3F, 0.4F);
        aP = 4;
        ak = V.nextInt(6000) + 6000;
    }

    public void D() {
        super.D();
        e = b;
        d = c;
        c += (double) (A ? -1 : 4) * 0.29999999999999999D;
        if (c < 0.0F) {
            c = 0.0F;
        }
        if (c > 1.0F) {
            c = 1.0F;
        }
        if (!A && aj < 1.0F) {
            aj = 1.0F;
        }
        aj *= 0.90000000000000002D;
        if (!A && t < 0.0D) {
            t *= 0.59999999999999998D;
        }
        b += aj * 2.0F;
        if (!l.z && --ak <= 0) {
            l.a(this, "mob.chickenplop", 1.0F, (V.nextFloat() - V.nextFloat()) * 0.2F + 1.0F);
            a(Item.aN.aW, 1);
            ak = V.nextInt(6000) + 6000;
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

