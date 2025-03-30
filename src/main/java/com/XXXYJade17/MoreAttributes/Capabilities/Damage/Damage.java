package com.XXXYJade17.MoreAttributes.Capabilities.Damage;

import net.minecraft.nbt.CompoundTag;

public class Damage implements IDamage {
    private float damage =0f;
    private float damage_multiplier=0f;

    public void saveData(CompoundTag nbt) {
        nbt.putFloat("base_damage", damage);
        nbt.putFloat("damage_multiplier", damage_multiplier);
    }

    public void loadData(CompoundTag nbt) {
        damage = nbt.getFloat("base_damage");
        damage_multiplier=nbt.getFloat("damage_multiplier");
    }

    @Override
    public float getDamage() {
        return damage;
    }

    @Override
    public void setDamage(float num) {
        damage = num;
    }

    @Override
    public float getDamageMultiplier() {
        return damage_multiplier;
    }

    @Override
    public void setDamageMultiplier(float num) {
        damage_multiplier=num;
    }
}
