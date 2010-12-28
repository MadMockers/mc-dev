package net.minecraft.server;


public class MathHelper {

    private static float a[];

    public MathHelper() {}

    public static final float a(float f) {
        return a[(int) (f * 10430.38F) & 0xffff];
    }

    public static final float b(float f) {
        return a[(int) (f * 10430.38F + 16384F) & 0xffff];
    }

    public static final float c(float f) {
        return (float) Math.sqrt(f);
    }

    public static final float a(double d1) {
        return (float) Math.sqrt(d1);
    }

    public static int d(float f) {
        int i = (int) f;

        return f >= (float) i ? i : i - 1;
    }

    public static int b(double d1) {
        int i = (int) d1;

        return d1 >= (double) i ? i : i - 1;
    }

    public static float e(float f) {
        return f < 0.0F ? -f : f;
    }

    public static double a(double d1, double d2) {
        if (d1 < 0.0D) {
            d1 = -d1;
        }
        if (d2 < 0.0D) {
            d2 = -d2;
        }
        return d1 <= d2 ? d2 : d1;
    }

    static {
        a = new float[0x10000];
        for (int i = 0; i < 0x10000; i++) {
            a[i] = (float) Math.sin(((double) i * 3.1415926535897931D * 2D) / 65536D);
        }

    }
}

