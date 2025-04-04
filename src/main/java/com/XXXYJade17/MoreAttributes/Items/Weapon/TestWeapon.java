package com.XXXYJade17.MoreAttributes.Items.Weapon;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal.LifeSteal;
import net.minecraft.world.item.Item;

public class TestWeapon extends Item implements IMoreAttributes {
    private Damage damage;
    private Crit crit;
    private LifeSteal lifeSteal;
    private static final int ATTACK_RANGE = 3;

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

        lifeSteal = new LifeSteal();
        lifeSteal.setLifeStealRate(0.8f);
        lifeSteal.setLifeStealMultiplier(0.5f);
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
        return null;
    }

    @Override
    public LifeSteal getLifeSteal() {
        return lifeSteal;
    }

    @Override
    public int getAttackRange() {
        return ATTACK_RANGE;
    }
}
