package com.XXXYJade17.MoreAttributes;

import com.XXXYJade17.MoreAttributes.Items.ItemsRegistry;
import com.XXXYJade17.MoreAttributes.Player.Event.AttackHandler;
import com.XXXYJade17.MoreAttributes.Player.Event.PlayerEvents;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(MoreAttributes.MODID)
public class MoreAttributes {
    public static final String MODID = "moreattributes";
    private static final Logger LOGGER= LogUtils.getLogger();

    public MoreAttributes(IEventBus bus, ModContainer container) {
        ItemsRegistry.register(bus);
        NeoForge.EVENT_BUS.register(AttackHandler.class);
        NeoForge.EVENT_BUS.register(PlayerEvents.class);
    }

    public static Logger getLOGGER(){
        return LOGGER;
    }
}
