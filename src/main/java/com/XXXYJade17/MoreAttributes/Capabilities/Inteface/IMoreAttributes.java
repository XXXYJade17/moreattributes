package com.XXXYJade17.MoreAttributes.Capabilities.Inteface;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;

public interface IMoreAttributes {
    double getAttackRange();
    Damage getDamage();
    Crit getCrit();
}
