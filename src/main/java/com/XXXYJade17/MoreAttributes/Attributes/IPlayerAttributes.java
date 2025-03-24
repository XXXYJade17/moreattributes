package com.XXXYJade17.MoreAttributes.Attributes;

import net.minecraft.world.entity.player.Player;

public interface IPlayerAttributes {
    PlayerAttributeSystem getAttributes();
    void recalculateAttributes(Player player);
}
