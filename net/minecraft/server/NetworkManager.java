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
    private DataInputStream f;
    private DataOutputStream g;
    private boolean h;
    private List i;
    private List j;
    private List k;
    private NetHandler l;
    private boolean m;
    private Thread n;
    private Thread o;
    private boolean p;
    private String q;
    private int r;
    private int s;
    private int t;

    public NetworkManager(Socket socket, String s1, NetHandler nethandler) {
        d = new Object();
        h = true;
        i = Collections.synchronizedList(new LinkedList());
        j = Collections.synchronizedList(new LinkedList());
        k = Collections.synchronizedList(new LinkedList());
        m = false;
        p = false;
        q = "";
        r = 0;
        s = 0;
        t = 0;
        e = socket;
        l = nethandler;
        socket.setTrafficClass(24);
        f = new DataInputStream(socket.getInputStream());
        g = new DataOutputStream(socket.getOutputStream());
        o = new NetworkReaderThread(this, (new StringBuilder()).append(s1).append(" read thread").toString());
        n = new NetworkWriterThread(this, (new StringBuilder()).append(s1).append(" write thread").toString());
        o.start();
        n.start();
    }

    public void a(NetHandler nethandler) {
        l = nethandler;
    }

    public void a(Packet packet) {
        if (m) {
            return;
        }
        synchronized (d) {
            s += packet.a() + 1;
            if (packet.j) {
                k.add(packet);
            } else {
                j.add(packet);
            }
        }
    }

    private void e() {
        try {
            boolean flag = true;

            if (!j.isEmpty()) {
                flag = false;
                Packet packet;

                synchronized (d) {
                    packet = (Packet) j.remove(0);
                    s -= packet.a() + 1;
                }
                Packet.a(packet, g);
            }
            if ((flag || t-- <= 0) && !k.isEmpty()) {
                flag = false;
                Packet packet1;

                synchronized (d) {
                    packet1 = (Packet) k.remove(0);
                    s -= packet1.a() + 1;
                }
                Packet.a(packet1, g);
                t = 50;
            }
            if (flag) {
                Thread.sleep(10L);
            }
        } catch (InterruptedException interruptedexception) {} catch (Exception exception) {
            if (!p) {
                a(exception);
            }
        }
    }

    private void f() {
        try {
            Packet packet = Packet.b(f);

            if (packet != null) {
                i.add(packet);
            } else {
                a("End of stream");
            }
        } catch (Exception exception) {
            if (!p) {
                a(exception);
            }
        }
    }

    private void a(Exception exception) {
        exception.printStackTrace();
        a((new StringBuilder()).append("Internal exception: ").append(exception.toString()).toString());
    }

    public void a(String s1) {
        if (!h) {
            return;
        }
        p = true;
        q = s1;
        (new NetworkMasterThread(this)).start();
        h = false;
        try {
            f.close();
        } catch (Throwable throwable) {}
        try {
            g.close();
        } catch (Throwable throwable1) {}
        try {
            e.close();
        } catch (Throwable throwable2) {}
    }

    public void a() {
        if (s > 0x100000) {
            a("Send buffer overflow");
        }
        if (i.isEmpty()) {
            if (r++ == 1200) {
                a("Timed out");
            }
        } else {
            r = 0;
        }
        Packet packet;

        for (int i1 = 100; !i.isEmpty() && i1-- >= 0; packet.a(l)) {
            packet = (Packet) i.remove(0);
        }

        if (p && i.isEmpty()) {
            l.a(q);
        }
    }

    public SocketAddress b() {
        return e.getRemoteSocketAddress();
    }

    public void c() {
        m = true;
        o.interrupt();
        (new ThreadMonitorConnection(this)).start();
    }

    public int d() {
        return k.size();
    }

    static boolean a(NetworkManager networkmanager) {
        return networkmanager.h;
    }

    static boolean b(NetworkManager networkmanager) {
        return networkmanager.m;
    }

    static void c(NetworkManager networkmanager) {
        networkmanager.f();
    }

    static void d(NetworkManager networkmanager) {
        networkmanager.e();
    }

    static Thread e(NetworkManager networkmanager) {
        return networkmanager.o;
    }

    static Thread f(NetworkManager networkmanager) {
        return networkmanager.n;
    }

}

