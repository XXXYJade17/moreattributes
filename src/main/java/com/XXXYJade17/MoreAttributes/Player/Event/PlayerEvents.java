package com.XXXYJade17.MoreAttributes.Player.Event;

import com.XXXYJade17.MoreAttributes.MoreAttributes;
import com.XXXYJade17.MoreAttributes.Player.PlayerAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.DEDICATED_SERVER)
public class PlayerEvents {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        if(event.getEntity() instanceof ServerPlayer player){
            PlayerAttributes.removeAttributes(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        AttributeInstance maxHealthAttribute = event.getEntity().getAttribute(Attributes.MAX_HEALTH);
        maxHealthAttribute.setBaseValue(10);
        event.getEntity().setHealth(10);
        AttributeInstance attackDamageAttribute = event.getEntity().getAttribute(Attributes.ATTACK_DAMAGE);
        attackDamageAttribute.setBaseValue(0.1f);
    }
}
