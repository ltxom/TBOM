package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TBOMMain.MODID);

	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GREEN).
					hardnessAndResistance(15f, 30f).
					harvestTool(ToolType.PICKAXE).
					harvestLevel(1).
					sound(SoundType.METAL).setRequiresTool()));

}
