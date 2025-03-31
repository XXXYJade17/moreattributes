package com.XXXYJade17.MoreAttributes.Capabilities.Crit;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class CritProvider implements ICapabilityProvider<Player, Void, Crit>, INBTSerializable<CompoundTag> {
    private Crit crit;

    public Crit getCrit(){
        if(crit == null){
            crit = new Crit();
        }
        return crit;
    }

    @Override
    public @Nullable Crit getCapability(Player o, Void unused) {
        return getCrit();
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getCrit().saveData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        getCrit().loadData(compoundTag);
    }
}
