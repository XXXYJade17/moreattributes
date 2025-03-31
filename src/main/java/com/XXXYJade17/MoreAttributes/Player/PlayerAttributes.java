package com.XXXYJade17.MoreAttributes.Player;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;

import java.util.Random;

public class PlayerAttributes {
    public static boolean isCrit(float critRate){
        Random random= new Random();
        float randomValue= random.nextFloat();
        if(randomValue<=critRate){
            return true;
        }else{
            return false;
        }
    }

    public static float finalAttack(Damage damage){
        float playerDamage= damage.getDamage();
        float playerDamageMultiplier= damage.getDamageMultiplier();
        return playerDamage*(playerDamageMultiplier+1);
    }
}
