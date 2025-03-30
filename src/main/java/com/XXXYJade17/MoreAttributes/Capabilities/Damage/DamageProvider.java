package com.XXXYJade17.MoreAttributes.Capabilities.Damage;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class DamageProvider implements ICapabilityProvider<Player, Void, Damage>, INBTSerializable<CompoundTag> {
    private Damage damage;

    public Damage getDamage() {
        if(damage == null){
            damage = new Damage();
        }
        return damage;
    }

    @Override
    public @Nullable Damage getCapability(Player o, Void unused) {
        return damage;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getDamage().saveData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        getDamage().loadData(compoundTag);
    }
}
