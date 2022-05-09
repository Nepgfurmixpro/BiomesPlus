package com.neothedeveloper.biomesplus.client.rendering;

public class ColorUtils {
    public static int GenerateFromRGB(int r, int g, int b) {
        return GenerateFromRGBA(r, g, b, 255);
    }
    public static int GenerateFromRGBA(int r, int g, int b, int a) {
        return (a << 24) + (r << 16) + (g << 8) + b;
    }
}
