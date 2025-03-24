package com.XXXYJade17.MoreAttributes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record AttributesData(String attribute,float value) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MoreAttributes.MODID,"attributes_data");

    public AttributesData(final FriendlyByteBuf buf){
        this(buf.readUtf(),buf.readInt());
    }
    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeUtf(attribute());
        buf.writeFloat(value());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}
