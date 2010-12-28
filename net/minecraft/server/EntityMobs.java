package net.minecraft.server;


import java.util.Random;


public class EntityMobs extends EntityCreature
        implements IMobs {

    protected int e;

    public EntityMobs(World world) {
        super(world);
        e = 2;
        aP = 20;
    }

    public void D() {
        float f = b(1.0F);

        if (f > 0.5F) {
            bf += 2;
        }
        super.D();
    }

    public void b_() {
        super.b_();
        if (l.k == 0) {
            l();
        }
    }

    protected Entity k() {
        EntityPlayer entityplayer = l.a(this, 16D);

        if (entityplayer != null && g(entityplayer)) {
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
                f = entity;
            }
            return true;
        } else {
            return false;
        }
    }

    protected void a(Entity entity, float f) {
        if ((double) f < 2.5D && entity.z.e > z.b && entity.z.b < z.e) {
            aV = 20;
            entity.a(this, e);
        }
    }

    protected float a(int i, int j, int l) {
        return 0.5F - this.l.j(i, j, l);
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

        if (this.l.a(EnumSkyBlock.a, i, j, l) > V.nextInt(32)) {
            return false;
        } else {
            int i1 = this.l.h(i, j, l);

            return i1 <= V.nextInt(8) && super.a();
        }
    }
}

