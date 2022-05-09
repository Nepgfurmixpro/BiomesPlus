package com.neothedeveloper.biomesplus.client.mixins;

import com.neothedeveloper.biomesplus.BiomesPlus;
import com.neothedeveloper.biomesplus.client.data.PlayerEntityExt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(MinecraftClientGame.class)
public class PlayerJoinMixin {
    @Inject(at = @At(value = "TAIL"), method = "onStartGameSession")
    private void onPlayerJoinGame(CallbackInfo ci) {
        BiomesPlus.LOGGER.info("Player joined server.");
        BiomesPlus.LOGGER.info(String.format("Water Level: %d", ((PlayerEntityExt) Objects.requireNonNull(MinecraftClient.getInstance().player)).getWater()));
    }
}
