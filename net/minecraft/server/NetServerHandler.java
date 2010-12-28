package net.minecraft.server;


import java.util.List;
import java.util.logging.Logger;


public class NetServerHandler extends NetHandler
        implements ICommandListener {

    public static Logger a = Logger.getLogger("Minecraft");
    public NetworkManager b;
    public boolean c;
    private MinecraftServer d;
    private EntityPlayerMP e;
    private int f;
    private double g;
    private double h;
    private double i;
    private boolean j;
    private ItemStack k;

    public NetServerHandler(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayerMP entityplayermp) {
        c = false;
        f = 0;
        j = true;
        k = null;
        d = minecraftserver;
        b = networkmanager;
        networkmanager.a(this);
        e = entityplayermp;
        entityplayermp.a = this;
    }

    public void a() {
        b.a();
        if (f++ % 20 == 0) {
            b.a(new Packet0KeepAlive());
        }
    }

    public void c(String s) {
        b.a(new Packet255KickDisconnect(s));
        b.c();
        d.f.c(e);
        c = true;
    }

    public void a(Packet10Flying packet10flying) {
        if (!j) {
            double d1 = packet10flying.b - h;

            if (packet10flying.a == g && d1 * d1 < 0.01D && packet10flying.c == i) {
                j = true;
            }
        }
        if (j) {
            if (e.k != null) {
                float f1 = e.v;
                float f2 = e.w;

                e.k.z();
                double d3 = e.p;
                double d5 = e.q;
                double d7 = e.r;
                double d8 = 0.0D;
                double d11 = 0.0D;

                if (packet10flying.i) {
                    f1 = packet10flying.e;
                    f2 = packet10flying.f;
                }
                if (packet10flying.h && packet10flying.b == -999D && packet10flying.d == -999D) {
                    d8 = packet10flying.a;
                    d11 = packet10flying.c;
                }
                e.k();
                e.b(d3, d5, d7, f1, f2);
                e.s = d8;
                e.u = d11;
                e.k.b_();
                return;
            }
            g = e.p;
            h = e.q;
            i = e.r;
            double d2 = e.p;
            double d4 = e.q;
            double d6 = e.r;
            float f3 = e.v;
            float f4 = e.w;

            if (packet10flying.h && packet10flying.b == -999D && packet10flying.d == -999D) {
                packet10flying.h = false;
            }
            if (packet10flying.h) {
                d2 = packet10flying.a;
                d4 = packet10flying.b;
                d6 = packet10flying.c;
                double d9 = packet10flying.d - packet10flying.b;

                if (d9 > 1.6499999999999999D || d9 < 0.10000000000000001D) {
                    c("Illegal stance");
                    a.warning((new StringBuilder()).append(e.ar).append(" had an illegal stance: ").append(d9).toString());
                }
                e.aj = packet10flying.d;
            }
            if (packet10flying.i) {
                f3 = packet10flying.e;
                f4 = packet10flying.f;
            }
            e.k();
            e.Q = 0.0F;
            e.b(g, h, i, f3, f4);
            double d10 = d2 - e.p;
            double d12 = d4 - e.q;
            double d13 = d6 - e.r;
            float f5 = 0.0625F;
            boolean flag = d.e.a(e, e.z.b().e(f5, f5, f5)).size() == 0;

            e.c(d10, d12, d13);
            d10 = d2 - e.p;
            d12 = d4 - e.q;
            if (d12 > -0.5D || d12 < 0.5D) {
                d12 = 0.0D;
            }
            d13 = d6 - e.r;
            double d14 = d10 * d10 + d12 * d12 + d13 * d13;
            boolean flag1 = false;

            if (d14 > 0.0625D) {
                flag1 = true;
                a.warning((new StringBuilder()).append(e.ar).append(" moved wrongly!").toString());
            }
            e.b(d2, d4, d6, f3, f4);
            boolean flag2 = d.e.a(e, e.z.b().e(f5, f5, f5)).size() == 0;

            if (flag && (flag1 || !flag2)) {
                a(g, h, i, f3, f4);
                return;
            }
            e.A = packet10flying.g;
            d.f.b(e);
        }
    }

    public void a(double d1, double d2, double d3, float f1, 
            float f2) {
        j = false;
        g = d1;
        h = d2;
        i = d3;
        e.b(d1, d2, d3, f1, f2);
        e.a.b(new Packet13PlayerLookMove(d1, d2 + 1.6200000047683716D, d2, d3, f1, f2, false));
    }

    public void a(Packet14BlockDig packet14blockdig) {
        e.ak.a[e.ak.d] = k;
        boolean flag = d.e.B = d.f.g(e.ar);
        boolean flag1 = false;

        if (packet14blockdig.e == 0) {
            flag1 = true;
        }
        if (packet14blockdig.e == 1) {
            flag1 = true;
        }
        if (flag1) {
            double d1 = e.q;

            e.q = e.aj;
            MovingObjectPosition movingobjectposition = e.a(4D, 1.0F);

            e.q = d1;
            if (movingobjectposition == null) {
                return;
            }
            if (movingobjectposition.b != packet14blockdig.a || movingobjectposition.c != packet14blockdig.b || movingobjectposition.d != packet14blockdig.c
                    || movingobjectposition.e != packet14blockdig.d) {
                return;
            }
        }
        int i1 = packet14blockdig.a;
        int j1 = packet14blockdig.b;
        int l = packet14blockdig.c;
        int k1 = packet14blockdig.d;
        int l1 = (int) MathHelper.e(i1 - d.e.m);
        int i2 = (int) MathHelper.e(l - d.e.o);

        if (l1 > i2) {
            i2 = l1;
        }
        if (packet14blockdig.e == 0) {
            if (i2 > 16 || flag) {
                e.c.a(i1, j1, l);
            }
        } else if (packet14blockdig.e == 2) {
            e.c.a();
        } else if (packet14blockdig.e == 1) {
            if (i2 > 16 || flag) {
                e.c.a(i1, j1, l, k1);
            }
        } else if (packet14blockdig.e == 3) {
            double d2 = e.p - ((double) i1 + 0.5D);
            double d3 = e.q - ((double) j1 + 0.5D);
            double d4 = e.r - ((double) l + 0.5D);
            double d5 = d2 * d2 + d3 * d3 + d4 * d4;

            if (d5 < 256D) {
                e.a.b(new Packet53BlockChange(i1, j1, l, d.e));
            }
        }
        d.e.B = false;
    }

    public void a(Packet15Place packet15place) {
        boolean flag = d.e.B = d.f.g(e.ar);

        if (packet15place.e == 255) {
            ItemStack itemstack = packet15place.a < 0 ? null : new ItemStack(packet15place.a);

            e.c.a(e, d.e, itemstack);
        } else {
            int l = packet15place.b;
            int i1 = packet15place.c;
            int j1 = packet15place.d;
            int k1 = packet15place.e;
            int l1 = (int) MathHelper.e(l - d.e.m);
            int i2 = (int) MathHelper.e(j1 - d.e.o);

            if (l1 > i2) {
                i2 = l1;
            }
            if (i2 > 16 || flag) {
                ItemStack itemstack1 = packet15place.a < 0 ? null : new ItemStack(packet15place.a);

                e.c.a(e, d.e, itemstack1, l, i1, j1, k1);
            }
            e.a.b(new Packet53BlockChange(l, i1, j1, d.e));
            if (k1 == 0) {
                i1--;
            }
            if (k1 == 1) {
                i1++;
            }
            if (k1 == 2) {
                j1--;
            }
            if (k1 == 3) {
                j1++;
            }
            if (k1 == 4) {
                l--;
            }
            if (k1 == 5) {
                l++;
            }
            e.a.b(new Packet53BlockChange(l, i1, j1, d.e));
        }
        d.e.B = false;
    }

    public void a(String s) {
        a.info((new StringBuilder()).append(e.ar).append(" lost connection: ").append(s).toString());
        d.f.c(e);
        c = true;
    }

    public void a(Packet packet) {
        a.warning((new StringBuilder()).append(getClass()).append(" wasn't prepared to deal with a ").append(packet.getClass()).toString());
        c("Protocol error, unexpected packet");
    }

    public void b(Packet packet) {
        b.a(packet);
    }

    public void a(Packet16BlockItemSwitch packet16blockitemswitch) {
        int l = packet16blockitemswitch.b;

        e.ak.d = e.ak.a.length - 1;
        if (l == 0) {
            k = null;
        } else {
            k = new ItemStack(l);
        }
        e.ak.a[e.ak.d] = k;
        d.k.a(e, new Packet16BlockItemSwitch(e.g, l));
    }

    public void a(Packet21PickupSpawn packet21pickupspawn) {
        double d1 = (double) packet21pickupspawn.b / 32D;
        double d2 = (double) packet21pickupspawn.c / 32D;
        double d3 = (double) packet21pickupspawn.d / 32D;
        EntityItem entityitem = new EntityItem(d.e, d1, d2, d3, new ItemStack(packet21pickupspawn.h, packet21pickupspawn.i));

        entityitem.s = (double) packet21pickupspawn.e / 128D;
        entityitem.t = (double) packet21pickupspawn.f / 128D;
        entityitem.u = (double) packet21pickupspawn.g / 128D;
        entityitem.c = 10;
        d.e.a(entityitem);
    }

    public void a(Packet3Chat packet3chat) {
        String s = packet3chat.a;

        if (s.length() > 100) {
            c("Chat message too long");
            return;
        }
        s = s.trim();
        for (int l = 0; l < s.length(); l++) {
            if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\307\374\351\342\344\340\345\347\352\353\350\357\356\354\304\305\311\346\306\364\366\362\373\371\377\326\334\370\243\330\327\u0192\341\355\363\372\361\321\252\272\277\256\254\275\274\241\253\273".indexOf(
                    s.charAt(l))
                            < 0) {
                c("Illegal characters in chat");
                return;
            }
        }

        if (s.startsWith("/")) {
            d(s);
        } else {
            s = (new StringBuilder()).append("<").append(e.ar).append("> ").append(s).toString();
            a.info(s);
            d.f.a(new Packet3Chat(s));
        }
    }

    private void d(String s) {
        if (s.toLowerCase().startsWith("/me ")) {
            s = (new StringBuilder()).append("* ").append(e.ar).append(" ").append(s.substring(s.indexOf(" ")).trim()).toString();
            a.info(s);
            d.f.a(new Packet3Chat(s));
        } else if (s.toLowerCase().startsWith("/tell ")) {
            String as[] = s.split(" ");

            if (as.length >= 3) {
                s = s.substring(s.indexOf(" ")).trim();
                s = s.substring(s.indexOf(" ")).trim();
                s = (new StringBuilder()).append("\2477").append(e.ar).append(" whispers ").append(s).toString();
                a.info((new StringBuilder()).append(s).append(" to ").append(as[1]).toString());
                if (!d.f.a(as[1], new Packet3Chat(s))) {
                    b(new Packet3Chat("\247cThere's no player by that name online."));
                }
            }
        } else if (s.toLowerCase().equalsIgnoreCase("/home")) {
            a.info((new StringBuilder()).append(e.ar).append(" returned home").toString());
            int l = d.e.e(d.e.m, d.e.o);

            a((double) d.e.m + 0.5D, (double) l + 1.5D, (double) d.e.o + 0.5D, 0.0F, 0.0F);
        } else if (d.f.g(e.ar)) {
            String s1 = s.substring(1);

            a.info((new StringBuilder()).append(e.ar).append(" issued server command: ").append(s1).toString());
            d.a(s1, this);
        } else {
            String s2 = s.substring(1);

            a.info((new StringBuilder()).append(e.ar).append(" tried command: ").append(s2).toString());
        }
    }

    public void a(Packet18ArmAnimation packet18armanimation) {
        if (packet18armanimation.b == 1) {
            e.E();
        }
    }

    public void a(Packet255KickDisconnect packet255kickdisconnect) {
        b.a("Quitting");
    }

    public int b() {
        return b.d();
    }

    public void b(String s) {
        b(((Packet) (new Packet3Chat((new StringBuilder()).append("\2477").append(s).toString()))));
    }

    public String c() {
        return e.ar;
    }

    public void a(Packet5PlayerInventory packet5playerinventory) {
        if (packet5playerinventory.a == -1) {
            e.ak.a = packet5playerinventory.b;
        }
        if (packet5playerinventory.a == -2) {
            e.ak.c = packet5playerinventory.b;
        }
        if (packet5playerinventory.a == -3) {
            e.ak.b = packet5playerinventory.b;
        }
    }

    public void d() {
        b.a(new Packet5PlayerInventory(-1, e.ak.a));
        b.a(new Packet5PlayerInventory(-2, e.ak.c));
        b.a(new Packet5PlayerInventory(-3, e.ak.b));
    }

    public void a(Packet59ComplexEntity packet59complexentity) {
        if (packet59complexentity.e.d("x") != packet59complexentity.a) {
            return;
        }
        if (packet59complexentity.e.d("y") != packet59complexentity.b) {
            return;
        }
        if (packet59complexentity.e.d("z") != packet59complexentity.c) {
            return;
        }
        TileEntity tileentity = d.e.k(packet59complexentity.a, packet59complexentity.b, packet59complexentity.c);

        if (tileentity != null) {
            try {
                tileentity.a(packet59complexentity.e);
            } catch (Exception exception) {}
            tileentity.c();
        }
    }

    public void a(Packet7 packet7) {
        Entity entity = d.e.a(packet7.b);

        if (entity != null && e.g(entity)) {
            entity.a(e);
        }
    }

}

