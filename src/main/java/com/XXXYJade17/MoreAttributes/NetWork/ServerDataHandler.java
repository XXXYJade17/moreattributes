package com.XXXYJade17.MoreAttributes.NetWork;

import com.XXXYJade17.MoreAttributes.Capability.PlayerAttributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class ServerDataHandler {
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(PlayerAttributes.PLAYER_ATTRIBUTES).ifPresent(oldData -> {
            event.getEntity().getCapability(PlayerAttributes.PLAYER_ATTRIBUTES).ifPresent(newData -> {
                newData.deserializeNBT(oldData.serializeNBT());
            });
        });
        event.getOriginal().invalidateCaps();

    }
}
