package com.XXXYJade17.MoreAttributes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;

public class ModCapabilities {
    public static final EntityCapability<IPlayerAttributes,Void> PLAYER_ATTRIBUTES_HANDLER =
            EntityCapability.createVoid(
                    new ResourceLocation(MoreAttributes.MODID,"player_attributes_handler"),
                    IPlayerAttributes.class
            );

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        //注册到玩家实体
        event.registerEntity(
                PLAYER_ATTRIBUTES_HANDLER,  //能力
                EntityType.PLAYER,  //目标类型
                (player, context) -> {
                    // 返回LazyOptional包装的能力实例
                    return player.getCapability(PLAYER_ATTRIBUTES_HANDLER);
                }
        );
    }
}
