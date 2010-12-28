package net.minecraft.server;


import java.util.Random;


public class NoiseGeneratorOctaves2 extends NoiseGenerator {

    private NoiseGenerator2 a[];
    private int b;

    public NoiseGeneratorOctaves2(Random random, int i) {
        b = i;
        a = new NoiseGenerator2[i];
        for (int j = 0; j < i; j++) {
            a[j] = new NoiseGenerator2(random);
        }

    }

    public double[] a(double ad[], double d, double d1, int i, int j, 
            double d2, double d3, double d4) {
        return a(ad, d, d1, i, j, d2, d3, d4, 0.5D);
    }

    public double[] a(double ad[], double d, double d1, int i, int j, 
            double d2, double d3, double d4, double d5) {
        d2 /= 1.5D;
        d3 /= 1.5D;
        if (ad == null || ad.length < i * j) {
            ad = new double[i * j];
        } else {
            for (int k = 0; k < ad.length; k++) {
                ad[k] = 0.0D;
            }

        }
        double d6 = 1.0D;
        double d7 = 1.0D;

        for (int l = 0; l < b; l++) {
            a[l].a(ad, d, d1, i, j, d2 * d7, d3 * d7, 0.55000000000000004D / d6);
            d7 *= d4;
            d6 *= d5;
        }

        return ad;
    }
}

