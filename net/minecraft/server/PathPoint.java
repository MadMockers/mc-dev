package net.minecraft.server;


public class PathPoint {

    public final int a;
    public final int b;
    public final int c;
    public final int d;
    int e;
    float f;
    float g;
    float h;
    PathPoint i;
    public boolean j;

    public PathPoint(int k, int l, int i1) {
        e = -1;
        j = false;
        a = k;
        b = l;
        c = i1;
        d = k | l << 10 | i1 << 20;
    }

    public float a(PathPoint pathpoint) {
        float f1 = pathpoint.a - a;
        float f2 = pathpoint.b - b;
        float f3 = pathpoint.c - c;

        return MathHelper.c(f1 * f1 + f2 * f2 + f3 * f3);
    }

    public boolean equals(Object obj) {
        return ((PathPoint) obj).d == d;
    }

    public int hashCode() {
        return d;
    }

    public boolean a() {
        return e >= 0;
    }

    public String toString() {
        return (new StringBuilder()).append(a).append(", ").append(b).append(", ").append(c).toString();
    }
}

