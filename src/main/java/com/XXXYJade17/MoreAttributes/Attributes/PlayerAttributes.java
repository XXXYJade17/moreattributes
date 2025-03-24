package com.XXXYJade17.MoreAttributes.Attributes;

import com.XXXYJade17.MoreAttributes.Equipment.EquipmentAttributeManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class PlayerAttributes implements IPlayerAttributes, INBTSerializable<CompoundTag> {
    public static final Capability<IPlayerAttributes> PLAYER_ATTRIBUTES = CapabilityManager.get(new CapabilityToken<>(){});
    private final PlayerAttributeSystem attributes = new PlayerAttributeSystem();

    @Override
    public PlayerAttributeSystem getAttributes() {
        return attributes;
    }

    @Override
    public void recalculateAttributes(Player player) {
        // 清空基础值
        attributes.setBaseAttack(0);

        // 调用装备系统重新计算（第二步实现）
        EquipmentAttributeManager.calculate(player, this);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("BaseAttack", attributes.getBaseAttack());
        tag.putFloat("AttackBonus", attributes.getAttackBonus());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        attributes.setBaseAttack(nbt.getFloat("BaseAttack"));
        attributes.setAttackBonus(nbt.getFloat("AttackBonus"));
    }
}
