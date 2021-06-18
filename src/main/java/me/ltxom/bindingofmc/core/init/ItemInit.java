package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.common.items.KeyToBasementItem;
import me.ltxom.bindingofmc.common.items.KeyToBasementPieceItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    TBOMMain.MODID);

//	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register
//	("thebindindofmc_test_item",
//			() -> new Item(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
//
//	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register
//	("special_item",
//			() -> new SpecialItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static final RegistryObject<KeyToBasementItem> KEY_TO_BASEMENT_ITEM =
            ITEMS.register("key_to_basement_item",
                    () -> new KeyToBasementItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static final RegistryObject<KeyToBasementPieceItem> KEY_TO_BASEMENT_PIECE_ITEM_REGISTRY_OBJECT =
            ITEMS.register("key_to_basement_piece_item",
                    () -> new KeyToBasementPieceItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    // block items

    //	public static final RegistryObject<Item> TEST_BLOCK = ITEMS.register("test_block",
//			() -> new BlockItem(BlockInit.TEST_BLOCK.get(), new Item.Properties().group
//			(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<Item> BASEMENT_DOOR_BLOCK_ITEM = ITEMS.register(
            "basement_door_block",
            () -> new BlockItem(BlockInit.BASEMENT_DOOR_BLOCK_REGISTRY_OBJECT.get(),
                    new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static final RegistryObject<Item> OPENED_BASEMENT_DOOR_BLOCK_ITEM = ITEMS.register(
            "opened_basement_door_block",
            () -> new BlockItem(BlockInit.OPENED_BASEMENT_DOOR_BLOCK_REGISTRY_OBJECT.get(),
                    new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    /*
     * spawn eggs */
    public static final RegistryObject<SpawnEggItem> MOTHER_SPAWN_EGG = ITEMS.register(
            "mother_spawn_egg", () -> new SpawnEggItem(EntityInit.MOTHER, 0x47CC3B,
                    0xC03BCC, new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static void initializeDispenserBehaviors() {
        // Copied from IDispenseItemBehavior
        DefaultDispenseItemBehavior defaultdispenseitembehavior =
                new DefaultDispenseItemBehavior() {
                    /**
                     * Dispense the specified stack, play the dispense sound and spawn
                     * particles.
                     */
                    public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                        Direction direction =
                                source.getBlockState().get(DispenserBlock.FACING);
                        EntityType<?> entitytype =
                                ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                        entitytype.spawn(source.getWorld(), stack, null,
                                source.getBlockPos().offset(direction), SpawnReason.DISPENSER,
                                direction != Direction.UP, false);
                        stack.shrink(1);
                        return stack;
                    }
                };
        SpawnEggItem[] spawnEggItems = new SpawnEggItem[]{
                MOTHER_SPAWN_EGG.get(),
        };
        for (SpawnEggItem spawneggitem : spawnEggItems) {
            DispenserBlock.registerDispenseBehavior(spawneggitem, defaultdispenseitembehavior);
        }

    }

}
