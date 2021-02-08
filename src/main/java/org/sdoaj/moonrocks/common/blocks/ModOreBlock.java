package org.sdoaj.moonrocks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class ModOreBlock extends Block {
    private final int expMin;
    private final int expMax;

    public ModOreBlock(Properties properties) {
        this(properties, 0, 0);
    }

    public ModOreBlock(Properties properties, int expMin, int expMax) {
        super(properties);
        this.expMin = expMin;
        this.expMax = expMax;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        if (expMin == 0 && expMax == 0) {
            return 0;
        }

        if (silktouch != 0) {
            return 0;
        }

        return MathHelper.nextInt(RANDOM, expMin, expMax);
    }
}
