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
import org.sdoaj.moonrocks.core.MoonRocks;

@Mod.EventBusSubscriber(modid = MoonRocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MoonRocks.MODID);

    public static final RegistryObject<Item> MOON_ROCK = REGISTER.register("moon_rock",
            () -> new Item(defaultProperties()));

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.REGISTER.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final BlockItem blockItem = new BlockItem(block, defaultProperties());
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(ItemGroup.MISC);
    }
}
