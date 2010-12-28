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
    private Object d;
    private Socket e;
    private final SocketAddress f;
    private DataInputStream g;
    private DataOutputStream h;
    private boolean i;
    private List j;
    private List k;
    private List l;
    private NetHandler m;
    private boolean n;
    private Thread o;
    private Thread p;
    private boolean q;
    private String r;
    private int s;
    private int t;
    private int u;

    public NetworkManager(Socket socket, String s1, NetHandler nethandler) {
        d = new Object();
        i = true;
        j = Collections.synchronizedList(new ArrayList());
        k = Collections.synchronizedList(new ArrayList());
        l = Collections.synchronizedList(new ArrayList());
        n = false;
        q = false;
        r = "";
        s = 0;
        t = 0;
        u = 0;
        e = socket;
        f = socket.getRemoteSocketAddress();
        m = nethandler;
        socket.setTrafficClass(24);
        g = new DataInputStream(socket.getInputStream());
        h = new DataOutputStream(socket.getOutputStream());
        p = new NetworkReaderThread(this, (new StringBuilder()).append(s1).append(" read thread").toString());
        o = new NetworkWriterThread(this, (new StringBuilder()).append(s1).append(" write thread").toString());
        p.start();
        o.start();
    }

    public void a(NetHandler nethandler) {
        m = nethandler;
    }

    public void a(Packet packet) {
        if (n) {
            return;
        }
        synchronized (d) {
            t += packet.a() + 1;
            if (packet.j) {
                l.add(packet);
            } else {
                k.add(packet);
            }
        }
    }

    private void e() {
        try {
            boolean flag = true;

            if (!k.isEmpty()) {
                flag = false;
                Packet packet;

                synchronized (d) {
                    packet = (Packet) k.remove(0);
                    t -= packet.a() + 1;
                }
                Packet.a(packet, h);
            }
            if ((flag || u-- <= 0) && !l.isEmpty()) {
                flag = false;
                Packet packet1;

                synchronized (d) {
                    packet1 = (Packet) l.remove(0);
                    t -= packet1.a() + 1;
                }
                Packet.a(packet1, h);
                u = 50;
            }
            if (flag) {
                Thread.sleep(10L);
            }
        } catch (InterruptedException interruptedexception) {} catch (Exception exception) {
            if (!q) {
                a(exception);
            }
        }
    }

    private void f() {
        try {
            Packet packet = Packet.b(g);

            if (packet != null) {
                j.add(packet);
            } else {
                a("End of stream");
            }
        } catch (Exception exception) {
            if (!q) {
                a(exception);
            }
        }
    }

    private void a(Exception exception) {
        exception.printStackTrace();
        a((new StringBuilder()).append("Internal exception: ").append(exception.toString()).toString());
    }

    public void a(String s1) {
        if (!i) {
            return;
        }
        q = true;
        r = s1;
        (new NetworkMasterThread(this)).start();
        i = false;
        try {
            g.close();
            g = null;
        } catch (Throwable throwable) {}
        try {
            h.close();
            h = null;
        } catch (Throwable throwable1) {}
        try {
            e.close();
            e = null;
        } catch (Throwable throwable2) {}
    }

    public void a() {
        if (t > 0x100000) {
            a("Send buffer overflow");
        }
        if (j.isEmpty()) {
            if (s++ == 1200) {
                a("Timed out");
            }
        } else {
            s = 0;
        }
        Packet packet;

        for (int i1 = 100; !j.isEmpty() && i1-- >= 0; packet.a(m)) {
            packet = (Packet) j.remove(0);
        }

        if (q && j.isEmpty()) {
            m.a(r);
        }
    }

    public SocketAddress b() {
        return f;
    }

    public void c() {
        n = true;
        p.interrupt();
        (new ThreadMonitorConnection(this)).start();
    }

    public int d() {
        return l.size();
    }

    static boolean a(NetworkManager networkmanager) {
        return networkmanager.i;
    }

    static boolean b(NetworkManager networkmanager) {
        return networkmanager.n;
    }

    static void c(NetworkManager networkmanager) {
        networkmanager.f();
    }

    static void d(NetworkManager networkmanager) {
        networkmanager.e();
    }

    static Thread e(NetworkManager networkmanager) {
        return networkmanager.p;
    }

    static Thread f(NetworkManager networkmanager) {
        return networkmanager.o;
    }

}

