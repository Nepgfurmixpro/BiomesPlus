package com.neothedeveloper.biomesplus.client.rendering;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.world.GameMode;

import java.util.Objects;

public class MainRenderer {
    public static void render(MatrixStack stack, float tickDelta) {
        UIElementRegistry.getRegistry().stream().filter(uie -> uie.checkGameMode(GameMode.valueOf(Objects.requireNonNull(MinecraftClient.getInstance().getGame().getCurrentSession()).getGameMode().toUpperCase()))).toList().forEach(uie -> {
            uie.render(stack, tickDelta);
        });
    }
}
