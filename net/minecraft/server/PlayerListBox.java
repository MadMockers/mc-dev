package net.minecraft.server;


import java.util.List;
import java.util.Vector;
import javax.swing.JList;


public class PlayerListBox extends JList
        implements IUpdatePlayerListBox {

    private MinecraftServer a;
    private int b;

    public PlayerListBox(MinecraftServer minecraftserver) {
        b = 0;
        a = minecraftserver;
        minecraftserver.a(this);
    }

    public void a() {
        if (b++ % 20 == 0) {
            Vector vector = new Vector();

            for (int i = 0; i < a.f.b.size(); i++) {
                vector.add(((EntityPlayerMP) a.f.b.get(i)).ar);
            }

            setListData(vector);
        }
    }
}

