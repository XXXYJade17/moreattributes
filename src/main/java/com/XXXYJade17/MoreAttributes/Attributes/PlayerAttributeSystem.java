package com.XXXYJade17.MoreAttributes.Attributes;

public class PlayerAttributeSystem {
    private float baseAttack = 0;
    private float attackBonus = 0;

    public float getFinalAttack() {
        return baseAttack * (1 + attackBonus);
    }

    public float getBaseAttack() {
        return baseAttack;
    }
    public float getAttackBonus() {
        return attackBonus;
    }
    public void setBaseAttack(float baseAttack) {
        this.baseAttack = baseAttack;
    }
    public void setAttackBonus(float attackBonus) {
        this.attackBonus = attackBonus;
    }

}
