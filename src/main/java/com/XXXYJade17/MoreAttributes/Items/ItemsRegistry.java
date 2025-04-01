package com.XXXYJade17.MoreAttributes.Items;

import com.XXXYJade17.MoreAttributes.Items.Armor.TestHelmet;
import com.XXXYJade17.MoreAttributes.Items.Weapon.SimpleStick;
import com.XXXYJade17.MoreAttributes.Items.Weapon.TestWeapon;
import com.XXXYJade17.MoreAttributes.MoreAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemsRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, MoreAttributes.MODID);

    public static final Supplier<Item> Test_Weapon =
            ITEMS.register("test_weapon", TestWeapon::new);
    public static final Supplier<Item> Simple_Stick =
            ITEMS.register("simple_stick", SimpleStick::new);
    public static final Supplier<Item> Test_Helmet =
            ITEMS.register("test_helmet", TestHelmet::new);

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
