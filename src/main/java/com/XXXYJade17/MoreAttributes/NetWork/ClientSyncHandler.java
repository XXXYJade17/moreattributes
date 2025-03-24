package com.XXXYJade17.MoreAttributes.NetWork;

import com.XXXYJade17.MoreAttributes.Attributes.PlayerAttributes;
import net.minecraft.world.entity.player.Player;

public class ClientSyncHandler {
    public static void syncCapability(Player player, PlayerAttributes data) {
        if(player.level().isClientSide) {
            player.getCapability(PlayerAttributes.PLAYER_ATTRIBUTES).ifPresent(clientData -> {
                clientData.getAttributes().setBaseAttack(data.getAttributes().getBaseAttack());
            });
        }
    }
}
