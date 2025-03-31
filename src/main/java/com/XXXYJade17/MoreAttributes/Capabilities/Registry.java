package com.XXXYJade17.MoreAttributes.Capabilities;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.CritProvider;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.DamageProvider;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
    @SubscribeEvent
    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(ModCapabilities.DAMAGE_HANDLER,
                EntityType.PLAYER,
                new DamageProvider());
        event.registerEntity(ModCapabilities.CRIT_HANDLER,
                EntityType.PLAYER,
                new CritProvider());
    }
}
