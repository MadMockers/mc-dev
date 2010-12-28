package net.minecraft.server;


public class MCHashTable2 {

    private transient HashEntry2 a[];
    private transient int b;
    private int c;
    private final float d = 0.75F;
    private volatile transient int e;

    public MCHashTable2() {
        c = 12;
        a = new HashEntry2[16];
    }

    private static int e(long l) {
        return a((int) (l ^ l >>> 32));
    }

    private static int a(int i) {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int a(int i, int j) {
        return i & j - 1;
    }

    public Object a(long l) {
        int i = e(l);

        for (HashEntry2 hashentry2 = a[a(i, a.length)]; hashentry2 != null; hashentry2 = hashentry2.c) {
            if (hashentry2.a == l) {
                return hashentry2.b;
            }
        }

        return null;
    }

    public void a(long l, Object obj) {
        int i = e(l);
        int j = a(i, a.length);

        for (HashEntry2 hashentry2 = a[j]; hashentry2 != null; hashentry2 = hashentry2.c) {
            if (hashentry2.a == l) {
                hashentry2.b = obj;
            }
        }

        e++;
        a(i, l, obj, j);
    }

    private void b(int i) {
        HashEntry2 ahashentry2[] = a;
        int j = ahashentry2.length;

        if (j == 0x40000000) {
            c = 0x7fffffff;
            return;
        } else {
            HashEntry2 ahashentry2_1[] = new HashEntry2[i];

            a(ahashentry2_1);
            a = ahashentry2_1;
            c = (int) ((float) i * d);
            return;
        }
    }

    private void a(HashEntry2 ahashentry2[]) {
        HashEntry2 ahashentry2_1[] = a;
        int i = ahashentry2.length;

        for (int j = 0; j < ahashentry2_1.length; j++) {
            HashEntry2 hashentry2 = ahashentry2_1[j];

            if (hashentry2 == null) {
                continue;
            }
            ahashentry2_1[j] = null;
            do {
                HashEntry2 hashentry2_1 = hashentry2.c;
                int k = a(hashentry2.d, i);

                hashentry2.c = ahashentry2[k];
                ahashentry2[k] = hashentry2;
                hashentry2 = hashentry2_1;
            } while (hashentry2 != null);
        }

    }

    public Object b(long l) {
        HashEntry2 hashentry2 = c(l);

        return hashentry2 != null ? hashentry2.b : null;
    }

    final HashEntry2 c(long l) {
        int i = e(l);
        int j = a(i, a.length);
        HashEntry2 hashentry2 = a[j];
        HashEntry2 hashentry2_1;
        HashEntry2 hashentry2_2;

        for (hashentry2_1 = hashentry2; hashentry2_1 != null; hashentry2_1 = hashentry2_2) {
            hashentry2_2 = hashentry2_1.c;
            if (hashentry2_1.a == l) {
                e++;
                b--;
                if (hashentry2 == hashentry2_1) {
                    a[j] = hashentry2_2;
                } else {
                    hashentry2.c = hashentry2_2;
                }
                return hashentry2_1;
            }
            hashentry2 = hashentry2_1;
        }

        return hashentry2_1;
    }

    private void a(int i, long l, Object obj, int j) {
        HashEntry2 hashentry2 = a[j];

        a[j] = new HashEntry2(i, l, obj, hashentry2);
        if (b++ >= c) {
            b(2 * a.length);
        }
    }

    static int d(long l) {
        return e(l);
    }
}

