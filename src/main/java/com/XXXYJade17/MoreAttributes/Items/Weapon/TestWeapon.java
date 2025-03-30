package com.XXXYJade17.MoreAttributes.Items.Weapon;

import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import net.minecraft.world.item.Item;

public class TestWeapon extends Item implements IMoreAttributes {
    private Damage damage;

    public TestWeapon() {
        super(new Properties()
                .stacksTo(1)
                .fireResistant());

        damage.setBaseDamage(10.0f);
        damage.setDamageMultiplier(0.5f);
    }

    @Override
    public Damage getDamage() {
        return damage;
    }
}
