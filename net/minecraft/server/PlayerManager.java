package net.minecraft.server;


import java.util.ArrayList;
import java.util.List;


public class PlayerManager {

    private List a;
    private MCHashTable2 b;
    private List c;
    private MinecraftServer d;

    public PlayerManager(MinecraftServer minecraftserver) {
        a = new ArrayList();
        b = new MCHashTable2();
        c = new ArrayList();
        d = minecraftserver;
    }

    public void a() {
        for (int i = 0; i < c.size(); i++) {
            ((PlayerInstance) c.get(i)).a();
        }

        c.clear();
    }

    private PlayerInstance a(int i, int j, boolean flag) {
        long l = (long) i + 0x7fffffffL | (long) j + 0x7fffffffL << 32;
        PlayerInstance playerinstance = (PlayerInstance) b.a(l);

        if (playerinstance == null && flag) {
            playerinstance = new PlayerInstance(this, i, j);
            b.a(l, playerinstance);
        }
        return playerinstance;
    }

    public void a(Packet packet, int i, int j, int k) {
        int l = i >> 4;
        int i1 = k >> 4;
        PlayerInstance playerinstance = a(l, i1, false);

        if (playerinstance != null) {
            playerinstance.a(packet);
        }
    }

    public void a(int i, int j, int k) {
        int l = i >> 4;
        int i1 = k >> 4;
        PlayerInstance playerinstance = a(l, i1, false);

        if (playerinstance != null) {
            playerinstance.a(i & 0xf, j, k & 0xf);
        }
    }

    public void a(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.p >> 4;
        int j = (int) entityplayermp.r >> 4;

        entityplayermp.d = entityplayermp.p;
        entityplayermp.e = entityplayermp.r;
        for (int k = i - 10; k <= i + 10; k++) {
            for (int l = j - 10; l <= j + 10; l++) {
                a(k, l, true).a(entityplayermp);
            }

        }

        a.add(entityplayermp);
    }

    public void b(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.d >> 4;
        int j = (int) entityplayermp.e >> 4;

        for (int k = i - 10; k <= i + 10; k++) {
            for (int l = j - 10; l <= j + 10; l++) {
                PlayerInstance playerinstance = a(k, l, false);

                if (playerinstance != null) {
                    playerinstance.b(entityplayermp);
                }
            }

        }

        a.remove(entityplayermp);
    }

    private boolean a(int i, int j, int k, int l) {
        int i1 = i - k;
        int j1 = j - l;

        if (i1 < -10 || i1 > 10) {
            return false;
        }
        return j1 >= -10 && j1 <= 10;
    }

    public void c(EntityPlayerMP entityplayermp) {
        int i = (int) entityplayermp.p >> 4;
        int j = (int) entityplayermp.r >> 4;
        double d1 = entityplayermp.d - entityplayermp.p;
        double d2 = entityplayermp.e - entityplayermp.r;
        double d3 = d1 * d1 + d2 * d2;

        if (d3 < 64D) {
            return;
        }
        int k = (int) entityplayermp.d >> 4;
        int l = (int) entityplayermp.e >> 4;
        int i1 = i - k;
        int j1 = j - l;

        if (i1 == 0 && j1 == 0) {
            return;
        }
        for (int k1 = i - 10; k1 <= i + 10; k1++) {
            for (int l1 = j - 10; l1 <= j + 10; l1++) {
                if (!a(k1, l1, k, l)) {
                    a(k1, l1, true).a(entityplayermp);
                }
                if (a(k1 - i1, l1 - j1, i, j)) {
                    continue;
                }
                PlayerInstance playerinstance = a(k1 - i1, l1 - j1, false);

                if (playerinstance != null) {
                    playerinstance.b(entityplayermp);
                }
            }

        }

        entityplayermp.d = entityplayermp.p;
        entityplayermp.e = entityplayermp.r;
    }

    public int b() {
        return 144;
    }

    static MinecraftServer a(PlayerManager playermanager) {
        return playermanager.d;
    }

    static MCHashTable2 b(PlayerManager playermanager) {
        return playermanager.b;
    }

    static List c(PlayerManager playermanager) {
        return playermanager.c;
    }
}

