package com.XXXYJade17.MoreAttributes.Equipment;

import com.XXXYJade17.MoreAttributes.Attributes.PlayerAttributeSystem;
import net.minecraft.world.entity.player.Player;

public interface EquipmentAttributeProvider {
    default void addWeaponAttributes(Player player, PlayerAttributeSystem attributes) {}
    default void addArmorAttributes(Player player, PlayerAttributeSystem attributes) {}
}
