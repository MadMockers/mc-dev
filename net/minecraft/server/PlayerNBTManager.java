package net.minecraft.server;


import java.io.*;
import java.util.logging.Logger;


public class PlayerNBTManager {

    public static Logger a = Logger.getLogger("Minecraft");
    private File b;

    public PlayerNBTManager(File file) {
        b = file;
        file.mkdir();
    }

    public void a(EntityPlayerMP entityplayermp) {
        try {
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            entityplayermp.d(nbttagcompound);
            File file = new File(b, "_tmp_.dat");
            File file1 = new File(b, (new StringBuilder()).append(entityplayermp.as).append(".dat").toString());

            CompressedStreamTools.a(nbttagcompound, new FileOutputStream(file));
            if (file1.exists()) {
                file1.delete();
            }
            file.renameTo(file1);
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to save player data for ").append(entityplayermp.as).toString());
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        try {
            File file = new File(b, (new StringBuilder()).append(entityplayermp.as).append(".dat").toString());

            if (file.exists()) {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a(new FileInputStream(file));

                if (nbttagcompound != null) {
                    entityplayermp.e(nbttagcompound);
                }
            }
        } catch (Exception exception) {
            a.warning((new StringBuilder()).append("Failed to load player data for ").append(entityplayermp.as).toString());
        }
    }

}

