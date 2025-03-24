package com.XXXYJade17.MoreAttributes;

import net.minecraft.world.entity.player.Player;

public interface IPlayerAttributes {
    float getAttackDamage();
    void setAttackDamage(float attackDamage);
    float getDamageMultiplier();
    void setDamageMultiplier(float damageMultiplier);
    float getCritChance();
    void setCritChance(float critChance);
    float getCritMultiplier();
    void setCritMultiplier(float critMultiplier);


    void recalculate(Player player);
}
