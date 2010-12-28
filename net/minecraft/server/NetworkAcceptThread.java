package net.minecraft.server;


import java.io.IOException;
import java.net.ServerSocket;


class NetworkAcceptThread extends Thread {

    final MinecraftServer a; /* synthetic field */
    final NetworkListenThread b; /* synthetic field */

    NetworkAcceptThread(NetworkListenThread networklistenthread, String s, MinecraftServer minecraftserver) {
        b = networklistenthread;
        a = minecraftserver;
        // super(s);
    }

    public void run() {
        do {
            if (!b.b) {
                break;
            }
            try {
                java.net.Socket socket = NetworkListenThread.a(b).accept();

                if (socket != null) {
                    NetLoginHandler netloginhandler = new NetLoginHandler(a, socket, (new StringBuilder()).append("Connection #").append(NetworkListenThread.b(b)).toString());

                    NetworkListenThread.a(b, netloginhandler);
                }
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        } while (true);
    }
}

