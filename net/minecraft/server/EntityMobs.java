package net.minecraft.server;


import java.util.Random;


public class EntityMobs extends EntityCreature
        implements IMobs {

    protected int f;

    public EntityMobs(World world) {
        super(world);
        f = 2;
        ba = 20;
    }

    public void G() {
        float f1 = b(1.0F);

        if (f1 > 0.5F) {
            bx += 2;
        }
        super.G();
    }

    public void b_() {
        super.b_();
        if (l.k == 0) {
            l();
        }
    }

    protected Entity k() {
        EntityPlayer entityplayer = l.a(this, 16D);

        if (entityplayer != null && i(entityplayer)) {
            return entityplayer;
        } else {
            return null;
        }
    }

    public boolean a(Entity entity, int i) {
        if (super.a(entity, i)) {
            if (j == entity || k == entity) {
                return true;
            }
            if (entity != this) {
                aj = entity;
            }
            return true;
        } else {
            return false;
        }
    }

    protected void a(Entity entity, float f1) {
        if ((double) f1 < 2.5D && entity.z.e > z.b && entity.z.b < z.e) {
            bg = 20;
            entity.a(this, f);
        }
    }

    protected float a(int i, int j, int l) {
        return 0.5F - this.l.k(i, j, l);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public boolean a() {
        int i = MathHelper.b(p);
        int j = MathHelper.b(z.b);
        int l = MathHelper.b(r);

        if (this.l.a(EnumSkyBlock.a, i, j, l) > W.nextInt(32)) {
            return false;
        } else {
            int i1 = this.l.i(i, j, l);

            return i1 <= W.nextInt(8) && super.a();
        }
    }
}

