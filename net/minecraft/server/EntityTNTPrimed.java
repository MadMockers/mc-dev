package net.minecraft.server;


public class EntityTNTPrimed extends Entity {

    public int a;

    public EntityTNTPrimed(World world) {
        super(world);
        a = 0;
        i = true;
        a(0.98F, 0.98F);
        G = I / 2.0F;
    }

    public EntityTNTPrimed(World world, float f, float f1, float f2) {
        this(world);
        a(f, f1, f2);
        float f3 = (float) (Math.random() * 3.1415927410125732D * 2D);

        s = -MathHelper.a((f3 * 3.141593F) / 180F) * 0.02F;
        t = 0.20000000298023224D;
        u = -MathHelper.b((f3 * 3.141593F) / 180F) * 0.02F;
        L = false;
        a = 80;
        m = f;
        n = f1;
        o = f2;
    }

    public boolean c_() {
        return !F;
    }

    public void b_() {
        m = p;
        n = q;
        o = r;
        t -= 0.039999999105930328D;
        c(s, t, u);
        s *= 0.98000001907348633D;
        t *= 0.98000001907348633D;
        u *= 0.98000001907348633D;
        if (A) {
            s *= 0.69999998807907104D;
            u *= 0.69999998807907104D;
            t *= -0.5D;
        }
        if (a-- <= 0) {
            l();
            c();
        } else {
            l.a("smoke", p, q + 0.5D, r, 0.0D, 0.0D, 0.0D);
        }
    }

    private void c() {
        float f = 4F;

        l.a(null, p, q, r, f);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Fuse", (byte) a);
    }

    protected void b(NBTTagCompound nbttagcompound) {
        a = nbttagcompound.b("Fuse");
    }
}

