package net.minecraft.server;


public final class ThreadServerApplication extends Thread {

    final MinecraftServer a; /* synthetic field */

    public ThreadServerApplication(String s, MinecraftServer minecraftserver) {
        a = minecraftserver;
        // super(s);
    }

    public void run() {
        a.run();
    }
}

