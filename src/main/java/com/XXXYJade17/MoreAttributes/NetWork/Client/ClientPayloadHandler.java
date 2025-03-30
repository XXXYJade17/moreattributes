package com.XXXYJade17.MoreAttributes.NetWork.Client;

import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDamage;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ClientPayloadHandler {
    private static ClientPayloadHandler INSTANCE;

    private static float clientDamage;
    private static float clientDamageMultiplier;

    public static ClientPayloadHandler getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ClientPayloadHandler();
        }
        return INSTANCE;
    }

    public void handleDamageData(PlayerDamage pDamage, PlayPayloadContext context) {
        clientDamage=pDamage.damage();
        clientDamageMultiplier=pDamage.multiplier();
        System.out.println("Client received data damage: " + clientDamage + ", level: " + clientDamageMultiplier);
    }

    public float getClientDamage() {
        return clientDamage;
    }
    public float getClientDamageMultiplier() {
        return clientDamageMultiplier;
    }
}
