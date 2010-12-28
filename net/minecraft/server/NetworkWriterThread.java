package net.minecraft.server;


class NetworkWriterThread extends Thread {

    final NetworkManager a; /* synthetic field */

    NetworkWriterThread(NetworkManager networkmanager, String s) {
        super(s);
        a = networkmanager;
    }

    public void run() {
        synchronized (NetworkManager.a) {
            NetworkManager.c++;
        }
        try {
            for (; NetworkManager.a(a); NetworkManager.d(a)) {
                ;
            }
        } finally {
            synchronized (NetworkManager.a) {
                NetworkManager.c--;
            }
        }
    }
}

