package com.XXXYJade17.MoreAttributes.Items.Weapon;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import net.minecraft.world.item.Item;

public class SimpleStick extends Item implements IMoreAttributes {
    private Damage damage;
    private static final float ATTACK_RANGE = 3.0f;
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
    public double getAttackRange() {
        return ATTACK_RANGE;
    }
}
