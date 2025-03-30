package com.XXXYJade17.MoreAttributes.Capabilities.Damage;

import net.minecraft.nbt.CompoundTag;

public class Damage implements IDamage {
    private float damage=0;
    private float damage_multiplier=0;

    public void saveData(CompoundTag nbt) {
        nbt.putFloat("damage", damage);
        nbt.putFloat("damage_multiplier", damage_multiplier);
    }

    public void loadData(CompoundTag nbt) {
        damage = nbt.getFloat("damage");
        damage_multiplier=nbt.getFloat("damage_multiplier");
    }

    @Override
    public float getDamage() {
        return damage;
    }

    @Override
    public void addDamage(float num) {
        damage += num;
    }

    @Override
    public float getDamageMultiplier() {
        return damage_multiplier;
    }

    @Override
    public void addDamageMultiplier(float num) {
        damage_multiplier+=num;
    }
}
