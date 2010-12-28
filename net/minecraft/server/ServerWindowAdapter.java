package net.minecraft.server;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


final class ServerWindowAdapter extends WindowAdapter {

    final MinecraftServer a; /* synthetic field */

    ServerWindowAdapter(MinecraftServer minecraftserver) {
        a = minecraftserver;
        // super();
    }

    public void windowClosing(WindowEvent windowevent) {
        a.a();
        while (!a.g) { 
            try {
                Thread.sleep(100L);
            } catch (InterruptedException interruptedexception) {
                interruptedexception.printStackTrace();
            }
        }
        System.exit(0);
    }
}

