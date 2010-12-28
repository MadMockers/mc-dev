package net.minecraft.server;


public class TileEntitySign extends TileEntity {

    public String e[] = {
        "", "", "", ""
    };
    public int f;

    public TileEntitySign() {
        f = -1;
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("Text1", e[0]);
        nbttagcompound.a("Text2", e[1]);
        nbttagcompound.a("Text3", e[2]);
        nbttagcompound.a("Text4", e[3]);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        for (int i = 0; i < 4; i++) {
            e[i] = nbttagcompound.h((new StringBuilder()).append("Text").append(i + 1).toString());
            if (e[i].length() > 15) {
                e[i] = e[i].substring(0, 15);
            }
        }

    }

    public Packet f() {
        String as[] = new String[4];

        for (int i = 0; i < 4; i++) {
            as[i] = e[i];
        }

        return new Packet130(b, c, d, as);
    }
}

