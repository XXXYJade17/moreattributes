package com.XXXYJade17.MoreAttributes.Equipment;

import com.XXXYJade17.MoreAttributes.Attributes.IPlayerAttributes;
import com.XXXYJade17.MoreAttributes.Attributes.PlayerAttributeSystem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class EquipmentAttributeManager {
    public static void calculate(Player player, IPlayerAttributes attrSystem) {
        PlayerAttributeSystem attrs = attrSystem.getAttributes();

        // 遍历装备
        for(ItemStack stack : player.getInventory().armor) {
            if(stack.getItem() instanceof EquipmentAttributeProvider provider) {
                provider.addArmorAttributes(player, attrs);
            }
        }

        // 主手物品（武器）
        ItemStack mainHand = player.getMainHandItem();
        if(mainHand.getItem() instanceof EquipmentAttributeProvider provider) {
            provider.addWeaponAttributes(player, attrs);
        }
    }
}
