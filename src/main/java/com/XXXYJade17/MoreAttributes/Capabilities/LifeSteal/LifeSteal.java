package com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal;

import net.minecraft.nbt.CompoundTag;

public class LifeSteal implements ILifeSteal{
    private float life_steal_rate=0f;
    private float life_steal_multiplier=0f;


    public void saveData(CompoundTag nbt) {
        nbt.putFloat("life_steal_rate", life_steal_rate);
        nbt.putFloat("life_steal_multiplier", life_steal_multiplier);
    }

    public void loadData(CompoundTag nbt) {
        life_steal_rate = nbt.getFloat("life_steal_rate");
        life_steal_multiplier=nbt.getFloat("life_steal_multiplier");
    }

    @Override
    public float getLifeStealRate() {
        return life_steal_rate;
    }

    @Override
    public void setLifeStealRate(float num) {
        life_steal_rate=num;
    }

    @Override
    public float getLifeStealMultiplier() {
        return life_steal_multiplier;
    }

    @Override
    public void setLifeStealMultiplier(float num) {
        life_steal_multiplier=num;
    }
}
