package com.XXXYJade17.MoreAttributes;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetWork {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlerEvent event) {
        final IPayloadRegistrar registrar = event.registrar(MoreAttributes.MODID);
        registrar.play(AttributesData.ID,AttributesData::new, handler ->
                handler.client(ClientPayloadHandler.getInstance()::handleAttributesData)
                        .server(ServerPayloadHandler.getInstance()::handleAttributeData));
    }
}
