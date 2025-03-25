package com.XXXYJade17.MoreAttributes;


import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(MoreAttributes.MODID)
public class MoreAttributes {
    public static final String MODID = "moreattributes";
    private static EventListeners eventListeners;

    public MoreAttributes() {
        eventListeners = EventListeners.getInstance();
        NeoForge.EVENT_BUS.register(eventListeners);
        NeoForge.EVENT_BUS.addListener(this::registerCaps);
    }
    private void registerCaps(RegisterCapabilitiesEvent event) {
        ModCapabilities.registerCapabilities(event);
    }
}