package com.XXXYJade17.MoreAttributes;


import com.XXXYJade17.MoreAttributes.EventListener.EventListeners;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(MoreAttributes.MODID)
public class MoreAttributes {
    public static final String MODID = "moreattributes";
    private static EventListeners eventListeners;
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, MODID);
    private static final Supplier<Item> Sword =
            ITEMS.register("sword", Sword::new);

    public MoreAttributes(IEventBus bus, ModContainer container) {
        eventListeners = EventListeners.getInstance();
        NeoForge.EVENT_BUS.register(eventListeners);
        NeoForge.EVENT_BUS.addListener(this::registerCaps);
        ITEMS.register(bus);
    }
    @SubscribeEvent
    private void registerCaps(RegisterCapabilitiesEvent event) {
        ModCapabilities.registerCapabilities(event);
    }
}