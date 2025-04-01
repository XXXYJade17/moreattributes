package com.XXXYJade17.MoreAttributes.Items.Weapon;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import net.minecraft.world.item.Item;

public class TestWeapon extends Item implements IMoreAttributes {
    private Damage damage;
    private Crit crit;
    private Defence defence;
    private static final float ATTACK_RANGE = 3.0f;

    public TestWeapon() {
        super(new Properties()
                .stacksTo(1)
                .fireResistant());

        damage = new Damage();
        damage.setDamage(10.0f);
        damage.setDamageMultiplier(0.5f);

        crit = new Crit();
        crit.setCritRate(0.5f);
        crit.setCritMultiplier(2f);
    }

    @Override
    public Damage getDamage() {
        return damage;
    }

    @Override
    public Crit getCrit() {
        return crit;
    }

    @Override
    public Defence getDefence() {
        return defence;
    }

    @Override
    public double getAttackRange() {
        return ATTACK_RANGE;
    }
}
