package com.XXXYJade17.MoreAttributes.EventListener;

import com.XXXYJade17.MoreAttributes.*;
import com.XXXYJade17.MoreAttributes.Data.ClientPlayerAttributesData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.network.PacketDistributor;

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
            ItemStack newItemStack = event.getTo();
            EquipmentSlot slot = event.getSlot();
            if (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND ||
                    slot == EquipmentSlot.HEAD || slot == EquipmentSlot.CHEST ||
                    slot == EquipmentSlot.LEGS || slot == EquipmentSlot.FEET) {

                if (newItemStack.getItem() instanceof PlayerAttributesProvider equip) {
                    PlayerAttributes attributes = equip.getAttributes();
                    ClientPlayerAttributesData.getAttributes(attributes);
                }
            }
        }
    }

    @SubscribeEvent
    public void onAttack(LivingAttackEvent event){
        if(event.getEntity() instanceof ServerPlayer player){
            LivingEntity target = event.getSource().getEntity() instanceof LivingEntity ? (LivingEntity) event.getSource().getEntity() : null;
            if (target != null) {
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

    private void sendAttributesToServer(ServerPlayer player, IPlayerAttributes attributes) {
//        channel.send(PacketDistributor.PLAYER.with(() -> player), new AttributesData("attackDamage", attributes.getAttackDamage()));
//        channel.send(PacketDistributor.PLAYER.with(() -> player), new AttributesData("damageMultiplier", attributes.getDamageMultiplier()));
//        channel.send(PacketDistributor.PLAYER.with(() -> player), new AttributesData("critChance", attributes.getCritChance()));
//        channel.send(PacketDistributor.PLAYER.with(() -> player), new AttributesData("critMultiplier", attributes.getCritMultiplier()));
    }

    private void updatePlayerStats(Player player) {
        IPlayerAttributes attributes = player.getCapability(ModCapabilities.PLAYER_ATTRIBUTES_HANDLER);
        if (attributes != null) {
            attributes.recalculate(player);
        }
    }
}