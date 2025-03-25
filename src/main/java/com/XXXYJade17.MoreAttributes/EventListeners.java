package com.XXXYJade17.MoreAttributes;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID,value = Dist.CLIENT)
public class EventListeners {
    private static EventListeners instance;
    private EventListeners(){}

    public static EventListeners getInstance(){
        if(instance==null){
            instance=new EventListeners();
        }
        return instance;
    }

    @SubscribeEvent
    public void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if(event.getEntity() instanceof ServerPlayer player){
            updatePlayerStats(player);
        }
    }

    private void updatePlayerStats(Player player) {
        IPlayerAttributes attributes = player.getCapability(ModCapabilities.PLAYER_ATTRIBUTES_HANDLER);
        if (attributes != null) {
            attributes.recalculate(player);
        }
    }
}

