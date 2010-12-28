package net.minecraft.server;


import java.util.*;


class PlayerInstance {

    private List b;
    private int c;
    private int d;
    private ChunkCoordIntPair e;
    private short f[];
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    final PlayerManager a; /* synthetic field */

    public PlayerInstance(PlayerManager playermanager, int i1, int j1) {
        a = playermanager;
        // super();
        b = new ArrayList();
        f = new short[10];
        g = 0;
        c = i1;
        d = j1;
        e = new ChunkCoordIntPair(i1, j1);
        PlayerManager.a(playermanager).e.A.d(i1, j1);
    }

    public void a(EntityPlayerMP entityplayermp) {
        if (b.contains(entityplayermp)) {
            throw new IllegalStateException((new StringBuilder()).append("Failed to add player. ").append(entityplayermp).append(" already is in chunk ").append(c).append(", ").append(d).toString());
        } else {
            entityplayermp.ai.add(e);
            entityplayermp.a.b(new Packet50PreChunk(e.a, e.b, true));
            b.add(entityplayermp);
            entityplayermp.f.add(e);
            return;
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        if (!b.contains(entityplayermp)) {
            (new IllegalStateException((new StringBuilder()).append("Failed to remove player. ").append(entityplayermp).append(" isn't in chunk ").append(c).append(", ").append(d).toString())).printStackTrace();
            return;
        }
        b.remove(entityplayermp);
        if (b.size() == 0) {
            long l1 = (long) c + 0x7fffffffL | (long) d + 0x7fffffffL << 32;

            PlayerManager.b(a).b(l1);
            if (g > 0) {
                PlayerManager.c(a).remove(this);
            }
            PlayerManager.a(a).e.A.c(c, d);
        }
        entityplayermp.f.remove(e);
        if (entityplayermp.ai.contains(e)) {
            entityplayermp.a.b(new Packet50PreChunk(c, d, false));
        }
    }

    public void a(int i1, int j1, int k1) {
        if (g == 0) {
            PlayerManager.c(a).add(this);
            h = i = i1;
            j = k = j1;
            l = m = k1;
        }
        if (h > i1) {
            h = i1;
        }
        if (i < i1) {
            i = i1;
        }
        if (j > j1) {
            j = j1;
        }
        if (k < j1) {
            k = j1;
        }
        if (l > k1) {
            l = k1;
        }
        if (m < k1) {
            m = k1;
        }
        if (g < 10) {
            short word0 = (short) (i1 << 12 | k1 << 8 | j1);

            for (int l1 = 0; l1 < g; l1++) {
                if (f[l1] == word0) {
                    return;
                }
            }

            f[g++] = word0;
        }
    }

    public void a(Packet packet) {
        for (int i1 = 0; i1 < b.size(); i1++) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) b.get(i1);

            if (entityplayermp.ai.contains(e)) {
                entityplayermp.a.b(packet);
            }
        }

    }

    public void a() {
        if (g == 0) {
            return;
        }
        if (g == 1) {
            int i1 = c * 16 + h;
            int l1 = j;
            int k2 = d * 16 + l;

            a(((Packet) (new Packet53BlockChange(i1, l1, k2, PlayerManager.a(a).e))));
            if (Block.p[PlayerManager.a(a).e.a(i1, l1, k2)]) {
                a(((Packet) (new Packet59ComplexEntity(i1, l1, k2, PlayerManager.a(a).e.k(i1, l1, k2)))));
            }
        } else if (g == 10) {
            j = (j / 2) * 2;
            k = (k / 2 + 1) * 2;
            int j1 = h + c * 16;
            int i2 = j;
            int l2 = l + d * 16;
            int j3 = (i - h) + 1;
            int l3 = (k - j) + 2;
            int i4 = (m - l) + 1;

            a(((Packet) (new Packet51MapChunk(j1, i2, l2, j3, l3, i4, PlayerManager.a(a).e))));
            List list = PlayerManager.a(a).e.d(j1, i2, l2, j1 + j3, i2 + l3, l2 + i4);

            for (int j4 = 0; j4 < list.size(); j4++) {
                TileEntity tileentity = (TileEntity) list.get(j4);

                a(((Packet) (new Packet59ComplexEntity(tileentity.b, tileentity.c, tileentity.d, tileentity))));
            }

        } else {
            a(((Packet) (new Packet52MultiBlockChange(c, d, f, g, PlayerManager.a(a).e))));
            for (int k1 = 0; k1 < g; k1++) {
                int j2 = c * 16 + (g >> 12 & 0xf);
                int i3 = g & 0xff;
                int k3 = d * 16 + (g >> 8 & 0xf);

                if (Block.p[PlayerManager.a(a).e.a(j2, i3, k3)]) {
                    a(((Packet) (new Packet59ComplexEntity(j2, i3, k3, PlayerManager.a(a).e.k(j2, i3, k3)))));
                }
            }

        }
        g = 0;
    }
}

