package com.XXXYJade17.MoreAttributes;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class PlayerAttributes implements IPlayerAttributes{
    private float attackDamage = 0f;
    private float damageMultiplier = 0f;
    private float critChance = 0f;
    private float critMultiplier = 0f;

    private float finalAttackDamage = 0f;


    @Override
    public void recalculate(Player player) {
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public float getDamageMultiplier() {
        return damageMultiplier;
    }

    @Override
    public void setDamageMultiplier(float damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    @Override
    public float getCritChance() {
        return critChance;
    }

    @Override
    public void setCritChance(float critChance) {
        this.critChance = critChance;
    }

    @Override
    public float getCritMultiplier() {
        return critMultiplier;
    }

    @Override
    public void setCritMultiplier(float critMultiplier) {
        this.critMultiplier = critMultiplier;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putFloat("attack_damage", attackDamage);
        nbt.putFloat("damage_multiplier", damageMultiplier);
        nbt.putFloat("crit_chance", critChance);
        nbt.putFloat("crit_multiplier", critMultiplier);
    }

    public void loadNBTData(CompoundTag nbt) {
        attackDamage = nbt.getFloat("attack_damage");
        damageMultiplier = nbt.getFloat("damage_multiplier");
        critChance = nbt.getFloat("crit_chance");
        critMultiplier = nbt.getFloat("crit_multiplier");
    }
}
