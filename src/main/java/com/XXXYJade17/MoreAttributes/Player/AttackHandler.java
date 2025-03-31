package com.XXXYJade17.MoreAttributes.Player;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.Items.ItemsRegistry;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttackHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingHurtEvent event) {
        float finalAttack = 0f;
        float finalCritRate=0f;
        float finalCritMultiplier=0f;
        if (event.getSource().getEntity() instanceof Player attacker) {
            EquipmentSlot[] slots = {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND,
                    EquipmentSlot.HEAD,
                    EquipmentSlot.CHEST,
                    EquipmentSlot.LEGS,
                    EquipmentSlot.FEET
            };
            for (EquipmentSlot slot : slots) {
                ItemStack itemStack = attacker.getItemBySlot(slot);
                if (itemStack.getItem() instanceof IMoreAttributes equip) {
                    Damage damage = equip.getDamage();
                    Crit crit = equip.getCrit();
                    if (damage != null) {
                        finalAttack += PlayerAttributes.finalAttack(damage);
                    }
                    if (crit != null) {
                        finalCritRate += crit.getCritRate();
                        finalCritMultiplier += crit.getCritMultiplier();
                    }
                }
            }
            if (finalAttack > 0) {
                if(PlayerAttributes.isCrit(finalCritRate)) {
                    event.setAmount(finalAttack*(finalCritMultiplier+2));
                    attacker.sendSystemMessage(Component.literal("造成伤害:"+finalAttack*(finalCritMultiplier+2)));
                }else{
                    event.setAmount(finalAttack);
                    attacker.sendSystemMessage(Component.literal("造成伤害:"+finalAttack));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        ItemStack itemStack = event.getEntity().getItemBySlot(EquipmentSlot.MAINHAND);
        if (itemStack.getItem() instanceof IMoreAttributes equip) {
            double distance = event.getEntity().distanceTo(event.getTarget());event.setCanceled(distance > equip.getAttackRange()); // 如果距离超过设置的攻击距离，取消攻击}

        }
    }
}