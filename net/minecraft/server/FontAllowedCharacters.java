package net.minecraft.server;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FontAllowedCharacters {

    public static final String a = a();

    public FontAllowedCharacters() {}

    private static String a() {
        String s = "";

        try {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.server.FontAllowedCharacters.class).getResourceAsStream("/font.txt"), "UTF-8"));
            String s1 = "";

            do {
                String s2;

                if ((s2 = bufferedreader.readLine()) == null) {
                    break;
                }
                if (!s2.startsWith("#")) {
                    s = (new StringBuilder()).append(s).append(s2).toString();
                }
            } while (true);
            bufferedreader.close();
        } catch (Exception exception) {}
        return s;
    }

}

