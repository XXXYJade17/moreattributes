package com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class LifeStealProvider implements ICapabilityProvider<Player, Void, LifeSteal>, INBTSerializable<CompoundTag> {
   private LifeSteal lifeSteal;

   public LifeSteal getLifeSteal() {
       if(lifeSteal == null){
           lifeSteal = new LifeSteal();
       }
       return lifeSteal;
   }

    @Override
    public @Nullable LifeSteal getCapability(Player o, Void unused) {
        return getLifeSteal();
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        getLifeSteal().saveData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        getLifeSteal().loadData(compoundTag);
    }
}
