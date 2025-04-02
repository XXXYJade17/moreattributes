package com.XXXYJade17.MoreAttributes.Items.Weapon;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal.LifeSteal;
import net.minecraft.world.item.Item;

public class SimpleStick extends Item implements IMoreAttributes {
    private Damage damage;
    private static final int ATTACK_RANGE = 4;
    public SimpleStick() {
        super(new Properties()
                .stacksTo(1)
                .fireResistant());

        damage = new Damage();
        damage.setDamage(10.0f);
        damage.setDamageMultiplier(0.5f);
    }
    @Override
    public Damage getDamage() {
        return damage;
    }

    @Override
    public Crit getCrit() {
        return null;
    }

    @Override
    public Defence getDefence() {
        return null;
    }

    @Override
    public LifeSteal getLifeSteal() {
        return null;
    }

    @Override
    public int getAttackRange() {
        return ATTACK_RANGE;
    }
}
