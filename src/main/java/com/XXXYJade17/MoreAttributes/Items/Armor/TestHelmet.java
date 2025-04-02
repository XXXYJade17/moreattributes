package com.XXXYJade17.MoreAttributes.Items.Armor;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.Inteface.IMoreAttributes;
import com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal.LifeSteal;
import net.minecraft.world.item.ArmorItem;

public class TestHelmet extends ArmorItem implements IMoreAttributes {
    public Defence defence;

    public TestHelmet(){
        super(new DefaultMaterial(), ArmorItem.Type.HELMET, new Properties()
                .stacksTo(1)
                .fireResistant());
        defence=new Defence();
        defence.setDefence(100);
    }

    @Override
    public int getAttackRange() {
        return 0;
    }

    @Override
    public Damage getDamage() {
        return null;
    }

    @Override
    public Crit getCrit() {
        return null;
    }

    @Override
    public Defence getDefence() {
        return defence;
    }

    @Override
    public LifeSteal getLifeSteal() {
        return null;
    }
}
