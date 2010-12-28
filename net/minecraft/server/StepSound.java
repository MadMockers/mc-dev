package net.minecraft.server;


public class StepSound {

    public final String a;
    public final float b;
    public final float c;

    public StepSound(String s, float f, float f1) {
        a = s;
        b = f;
        c = f1;
    }

    public float a() {
        return b;
    }

    public float b() {
        return c;
    }

    public String c() {
        return (new StringBuilder()).append("step.").append(a).toString();
    }
}

