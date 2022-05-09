package com.neothedeveloper.biomesplus.client.rendering;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.world.GameMode;

import java.util.Arrays;

public class UIElement {
    protected MinecraftClient client;
    protected GameMode[] modes;
    public UIElement(GameMode ...modes) {
        this.modes = modes;
        client = MinecraftClient.getInstance();
    }
    public boolean checkGameMode(GameMode gameMode) {
        return Arrays.stream(this.modes).toList().contains(gameMode);
    }
    public void render(MatrixStack stack, float tickDelta) {}
}
