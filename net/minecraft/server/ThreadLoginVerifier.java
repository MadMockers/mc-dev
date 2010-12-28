package net.minecraft.server;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


class ThreadLoginVerifier extends Thread {

    final Packet1Login a; /* synthetic field */
    final NetLoginHandler b; /* synthetic field */

    ThreadLoginVerifier(NetLoginHandler netloginhandler, Packet1Login packet1login) {
        b = netloginhandler;
        a = packet1login;
        // super();
    }

    public void run() {
        try {
            String s = NetLoginHandler.a(b);
            URL url = new URL((new StringBuilder()).append("http://www.minecraft.net/game/checkserver.jsp?user=").append(a.b).append("&serverId=").append(s).toString());
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s1 = bufferedreader.readLine();

            bufferedreader.close();
            if (s1.equals("YES")) {
                NetLoginHandler.a(b, a);
            } else {
                b.a("Failed to verify username!");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

