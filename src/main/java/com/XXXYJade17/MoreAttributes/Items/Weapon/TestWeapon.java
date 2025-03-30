package com.XXXYJade17.MoreAttributes.Items.Weapon;

import net.minecraft.world.item.Item;

public class TestWeapon extends Item {
    public TestWeapon() {
        super(new Properties()
                .stacksTo(1)
                .fireResistant());
    }
}
