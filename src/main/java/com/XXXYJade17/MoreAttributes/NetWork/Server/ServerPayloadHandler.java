package com.XXXYJade17.MoreAttributes.NetWork.Server;

import com.XXXYJade17.MoreAttributes.Capabilities.ModCapabilities;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDamage;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import java.util.Optional;

public class ServerPayloadHandler {
    private static ServerPayloadHandler INSTANCE;

    public static ServerPayloadHandler getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new ServerPayloadHandler();
        }
        return INSTANCE;
    }

    public void handleDamageData(PlayerDamage pDamage, PlayPayloadContext context) {
        context.player().ifPresent(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                Optional.ofNullable(player.getCapability(ModCapabilities.DAMAGE_HANDLER))
                        .ifPresent(damage -> {
                            PacketDistributor.PLAYER.with(serverPlayer)
                                    .send(new PlayerDamage(damage.getDamage(), damage.getDamageMultiplier()));
                        });
            }
        });
    }
}
