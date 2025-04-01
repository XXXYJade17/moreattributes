package com.XXXYJade17.MoreAttributes.Capabilities.Inteface;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;

public interface IMoreAttributes {
    int getAttackRange();
    Damage getDamage();
    Crit getCrit();
    Defence getDefence();
}
