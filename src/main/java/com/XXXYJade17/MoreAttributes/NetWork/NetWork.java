package com.XXXYJade17.MoreAttributes.NetWork;

import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerCrit;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDamage;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDefence;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerLifeSteal;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import com.XXXYJade17.MoreAttributes.NetWork.Client.ClientPayloadHandler;
import com.XXXYJade17.MoreAttributes.NetWork.Server.ServerPayloadHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetWork {
    @SubscribeEvent
    public static void registerPackets(RegisterPayloadHandlerEvent event) {
        IPayloadRegistrar registrar = event.registrar(MoreAttributes.MODID);
        registrar.play(PlayerDamage.ID, PlayerDamage::new, handler ->
                handler.client(ClientPayloadHandler.getINSTANCE()::handleDamageData)
                        .server(ServerPayloadHandler.getINSTANCE()::handleDamageData));
        registrar.play(PlayerCrit.ID, PlayerCrit::new, handler ->
                handler.client(ClientPayloadHandler.getINSTANCE()::handelCritData)
                        .server(ServerPayloadHandler.getINSTANCE()::handleCritData));
        registrar.play(PlayerLifeSteal.ID, PlayerLifeSteal::new, handler ->
                handler.client(ClientPayloadHandler.getINSTANCE()::handleLifeStealData)
                        .server(ServerPayloadHandler.getINSTANCE()::handleLifeStealData));
        registrar.play(PlayerDefence.ID, PlayerDefence::new, handler ->
                handler.client(ClientPayloadHandler.getINSTANCE()::handleDefenceData)
                        .server(ServerPayloadHandler.getINSTANCE()::handleDefenceData));
    }
}
