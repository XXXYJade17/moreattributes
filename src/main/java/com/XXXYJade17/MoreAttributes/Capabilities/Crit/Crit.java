package com.XXXYJade17.MoreAttributes.Capabilities.Crit;

import net.minecraft.nbt.CompoundTag;

public class Crit implements ICrit{
    private float crit_rate=0f;
    private float crit_multiplier=0f;

    public void saveData(CompoundTag nbt) {
        nbt.putFloat("crit_rate", crit_rate);
        nbt.putFloat("crit_multiplier", crit_multiplier);
    }

    public void loadData(CompoundTag nbt) {
        crit_rate = nbt.getFloat("crit");
        crit_multiplier=nbt.getFloat("crit_multiplier");
    }

    @Override
    public float getCritRate() {
        return crit_rate;
    }

    @Override
    public void setCritRate(float num) {
        crit_rate=num;
    }

    @Override
    public float getCritMultiplier() {
        return crit_multiplier;
    }

    @Override
    public void setCritMultiplier(float num) {
        crit_multiplier=num;
    }
}
