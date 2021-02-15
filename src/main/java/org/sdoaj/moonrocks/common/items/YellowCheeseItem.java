package org.sdoaj.moonrocks.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class YellowCheeseItem extends Item {
    public static final Food YELLOW_CHEESE = (new Food.Builder()).hunger(4).saturation(0.7F).build();

    public YellowCheeseItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        Style style = Style.EMPTY.createStyleFromFormattings(TextFormatting.DARK_PURPLE, TextFormatting.ITALIC);
        tooltip.add(new StringTextComponent("With my new factory,").setStyle(style));
        tooltip.add(new StringTextComponent("I can make yellow cheese").setStyle(style));
    }
}
