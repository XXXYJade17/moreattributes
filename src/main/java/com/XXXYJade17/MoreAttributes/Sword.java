package com.XXXYJade17.MoreAttributes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class Sword extends Item implements PlayerAttributesProvider {
    private final IPlayerAttributes attributes=this.getAttributes();

    public Sword(){
        super(new Item.Properties());
        setAttributes();
    }

    private void setAttributes(){
        attributes.setAttackDamage(5.0f);
        attributes.setDamageMultiplier(0.5f);
        attributes.setCritChance(0.5f);
        attributes.setCritMultiplier(2.0f);
    }

}
