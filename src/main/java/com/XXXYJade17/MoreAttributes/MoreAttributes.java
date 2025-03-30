package com.XXXYJade17.MoreAttributes;

import com.XXXYJade17.MoreAttributes.Player.AttackHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(MoreAttributes.MODID)
public class MoreAttributes {
    public static final String MODID = "moreattributes";

    public MoreAttributes(IEventBus bus, ModContainer container) {
        NeoForge.EVENT_BUS.register(AttackHandler.class);
    }
}
