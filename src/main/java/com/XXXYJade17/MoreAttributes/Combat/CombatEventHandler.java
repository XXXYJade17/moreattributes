package com.XXXYJade17.MoreAttributes.Combat;

import com.XXXYJade17.MoreAttributes.Attributes.PlayerAttributeSystem;
import com.XXXYJade17.MoreAttributes.Capability.PlayerAttributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@Mod.EventBusSubscriber
public class CombatEventHandler {
    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        player.getCapability(PlayerAttributes.PLAYER_ATTRIBUTES).ifPresent(attrs -> {
            PlayerAttributeSystem stats = attrs.getAttributes();
            // 计算实际攻击力
            float damage = stats.getFinalAttack();
            // 应用伤害
            event.getTarget().hurt(player.damageSources().playerAttack(player), damage);

        });
    }

    // 装备变更时重新计算属性
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if(event.getEntity() instanceof Player player) {
            player.getCapability(PlayerAttributes.PLAYER_ATTRIBUTES)
                    .ifPresent(attrs -> attrs.recalculateAttributes(player));
        }
    }
}
