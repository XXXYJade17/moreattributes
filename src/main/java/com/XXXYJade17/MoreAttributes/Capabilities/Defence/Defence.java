package com.XXXYJade17.MoreAttributes.Capabilities.Defence;

import net.minecraft.nbt.CompoundTag;

public class Defence implements IDefence{
    private float defence=0;

    public void saveData(CompoundTag nbt) {
        nbt.putFloat("defence",defence);
    }

    public void loadData(CompoundTag nbt) {
        defence = nbt.getFloat("defence");
    }

    @Override
    public float getDefence() {
        return defence;
    }

    @Override
    public void setDefence(float num) {
        defence = num;
    }
}
