package com.XXXYJade17.MoreAttributes.Capabilities.Defence;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class DefenceProvider  implements ICapabilityProvider<Player, Void, Defence>, INBTSerializable<CompoundTag> {
    private Defence defence;

    public Defence getDefence(){
        if(defence==null){
            defence = new Defence();
        }
        return defence;
    }

    @Override
    public @Nullable Defence getCapability(Player o, Void unused) {
        return getDefence();
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getDefence().saveData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        getDefence().loadData(compoundTag);
    }
}
