package net.minecraft.server;


public class MCHashTable {

    private transient HashEntry a[];
    private transient int b;
    private int c;
    private final float d = 0.75F;
    private volatile transient int e;

    public MCHashTable() {
        c = 12;
        a = new HashEntry[16];
    }

    private static int g(int i) {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int a(int i, int j) {
        return i & j - 1;
    }

    public Object a(int i) {
        int j = g(i);

        for (HashEntry hashentry = a[a(j, a.length)]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                return hashentry.b;
            }
        }

        return null;
    }

    public boolean b(int i) {
        return c(i) != null;
    }

    final HashEntry c(int i) {
        int j = g(i);

        for (HashEntry hashentry = a[a(j, a.length)]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                return hashentry;
            }
        }

        return null;
    }

    public void a(int i, Object obj) {
        int j = g(i);
        int k = a(j, a.length);

        for (HashEntry hashentry = a[k]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                hashentry.b = obj;
            }
        }

        e++;
        a(j, i, obj, k);
    }

    private void h(int i) {
        HashEntry ahashentry[] = a;
        int j = ahashentry.length;

        if (j == 0x40000000) {
            c = 0x7fffffff;
            return;
        } else {
            HashEntry ahashentry1[] = new HashEntry[i];

            a(ahashentry1);
            a = ahashentry1;
            c = (int) ((float) i * d);
            return;
        }
    }

    private void a(HashEntry ahashentry[]) {
        HashEntry ahashentry1[] = a;
        int i = ahashentry.length;

        for (int j = 0; j < ahashentry1.length; j++) {
            HashEntry hashentry = ahashentry1[j];

            if (hashentry == null) {
                continue;
            }
            ahashentry1[j] = null;
            do {
                HashEntry hashentry1 = hashentry.c;
                int k = a(hashentry.d, i);

                hashentry.c = ahashentry[k];
                ahashentry[k] = hashentry;
                hashentry = hashentry1;
            } while (hashentry != null);
        }

    }

    public Object d(int i) {
        HashEntry hashentry = e(i);

        return hashentry != null ? hashentry.b : null;
    }

    final HashEntry e(int i) {
        int j = g(i);
        int k = a(j, a.length);
        HashEntry hashentry = a[k];
        HashEntry hashentry1;
        HashEntry hashentry2;

        for (hashentry1 = hashentry; hashentry1 != null; hashentry1 = hashentry2) {
            hashentry2 = hashentry1.c;
            if (hashentry1.a == i) {
                e++;
                b--;
                if (hashentry == hashentry1) {
                    a[k] = hashentry2;
                } else {
                    hashentry.c = hashentry2;
                }
                return hashentry1;
            }
            hashentry = hashentry1;
        }

        return hashentry1;
    }

    public void a() {
        e++;
        HashEntry ahashentry[] = a;

        for (int i = 0; i < ahashentry.length; i++) {
            ahashentry[i] = null;
        }

        b = 0;
    }

    private void a(int i, int j, Object obj, int k) {
        HashEntry hashentry = a[k];

        a[k] = new HashEntry(i, j, obj, hashentry);
        if (b++ >= c) {
            h(2 * a.length);
        }
    }

    static int f(int i) {
        return g(i);
    }
}

