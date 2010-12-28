package net.minecraft.server;


import java.util.List;
import java.util.Random;


public class EntityPigZombie extends EntityZombie {

    private int a;
    private int b;
    private static final ItemStack c;

    public EntityPigZombie(World world) {
        super(world);
        a = 0;
        b = 0;
        aG = "/mob/pigzombie.png";
        bt = 0.5F;
        e = 5;
        ae = true;
    }

    public void b_() {
        bt = f == null ? 0.5F : 0.95F;
        if (b > 0 && --b == 0) {
            l.a(this, "mob.zombiepig.zpigangry", h() * 2.0F, ((W.nextFloat() - W.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }
        super.b_();
    }

    public boolean a() {
        return l.k > 0 && l.a(z) && l.a(this, z).size() == 0 && !l.b(z);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.a("Anger", (short) a);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        a = nbttagcompound.c("Anger");
    }

    protected Entity k() {
        if (a == 0) {
            return null;
        } else {
            return super.k();
        }
    }

    public void E() {
        super.E();
    }

    public boolean a(Entity entity, int i) {
        if (entity instanceof EntityPlayer) {
            List list = l.b(this, z.b(32D, 32D, 32D));

            for (int j = 0; j < list.size(); j++) {
                Entity entity1 = (Entity) list.get(j);

                if (entity1 instanceof EntityPigZombie) {
                    EntityPigZombie entitypigzombie = (EntityPigZombie) entity1;

                    entitypigzombie.g(entity);
                }
            }

            g(entity);
        }
        return super.a(entity, i);
    }

    private void g(Entity entity) {
        f = entity;
        a = 400 + W.nextInt(400);
        b = W.nextInt(40);
    }

    protected String d() {
        return "mob.zombiepig.zpig";
    }

    protected String e() {
        return "mob.zombiepig.zpighurt";
    }

    protected String f() {
        return "mob.zombiepig.zpigdeath";
    }

    protected int g() {
        return Item.ap.aW;
    }

    static {
        c = new ItemStack(Item.E, 1);
    }
}

