package com.XXXYJade17.MoreAttributes.Capability;

import com.XXXYJade17.MoreAttributes.Attributes.IPlayerAttributes;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCapabilities {
    public static final EntityCapability<PlayerAttributes, Void> PLAYER_ATTRIBUTES =
            EntityCapability.createVoid(
                    new ResourceLocation(MoreAttributes.MODID, "player_attributes"),
                    PlayerAttributes.class
            );
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(
                ModCapabilities.PLAYER_ATTRIBUTES,
                EntityType.PLAYER,
                (entity, context) -> new PlayerAttributes()
        );
    }
}