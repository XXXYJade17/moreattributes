package com.XXXYJade17.MoreAttributes.Player;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;

public class PlayerAttributes {

    public static float finalAttack(Damage damage){
        float playerDamage= damage.getDamage();
        float playerDamageMultiplier= damage.getDamageMultiplier();
        return playerDamage*(playerDamageMultiplier+1);
    }
}
