package org.sdoaj.moonrocks.core;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sdoaj.moonrocks.core.init.ItemInit;

@Mod(MoonRocks.MODID)
public class MoonRocks {
    public static final String MODID = "moonrocks";

    private static final Logger LOGGER = LogManager.getLogger();

    public MoonRocks() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);

        ItemInit.REGISTRY.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("moon rocks setup");
    }
}
