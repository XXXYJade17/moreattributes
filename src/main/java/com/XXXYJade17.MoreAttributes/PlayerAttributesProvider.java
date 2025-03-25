package com.XXXYJade17.MoreAttributes;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.BaseCapability;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public interface PlayerAttributesProvider extends ICapabilityProvider<Player,Void, PlayerAttributes>,INBTSerializable<CompoundTag> {
    PlayerAttributes instance = new PlayerAttributes();

    default PlayerAttributes getAttributes() {
        return instance;
    }

    @Override
    default CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getAttributes().saveNBTData(nbt);
        return nbt;
    }

    @Override
    default void deserializeNBT(CompoundTag nbt) {
        getAttributes().loadNBTData(nbt);
    }

    @Override
    default PlayerAttributes getCapability(Player player, Void context) {
        return this.getAttributes();
    }
}
