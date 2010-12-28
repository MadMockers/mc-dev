package net.minecraft.server;


class HashEntry {

    final int a;
    Object b;
    HashEntry c;
    final int d;

    HashEntry(int i, int j, Object obj, HashEntry hashentry) {
        b = obj;
        c = hashentry;
        a = j;
        d = i;
    }

    public final int a() {
        return a;
    }

    public final Object b() {
        return b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HashEntry)) {
            return false;
        }
        HashEntry hashentry = (HashEntry) obj;
        Integer integer = Integer.valueOf(a());
        Integer integer1 = Integer.valueOf(hashentry.a());

        if (integer == integer1 || integer != null && integer.equals(integer1)) {
            Object obj1 = b();
            Object obj2 = hashentry.b();

            if (obj1 == obj2 || obj1 != null && obj1.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return MCHashTable.f(a);
    }

    public final String toString() {
        return (new StringBuilder()).append(a()).append("=").append(b()).toString();
    }
}

