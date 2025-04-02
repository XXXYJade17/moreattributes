package com.XXXYJade17.MoreAttributes.NetWork.Server;

import com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal.LifeSteal;
import com.XXXYJade17.MoreAttributes.Capabilities.ModCapabilities;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerCrit;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDamage;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDefence;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerLifeSteal;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import java.util.Optional;

public class ServerPayloadHandler {
    private static ServerPayloadHandler INSTANCE;

    public static ServerPayloadHandler getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new ServerPayloadHandler();
        }
        return INSTANCE;
    }

    public void handleDamageData(PlayerDamage pDamage, PlayPayloadContext context) {
        context.player().ifPresent(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                Optional.ofNullable(player.getCapability(ModCapabilities.DAMAGE_HANDLER))
                        .ifPresent(damage -> {
                            PacketDistributor.PLAYER.with(serverPlayer)
                                    .send(new PlayerDamage(damage.getDamage(), damage.getDamageMultiplier()));
                        });
            }
        });
    }

    public void handleCritData(PlayerCrit pCrit, PlayPayloadContext context) {
        context.player().ifPresent(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                Optional.ofNullable(player.getCapability(ModCapabilities.CRIT_HANDLER))
                        .ifPresent(crit -> {
                            PacketDistributor.PLAYER.with(serverPlayer)
                                    .send(new PlayerCrit(crit.getCritRate(), crit.getCritMultiplier()));
                        });
            }
        });
    }

    public void handleLifeStealData(PlayerLifeSteal pLifeSteal, PlayPayloadContext context) {
        context.player().ifPresent(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                Optional.ofNullable(player.getCapability(ModCapabilities.LIFE_STEAL_HANDLER))
                        .ifPresent(lifeSteal -> {
                            PacketDistributor.PLAYER.with(serverPlayer)
                                    .send(new PlayerCrit(lifeSteal.getLifeStealRate(), lifeSteal.getLifeStealMultiplier()));
                        });
            }
        });
    }

    public void handleDefenceData(PlayerLifeSteal pLifeSteal, PlayPayloadContext context) {
        context.player().ifPresent(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                Optional.ofNullable(player.getCapability(ModCapabilities.DEFENCE_HANDLER))
                        .ifPresent(defence -> {
                            PacketDistributor.PLAYER.with(serverPlayer)
                                    .send(new PlayerDefence(defence.getDefence()));
                        });
            }
        });
    }
}
