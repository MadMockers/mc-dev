package net.minecraft.server;


public class Path {

    private PathPoint a[];
    private int b;

    public Path() {
        a = new PathPoint[1024];
        b = 0;
    }

    public PathPoint a(PathPoint pathpoint) {
        if (pathpoint.e >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (b == a.length) {
            PathPoint apathpoint[] = new PathPoint[b << 1];

            System.arraycopy(a, 0, apathpoint, 0, b);
            a = apathpoint;
        }
        a[b] = pathpoint;
        pathpoint.e = b;
        a(b++);
        return pathpoint;
    }

    public void a() {
        b = 0;
    }

    public PathPoint b() {
        PathPoint pathpoint = a[0];

        a[0] = a[--b];
        a[b] = null;
        if (b > 0) {
            b(0);
        }
        pathpoint.e = -1;
        return pathpoint;
    }

    public void a(PathPoint pathpoint, float f) {
        float f1 = pathpoint.h;

        pathpoint.h = f;
        if (f < f1) {
            a(pathpoint.e);
        } else {
            b(pathpoint.e);
        }
    }

    private void a(int i) {
        PathPoint pathpoint = a[i];
        float f = pathpoint.h;

        do {
            if (i <= 0) {
                break;
            }
            int j = i - 1 >> 1;
            PathPoint pathpoint1 = a[j];

            if (f >= pathpoint1.h) {
                break;
            }
            a[i] = pathpoint1;
            pathpoint1.e = i;
            i = j;
        } while (true);
        a[i] = pathpoint;
        pathpoint.e = i;
    }

    private void b(int i) {
        PathPoint pathpoint = a[i];
        float f = pathpoint.h;

        do {
            int j = 1 + (i << 1);
            int k = j + 1;

            if (j >= b) {
                break;
            }
            PathPoint pathpoint1 = a[j];
            float f1 = pathpoint1.h;
            PathPoint pathpoint2;
            float f2;

            if (k >= b) {
                pathpoint2 = null;
                f2 = (1.0F / 0.0F);
            } else {
                pathpoint2 = a[k];
                f2 = pathpoint2.h;
            }
            if (f1 < f2) {
                if (f1 >= f) {
                    break;
                }
                a[i] = pathpoint1;
                pathpoint1.e = i;
                i = j;
                continue;
            }
            if (f2 >= f) {
                break;
            }
            a[i] = pathpoint2;
            pathpoint2.e = i;
            i = k;
        } while (true);
        a[i] = pathpoint;
        pathpoint.e = i;
    }

    public boolean c() {
        return b == 0;
    }
}

