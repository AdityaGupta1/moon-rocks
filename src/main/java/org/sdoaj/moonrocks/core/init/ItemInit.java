package org.sdoaj.moonrocks.core.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.sdoaj.moonrocks.core.MoonRocks;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MoonRocks.MODID);

    public static final RegistryObject<Item> MOON_ROCK = REGISTRY.register("moon_rock", defaultItemSupplier());

    private static Supplier<Item> defaultItemSupplier() {
        return () -> new Item(new Item.Properties().group(ItemGroup.MISC));
    }
}
