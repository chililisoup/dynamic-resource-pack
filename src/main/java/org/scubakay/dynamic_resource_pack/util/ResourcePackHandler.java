package org.scubakay.dynamic_resource_pack.util;

import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.scubakay.dynamic_resource_pack.config.ServerProperties;

import java.util.Collection;

public class ResourcePackHandler {
    public static void push(ServerPlayNetworkHandler handler, MinecraftServer server) {
        ServerProperties config = ConfigFileHandler.getInstance(server).config;
        handler.sendPacket(new ResourcePackSendS2CPacket(
                config.id.get(),
                config.url.get(),
                config.hash.get(),
                config.required.get(),
                config.getPrompt(server.getRegistryManager())
        ));
    }

    public static int pushTo(MinecraftServer server) {
        return pushTo(server.getPlayerManager(), server);
    }
    public static int pushTo(PlayerManager players, MinecraftServer server) {
        return pushTo(players.getPlayerList(), server);
    }
    public static int pushTo(Collection<ServerPlayerEntity> players, MinecraftServer server) {
        for (ServerPlayerEntity player : players) push(player.networkHandler, server);
        return players.size();
    }
}
