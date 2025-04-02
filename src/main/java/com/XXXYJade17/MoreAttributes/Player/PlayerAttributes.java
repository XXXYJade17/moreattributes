package com.XXXYJade17.MoreAttributes.Player;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

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

    public static boolean isLifeSteal(float lifeSteal){
        Random random= new Random();
        float randomValue= random.nextFloat();
        if(randomValue<=lifeSteal){
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

    public static float finalDamage(float defence,float damage){
        float finalDamage= damage*(1-(defence/(100+defence)));
        return finalDamage;
    }

    public static void removeAttributes(Player player){
        setArmor(player);
        setMaxHealth(player);
        setAttackDamage(player);
        setArmorToughness(player);
    }

    public static void setArmor(Player player){
        float Armor= 0f;
        // 护甲
        UUID ARMOR_MODIFIER_ID = UUID.fromString("12345678-1234-5678-1234-56789abcdef0");
        AttributeInstance armorAttribute = player.getAttribute(Attributes.ARMOR);
        if (armorAttribute != null) {
            armorAttribute.removeModifier(ARMOR_MODIFIER_ID);
            armorAttribute.setBaseValue(Armor);
        }
    }

    public static void setMaxHealth(Player player){
        float MaxHealth = 10f;
        // 最大生命值
        UUID MAX_HEALTH_MODIFIER_ID = UUID.fromString("87654321-1234-5678-1234-56789abcdef0");
        AttributeInstance maxHealthAttribute = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttribute != null) {
            maxHealthAttribute.removeModifier(MAX_HEALTH_MODIFIER_ID);
            maxHealthAttribute.setBaseValue(MaxHealth);
        }
    }

    public static void setAttackDamage(Player player){
        float AttackDamage = 0.1f;
        // 攻击力
        UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("11223344-1234-5678-1234-56789abcdef0");
        AttributeInstance attackDamageAttribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackDamageAttribute != null) {
            attackDamageAttribute.removeModifier(ATTACK_DAMAGE_MODIFIER_ID);
            attackDamageAttribute.setBaseValue(AttackDamage);
        }
    }

    public static void setArmorToughness(Player player){
        float ArmorToughness = 0f;
        // 韧性
        UUID ARMOR_TOUGHNESS_MODIFIER_ID = UUID.fromString("44332211-1234-5678-1234-56789abcdef0");
        AttributeInstance armorToughnessAttribute = player.getAttribute(Attributes.ARMOR_TOUGHNESS);
        if (armorToughnessAttribute != null) {
            armorToughnessAttribute.removeModifier(ARMOR_TOUGHNESS_MODIFIER_ID);
            armorToughnessAttribute.setBaseValue(ArmorToughness);
        }
    }
}
