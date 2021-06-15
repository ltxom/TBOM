package me.ltxom.bindingofmc.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialItem extends Item {
	public SpecialItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 5));
			playerIn.getCooldownTracker().setCooldown(this, 24 * 10);
			return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
		}
		return ActionResult.resultFail(playerIn.getHeldItem(handIn));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
							   ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
			tooltip.add(new TranslationTextComponent("tooltip.bindingofminecraft.special_item.test_tooltip"));
		}else{
			tooltip.add(new StringTextComponent("Hold SHIFT for more info."));
		}
	}
}
