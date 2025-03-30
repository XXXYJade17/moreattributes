package com.XXXYJade17.MoreAttributes.Items;

import com.XXXYJade17.MoreAttributes.Items.Weapon.TestWeapon;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemsRegistry {
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, MoreAttributes.MODID);

    private static final Supplier<Item> TestWeapon =
            ITEMS.register("test_weapon", TestWeapon::new);

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
