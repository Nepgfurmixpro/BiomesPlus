package com.neothedeveloper.biomesplus.client.rendering.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.neothedeveloper.biomesplus.BiomesPlus;
import com.neothedeveloper.biomesplus.client.data.PlayerEntityExt;
import com.neothedeveloper.biomesplus.client.rendering.ColorUtils;
import com.neothedeveloper.biomesplus.client.rendering.UIElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

import java.util.Objects;

public class WaterMeter extends UIElement {
    public WaterMeter() {
        super(GameMode.SURVIVAL, GameMode.ADVENTURE);
    }
    private static final int TEXTURE_SIZE = 12;
    public static final Identifier WATER_EMPTY = new Identifier(BiomesPlus.MOD_ID, "textures/gui/watermeter/empty.png");
    public static final Identifier WATER_HALF = new Identifier(BiomesPlus.MOD_ID, "textures/gui/watermeter/half.png");
    public static final Identifier WATER_FULL = new Identifier(BiomesPlus.MOD_ID, "textures/gui/watermeter/full.png");
    @Override
    public void render(MatrixStack stack, float tickDelta) {
        double level = ((double)((PlayerEntityExt) Objects.requireNonNull(MinecraftClient.getInstance().player)).getWater()) / 2;
        String[] valueStrings = Double.toString(level).split("\\.");
        int fullWater = Integer.parseInt(valueStrings[0]);
        boolean hasHalfWater = Integer.parseInt(valueStrings[1]) > 0;
        DrawableHelper.drawCenteredText(stack, MinecraftClient.getInstance().textRenderer, String.format("%d", Objects.requireNonNull(MinecraftClient.getInstance().world).getTime()), 20, 8, ColorUtils.GenerateFromRGB(255, 255, 255));
        int shakeValue = 100;
        if (fullWater == 4) shakeValue = 50;
        if (fullWater == 3) shakeValue = 25;
        if (fullWater <= 2) shakeValue = 10;
        if (fullWater == 0) shakeValue = 3;
        boolean bounce = Objects.requireNonNull(MinecraftClient.getInstance().world).getTime() % (shakeValue) == 0;
        for (int i = 0; i < 10; i++) {
            if (i + 1 <= fullWater) {
                RenderSystem.setShaderTexture(0, WATER_FULL);
            } else if (hasHalfWater && i + 1 == fullWater + 1) {
                RenderSystem.setShaderTexture(0, WATER_HALF);
            } else {
                RenderSystem.setShaderTexture(0, WATER_EMPTY);
            }
            DrawableHelper.drawTexture(
                    stack,
                    ((client.getWindow().getScaledWidth() / 2) + 19 + (8 * i)) - TEXTURE_SIZE,
                    (int) (((client.getWindow().getScaledHeight() - TEXTURE_SIZE) - 40) + (bounce ? Math.floor(Math.random() * 3) - 2 : 0)),
                    -1,
                    180,
                    300,
                    TEXTURE_SIZE,
                    TEXTURE_SIZE,
                    TEXTURE_SIZE,
                    TEXTURE_SIZE);
        }
    }
}
