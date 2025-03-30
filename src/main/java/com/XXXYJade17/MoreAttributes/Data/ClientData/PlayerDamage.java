package com.XXXYJade17.MoreAttributes.Data.ClientData;

import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PlayerDamage(float damage, float multiplier) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MoreAttributes.MODID, "player_damage");

    public PlayerDamage(FriendlyByteBuf buf) {
        this(buf.readFloat(), buf.readFloat());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeFloat(damage);
        buf.writeFloat(multiplier);
    }

    public ResourceLocation id() {
        return ID;
    }
}
