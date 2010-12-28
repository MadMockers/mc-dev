package net.minecraft.server;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class GuiStatsListener
        implements ActionListener {

    final GuiStatsComponent a; /* synthetic field */

    GuiStatsListener(GuiStatsComponent guistatscomponent) {
        a = guistatscomponent;
        // super();
    }

    public void actionPerformed(ActionEvent actionevent) {
        GuiStatsComponent.a(a);
    }
}

