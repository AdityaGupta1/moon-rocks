package org.sdoaj.moonrocks.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class EraserItem extends Item {
    public EraserItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        Style style = Style.EMPTY.createStyleFromFormattings(TextFormatting.DARK_PURPLE, TextFormatting.ITALIC);
        tooltip.add(new StringTextComponent("There are many things").setStyle(style));
        tooltip.add(new StringTextComponent("that need to be erased").setStyle(style));
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        target.remove();
        stack.damageItem(1, player, p -> p.sendBreakAnimation(hand));
        return ActionResultType.SUCCESS;
    }
}
