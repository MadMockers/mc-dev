package net.minecraft.server;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


class ServerGuiFocusAdapter extends FocusAdapter {

    final ServerGUI a; /* synthetic field */

    ServerGuiFocusAdapter(ServerGUI servergui) {
        a = servergui;
        // super();
    }

    public void focusGained(FocusEvent focusevent) {}
}

