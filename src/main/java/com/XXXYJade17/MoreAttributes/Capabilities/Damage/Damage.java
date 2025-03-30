package com.XXXYJade17.MoreAttributes.Capabilities.Damage;

import net.minecraft.nbt.CompoundTag;

public class Damage implements IDamage {
    private float base_damage =0;
    private float damage_multiplier=0;

    public void saveData(CompoundTag nbt) {
        nbt.putFloat("base_damage", base_damage);
        nbt.putFloat("damage_multiplier", damage_multiplier);
    }

    public void loadData(CompoundTag nbt) {
        base_damage = nbt.getFloat("base_damage");
        damage_multiplier=nbt.getFloat("damage_multiplier");
    }

    @Override
    public float getBaseDamage() {
        return base_damage;
    }

    @Override
    public void setBaseDamage(float num) {
        this.base_damage = num;
    }

    @Override
    public float getDamageMultiplier() {
        return damage_multiplier;
    }

    @Override
    public void setDamageMultiplier(float num) {
        this.damage_multiplier=num;
    }
}
