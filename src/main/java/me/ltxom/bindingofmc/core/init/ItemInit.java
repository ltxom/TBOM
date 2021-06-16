package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.common.items.KeyToBasementItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
}
