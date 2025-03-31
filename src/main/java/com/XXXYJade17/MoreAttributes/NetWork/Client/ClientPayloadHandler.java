package com.XXXYJade17.MoreAttributes.NetWork.Client;

import com.XXXYJade17.MoreAttributes.Capabilities.Crit.Crit;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerCrit;
import com.XXXYJade17.MoreAttributes.Data.ClientData.PlayerDamage;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class ClientPayloadHandler {
    private static ClientPayloadHandler INSTANCE;

    private static float clientDamage;
    private static float clientDamageMultiplier;
    private static float clientCritRate;
    private static float clientCritMultiplier;

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

    public void handelCritData(PlayerCrit pCrit, PlayPayloadContext context){
        clientCritRate=pCrit.rate();
        clientCritMultiplier=pCrit.multiplier();
        System.out.println("Client received data critRate: " + clientCritRate + ", level: " + clientCritMultiplier);
    }

    public float getClientDamage() {
        return clientDamage;
    }
    public float getClientDamageMultiplier() {
        return clientDamageMultiplier;
    }
    public float getClientCritRate() {
        return clientCritRate;
    }
    public float getClientCritMultiplier() {
        return clientCritMultiplier;
    }
}
