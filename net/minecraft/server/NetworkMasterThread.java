package net.minecraft.server;


class NetworkMasterThread extends Thread {

    final NetworkManager a; /* synthetic field */

    NetworkMasterThread(NetworkManager networkmanager) {
        a = networkmanager;
        // super();
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.e(a).isAlive()) {
                try {
                    NetworkManager.e(a).stop();
                } catch (Throwable throwable) {}
            }
            if (NetworkManager.f(a).isAlive()) {
                try {
                    NetworkManager.f(a).stop();
                } catch (Throwable throwable1) {}
            }
        } catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }
    }
}

