package com.XXXYJade17.MoreAttributes.Player;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

@Mod.EventBusSubscriber(modid = MoreAttributes.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttackHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingHurtEvent event) {
        float finalAttack=0f;
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
                    Damage damage= equip.getDamage();
                    if(damage!=null) {
                        finalAttack += PlayerAttributes.finalAttack(damage);
                        LogUtils.getLogger().info("finalAttack: {}", finalAttack);

                    }
                }
            }
            if(finalAttack>0) {
                event.setAmount(finalAttack);
//                event.setCanceled(true);
            }
        }
    }
}
