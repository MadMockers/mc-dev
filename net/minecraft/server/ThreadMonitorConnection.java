package net.minecraft.server;


class ThreadMonitorConnection extends Thread {

    final NetworkManager a; /* synthetic field */

    ThreadMonitorConnection(NetworkManager networkmanager) {
        a = networkmanager;
        // super();
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (NetworkManager.a(a)) {
                NetworkManager.f(a).interrupt();
                a.a("disconnect.closed", new Object[0]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

