package org.sdoaj.moonrocks.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.sdoaj.moonrocks.core.init.ItemInit;

public class MoonRocksItemGroup extends ItemGroup {
    public static final MoonRocksItemGroup INSTANCE = new MoonRocksItemGroup();

    private MoonRocksItemGroup() {
        super(MoonRocks.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return ItemInit.MOON_ROCK.get().getDefaultInstance();
    }
}
