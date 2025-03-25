package com.XXXYJade17.MoreAttributes.NetWork;

import com.XXXYJade17.MoreAttributes.AttributesData;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

//Sever to Client
public class ClientPayloadHandler {
    private static final ClientPayloadHandler instance = new ClientPayloadHandler();

    public static ClientPayloadHandler getInstance() {
        return instance;
    }

    public void handleAttributesData(final AttributesData data, final PlayPayloadContext context){
        context.workHandler().submitAsync(()->{
            //数据处理
        }).exceptionally(e->{
            context.packetHandler().disconnect(Component.literal("my_mod.networking.failed"));
            return null;
        });
    }
}
