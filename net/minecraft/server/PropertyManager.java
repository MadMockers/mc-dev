package net.minecraft.server;


import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertyManager {

    public static Logger a = Logger.getLogger("Minecraft");
    private Properties b;
    private File c;

    public PropertyManager(File file) {
        b = new Properties();
        c = file;
        if (file.exists()) {
            try {
                b.load(new FileInputStream(file));
            } catch (Exception exception) {
                a.log(Level.WARNING, (new StringBuilder()).append("Failed to load ").append(file).toString(), exception);
                a();
            }
        } else {
            a.log(Level.WARNING, (new StringBuilder()).append(file).append(" does not exist").toString());
            a();
        }
    }

    public void a() {
        a.log(Level.INFO, "Generating new properties file");
        b();
    }

    public void b() {
        try {
            b.store(new FileOutputStream(c), "Minecraft server properties");
        } catch (Exception exception) {
            a.log(Level.WARNING, (new StringBuilder()).append("Failed to save ").append(c).toString(), exception);
            a();
        }
    }

    public String a(String s, String s1) {
        if (!b.containsKey(s)) {
            b.setProperty(s, s1);
            b();
        }
        return b.getProperty(s, s1);
    }

    public int a(String s, int i) {
        try {
            return Integer.parseInt(a(s, (new StringBuilder()).append("").append(i).toString()));
        } catch (Exception exception) {
            b.setProperty(s, (new StringBuilder()).append("").append(i).toString());
        }
        return i;
    }

    public boolean a(String s, boolean flag) {
        try {
            return Boolean.parseBoolean(a(s, (new StringBuilder()).append("").append(flag).toString()));
        } catch (Exception exception) {
            b.setProperty(s, (new StringBuilder()).append("").append(flag).toString());
        }
        return flag;
    }

}

