package org.sdoaj.moonrocks.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.sdoaj.moonrocks.core.MoonRocks;

public class BlockInit {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MoonRocks.MODID);

    public static final RegistryObject<Block> MOON_ROCK_ORE = REGISTER.register("moon_rock_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(5, 4)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .setRequiresTool()));
}
