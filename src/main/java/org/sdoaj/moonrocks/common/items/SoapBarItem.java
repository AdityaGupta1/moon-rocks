package org.sdoaj.moonrocks.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SoapBarItem extends Item {
    private static final int amplifierMultiplier = 1;
    private static final int secondsPerDurability = 5;

    public SoapBarItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        Style style = Style.EMPTY.createStyleFromFormattings(TextFormatting.DARK_PURPLE, TextFormatting.ITALIC);
        tooltip.add(new StringTextComponent("I can also make bars of soap").setStyle(style));
        tooltip.add(new StringTextComponent("so I can be clean").setStyle(style));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        player.setActiveHand(hand);

//        List<EffectInstance> harmfulEffects = new ArrayList<>();
//        for (EffectInstance effect : player.getActivePotionEffects()) {
//            if (effect.getPotion().getEffectType() == EffectType.HARMFUL) {
//                harmfulEffects.add(effect);
//            }
//        }
//
//        EffectInstance effect = harmfulEffects.get(random.nextInt(harmfulEffects.size()));
//
//        int maxCost = amplifierMultiplier * (effect.getAmplifier() + 1);
//
//        if (getDamage(stack) >= maxCost) {
//
//        }
//
//        stack.damageItem(maxCost, player, p -> p.sendBreakAnimation(hand));

        return ActionResult.resultSuccess(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }
}
