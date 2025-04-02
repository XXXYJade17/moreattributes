package com.XXXYJade17.MoreAttributes.Data.ClientData;

import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record PlayerDefence(float defence) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MoreAttributes.MODID, "player_defence");

    PlayerDefence(FriendlyByteBuf buf){
        this(buf.readFloat());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeFloat(defence);
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}
