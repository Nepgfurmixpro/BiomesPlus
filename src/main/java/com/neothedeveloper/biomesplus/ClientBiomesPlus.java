package com.neothedeveloper.biomesplus;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.neothedeveloper.biomesplus.client.data.PlayerEntityExt;
import com.neothedeveloper.biomesplus.client.rendering.MainRenderer;
import com.neothedeveloper.biomesplus.client.rendering.UIElement;
import com.neothedeveloper.biomesplus.client.rendering.UIElementRegistry;
import com.neothedeveloper.biomesplus.client.rendering.gui.TemperatureMeter;
import com.neothedeveloper.biomesplus.client.rendering.gui.WaterMeter;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.mixin.gametest.ArgumentTypesMixin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.command.argument.ArgumentTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

@Environment(EnvType.CLIENT)
public class ClientBiomesPlus implements ClientModInitializer {
    public static final UIElement TEMPERATURE_METER = new TemperatureMeter();
    public static final UIElement WATER_METER = new WaterMeter();
    @Override
    public void onInitializeClient() {
        UIElementRegistry.register(TEMPERATURE_METER);
        UIElementRegistry.register(WATER_METER);

        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            dispatcher.register(literal("setwater").then(argument("value", IntegerArgumentType.integer()).executes((context -> {
                ClientPlayerEntity playerEntity = MinecraftClient.getInstance().player;
                int value = IntegerArgumentType.getInteger(context, "value");
                value = value <= 20 && value >= 0 ? value : 20;
                ((PlayerEntityExt) Objects.requireNonNull(playerEntity)).setWater(value);
                return 0;
            }))));
        }));

        HudRenderCallback.EVENT.register((MainRenderer::render));
    }
}
