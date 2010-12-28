package net.minecraft.server;


class HashEntry2 {

    final long a;
    Object b;
    HashEntry2 c;
    final int d;

    HashEntry2(int i, long l, Object obj, HashEntry2 hashentry2) {
        b = obj;
        c = hashentry2;
        a = l;
        d = i;
    }

    public final long a() {
        return a;
    }

    public final Object b() {
        return b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HashEntry2)) {
            return false;
        }
        HashEntry2 hashentry2 = (HashEntry2) obj;
        Long long1 = Long.valueOf(a());
        Long long2 = Long.valueOf(hashentry2.a());

        if (long1 == long2 || long1 != null && long1.equals(long2)) {
            Object obj1 = b();
            Object obj2 = hashentry2.b();

            if (obj1 == obj2 || obj1 != null && obj1.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return MCHashTable2.d(a);
    }

    public final String toString() {
        return (new StringBuilder()).append(a()).append("=").append(b()).toString();
    }
}

