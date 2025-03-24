package com.XXXYJade17.MoreAttributes;

import net.minecraft.world.entity.player.Player;

public class PlayerAttributes implements IPlayerAttributes{
    private float attackDamage;
    private float damageMultiplier;
    private float critChance;
    private float critMultiplier;

    @Override
    public void recalculate(Player player) {

    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public float getDamageMultiplier() {
        return 0;
    }

    @Override
    public void setDamageMultiplier(float damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    @Override
    public float getCritChance() {
        return 0;
    }

    @Override
    public void setCritChance(float critChance) {
        this.critChance = critChance;
    }

    @Override
    public float getCritMultiplier() {
        return 0;
    }

    @Override
    public void setCritMultiplier(float critMultiplier) {
        this.critMultiplier = critMultiplier;
    }
}
