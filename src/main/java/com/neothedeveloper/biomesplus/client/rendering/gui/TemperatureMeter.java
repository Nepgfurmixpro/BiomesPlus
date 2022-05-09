package com.neothedeveloper.biomesplus.client.rendering.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.neothedeveloper.biomesplus.BiomesPlus;
import com.neothedeveloper.biomesplus.client.rendering.UIElement;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.world.GameMode;

public class TemperatureMeter extends UIElement {
    public TemperatureMeter() {
        super(GameMode.SURVIVAL, GameMode.ADVENTURE);
    }
    private static final int TEXTURE_SIZE = 32;
    public static final Identifier TEMPERATURE_METER_COLD_0 = new Identifier(BiomesPlus.MOD_ID, "textures/gui/tempmeter/cold_meter_0.png");
    @Override
    public void render(MatrixStack stack, float tickDelta) {
        RenderSystem.setShaderTexture(0, TEMPERATURE_METER_COLD_0);
        Matrix4f matrix = RenderSystem.getTextureMatrix();
        DrawableHelper.drawTexture(
                stack,
                ((client.getWindow().getScaledWidth() / 2) + 120) - TEXTURE_SIZE,
                (client.getWindow().getScaledHeight() - TEXTURE_SIZE) - 2,
                0,
                180,
                320,
                TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE);
    }
}
