package org.sdoaj.moonrocks.core.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.sdoaj.moonrocks.common.items.EraserItem;
import org.sdoaj.moonrocks.common.items.SoapBarItem;
import org.sdoaj.moonrocks.core.MoonRocks;
import org.sdoaj.moonrocks.core.MoonRocksItemGroup;

@Mod.EventBusSubscriber(modid = MoonRocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MoonRocks.MODID);

    public static final RegistryObject<Item> MOON_ROCK = defaultItem("moon_rock");
    public static final RegistryObject<Item> MOON_ROCK_CLUMP = defaultItem("moon_rock_clump");
    public static final RegistryObject<Item> MOON_CRYSTAL = defaultItem("moon_crystal");

    public static final RegistryObject<Item> ERASER = REGISTER.register("eraser",
            () -> new EraserItem(defaultProperties().defaultMaxDamage(100)));
    public static final RegistryObject<Item> BAR_OF_SOAP = REGISTER.register("bar_of_soap",
            () -> new SoapBarItem(defaultProperties().defaultMaxDamage(1000)));

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.REGISTER.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final BlockItem blockItem = new BlockItem(block, defaultProperties());
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private static RegistryObject<Item> defaultItem(String name) {
        return REGISTER.register(name, () -> new Item(defaultProperties()));
    }

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(MoonRocksItemGroup.INSTANCE);
    }
}
