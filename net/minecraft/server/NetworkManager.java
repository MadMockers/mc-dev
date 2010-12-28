package net.minecraft.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.*;


public class NetworkManager {

    public static final Object a = new Object();
    public static int b;
    public static int c;
    private Object e;
    private Socket f;
    private final SocketAddress g;
    private DataInputStream h;
    private DataOutputStream i;
    private boolean j;
    private List k;
    private List l;
    private List m;
    private NetHandler n;
    private boolean o;
    private Thread p;
    private Thread q;
    private boolean r;
    private String s;
    private Object t[];
    private int u;
    private int v;
    public int d;
    private int w;

    public NetworkManager(Socket socket, String s1, NetHandler nethandler) {
        e = new Object();
        j = true;
        k = Collections.synchronizedList(new ArrayList());
        l = Collections.synchronizedList(new ArrayList());
        m = Collections.synchronizedList(new ArrayList());
        o = false;
        r = false;
        s = "";
        u = 0;
        v = 0;
        d = 0;
        w = 0;
        f = socket;
        g = socket.getRemoteSocketAddress();
        n = nethandler;
        socket.setTrafficClass(24);
        h = new DataInputStream(socket.getInputStream());
        i = new DataOutputStream(socket.getOutputStream());
        q = new NetworkReaderThread(this, (new StringBuilder()).append(s1).append(" read thread").toString());
        p = new NetworkWriterThread(this, (new StringBuilder()).append(s1).append(" write thread").toString());
        q.start();
        p.start();
    }

    public void a(NetHandler nethandler) {
        n = nethandler;
    }

    public void a(Packet packet) {
        if (o) {
            return;
        }
        synchronized (e) {
            v += packet.a() + 1;
            if (packet.k) {
                m.add(packet);
            } else {
                l.add(packet);
            }
        }
    }

    private void e() {
        try {
            boolean flag = true;

            if (!l.isEmpty() && (d == 0 || System.currentTimeMillis() - ((Packet) l.get(0)).j >= (long) d)) {
                flag = false;
                Packet packet;

                synchronized (e) {
                    packet = (Packet) l.remove(0);
                    v -= packet.a() + 1;
                }
                Packet.a(packet, i);
            }
            if ((flag || w-- <= 0) && !m.isEmpty() && (d == 0 || System.currentTimeMillis() - ((Packet) m.get(0)).j >= (long) d)) {
                flag = false;
                Packet packet1;

                synchronized (e) {
                    packet1 = (Packet) m.remove(0);
                    v -= packet1.a() + 1;
                }
                Packet.a(packet1, i);
                w = 50;
            }
            if (flag) {
                Thread.sleep(10L);
            }
        } catch (InterruptedException interruptedexception) {} catch (Exception exception) {
            if (!r) {
                a(exception);
            }
        }
    }

    private void f() {
        try {
            Packet packet = Packet.b(h);

            if (packet != null) {
                k.add(packet);
            } else {
                a("disconnect.endOfStream", new Object[0]);
            }
        } catch (Exception exception) {
            if (!r) {
                a(exception);
            }
        }
    }

    private void a(Exception exception) {
        exception.printStackTrace();
        a("disconnect.genericReason", new Object[] {
            (new StringBuilder()).append("Internal exception: ").append(exception.toString()).toString()
        });
    }

    public void a(String s1, Object aobj[]) {
        if (!j) {
            return;
        }
        r = true;
        s = s1;
        t = aobj;
        (new NetworkMasterThread(this)).start();
        j = false;
        try {
            h.close();
            h = null;
        } catch (Throwable throwable) {}
        try {
            i.close();
            i = null;
        } catch (Throwable throwable1) {}
        try {
            f.close();
            f = null;
        } catch (Throwable throwable2) {}
    }

    public void a() {
        if (v > 0x100000) {
            a("disconnect.overflow", new Object[0]);
        }
        if (k.isEmpty()) {
            if (u++ == 1200) {
                a("disconnect.timeout", new Object[0]);
            }
        } else {
            u = 0;
        }
        Packet packet;

        for (int i1 = 100; !k.isEmpty() && i1-- >= 0; packet.a(n)) {
            packet = (Packet) k.remove(0);
        }

        if (r && k.isEmpty()) {
            n.a(s, t);
        }
    }

    public SocketAddress b() {
        return g;
    }

    public void c() {
        o = true;
        q.interrupt();
        (new ThreadMonitorConnection(this)).start();
    }

    public int d() {
        return m.size();
    }

    static boolean a(NetworkManager networkmanager) {
        return networkmanager.j;
    }

    static boolean b(NetworkManager networkmanager) {
        return networkmanager.o;
    }

    static void c(NetworkManager networkmanager) {
        networkmanager.f();
    }

    static void d(NetworkManager networkmanager) {
        networkmanager.e();
    }

    static Thread e(NetworkManager networkmanager) {
        return networkmanager.q;
    }

    static Thread f(NetworkManager networkmanager) {
        return networkmanager.p;
    }

}

