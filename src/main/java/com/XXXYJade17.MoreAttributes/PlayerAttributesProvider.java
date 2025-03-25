package com.XXXYJade17.MoreAttributes;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.BaseCapability;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public interface PlayerAttributesProvider extends INBTSerializable<CompoundTag> {
    IPlayerAttributes instance = new PlayerAttributes();

    @Override
    default CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("attack_damage", instance.getAttackDamage());
        tag.putFloat("damage_multiplier", instance.getDamageMultiplier());
        tag.putFloat("crit_chance", instance.getCritChance());
        tag.putFloat("crit_multiplier", instance.getCritMultiplier());
        return tag;
    }

    @Override
    default void deserializeNBT(CompoundTag compoundTag) {
        instance.setAttackDamage(compoundTag.getFloat("attack_damage"));
        instance.setDamageMultiplier(compoundTag.getFloat("damage_multiplier"));
        instance.setCritChance(compoundTag.getFloat("crit_chance"));
        instance.setCritMultiplier(compoundTag.getFloat("crit_multiplier"));
    }

    default IPlayerAttributes getInstance(){
        return instance;
    }
}
