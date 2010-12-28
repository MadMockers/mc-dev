package net.minecraft.server;


public class PathEntity {

    private final PathPoint b[];
    public final int a;
    private int c;

    public PathEntity(PathPoint apathpoint[]) {
        b = apathpoint;
        a = apathpoint.length;
    }

    public void a() {
        c++;
    }

    public boolean b() {
        return c >= b.length;
    }

    public Vec3D a(Entity entity) {
        double d = (double) b[c].a + (double) (int) (entity.H + 1.0F) * 0.5D;
        double d1 = b[c].b;
        double d2 = (double) b[c].c + (double) (int) (entity.H + 1.0F) * 0.5D;

        return Vec3D.b(d, d1, d2);
    }
}

