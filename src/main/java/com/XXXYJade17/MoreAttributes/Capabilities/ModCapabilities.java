package com.XXXYJade17.MoreAttributes.Capabilities;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Capabilities.Damage.Damage;
import com.XXXYJade17.MoreAttributes.Capabilities.Defence.Defence;
import com.XXXYJade17.MoreAttributes.Capabilities.LifeSteal.LifeSteal;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.EntityCapability;

public class ModCapabilities {
    public static final EntityCapability<Damage, Void> DAMAGE_HANDLER =
            EntityCapability.createVoid(new ResourceLocation(MoreAttributes.MODID, "damage_handler"),
                    Damage.class);
    public static final EntityCapability<Crit, Void> CRIT_HANDLER =
            EntityCapability.createVoid(new ResourceLocation(MoreAttributes.MODID, "crit_handler"),
                    Crit.class);
    public static final EntityCapability<LifeSteal, Void> LIFE_STEAL_HANDLER =
            EntityCapability.createVoid(new ResourceLocation(MoreAttributes.MODID, "life_steal_handler"),
                    LifeSteal.class);
    public static final EntityCapability<Defence, Void> DEFENCE_HANDLER =
            EntityCapability.createVoid(new ResourceLocation(MoreAttributes.MODID, "defence_handler"),
                    Defence.class);
}
