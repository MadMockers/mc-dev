package net.minecraft.server;


public class EntityFallingSand extends Entity {

    public int a;
    public int b;

    public EntityFallingSand(World world) {
        super(world);
        b = 0;
    }

    public EntityFallingSand(World world, float f, float f1, float f2, int i) {
        super(world);
        b = 0;
        a = i;
        this.i = true;
        a(0.98F, 0.98F);
        G = I / 2.0F;
        a(f, f1, f2);
        s = 0.0D;
        t = 0.0D;
        u = 0.0D;
        L = false;
        m = f;
        n = f1;
        o = f2;
    }

    public boolean c_() {
        return !F;
    }

    public void b_() {
        if (a == 0) {
            l();
            return;
        }
        m = p;
        n = q;
        o = r;
        b++;
        t -= 0.039999999105930328D;
        c(s, t, u);
        s *= 0.98000001907348633D;
        t *= 0.98000001907348633D;
        u *= 0.98000001907348633D;
        int i = MathHelper.b(p);
        int j = MathHelper.b(q);
        int k = MathHelper.b(r);

        if (l.a(i, j, k) == a) {
            l.d(i, j, k, 0);
        }
        if (A) {
            s *= 0.69999998807907104D;
            u *= 0.69999998807907104D;
            t *= -0.5D;
            l();
            if (!l.a(a, i, j, k, true) || !l.d(i, j, k, a)) {
                a(a, 1);
            }
        } else if (b > 100) {
            a(a, 1);
            l();
        }
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Tile", (byte) a);
    }

    protected void b(NBTTagCompound nbttagcompound) {
        a = nbttagcompound.b("Tile") & 0xff;
    }
}

