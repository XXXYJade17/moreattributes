package com.XXXYJade17.MoreAttributes;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID,value = Dist.CLIENT)
public class EventListeners {
    private static EventListeners instance;
    private EventListeners(){}

    public static EventListeners getInstance(){
        if(instance==null){
            instance=new EventListeners();
        }
        return instance;
    }

    @SubscribeEvent
    public void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if(event.getEntity() instanceof ServerPlayer player){
            updatePlayerStats(player);
        }
    }

    @SubscribeEvent
    public void onAttack(LivingAttackEvent event){
        if(event.getEntity() instanceof ServerPlayer player){
            LivingEntity target = event.getSource().getEntity() instanceof LivingEntity ? (LivingEntity) event.getSource().getEntity() : null;
            if (target != null) {
                // 获取玩家属性
                IPlayerAttributes attributes = player.getCapability(ModCapabilities.PLAYER_ATTRIBUTES_HANDLER);
                if (attributes != null) {
                    // 获取基础攻击和伤害倍率
                    float baseDamage = attributes.getAttackDamage();
                    float damageMultiplier = attributes.getDamageMultiplier();
                    // 计算最终伤害
                    float finalDamage = baseDamage * damageMultiplier;
                    // 对目标造成伤害
                    target.hurt(event.getSource(), finalDamage);
                }
            }
        }
    }

    private void updatePlayerStats(Player player) {
        IPlayerAttributes attributes = player.getCapability(ModCapabilities.PLAYER_ATTRIBUTES_HANDLER);
        if (attributes != null) {
            attributes.recalculate(player);
        }
    }
}