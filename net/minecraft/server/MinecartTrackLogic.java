package net.minecraft.server;


import java.util.ArrayList;
import java.util.List;


class MinecartTrackLogic {

    private World b;
    private int c;
    private int d;
    private int e;
    private int f;
    private List g;
    final BlockMinecartTrack a; /* synthetic field */

    public MinecartTrackLogic(BlockMinecartTrack blockminecarttrack, World world, int i, int j, int k) {
        a = blockminecarttrack;
        // super();
        g = new ArrayList();
        b = world;
        c = i;
        d = j;
        e = k;
        f = world.b(i, j, k);
        a();
    }

    private void a() {
        g.clear();
        if (f == 0) {
            g.add(new ChunkPosition(c, d, e - 1));
            g.add(new ChunkPosition(c, d, e + 1));
        } else if (f == 1) {
            g.add(new ChunkPosition(c - 1, d, e));
            g.add(new ChunkPosition(c + 1, d, e));
        } else if (f == 2) {
            g.add(new ChunkPosition(c - 1, d, e));
            g.add(new ChunkPosition(c + 1, d + 1, e));
        } else if (f == 3) {
            g.add(new ChunkPosition(c - 1, d + 1, e));
            g.add(new ChunkPosition(c + 1, d, e));
        } else if (f == 4) {
            g.add(new ChunkPosition(c, d + 1, e - 1));
            g.add(new ChunkPosition(c, d, e + 1));
        } else if (f == 5) {
            g.add(new ChunkPosition(c, d, e - 1));
            g.add(new ChunkPosition(c, d + 1, e + 1));
        } else if (f == 6) {
            g.add(new ChunkPosition(c + 1, d, e));
            g.add(new ChunkPosition(c, d, e + 1));
        } else if (f == 7) {
            g.add(new ChunkPosition(c - 1, d, e));
            g.add(new ChunkPosition(c, d, e + 1));
        } else if (f == 8) {
            g.add(new ChunkPosition(c - 1, d, e));
            g.add(new ChunkPosition(c, d, e - 1));
        } else if (f == 9) {
            g.add(new ChunkPosition(c + 1, d, e));
            g.add(new ChunkPosition(c, d, e - 1));
        }
    }

    private void b() {
        for (int i = 0; i < g.size(); i++) {
            MinecartTrackLogic minecarttracklogic = a((ChunkPosition) g.get(i));

            if (minecarttracklogic == null || !minecarttracklogic.b(this)) {
                g.remove(i--);
            } else {
                g.set(i, new ChunkPosition(minecarttracklogic.c, minecarttracklogic.d, minecarttracklogic.e));
            }
        }

    }

    private boolean a(int i, int j, int k) {
        if (b.a(i, j, k) == a.bi) {
            return true;
        }
        if (b.a(i, j + 1, k) == a.bi) {
            return true;
        }
        return b.a(i, j - 1, k) == a.bi;
    }

    private MinecartTrackLogic a(ChunkPosition chunkposition) {
        if (b.a(chunkposition.a, chunkposition.b, chunkposition.c) == a.bi) {
            return new MinecartTrackLogic(a, b, chunkposition.a, chunkposition.b, chunkposition.c);
        }
        if (b.a(chunkposition.a, chunkposition.b + 1, chunkposition.c) == a.bi) {
            return new MinecartTrackLogic(a, b, chunkposition.a, chunkposition.b + 1, chunkposition.c);
        }
        if (b.a(chunkposition.a, chunkposition.b - 1, chunkposition.c) == a.bi) {
            return new MinecartTrackLogic(a, b, chunkposition.a, chunkposition.b - 1, chunkposition.c);
        } else {
            return null;
        }
    }

    private boolean b(MinecartTrackLogic minecarttracklogic) {
        for (int i = 0; i < g.size(); i++) {
            ChunkPosition chunkposition = (ChunkPosition) g.get(i);

            if (chunkposition.a == minecarttracklogic.c && chunkposition.c == minecarttracklogic.e) {
                return true;
            }
        }

        return false;
    }

    private boolean b(int i, int j, int k) {
        for (int l = 0; l < g.size(); l++) {
            ChunkPosition chunkposition = (ChunkPosition) g.get(l);

            if (chunkposition.a == i && chunkposition.c == k) {
                return true;
            }
        }

        return false;
    }

    private int c() {
        int i = 0;

        if (a(c, d, e - 1)) {
            i++;
        }
        if (a(c, d, e + 1)) {
            i++;
        }
        if (a(c - 1, d, e)) {
            i++;
        }
        if (a(c + 1, d, e)) {
            i++;
        }
        return i;
    }

