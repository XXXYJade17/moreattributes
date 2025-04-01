package com.XXXYJade17.MoreAttributes.Player.Event;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import com.XXXYJade17.MoreAttributes.Player.PlayerAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.DEDICATED_SERVER)
public class AttackHandler {
    private static EquipmentSlot[] slots = {
            EquipmentSlot.MAINHAND,
            EquipmentSlot.OFFHAND,
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    // 防守
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event){
        float originalDamage = event.getAmount();
        float defence = 0f;
        if(event.getEntity() instanceof ServerPlayer defender){
            for (EquipmentSlot slot : slots) {
                ItemStack itemStack = defender.getItemBySlot(slot);
                if (itemStack.getItem() instanceof IMoreAttributes equip) {
                    Defence pDefence = equip.getDefence();
                    defence += pDefence.getDefence();
                }
            }
            defender.sendSystemMessage(Component.literal("被揍了"));
            event.setAmount(PlayerAttributes.finalDamage(defence, originalDamage));
            MoreAttributes.getLOGGER().info("最终防御力:"+defence+"最终受到伤害:"+event.getAmount());
        }
    }

     // 攻击
    @SubscribeEvent
    public static void onLivingAttack(LivingHurtEvent event) {
        float attack = 0f;
        float critRate=0f;
        float critMultiplier=0f;
        float defence=0f;
        if (event.getSource().getEntity() instanceof Player player) {
            for (EquipmentSlot slot : slots) {
                ItemStack itemStack = player.getItemBySlot(slot);
                if (itemStack.getItem() instanceof IMoreAttributes equip) {
                    Damage pDamage = equip.getDamage();
                    Crit pCrit = equip.getCrit();
                    Defence pDefence = equip.getDefence();
                    if (pDamage != null) {
                        attack += PlayerAttributes.finalAttack(pDamage);
                    }
                    if (pCrit != null) {
                        critRate += pCrit.getCritRate();
                        critMultiplier += pCrit.getCritMultiplier();
                    }
                    if(pDefence!=null){
                        defence+=pDefence.getDefence();
                    }
                }
            }
            if(PlayerAttributes.isCrit(critRate)) {
                float criticalAttack=attack*(critMultiplier+2);
                event.setAmount(criticalAttack);
                player.sendSystemMessage(Component.literal("造成伤害:"+criticalAttack));
            }else{
                event.setAmount(attack);
                player.sendSystemMessage(Component.literal("造成伤害:"+attack));
            }
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        if(event.getEntity() instanceof ServerPlayer player){
            Entity target = event.getTarget();
            if(player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof IMoreAttributes equip){
                double attackRange=(double)equip.getAttackRange();
                if(attackRange>0) {
                    double distance = player.distanceTo(target);
                    event.setCanceled(distance > attackRange);
                }
            }else{
                double distance = player.distanceTo(target);
                event.setCanceled(distance > 5);
            }
        }
    }
}