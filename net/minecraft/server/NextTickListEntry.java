package net.minecraft.server;


public class NextTickListEntry
        implements Comparable {

    private static long f = 0L;
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    private long g;

    public NextTickListEntry(int i, int j, int k, int l) {
        g = f++;
        a = i;
        b = j;
        c = k;
        d = l;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NextTickListEntry) {
            NextTickListEntry nextticklistentry = (NextTickListEntry) obj;

            return a == nextticklistentry.a && b == nextticklistentry.b && c == nextticklistentry.c && d == nextticklistentry.d;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (a * 128 * 1024 + c * 128 + b) * 256 + d;
    }

    public NextTickListEntry a(long l) {
        e = l;
        return this;
    }

    public int a(NextTickListEntry nextticklistentry) {
        if (e < nextticklistentry.e) {
            return -1;
        }
        if (e > nextticklistentry.e) {
            return 1;
        }
        if (g < nextticklistentry.g) {
            return -1;
        }
        return g <= nextticklistentry.g ? 0 : 1;
    }

    public int compareTo(Object obj) {
        return a((NextTickListEntry) obj);
    }

}

