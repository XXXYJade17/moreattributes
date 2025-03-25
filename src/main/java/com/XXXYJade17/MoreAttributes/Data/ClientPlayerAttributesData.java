package com.XXXYJade17.MoreAttributes.Data;

import com.XXXYJade17.MoreAttributes.PlayerAttributes;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientPlayerAttributesData {
    private static float attackDamage = 0f;
    private static float damageMultiplier = 0f;
    private static float critChance = 0f;
    private static float critMultiplier = 0f;

    public void setAttackDamage(float attackDamage){
        this.attackDamage = attackDamage;
    }
    public float getAttackDamage(){
        return attackDamage;
    }

//    public static FriendlyByteBuf getAttackDamage(){
//        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
//        buf.writeUtf("attack_damage"); // 写入 level
//        buf.writeFloat(attackDamage); // 写入 thirst
//        return buf;
//    }
    public void setDamageMultiplier(float damageMultiplier){
        this.damageMultiplier = damageMultiplier;
    }
    public float getDamageMultiplier(){
        return damageMultiplier;
    }
    public void setCritChance(float critChance){
        this.critChance = critChance;
    }
    public float getCritChance(){
        return critChance;
    }
    public static void getAttributes(PlayerAttributes attributes){
        attackDamage = attributes.getAttackDamage();
        damageMultiplier = attributes.getDamageMultiplier();
        critChance = attributes.getCritChance();
        critMultiplier = attributes.getCritMultiplier();
    }
}
