package net.minecraft.server;


class NetworkReaderThread extends Thread {

    final NetworkManager a; /* synthetic field */

    NetworkReaderThread(NetworkManager networkmanager, String s) {
        super(s);
        a = networkmanager;
    }

    public void run() {
        synchronized (NetworkManager.a) {
            NetworkManager.b++;
        }
        try {
            for (; NetworkManager.a(a) && !NetworkManager.b(a); NetworkManager.c(a)) {
                ;
            }
        } finally {
            synchronized (NetworkManager.a) {
                NetworkManager.b--;
            }
        }
    }
}

