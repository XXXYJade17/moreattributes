package com.XXXYJade17.MoreAttributes.NetWork;

import com.XXXYJade17.MoreAttributes.AttributesData;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ServerPayloadHandler {
    private static final ServerPayloadHandler instance = new ServerPayloadHandler();

    public static ServerPayloadHandler getInstance() {
        return instance;
    }

    public void handleAttributeData(final AttributesData data, final PlayPayloadContext context){
        context.workHandler().submitAsync(()->{
            context.player().ifPresent(player -> {
                // 玩家应该是服务端的玩家
                if (player instanceof ServerPlayer serverPlayer){
                    // 服务端的level
                    ServerLevel level = (ServerLevel) player.level();
                }
            });
        }).exceptionally(e->{
            context.packetHandler().disconnect(Component.literal("my_mod.networking.failed"));
            return null;
        });
    }
}