    private boolean c(MinecartTrackLogic minecarttracklogic) {
        if (b(minecarttracklogic)) {
            return true;
        }
        if (g.size() == 2) {
            return false;
        }
        if (g.size() == 0) {
            return true;
        }
        ChunkPosition chunkposition = (ChunkPosition) g.get(0);

        return minecarttracklogic.d != d || chunkposition.b != d ? true : true;
    }

    private void d(MinecartTrackLogic minecarttracklogic) {
        g.add(new ChunkPosition(minecarttracklogic.c, minecarttracklogic.d, minecarttracklogic.e));
        boolean flag = b(c, d, e - 1);
        boolean flag1 = b(c, d, e + 1);
        boolean flag2 = b(c - 1, d, e);
        boolean flag3 = b(c + 1, d, e);
        byte byte0 = -1;

        if (flag || flag1) {
            byte0 = 0;
        }
        if (flag2 || flag3) {
            byte0 = 1;
        }
        if (flag1 && flag3 && !flag && !flag2) {
            byte0 = 6;
        }
        if (flag1 && flag2 && !flag && !flag3) {
            byte0 = 7;
        }
        if (flag && flag2 && !flag1 && !flag3) {
            byte0 = 8;
        }
        if (flag && flag3 && !flag1 && !flag2) {
            byte0 = 9;
        }
        if (byte0 == 0) {
            if (b.a(c, d + 1, e - 1) == a.bi) {
                byte0 = 4;
            }
            if (b.a(c, d + 1, e + 1) == a.bi) {
                byte0 = 5;
            }
        }
        if (byte0 == 1) {
            if (b.a(c + 1, d + 1, e) == a.bi) {
                byte0 = 2;
            }
            if (b.a(c - 1, d + 1, e) == a.bi) {
                byte0 = 3;
            }
        }
        if (byte0 < 0) {
            byte0 = 0;
        }
        b.b(c, d, e, byte0);
    }

    private boolean c(int i, int j, int k) {
        MinecartTrackLogic minecarttracklogic = a(new ChunkPosition(i, j, k));

        if (minecarttracklogic == null) {
            return false;
        } else {
            minecarttracklogic.b();
            return minecarttracklogic.c(this);
        }
    }

    public void a(boolean flag) {
        boolean flag1 = c(c, d, e - 1);
        boolean flag2 = c(c, d, e + 1);
        boolean flag3 = c(c - 1, d, e);
        boolean flag4 = c(c + 1, d, e);
        int i = -1;

        if ((flag1 || flag2) && !flag3 && !flag4) {
            i = 0;
        }
        if ((flag3 || flag4) && !flag1 && !flag2) {
            i = 1;
        }
        if (flag2 && flag4 && !flag1 && !flag3) {
            i = 6;
        }
        if (flag2 && flag3 && !flag1 && !flag4) {
            i = 7;
        }
        if (flag1 && flag3 && !flag2 && !flag4) {
            i = 8;
        }
        if (flag1 && flag4 && !flag2 && !flag3) {
            i = 9;
        }
        if (i == -1) {
            if (flag1 || flag2) {
                i = 0;
            }
            if (flag3 || flag4) {
                i = 1;
            }
            if (flag) {
                if (flag2 && flag4) {
                    i = 6;
                }
                if (flag3 && flag2) {
                    i = 7;
                }
                if (flag4 && flag1) {
                    i = 9;
                }
                if (flag1 && flag3) {
                    i = 8;
                }
            } else {
                if (flag1 && flag3) {
                    i = 8;
                }
                if (flag4 && flag1) {
                    i = 9;
                }
                if (flag3 && flag2) {
                    i = 7;
                }
                if (flag2 && flag4) {
                    i = 6;
                }
            }
        }
        if (i == 0) {
            if (b.a(c, d + 1, e - 1) == a.bi) {
                i = 4;
            }
            if (b.a(c, d + 1, e + 1) == a.bi) {
                i = 5;
            }
        }
        if (i == 1) {
            if (b.a(c + 1, d + 1, e) == a.bi) {
                i = 2;
            }
            if (b.a(c - 1, d + 1, e) == a.bi) {
                i = 3;
            }
        }
        if (i < 0) {
            i = 0;
        }
        f = i;
        a();
        b.b(c, d, e, i);
        for (int j = 0; j < g.size(); j++) {
            MinecartTrackLogic minecarttracklogic = a((ChunkPosition) g.get(j));

            if (minecarttracklogic == null) {
                continue;
            }
            minecarttracklogic.b();
            if (minecarttracklogic.c(this)) {
                minecarttracklogic.d(this);
            }
        }

    }

    static int a(MinecartTrackLogic minecarttracklogic) {
        return minecarttracklogic.c();
    }
}

