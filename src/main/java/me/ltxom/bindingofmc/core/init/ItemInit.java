package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.common.items.KeyToBasementItem;
import me.ltxom.bindingofmc.common.items.KeyToBasementPieceItem;
import me.ltxom.bindingofmc.common.items.MotherKnifeItem;
import me.ltxom.bindingofmc.common.items.collectibles.*;
import me.ltxom.bindingofmc.common.items.hearts.*;
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

    public static final RegistryObject<MotherKnifeItem> MOTHER_KNIFE_ITEM = ITEMS.register
            ("mother_knife_item",
                    () -> new MotherKnifeItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static final RegistryObject<KeyToBasementItem> KEY_TO_BASEMENT_ITEM =
            ITEMS.register("key_to_basement_item",
                    () -> new KeyToBasementItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    public static final RegistryObject<KeyToBasementPieceItem> KEY_TO_BASEMENT_PIECE_ITEM_REGISTRY_OBJECT =
            ITEMS.register("key_to_basement_piece_item",
                    () -> new KeyToBasementPieceItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

    // hearts
    public static final RegistryObject<BlackHeartItem> BLACK_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("black_heart",
                    () -> new BlackHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<BoneHeartItem> BONE_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("bone_heart",
                    () -> new BoneHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<HalfBlackHeartItem> HALF_BLACK_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("half_black_heart",
                    () -> new HalfBlackHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<HalfRedHeartItem> HALF_RED_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("half_red_heart",
                    () -> new HalfRedHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<HalfSoulHeartItem> HALF_SOUL_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("half_soul_heart",
                    () -> new HalfSoulHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<RedBlackHeartItem> RED_BLACK_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("red_black_heart",
                    () -> new RedBlackHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<RedHeartItem> RED_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("red_heart",
                    () -> new RedHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<SoulHeartItem> SOUL_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("soul_heart",
                    () -> new SoulHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<SoulRedHeartItem> SOUL_RED_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("soul_red_heart",
                    () -> new SoulRedHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));
    public static final RegistryObject<WhiteHeartItem> WHITE_HEART_ITEM_REGISTRY_OBJECT = ITEMS.register
            ("white_heart",
                    () -> new WhiteHeartItem(new Item.Properties().group(TBOMMain.ITEM_GROUP)));

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



    // Collectibles
    public static final RegistryObject<collectibles001thesadonion> COLLECTIBLES_001_THESADONION_ITEM = ITEMS
            .register
                    ("collectibles_001_thesadonion_item",
                            () -> new collectibles001thesadonion(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles002theinnereye> COLLECTIBLES_002_THEINNEREYE_ITEM = ITEMS
            .register
                    ("collectibles_002_theinnereye_item",
                            () -> new collectibles002theinnereye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles003spoonbender> COLLECTIBLES_003_SPOONBENDER_ITEM = ITEMS
            .register
                    ("collectibles_003_spoonbender_item",
                            () -> new collectibles003spoonbender(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles004cricketshead> COLLECTIBLES_004_CRICKETSHEAD_ITEM = ITEMS
            .register
                    ("collectibles_004_cricketshead_item",
                            () -> new collectibles004cricketshead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles005myreflection> COLLECTIBLES_005_MYREFLECTION_ITEM = ITEMS
            .register
                    ("collectibles_005_myreflection_item",
                            () -> new collectibles005myreflection(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles006numberone> COLLECTIBLES_006_NUMBERONE_ITEM = ITEMS
            .register
                    ("collectibles_006_numberone_item",
                            () -> new collectibles006numberone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles007bloodofthemartyr> COLLECTIBLES_007_BLOODOFTHEMARTYR_ITEM = ITEMS
            .register
                    ("collectibles_007_bloodofthemartyr_item",
                            () -> new collectibles007bloodofthemartyr(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles008brotherbobby> COLLECTIBLES_008_BROTHERBOBBY_ITEM = ITEMS
            .register
                    ("collectibles_008_brotherbobby_item",
                            () -> new collectibles008brotherbobby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles009skatole> COLLECTIBLES_009_SKATOLE_ITEM = ITEMS
            .register
                    ("collectibles_009_skatole_item",
                            () -> new collectibles009skatole(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles010haloofflies> COLLECTIBLES_010_HALOOFFLIES_ITEM = ITEMS
            .register
                    ("collectibles_010_haloofflies_item",
                            () -> new collectibles010haloofflies(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles0111up> COLLECTIBLES_011_1UP_ITEM = ITEMS
            .register
                    ("collectibles_011_1up_item",
                            () -> new collectibles0111up(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles012magicmushroom> COLLECTIBLES_012_MAGICMUSHROOM_ITEM = ITEMS
            .register
                    ("collectibles_012_magicmushroom_item",
                            () -> new collectibles012magicmushroom(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles013thevirus> COLLECTIBLES_013_THEVIRUS_ITEM = ITEMS
            .register
                    ("collectibles_013_thevirus_item",
                            () -> new collectibles013thevirus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles014roidrage> COLLECTIBLES_014_ROIDRAGE_ITEM = ITEMS
            .register
                    ("collectibles_014_roidrage_item",
                            () -> new collectibles014roidrage(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles015heart> COLLECTIBLES_015_HEART_ITEM = ITEMS
            .register
                    ("collectibles_015_heart_item",
                            () -> new collectibles015heart(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles016rawliver> COLLECTIBLES_016_RAWLIVER_ITEM = ITEMS
            .register
                    ("collectibles_016_rawliver_item",
                            () -> new collectibles016rawliver(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles017skeletonkey> COLLECTIBLES_017_SKELETONKEY_ITEM = ITEMS
            .register
                    ("collectibles_017_skeletonkey_item",
                            () -> new collectibles017skeletonkey(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles018adollar> COLLECTIBLES_018_ADOLLAR_ITEM = ITEMS
            .register
                    ("collectibles_018_adollar_item",
                            () -> new collectibles018adollar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles019boom> COLLECTIBLES_019_BOOM_ITEM = ITEMS
            .register
                    ("collectibles_019_boom_item",
                            () -> new collectibles019boom(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles020transcendence> COLLECTIBLES_020_TRANSCENDENCE_ITEM = ITEMS
            .register
                    ("collectibles_020_transcendence_item",
                            () -> new collectibles020transcendence(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles021thecompass> COLLECTIBLES_021_THECOMPASS_ITEM = ITEMS
            .register
                    ("collectibles_021_thecompass_item",
                            () -> new collectibles021thecompass(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles022lunch> COLLECTIBLES_022_LUNCH_ITEM = ITEMS
            .register
                    ("collectibles_022_lunch_item",
                            () -> new collectibles022lunch(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles023dinner> COLLECTIBLES_023_DINNER_ITEM = ITEMS
            .register
                    ("collectibles_023_dinner_item",
                            () -> new collectibles023dinner(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles024dessert> COLLECTIBLES_024_DESSERT_ITEM = ITEMS
            .register
                    ("collectibles_024_dessert_item",
                            () -> new collectibles024dessert(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles025breakfast> COLLECTIBLES_025_BREAKFAST_ITEM = ITEMS
            .register
                    ("collectibles_025_breakfast_item",
                            () -> new collectibles025breakfast(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles026rottenmeat> COLLECTIBLES_026_ROTTENMEAT_ITEM = ITEMS
            .register
                    ("collectibles_026_rottenmeat_item",
                            () -> new collectibles026rottenmeat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles027woodenspoon> COLLECTIBLES_027_WOODENSPOON_ITEM = ITEMS
            .register
                    ("collectibles_027_woodenspoon_item",
                            () -> new collectibles027woodenspoon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles028thebelt> COLLECTIBLES_028_THEBELT_ITEM = ITEMS
            .register
                    ("collectibles_028_thebelt_item",
                            () -> new collectibles028thebelt(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles029momsunderwear> COLLECTIBLES_029_MOMSUNDERWEAR_ITEM = ITEMS
            .register
                    ("collectibles_029_momsunderwear_item",
                            () -> new collectibles029momsunderwear(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles030momsheels> COLLECTIBLES_030_MOMSHEELS_ITEM = ITEMS
            .register
                    ("collectibles_030_momsheels_item",
                            () -> new collectibles030momsheels(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles031momslipstick> COLLECTIBLES_031_MOMSLIPSTICK_ITEM = ITEMS
            .register
                    ("collectibles_031_momslipstick_item",
                            () -> new collectibles031momslipstick(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles032wirecoathanger> COLLECTIBLES_032_WIRECOATHANGER_ITEM = ITEMS
            .register
                    ("collectibles_032_wirecoathanger_item",
                            () -> new collectibles032wirecoathanger(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles033thebible> COLLECTIBLES_033_THEBIBLE_ITEM = ITEMS
            .register
                    ("collectibles_033_thebible_item",
                            () -> new collectibles033thebible(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles034thebookofbelial> COLLECTIBLES_034_THEBOOKOFBELIAL_ITEM = ITEMS
            .register
                    ("collectibles_034_thebookofbelial_item",
                            () -> new collectibles034thebookofbelial(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles035thenecronomicon> COLLECTIBLES_035_THENECRONOMICON_ITEM = ITEMS
            .register
                    ("collectibles_035_thenecronomicon_item",
                            () -> new collectibles035thenecronomicon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles036thepoop> COLLECTIBLES_036_THEPOOP_ITEM = ITEMS
            .register
                    ("collectibles_036_thepoop_item",
                            () -> new collectibles036thepoop(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles037mrboom> COLLECTIBLES_037_MRBOOM_ITEM = ITEMS
            .register
                    ("collectibles_037_mrboom_item",
                            () -> new collectibles037mrboom(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles038tammyshead> COLLECTIBLES_038_TAMMYSHEAD_ITEM = ITEMS
            .register
                    ("collectibles_038_tammyshead_item",
                            () -> new collectibles038tammyshead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles039momsbra> COLLECTIBLES_039_MOMSBRA_ITEM = ITEMS
            .register
                    ("collectibles_039_momsbra_item",
                            () -> new collectibles039momsbra(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles040kamikaze> COLLECTIBLES_040_KAMIKAZE_ITEM = ITEMS
            .register
                    ("collectibles_040_kamikaze_item",
                            () -> new collectibles040kamikaze(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles041momspad> COLLECTIBLES_041_MOMSPAD_ITEM = ITEMS
            .register
                    ("collectibles_041_momspad_item",
                            () -> new collectibles041momspad(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles042bobsrottenhead> COLLECTIBLES_042_BOBSROTTENHEAD_ITEM = ITEMS
            .register
                    ("collectibles_042_bobsrottenhead_item",
                            () -> new collectibles042bobsrottenhead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles044teleport> COLLECTIBLES_044_TELEPORT_ITEM = ITEMS
            .register
                    ("collectibles_044_teleport_item",
                            () -> new collectibles044teleport(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles045yumheart> COLLECTIBLES_045_YUMHEART_ITEM = ITEMS
            .register
                    ("collectibles_045_yumheart_item",
                            () -> new collectibles045yumheart(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles046luckyfoot> COLLECTIBLES_046_LUCKYFOOT_ITEM = ITEMS
            .register
                    ("collectibles_046_luckyfoot_item",
                            () -> new collectibles046luckyfoot(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles047doctorsremote> COLLECTIBLES_047_DOCTORSREMOTE_ITEM = ITEMS
            .register
                    ("collectibles_047_doctorsremote_item",
                            () -> new collectibles047doctorsremote(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles048cupidsarrow> COLLECTIBLES_048_CUPIDSARROW_ITEM = ITEMS
            .register
                    ("collectibles_048_cupidsarrow_item",
                            () -> new collectibles048cupidsarrow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles049shoopdawhoop> COLLECTIBLES_049_SHOOPDAWHOOP_ITEM = ITEMS
            .register
                    ("collectibles_049_shoopdawhoop_item",
                            () -> new collectibles049shoopdawhoop(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles050steven> COLLECTIBLES_050_STEVEN_ITEM = ITEMS
            .register
                    ("collectibles_050_steven_item",
                            () -> new collectibles050steven(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles051pentagram> COLLECTIBLES_051_PENTAGRAM_ITEM = ITEMS
            .register
                    ("collectibles_051_pentagram_item",
                            () -> new collectibles051pentagram(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles052drfetus> COLLECTIBLES_052_DRFETUS_ITEM = ITEMS
            .register
                    ("collectibles_052_drfetus_item",
                            () -> new collectibles052drfetus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles053magneto> COLLECTIBLES_053_MAGNETO_ITEM = ITEMS
            .register
                    ("collectibles_053_magneto_item",
                            () -> new collectibles053magneto(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles054treasuremap> COLLECTIBLES_054_TREASUREMAP_ITEM = ITEMS
            .register
                    ("collectibles_054_treasuremap_item",
                            () -> new collectibles054treasuremap(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles055momseye> COLLECTIBLES_055_MOMSEYE_ITEM = ITEMS
            .register
                    ("collectibles_055_momseye_item",
                            () -> new collectibles055momseye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles056lemonmishap> COLLECTIBLES_056_LEMONMISHAP_ITEM = ITEMS
            .register
                    ("collectibles_056_lemonmishap_item",
                            () -> new collectibles056lemonmishap(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles057distantadmiration> COLLECTIBLES_057_DISTANTADMIRATION_ITEM = ITEMS
            .register
                    ("collectibles_057_distantadmiration_item",
                            () -> new collectibles057distantadmiration(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles058bookofshadows> COLLECTIBLES_058_BOOKOFSHADOWS_ITEM = ITEMS
            .register
                    ("collectibles_058_bookofshadows_item",
                            () -> new collectibles058bookofshadows(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles060theladder> COLLECTIBLES_060_THELADDER_ITEM = ITEMS
            .register
                    ("collectibles_060_theladder_item",
                            () -> new collectibles060theladder(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles062charmofthevampire> COLLECTIBLES_062_CHARMOFTHEVAMPIRE_ITEM = ITEMS
            .register
                    ("collectibles_062_charmofthevampire_item",
                            () -> new collectibles062charmofthevampire(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles063thebattery> COLLECTIBLES_063_THEBATTERY_ITEM = ITEMS
            .register
                    ("collectibles_063_thebattery_item",
                            () -> new collectibles063thebattery(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles064steamsale> COLLECTIBLES_064_STEAMSALE_ITEM = ITEMS
            .register
                    ("collectibles_064_steamsale_item",
                            () -> new collectibles064steamsale(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles065anarchistcookbook> COLLECTIBLES_065_ANARCHISTCOOKBOOK_ITEM = ITEMS
            .register
                    ("collectibles_065_anarchistcookbook_item",
                            () -> new collectibles065anarchistcookbook(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles066thehourglass> COLLECTIBLES_066_THEHOURGLASS_ITEM = ITEMS
            .register
                    ("collectibles_066_thehourglass_item",
                            () -> new collectibles066thehourglass(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles067sistermaggy> COLLECTIBLES_067_SISTERMAGGY_ITEM = ITEMS
            .register
                    ("collectibles_067_sistermaggy_item",
                            () -> new collectibles067sistermaggy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles068technology> COLLECTIBLES_068_TECHNOLOGY_ITEM = ITEMS
            .register
                    ("collectibles_068_technology_item",
                            () -> new collectibles068technology(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles069chocolatemilk> COLLECTIBLES_069_CHOCOLATEMILK_ITEM = ITEMS
            .register
                    ("collectibles_069_chocolatemilk_item",
                            () -> new collectibles069chocolatemilk(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles070growthhormones> COLLECTIBLES_070_GROWTHHORMONES_ITEM = ITEMS
            .register
                    ("collectibles_070_growthhormones_item",
                            () -> new collectibles070growthhormones(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles071minimushroom> COLLECTIBLES_071_MINIMUSHROOM_ITEM = ITEMS
            .register
                    ("collectibles_071_minimushroom_item",
                            () -> new collectibles071minimushroom(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles072rosary> COLLECTIBLES_072_ROSARY_ITEM = ITEMS
            .register
                    ("collectibles_072_rosary_item",
                            () -> new collectibles072rosary(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles073cubeofmeat> COLLECTIBLES_073_CUBEOFMEAT_ITEM = ITEMS
            .register
                    ("collectibles_073_cubeofmeat_item",
                            () -> new collectibles073cubeofmeat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles074aquarter> COLLECTIBLES_074_AQUARTER_ITEM = ITEMS
            .register
                    ("collectibles_074_aquarter_item",
                            () -> new collectibles074aquarter(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles075phd> COLLECTIBLES_075_PHD_ITEM = ITEMS
            .register
                    ("collectibles_075_phd_item",
                            () -> new collectibles075phd(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles076xrayvision> COLLECTIBLES_076_XRAYVISION_ITEM = ITEMS
            .register
                    ("collectibles_076_xrayvision_item",
                            () -> new collectibles076xrayvision(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles077mylittleunicorn> COLLECTIBLES_077_MYLITTLEUNICORN_ITEM = ITEMS
            .register
                    ("collectibles_077_mylittleunicorn_item",
                            () -> new collectibles077mylittleunicorn(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles078bookofrevelations> COLLECTIBLES_078_BOOKOFREVELATIONS_ITEM = ITEMS
            .register
                    ("collectibles_078_bookofrevelations_item",
                            () -> new collectibles078bookofrevelations(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles079themark> COLLECTIBLES_079_THEMARK_ITEM = ITEMS
            .register
                    ("collectibles_079_themark_item",
                            () -> new collectibles079themark(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles080thepact> COLLECTIBLES_080_THEPACT_ITEM = ITEMS
            .register
                    ("collectibles_080_thepact_item",
                            () -> new collectibles080thepact(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles081deadcat> COLLECTIBLES_081_DEADCAT_ITEM = ITEMS
            .register
                    ("collectibles_081_deadcat_item",
                            () -> new collectibles081deadcat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles082lordofthepit> COLLECTIBLES_082_LORDOFTHEPIT_ITEM = ITEMS
            .register
                    ("collectibles_082_lordofthepit_item",
                            () -> new collectibles082lordofthepit(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles083thenail> COLLECTIBLES_083_THENAIL_ITEM = ITEMS
            .register
                    ("collectibles_083_thenail_item",
                            () -> new collectibles083thenail(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles084weneedtogodeeper> COLLECTIBLES_084_WENEEDTOGODEEPER_ITEM = ITEMS
            .register
                    ("collectibles_084_weneedtogodeeper_item",
                            () -> new collectibles084weneedtogodeeper(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles085deckofcards> COLLECTIBLES_085_DECKOFCARDS_ITEM = ITEMS
            .register
                    ("collectibles_085_deckofcards_item",
                            () -> new collectibles085deckofcards(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles086monstrostooth> COLLECTIBLES_086_MONSTROSTOOTH_ITEM = ITEMS
            .register
                    ("collectibles_086_monstrostooth_item",
                            () -> new collectibles086monstrostooth(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles087lokishorns> COLLECTIBLES_087_LOKISHORNS_ITEM = ITEMS
            .register
                    ("collectibles_087_lokishorns_item",
                            () -> new collectibles087lokishorns(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles088littlechubby> COLLECTIBLES_088_LITTLECHUBBY_ITEM = ITEMS
            .register
                    ("collectibles_088_littlechubby_item",
                            () -> new collectibles088littlechubby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles089spidersbite> COLLECTIBLES_089_SPIDERSBITE_ITEM = ITEMS
            .register
                    ("collectibles_089_spidersbite_item",
                            () -> new collectibles089spidersbite(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles090smallrock> COLLECTIBLES_090_SMALLROCK_ITEM = ITEMS
            .register
                    ("collectibles_090_smallrock_item",
                            () -> new collectibles090smallrock(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles091spelunkerhat> COLLECTIBLES_091_SPELUNKERHAT_ITEM = ITEMS
            .register
                    ("collectibles_091_spelunkerhat_item",
                            () -> new collectibles091spelunkerhat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles092superbandage> COLLECTIBLES_092_SUPERBANDAGE_ITEM = ITEMS
            .register
                    ("collectibles_092_superbandage_item",
                            () -> new collectibles092superbandage(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles093thegamekid> COLLECTIBLES_093_THEGAMEKID_ITEM = ITEMS
            .register
                    ("collectibles_093_thegamekid_item",
                            () -> new collectibles093thegamekid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles094sackofpennies> COLLECTIBLES_094_SACKOFPENNIES_ITEM = ITEMS
            .register
                    ("collectibles_094_sackofpennies_item",
                            () -> new collectibles094sackofpennies(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles095robobaby> COLLECTIBLES_095_ROBOBABY_ITEM = ITEMS
            .register
                    ("collectibles_095_robobaby_item",
                            () -> new collectibles095robobaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles096littlechad> COLLECTIBLES_096_LITTLECHAD_ITEM = ITEMS
            .register
                    ("collectibles_096_littlechad_item",
                            () -> new collectibles096littlechad(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles097bookofsin> COLLECTIBLES_097_BOOKOFSIN_ITEM = ITEMS
            .register
                    ("collectibles_097_bookofsin_item",
                            () -> new collectibles097bookofsin(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles098therelic> COLLECTIBLES_098_THERELIC_ITEM = ITEMS
            .register
                    ("collectibles_098_therelic_item",
                            () -> new collectibles098therelic(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles099littlegish> COLLECTIBLES_099_LITTLEGISH_ITEM = ITEMS
            .register
                    ("collectibles_099_littlegish_item",
                            () -> new collectibles099littlegish(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles100littlesteve> COLLECTIBLES_100_LITTLESTEVE_ITEM = ITEMS
            .register
                    ("collectibles_100_littlesteve_item",
                            () -> new collectibles100littlesteve(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles101thehalo> COLLECTIBLES_101_THEHALO_ITEM = ITEMS
            .register
                    ("collectibles_101_thehalo_item",
                            () -> new collectibles101thehalo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles102momsbottleofpills> COLLECTIBLES_102_MOMSBOTTLEOFPILLS_ITEM = ITEMS
            .register
                    ("collectibles_102_momsbottleofpills_item",
                            () -> new collectibles102momsbottleofpills(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles103thecommoncold> COLLECTIBLES_103_THECOMMONCOLD_ITEM = ITEMS
            .register
                    ("collectibles_103_thecommoncold_item",
                            () -> new collectibles103thecommoncold(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles104theparasite> COLLECTIBLES_104_THEPARASITE_ITEM = ITEMS
            .register
                    ("collectibles_104_theparasite_item",
                            () -> new collectibles104theparasite(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles105dice> COLLECTIBLES_105_DICE_ITEM = ITEMS
            .register
                    ("collectibles_105_dice_item",
                            () -> new collectibles105dice(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles106mrmega> COLLECTIBLES_106_MRMEGA_ITEM = ITEMS
            .register
                    ("collectibles_106_mrmega_item",
                            () -> new collectibles106mrmega(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles107pinkingshears> COLLECTIBLES_107_PINKINGSHEARS_ITEM = ITEMS
            .register
                    ("collectibles_107_pinkingshears_item",
                            () -> new collectibles107pinkingshears(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles108thewafer> COLLECTIBLES_108_THEWAFER_ITEM = ITEMS
            .register
                    ("collectibles_108_thewafer_item",
                            () -> new collectibles108thewafer(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles109moneyispower> COLLECTIBLES_109_MONEYISPOWER_ITEM = ITEMS
            .register
                    ("collectibles_109_moneyispower_item",
                            () -> new collectibles109moneyispower(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles110momscontacts> COLLECTIBLES_110_MOMSCONTACTS_ITEM = ITEMS
            .register
                    ("collectibles_110_momscontacts_item",
                            () -> new collectibles110momscontacts(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles111thebean> COLLECTIBLES_111_THEBEAN_ITEM = ITEMS
            .register
                    ("collectibles_111_thebean_item",
                            () -> new collectibles111thebean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles112guardianangel> COLLECTIBLES_112_GUARDIANANGEL_ITEM = ITEMS
            .register
                    ("collectibles_112_guardianangel_item",
                            () -> new collectibles112guardianangel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles113demonbaby> COLLECTIBLES_113_DEMONBABY_ITEM = ITEMS
            .register
                    ("collectibles_113_demonbaby_item",
                            () -> new collectibles113demonbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles114momsknife> COLLECTIBLES_114_MOMSKNIFE_ITEM = ITEMS
            .register
                    ("collectibles_114_momsknife_item",
                            () -> new collectibles114momsknife(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles115ouijaboard> COLLECTIBLES_115_OUIJABOARD_ITEM = ITEMS
            .register
                    ("collectibles_115_ouijaboard_item",
                            () -> new collectibles115ouijaboard(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles1169volt> COLLECTIBLES_116_9VOLT_ITEM = ITEMS
            .register
                    ("collectibles_116_9volt_item",
                            () -> new collectibles1169volt(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles117deadbird> COLLECTIBLES_117_DEADBIRD_ITEM = ITEMS
            .register
                    ("collectibles_117_deadbird_item",
                            () -> new collectibles117deadbird(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles118brimstone> COLLECTIBLES_118_BRIMSTONE_ITEM = ITEMS
            .register
                    ("collectibles_118_brimstone_item",
                            () -> new collectibles118brimstone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles119bloodbag> COLLECTIBLES_119_BLOODBAG_ITEM = ITEMS
            .register
                    ("collectibles_119_bloodbag_item",
                            () -> new collectibles119bloodbag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles120oddmushroomthin> COLLECTIBLES_120_ODDMUSHROOMTHIN_ITEM = ITEMS
            .register
                    ("collectibles_120_oddmushroomthin_item",
                            () -> new collectibles120oddmushroomthin(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles121oddmushroomlarge> COLLECTIBLES_121_ODDMUSHROOMLARGE_ITEM = ITEMS
            .register
                    ("collectibles_121_oddmushroomlarge_item",
                            () -> new collectibles121oddmushroomlarge(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles122whoreofbabylon> COLLECTIBLES_122_WHOREOFBABYLON_ITEM = ITEMS
            .register
                    ("collectibles_122_whoreofbabylon_item",
                            () -> new collectibles122whoreofbabylon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles123monstermanual> COLLECTIBLES_123_MONSTERMANUAL_ITEM = ITEMS
            .register
                    ("collectibles_123_monstermanual_item",
                            () -> new collectibles123monstermanual(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles124deadseascrolls> COLLECTIBLES_124_DEADSEASCROLLS_ITEM = ITEMS
            .register
                    ("collectibles_124_deadseascrolls_item",
                            () -> new collectibles124deadseascrolls(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles125bobbybomb> COLLECTIBLES_125_BOBBYBOMB_ITEM = ITEMS
            .register
                    ("collectibles_125_bobbybomb_item",
                            () -> new collectibles125bobbybomb(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles126razorblade> COLLECTIBLES_126_RAZORBLADE_ITEM = ITEMS
            .register
                    ("collectibles_126_razorblade_item",
                            () -> new collectibles126razorblade(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles127forgetmenow> COLLECTIBLES_127_FORGETMENOW_ITEM = ITEMS
            .register
                    ("collectibles_127_forgetmenow_item",
                            () -> new collectibles127forgetmenow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles128foreveralone> COLLECTIBLES_128_FOREVERALONE_ITEM = ITEMS
            .register
                    ("collectibles_128_foreveralone_item",
                            () -> new collectibles128foreveralone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles129bucketoflard> COLLECTIBLES_129_BUCKETOFLARD_ITEM = ITEMS
            .register
                    ("collectibles_129_bucketoflard_item",
                            () -> new collectibles129bucketoflard(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles130apony> COLLECTIBLES_130_APONY_ITEM = ITEMS
            .register
                    ("collectibles_130_apony_item",
                            () -> new collectibles130apony(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles131bombbag> COLLECTIBLES_131_BOMBBAG_ITEM = ITEMS
            .register
                    ("collectibles_131_bombbag_item",
                            () -> new collectibles131bombbag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles132alumpofcoal> COLLECTIBLES_132_ALUMPOFCOAL_ITEM = ITEMS
            .register
                    ("collectibles_132_alumpofcoal_item",
                            () -> new collectibles132alumpofcoal(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles133guppyspaw> COLLECTIBLES_133_GUPPYSPAW_ITEM = ITEMS
            .register
                    ("collectibles_133_guppyspaw_item",
                            () -> new collectibles133guppyspaw(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles134guppystail> COLLECTIBLES_134_GUPPYSTAIL_ITEM = ITEMS
            .register
                    ("collectibles_134_guppystail_item",
                            () -> new collectibles134guppystail(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles135ivbag> COLLECTIBLES_135_IVBAG_ITEM = ITEMS
            .register
                    ("collectibles_135_ivbag_item",
                            () -> new collectibles135ivbag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles136bestfriend> COLLECTIBLES_136_BESTFRIEND_ITEM = ITEMS
            .register
                    ("collectibles_136_bestfriend_item",
                            () -> new collectibles136bestfriend(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles137remotedetonator> COLLECTIBLES_137_REMOTEDETONATOR_ITEM = ITEMS
            .register
                    ("collectibles_137_remotedetonator_item",
                            () -> new collectibles137remotedetonator(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles138stigmata> COLLECTIBLES_138_STIGMATA_ITEM = ITEMS
            .register
                    ("collectibles_138_stigmata_item",
                            () -> new collectibles138stigmata(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles139momspurse> COLLECTIBLES_139_MOMSPURSE_ITEM = ITEMS
            .register
                    ("collectibles_139_momspurse_item",
                            () -> new collectibles139momspurse(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles140bobscurse> COLLECTIBLES_140_BOBSCURSE_ITEM = ITEMS
            .register
                    ("collectibles_140_bobscurse_item",
                            () -> new collectibles140bobscurse(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles141pageantboy> COLLECTIBLES_141_PAGEANTBOY_ITEM = ITEMS
            .register
                    ("collectibles_141_pageantboy_item",
                            () -> new collectibles141pageantboy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles142scapular> COLLECTIBLES_142_SCAPULAR_ITEM = ITEMS
            .register
                    ("collectibles_142_scapular_item",
                            () -> new collectibles142scapular(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles143speedball> COLLECTIBLES_143_SPEEDBALL_ITEM = ITEMS
            .register
                    ("collectibles_143_speedball_item",
                            () -> new collectibles143speedball(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles144bumfriend> COLLECTIBLES_144_BUMFRIEND_ITEM = ITEMS
            .register
                    ("collectibles_144_bumfriend_item",
                            () -> new collectibles144bumfriend(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles145guppyshead> COLLECTIBLES_145_GUPPYSHEAD_ITEM = ITEMS
            .register
                    ("collectibles_145_guppyshead_item",
                            () -> new collectibles145guppyshead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles146prayercard> COLLECTIBLES_146_PRAYERCARD_ITEM = ITEMS
            .register
                    ("collectibles_146_prayercard_item",
                            () -> new collectibles146prayercard(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles147notchedaxe> COLLECTIBLES_147_NOTCHEDAXE_ITEM = ITEMS
            .register
                    ("collectibles_147_notchedaxe_item",
                            () -> new collectibles147notchedaxe(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles148infestation> COLLECTIBLES_148_INFESTATION_ITEM = ITEMS
            .register
                    ("collectibles_148_infestation_item",
                            () -> new collectibles148infestation(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles149ipecac> COLLECTIBLES_149_IPECAC_ITEM = ITEMS
            .register
                    ("collectibles_149_ipecac_item",
                            () -> new collectibles149ipecac(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles150toughlove> COLLECTIBLES_150_TOUGHLOVE_ITEM = ITEMS
            .register
                    ("collectibles_150_toughlove_item",
                            () -> new collectibles150toughlove(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles151themulligan> COLLECTIBLES_151_THEMULLIGAN_ITEM = ITEMS
            .register
                    ("collectibles_151_themulligan_item",
                            () -> new collectibles151themulligan(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles152technology2> COLLECTIBLES_152_TECHNOLOGY2_ITEM = ITEMS
            .register
                    ("collectibles_152_technology2_item",
                            () -> new collectibles152technology2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles153mutantspider> COLLECTIBLES_153_MUTANTSPIDER_ITEM = ITEMS
            .register
                    ("collectibles_153_mutantspider_item",
                            () -> new collectibles153mutantspider(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles154chemicalpeel> COLLECTIBLES_154_CHEMICALPEEL_ITEM = ITEMS
            .register
                    ("collectibles_154_chemicalpeel_item",
                            () -> new collectibles154chemicalpeel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles155thepeeper> COLLECTIBLES_155_THEPEEPER_ITEM = ITEMS
            .register
                    ("collectibles_155_thepeeper_item",
                            () -> new collectibles155thepeeper(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles156habit> COLLECTIBLES_156_HABIT_ITEM = ITEMS
            .register
                    ("collectibles_156_habit_item",
                            () -> new collectibles156habit(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles157bloodylust> COLLECTIBLES_157_BLOODYLUST_ITEM = ITEMS
            .register
                    ("collectibles_157_bloodylust_item",
                            () -> new collectibles157bloodylust(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles158crystalball> COLLECTIBLES_158_CRYSTALBALL_ITEM = ITEMS
            .register
                    ("collectibles_158_crystalball_item",
                            () -> new collectibles158crystalball(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles159spiritofthenight> COLLECTIBLES_159_SPIRITOFTHENIGHT_ITEM = ITEMS
            .register
                    ("collectibles_159_spiritofthenight_item",
                            () -> new collectibles159spiritofthenight(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles160crackthesky> COLLECTIBLES_160_CRACKTHESKY_ITEM = ITEMS
            .register
                    ("collectibles_160_crackthesky_item",
                            () -> new collectibles160crackthesky(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles161ankh> COLLECTIBLES_161_ANKH_ITEM = ITEMS
            .register
                    ("collectibles_161_ankh_item",
                            () -> new collectibles161ankh(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles162celticcross> COLLECTIBLES_162_CELTICCROSS_ITEM = ITEMS
            .register
                    ("collectibles_162_celticcross_item",
                            () -> new collectibles162celticcross(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles163ghostbaby> COLLECTIBLES_163_GHOSTBABY_ITEM = ITEMS
            .register
                    ("collectibles_163_ghostbaby_item",
                            () -> new collectibles163ghostbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles164bluecandle> COLLECTIBLES_164_BLUECANDLE_ITEM = ITEMS
            .register
                    ("collectibles_164_bluecandle_item",
                            () -> new collectibles164bluecandle(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles165catoninetails> COLLECTIBLES_165_CATONINETAILS_ITEM = ITEMS
            .register
                    ("collectibles_165_catoninetails_item",
                            () -> new collectibles165catoninetails(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles166d20> COLLECTIBLES_166_D20_ITEM = ITEMS
            .register
                    ("collectibles_166_d20_item",
                            () -> new collectibles166d20(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles167harlequinbaby> COLLECTIBLES_167_HARLEQUINBABY_ITEM = ITEMS
            .register
                    ("collectibles_167_harlequinbaby_item",
                            () -> new collectibles167harlequinbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles168epicfetus> COLLECTIBLES_168_EPICFETUS_ITEM = ITEMS
            .register
                    ("collectibles_168_epicfetus_item",
                            () -> new collectibles168epicfetus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles169polyphemus> COLLECTIBLES_169_POLYPHEMUS_ITEM = ITEMS
            .register
                    ("collectibles_169_polyphemus_item",
                            () -> new collectibles169polyphemus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles170daddylonglegs> COLLECTIBLES_170_DADDYLONGLEGS_ITEM = ITEMS
            .register
                    ("collectibles_170_daddylonglegs_item",
                            () -> new collectibles170daddylonglegs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles171spiderbutt> COLLECTIBLES_171_SPIDERBUTT_ITEM = ITEMS
            .register
                    ("collectibles_171_spiderbutt_item",
                            () -> new collectibles171spiderbutt(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles172sacrificialdagger> COLLECTIBLES_172_SACRIFICIALDAGGER_ITEM = ITEMS
            .register
                    ("collectibles_172_sacrificialdagger_item",
                            () -> new collectibles172sacrificialdagger(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles173mitre> COLLECTIBLES_173_MITRE_ITEM = ITEMS
            .register
                    ("collectibles_173_mitre_item",
                            () -> new collectibles173mitre(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles174rainbowbaby> COLLECTIBLES_174_RAINBOWBABY_ITEM = ITEMS
            .register
                    ("collectibles_174_rainbowbaby_item",
                            () -> new collectibles174rainbowbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles175dadskey> COLLECTIBLES_175_DADSKEY_ITEM = ITEMS
            .register
                    ("collectibles_175_dadskey_item",
                            () -> new collectibles175dadskey(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles176stemcells> COLLECTIBLES_176_STEMCELLS_ITEM = ITEMS
            .register
                    ("collectibles_176_stemcells_item",
                            () -> new collectibles176stemcells(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles177portableslot> COLLECTIBLES_177_PORTABLESLOT_ITEM = ITEMS
            .register
                    ("collectibles_177_portableslot_item",
                            () -> new collectibles177portableslot(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles178holywater> COLLECTIBLES_178_HOLYWATER_ITEM = ITEMS
            .register
                    ("collectibles_178_holywater_item",
                            () -> new collectibles178holywater(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles179fate> COLLECTIBLES_179_FATE_ITEM = ITEMS
            .register
                    ("collectibles_179_fate_item",
                            () -> new collectibles179fate(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles180blackbean> COLLECTIBLES_180_BLACKBEAN_ITEM = ITEMS
            .register
                    ("collectibles_180_blackbean_item",
                            () -> new collectibles180blackbean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles181whitepony> COLLECTIBLES_181_WHITEPONY_ITEM = ITEMS
            .register
                    ("collectibles_181_whitepony_item",
                            () -> new collectibles181whitepony(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles182sacredheart> COLLECTIBLES_182_SACREDHEART_ITEM = ITEMS
            .register
                    ("collectibles_182_sacredheart_item",
                            () -> new collectibles182sacredheart(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles183toothpicks> COLLECTIBLES_183_TOOTHPICKS_ITEM = ITEMS
            .register
                    ("collectibles_183_toothpicks_item",
                            () -> new collectibles183toothpicks(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles184holygrail> COLLECTIBLES_184_HOLYGRAIL_ITEM = ITEMS
            .register
                    ("collectibles_184_holygrail_item",
                            () -> new collectibles184holygrail(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles185deaddove> COLLECTIBLES_185_DEADDOVE_ITEM = ITEMS
            .register
                    ("collectibles_185_deaddove_item",
                            () -> new collectibles185deaddove(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles186bloodrights> COLLECTIBLES_186_BLOODRIGHTS_ITEM = ITEMS
            .register
                    ("collectibles_186_bloodrights_item",
                            () -> new collectibles186bloodrights(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles187guppyshairball> COLLECTIBLES_187_GUPPYSHAIRBALL_ITEM = ITEMS
            .register
                    ("collectibles_187_guppyshairball_item",
                            () -> new collectibles187guppyshairball(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles188abel> COLLECTIBLES_188_ABEL_ITEM = ITEMS
            .register
                    ("collectibles_188_abel_item",
                            () -> new collectibles188abel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles189smbsuperfan> COLLECTIBLES_189_SMBSUPERFAN_ITEM = ITEMS
            .register
                    ("collectibles_189_smbsuperfan_item",
                            () -> new collectibles189smbsuperfan(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles190pyro> COLLECTIBLES_190_PYRO_ITEM = ITEMS
            .register
                    ("collectibles_190_pyro_item",
                            () -> new collectibles190pyro(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles1913dollarbill> COLLECTIBLES_191_3DOLLARBILL_ITEM = ITEMS
            .register
                    ("collectibles_191_3dollarbill_item",
                            () -> new collectibles1913dollarbill(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles192telepathyfordummies> COLLECTIBLES_192_TELEPATHYFORDUMMIES_ITEM = ITEMS
            .register
                    ("collectibles_192_telepathyfordummies_item",
                            () -> new collectibles192telepathyfordummies(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles193meat> COLLECTIBLES_193_MEAT_ITEM = ITEMS
            .register
                    ("collectibles_193_meat_item",
                            () -> new collectibles193meat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles194magic8ball> COLLECTIBLES_194_MAGIC8BALL_ITEM = ITEMS
            .register
                    ("collectibles_194_magic8ball_item",
                            () -> new collectibles194magic8ball(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles195momscoinpurse> COLLECTIBLES_195_MOMSCOINPURSE_ITEM = ITEMS
            .register
                    ("collectibles_195_momscoinpurse_item",
                            () -> new collectibles195momscoinpurse(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles196squeezy> COLLECTIBLES_196_SQUEEZY_ITEM = ITEMS
            .register
                    ("collectibles_196_squeezy_item",
                            () -> new collectibles196squeezy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles197jesusjuice> COLLECTIBLES_197_JESUSJUICE_ITEM = ITEMS
            .register
                    ("collectibles_197_jesusjuice_item",
                            () -> new collectibles197jesusjuice(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles198box> COLLECTIBLES_198_BOX_ITEM = ITEMS
            .register
                    ("collectibles_198_box_item",
                            () -> new collectibles198box(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles199momskey> COLLECTIBLES_199_MOMSKEY_ITEM = ITEMS
            .register
                    ("collectibles_199_momskey_item",
                            () -> new collectibles199momskey(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles200momseyeshadow> COLLECTIBLES_200_MOMSEYESHADOW_ITEM = ITEMS
            .register
                    ("collectibles_200_momseyeshadow_item",
                            () -> new collectibles200momseyeshadow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles201ironbar> COLLECTIBLES_201_IRONBAR_ITEM = ITEMS
            .register
                    ("collectibles_201_ironbar_item",
                            () -> new collectibles201ironbar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles202midastouch> COLLECTIBLES_202_MIDASTOUCH_ITEM = ITEMS
            .register
                    ("collectibles_202_midastouch_item",
                            () -> new collectibles202midastouch(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles203humblingbundle> COLLECTIBLES_203_HUMBLINGBUNDLE_ITEM = ITEMS
            .register
                    ("collectibles_203_humblingbundle_item",
                            () -> new collectibles203humblingbundle(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles204fannypack> COLLECTIBLES_204_FANNYPACK_ITEM = ITEMS
            .register
                    ("collectibles_204_fannypack_item",
                            () -> new collectibles204fannypack(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles205sharpplug> COLLECTIBLES_205_SHARPPLUG_ITEM = ITEMS
            .register
                    ("collectibles_205_sharpplug_item",
                            () -> new collectibles205sharpplug(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles206guillotine> COLLECTIBLES_206_GUILLOTINE_ITEM = ITEMS
            .register
                    ("collectibles_206_guillotine_item",
                            () -> new collectibles206guillotine(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles207ballofbandages> COLLECTIBLES_207_BALLOFBANDAGES_ITEM = ITEMS
            .register
                    ("collectibles_207_ballofbandages_item",
                            () -> new collectibles207ballofbandages(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles208championbelt> COLLECTIBLES_208_CHAMPIONBELT_ITEM = ITEMS
            .register
                    ("collectibles_208_championbelt_item",
                            () -> new collectibles208championbelt(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles209buttbombs> COLLECTIBLES_209_BUTTBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_209_buttbombs_item",
                            () -> new collectibles209buttbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles210gnawedleaf> COLLECTIBLES_210_GNAWEDLEAF_ITEM = ITEMS
            .register
                    ("collectibles_210_gnawedleaf_item",
                            () -> new collectibles210gnawedleaf(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles211spiderbaby> COLLECTIBLES_211_SPIDERBABY_ITEM = ITEMS
            .register
                    ("collectibles_211_spiderbaby_item",
                            () -> new collectibles211spiderbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles212guppyscollar> COLLECTIBLES_212_GUPPYSCOLLAR_ITEM = ITEMS
            .register
                    ("collectibles_212_guppyscollar_item",
                            () -> new collectibles212guppyscollar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles213lostcontact> COLLECTIBLES_213_LOSTCONTACT_ITEM = ITEMS
            .register
                    ("collectibles_213_lostcontact_item",
                            () -> new collectibles213lostcontact(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles214anemic> COLLECTIBLES_214_ANEMIC_ITEM = ITEMS
            .register
                    ("collectibles_214_anemic_item",
                            () -> new collectibles214anemic(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles215goathead> COLLECTIBLES_215_GOATHEAD_ITEM = ITEMS
            .register
                    ("collectibles_215_goathead_item",
                            () -> new collectibles215goathead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles216ceremonialrobes> COLLECTIBLES_216_CEREMONIALROBES_ITEM = ITEMS
            .register
                    ("collectibles_216_ceremonialrobes_item",
                            () -> new collectibles216ceremonialrobes(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles217momswig> COLLECTIBLES_217_MOMSWIG_ITEM = ITEMS
            .register
                    ("collectibles_217_momswig_item",
                            () -> new collectibles217momswig(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles218placenta> COLLECTIBLES_218_PLACENTA_ITEM = ITEMS
            .register
                    ("collectibles_218_placenta_item",
                            () -> new collectibles218placenta(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles219oldbandage> COLLECTIBLES_219_OLDBANDAGE_ITEM = ITEMS
            .register
                    ("collectibles_219_oldbandage_item",
                            () -> new collectibles219oldbandage(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles220sadbombs> COLLECTIBLES_220_SADBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_220_sadbombs_item",
                            () -> new collectibles220sadbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles221rubbercement> COLLECTIBLES_221_RUBBERCEMENT_ITEM = ITEMS
            .register
                    ("collectibles_221_rubbercement_item",
                            () -> new collectibles221rubbercement(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles222antigravity> COLLECTIBLES_222_ANTIGRAVITY_ITEM = ITEMS
            .register
                    ("collectibles_222_antigravity_item",
                            () -> new collectibles222antigravity(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles223pyromaniac> COLLECTIBLES_223_PYROMANIAC_ITEM = ITEMS
            .register
                    ("collectibles_223_pyromaniac_item",
                            () -> new collectibles223pyromaniac(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles224cricketsbody> COLLECTIBLES_224_CRICKETSBODY_ITEM = ITEMS
            .register
                    ("collectibles_224_cricketsbody_item",
                            () -> new collectibles224cricketsbody(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles225gimpy> COLLECTIBLES_225_GIMPY_ITEM = ITEMS
            .register
                    ("collectibles_225_gimpy_item",
                            () -> new collectibles225gimpy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles226blacklotus> COLLECTIBLES_226_BLACKLOTUS_ITEM = ITEMS
            .register
                    ("collectibles_226_blacklotus_item",
                            () -> new collectibles226blacklotus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles227piggybank> COLLECTIBLES_227_PIGGYBANK_ITEM = ITEMS
            .register
                    ("collectibles_227_piggybank_item",
                            () -> new collectibles227piggybank(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles228momsperfume> COLLECTIBLES_228_MOMSPERFUME_ITEM = ITEMS
            .register
                    ("collectibles_228_momsperfume_item",
                            () -> new collectibles228momsperfume(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles229monstroslung> COLLECTIBLES_229_MONSTROSLUNG_ITEM = ITEMS
            .register
                    ("collectibles_229_monstroslung_item",
                            () -> new collectibles229monstroslung(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles230abaddon> COLLECTIBLES_230_ABADDON_ITEM = ITEMS
            .register
                    ("collectibles_230_abaddon_item",
                            () -> new collectibles230abaddon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles231balloftar> COLLECTIBLES_231_BALLOFTAR_ITEM = ITEMS
            .register
                    ("collectibles_231_balloftar_item",
                            () -> new collectibles231balloftar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles232stopwatch> COLLECTIBLES_232_STOPWATCH_ITEM = ITEMS
            .register
                    ("collectibles_232_stopwatch_item",
                            () -> new collectibles232stopwatch(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles233tinyplanet> COLLECTIBLES_233_TINYPLANET_ITEM = ITEMS
            .register
                    ("collectibles_233_tinyplanet_item",
                            () -> new collectibles233tinyplanet(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles234infestation2> COLLECTIBLES_234_INFESTATION2_ITEM = ITEMS
            .register
                    ("collectibles_234_infestation2_item",
                            () -> new collectibles234infestation2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles236ecoli> COLLECTIBLES_236_ECOLI_ITEM = ITEMS
            .register
                    ("collectibles_236_ecoli_item",
                            () -> new collectibles236ecoli(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles237deathstouch> COLLECTIBLES_237_DEATHSTOUCH_ITEM = ITEMS
            .register
                    ("collectibles_237_deathstouch_item",
                            () -> new collectibles237deathstouch(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles238keypiece1> COLLECTIBLES_238_KEYPIECE1_ITEM = ITEMS
            .register
                    ("collectibles_238_keypiece1_item",
                            () -> new collectibles238keypiece1(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles239keypiece2> COLLECTIBLES_239_KEYPIECE2_ITEM = ITEMS
            .register
                    ("collectibles_239_keypiece2_item",
                            () -> new collectibles239keypiece2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles240experimentaltreatment> COLLECTIBLES_240_EXPERIMENTALTREATMENT_ITEM = ITEMS
            .register
                    ("collectibles_240_experimentaltreatment_item",
                            () -> new collectibles240experimentaltreatment(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles241contractfrombelow> COLLECTIBLES_241_CONTRACTFROMBELOW_ITEM = ITEMS
            .register
                    ("collectibles_241_contractfrombelow_item",
                            () -> new collectibles241contractfrombelow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles242infamy> COLLECTIBLES_242_INFAMY_ITEM = ITEMS
            .register
                    ("collectibles_242_infamy_item",
                            () -> new collectibles242infamy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles243trinityshield> COLLECTIBLES_243_TRINITYSHIELD_ITEM = ITEMS
            .register
                    ("collectibles_243_trinityshield_item",
                            () -> new collectibles243trinityshield(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles244techpointfive> COLLECTIBLES_244_TECHPOINTFIVE_ITEM = ITEMS
            .register
                    ("collectibles_244_techpointfive_item",
                            () -> new collectibles244techpointfive(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles2452020> COLLECTIBLES_245_2020_ITEM = ITEMS
            .register
                    ("collectibles_245_2020_item",
                            () -> new collectibles2452020(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles246bluemap> COLLECTIBLES_246_BLUEMAP_ITEM = ITEMS
            .register
                    ("collectibles_246_bluemap_item",
                            () -> new collectibles246bluemap(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles247bffs> COLLECTIBLES_247_BFFS_ITEM = ITEMS
            .register
                    ("collectibles_247_bffs_item",
                            () -> new collectibles247bffs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles248hivemind> COLLECTIBLES_248_HIVEMIND_ITEM = ITEMS
            .register
                    ("collectibles_248_hivemind_item",
                            () -> new collectibles248hivemind(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles249theresoptions> COLLECTIBLES_249_THERESOPTIONS_ITEM = ITEMS
            .register
                    ("collectibles_249_theresoptions_item",
                            () -> new collectibles249theresoptions(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles250bogobombs> COLLECTIBLES_250_BOGOBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_250_bogobombs_item",
                            () -> new collectibles250bogobombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles251starterdeck> COLLECTIBLES_251_STARTERDECK_ITEM = ITEMS
            .register
                    ("collectibles_251_starterdeck_item",
                            () -> new collectibles251starterdeck(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles252littlebaggy> COLLECTIBLES_252_LITTLEBAGGY_ITEM = ITEMS
            .register
                    ("collectibles_252_littlebaggy_item",
                            () -> new collectibles252littlebaggy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles253magicscab> COLLECTIBLES_253_MAGICSCAB_ITEM = ITEMS
            .register
                    ("collectibles_253_magicscab_item",
                            () -> new collectibles253magicscab(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles254bloodclot> COLLECTIBLES_254_BLOODCLOT_ITEM = ITEMS
            .register
                    ("collectibles_254_bloodclot_item",
                            () -> new collectibles254bloodclot(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles255screw> COLLECTIBLES_255_SCREW_ITEM = ITEMS
            .register
                    ("collectibles_255_screw_item",
                            () -> new collectibles255screw(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles256hotbombs> COLLECTIBLES_256_HOTBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_256_hotbombs_item",
                            () -> new collectibles256hotbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles257firemind> COLLECTIBLES_257_FIREMIND_ITEM = ITEMS
            .register
                    ("collectibles_257_firemind_item",
                            () -> new collectibles257firemind(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles258missingno> COLLECTIBLES_258_MISSINGNO_ITEM = ITEMS
            .register
                    ("collectibles_258_missingno_item",
                            () -> new collectibles258missingno(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles259darkmatter> COLLECTIBLES_259_DARKMATTER_ITEM = ITEMS
            .register
                    ("collectibles_259_darkmatter_item",
                            () -> new collectibles259darkmatter(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles260blackcandle> COLLECTIBLES_260_BLACKCANDLE_ITEM = ITEMS
            .register
                    ("collectibles_260_blackcandle_item",
                            () -> new collectibles260blackcandle(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles261proptosis> COLLECTIBLES_261_PROPTOSIS_ITEM = ITEMS
            .register
                    ("collectibles_261_proptosis_item",
                            () -> new collectibles261proptosis(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles262missingpage2> COLLECTIBLES_262_MISSINGPAGE2_ITEM = ITEMS
            .register
                    ("collectibles_262_missingpage2_item",
                            () -> new collectibles262missingpage2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles263blankrune> COLLECTIBLES_263_BLANKRUNE_ITEM = ITEMS
            .register
                    ("collectibles_263_blankrune_item",
                            () -> new collectibles263blankrune(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles264smartfly> COLLECTIBLES_264_SMARTFLY_ITEM = ITEMS
            .register
                    ("collectibles_264_smartfly_item",
                            () -> new collectibles264smartfly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles265drybaby> COLLECTIBLES_265_DRYBABY_ITEM = ITEMS
            .register
                    ("collectibles_265_drybaby_item",
                            () -> new collectibles265drybaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles266juicysack> COLLECTIBLES_266_JUICYSACK_ITEM = ITEMS
            .register
                    ("collectibles_266_juicysack_item",
                            () -> new collectibles266juicysack(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles267robobaby2> COLLECTIBLES_267_ROBOBABY2_ITEM = ITEMS
            .register
                    ("collectibles_267_robobaby2_item",
                            () -> new collectibles267robobaby2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles268rottenbaby> COLLECTIBLES_268_ROTTENBABY_ITEM = ITEMS
            .register
                    ("collectibles_268_rottenbaby_item",
                            () -> new collectibles268rottenbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles269headlessbaby> COLLECTIBLES_269_HEADLESSBABY_ITEM = ITEMS
            .register
                    ("collectibles_269_headlessbaby_item",
                            () -> new collectibles269headlessbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles270leech> COLLECTIBLES_270_LEECH_ITEM = ITEMS
            .register
                    ("collectibles_270_leech_item",
                            () -> new collectibles270leech(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles271mysterysack> COLLECTIBLES_271_MYSTERYSACK_ITEM = ITEMS
            .register
                    ("collectibles_271_mysterysack_item",
                            () -> new collectibles271mysterysack(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles272bff> COLLECTIBLES_272_BFF_ITEM = ITEMS
            .register
                    ("collectibles_272_bff_item",
                            () -> new collectibles272bff(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles273bobsbrain> COLLECTIBLES_273_BOBSBRAIN_ITEM = ITEMS
            .register
                    ("collectibles_273_bobsbrain_item",
                            () -> new collectibles273bobsbrain(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles274bestbud> COLLECTIBLES_274_BESTBUD_ITEM = ITEMS
            .register
                    ("collectibles_274_bestbud_item",
                            () -> new collectibles274bestbud(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles275lilbrimstone> COLLECTIBLES_275_LILBRIMSTONE_ITEM = ITEMS
            .register
                    ("collectibles_275_lilbrimstone_item",
                            () -> new collectibles275lilbrimstone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles276isaacsheart> COLLECTIBLES_276_ISAACSHEART_ITEM = ITEMS
            .register
                    ("collectibles_276_isaacsheart_item",
                            () -> new collectibles276isaacsheart(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles277lilhaunt> COLLECTIBLES_277_LILHAUNT_ITEM = ITEMS
            .register
                    ("collectibles_277_lilhaunt_item",
                            () -> new collectibles277lilhaunt(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles278darkbum> COLLECTIBLES_278_DARKBUM_ITEM = ITEMS
            .register
                    ("collectibles_278_darkbum_item",
                            () -> new collectibles278darkbum(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles279bigfan> COLLECTIBLES_279_BIGFAN_ITEM = ITEMS
            .register
                    ("collectibles_279_bigfan_item",
                            () -> new collectibles279bigfan(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles280sissylonglegs> COLLECTIBLES_280_SISSYLONGLEGS_ITEM = ITEMS
            .register
                    ("collectibles_280_sissylonglegs_item",
                            () -> new collectibles280sissylonglegs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles281punchingbag> COLLECTIBLES_281_PUNCHINGBAG_ITEM = ITEMS
            .register
                    ("collectibles_281_punchingbag_item",
                            () -> new collectibles281punchingbag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles282howtojump> COLLECTIBLES_282_HOWTOJUMP_ITEM = ITEMS
            .register
                    ("collectibles_282_howtojump_item",
                            () -> new collectibles282howtojump(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles283d100> COLLECTIBLES_283_D100_ITEM = ITEMS
            .register
                    ("collectibles_283_d100_item",
                            () -> new collectibles283d100(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles284d4> COLLECTIBLES_284_D4_ITEM = ITEMS
            .register
                    ("collectibles_284_d4_item",
                            () -> new collectibles284d4(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles285d10> COLLECTIBLES_285_D10_ITEM = ITEMS
            .register
                    ("collectibles_285_d10_item",
                            () -> new collectibles285d10(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles286blankcard> COLLECTIBLES_286_BLANKCARD_ITEM = ITEMS
            .register
                    ("collectibles_286_blankcard_item",
                            () -> new collectibles286blankcard(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles287bookofsecrets> COLLECTIBLES_287_BOOKOFSECRETS_ITEM = ITEMS
            .register
                    ("collectibles_287_bookofsecrets_item",
                            () -> new collectibles287bookofsecrets(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles288boxofspiders> COLLECTIBLES_288_BOXOFSPIDERS_ITEM = ITEMS
            .register
                    ("collectibles_288_boxofspiders_item",
                            () -> new collectibles288boxofspiders(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles289redcandle> COLLECTIBLES_289_REDCANDLE_ITEM = ITEMS
            .register
                    ("collectibles_289_redcandle_item",
                            () -> new collectibles289redcandle(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles290thejar> COLLECTIBLES_290_THEJAR_ITEM = ITEMS
            .register
                    ("collectibles_290_thejar_item",
                            () -> new collectibles290thejar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles291flush> COLLECTIBLES_291_FLUSH_ITEM = ITEMS
            .register
                    ("collectibles_291_flush_item",
                            () -> new collectibles291flush(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles292satanicbible> COLLECTIBLES_292_SATANICBIBLE_ITEM = ITEMS
            .register
                    ("collectibles_292_satanicbible_item",
                            () -> new collectibles292satanicbible(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles293headofkrampus> COLLECTIBLES_293_HEADOFKRAMPUS_ITEM = ITEMS
            .register
                    ("collectibles_293_headofkrampus_item",
                            () -> new collectibles293headofkrampus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles294butterbean> COLLECTIBLES_294_BUTTERBEAN_ITEM = ITEMS
            .register
                    ("collectibles_294_butterbean_item",
                            () -> new collectibles294butterbean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles295magicfingers> COLLECTIBLES_295_MAGICFINGERS_ITEM = ITEMS
            .register
                    ("collectibles_295_magicfingers_item",
                            () -> new collectibles295magicfingers(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles296converter> COLLECTIBLES_296_CONVERTER_ITEM = ITEMS
            .register
                    ("collectibles_296_converter_item",
                            () -> new collectibles296converter(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles297bluebox> COLLECTIBLES_297_BLUEBOX_ITEM = ITEMS
            .register
                    ("collectibles_297_bluebox_item",
                            () -> new collectibles297bluebox(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles298unicornstump> COLLECTIBLES_298_UNICORNSTUMP_ITEM = ITEMS
            .register
                    ("collectibles_298_unicornstump_item",
                            () -> new collectibles298unicornstump(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles299taurus> COLLECTIBLES_299_TAURUS_ITEM = ITEMS
            .register
                    ("collectibles_299_taurus_item",
                            () -> new collectibles299taurus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles300aries> COLLECTIBLES_300_ARIES_ITEM = ITEMS
            .register
                    ("collectibles_300_aries_item",
                            () -> new collectibles300aries(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles301cancer> COLLECTIBLES_301_CANCER_ITEM = ITEMS
            .register
                    ("collectibles_301_cancer_item",
                            () -> new collectibles301cancer(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles302leo> COLLECTIBLES_302_LEO_ITEM = ITEMS
            .register
                    ("collectibles_302_leo_item",
                            () -> new collectibles302leo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles303virgo> COLLECTIBLES_303_VIRGO_ITEM = ITEMS
            .register
                    ("collectibles_303_virgo_item",
                            () -> new collectibles303virgo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles304libra> COLLECTIBLES_304_LIBRA_ITEM = ITEMS
            .register
                    ("collectibles_304_libra_item",
                            () -> new collectibles304libra(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles305scorpio> COLLECTIBLES_305_SCORPIO_ITEM = ITEMS
            .register
                    ("collectibles_305_scorpio_item",
                            () -> new collectibles305scorpio(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles306sagittarius> COLLECTIBLES_306_SAGITTARIUS_ITEM = ITEMS
            .register
                    ("collectibles_306_sagittarius_item",
                            () -> new collectibles306sagittarius(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles307capricorn> COLLECTIBLES_307_CAPRICORN_ITEM = ITEMS
            .register
                    ("collectibles_307_capricorn_item",
                            () -> new collectibles307capricorn(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles308aquarius> COLLECTIBLES_308_AQUARIUS_ITEM = ITEMS
            .register
                    ("collectibles_308_aquarius_item",
                            () -> new collectibles308aquarius(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles309pisces> COLLECTIBLES_309_PISCES_ITEM = ITEMS
            .register
                    ("collectibles_309_pisces_item",
                            () -> new collectibles309pisces(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles310evesmascara> COLLECTIBLES_310_EVESMASCARA_ITEM = ITEMS
            .register
                    ("collectibles_310_evesmascara_item",
                            () -> new collectibles310evesmascara(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles311judasshadow> COLLECTIBLES_311_JUDASSHADOW_ITEM = ITEMS
            .register
                    ("collectibles_311_judasshadow_item",
                            () -> new collectibles311judasshadow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles312maggysbow> COLLECTIBLES_312_MAGGYSBOW_ITEM = ITEMS
            .register
                    ("collectibles_312_maggysbow_item",
                            () -> new collectibles312maggysbow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles313holymantle> COLLECTIBLES_313_HOLYMANTLE_ITEM = ITEMS
            .register
                    ("collectibles_313_holymantle_item",
                            () -> new collectibles313holymantle(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles314thunderthighs> COLLECTIBLES_314_THUNDERTHIGHS_ITEM = ITEMS
            .register
                    ("collectibles_314_thunderthighs_item",
                            () -> new collectibles314thunderthighs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles315strangeattractor> COLLECTIBLES_315_STRANGEATTRACTOR_ITEM = ITEMS
            .register
                    ("collectibles_315_strangeattractor_item",
                            () -> new collectibles315strangeattractor(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles316cursedeye> COLLECTIBLES_316_CURSEDEYE_ITEM = ITEMS
            .register
                    ("collectibles_316_cursedeye_item",
                            () -> new collectibles316cursedeye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles317mysteriousliquid> COLLECTIBLES_317_MYSTERIOUSLIQUID_ITEM = ITEMS
            .register
                    ("collectibles_317_mysteriousliquid_item",
                            () -> new collectibles317mysteriousliquid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles318gemini> COLLECTIBLES_318_GEMINI_ITEM = ITEMS
            .register
                    ("collectibles_318_gemini_item",
                            () -> new collectibles318gemini(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles319cainseye> COLLECTIBLES_319_CAINSEYE_ITEM = ITEMS
            .register
                    ("collectibles_319_cainseye_item",
                            () -> new collectibles319cainseye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles320bluebabysonlyfriend> COLLECTIBLES_320_BLUEBABYSONLYFRIEND_ITEM = ITEMS
            .register
                    ("collectibles_320_bluebabysonlyfriend_item",
                            () -> new collectibles320bluebabysonlyfriend(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles321samsonschains> COLLECTIBLES_321_SAMSONSCHAINS_ITEM = ITEMS
            .register
                    ("collectibles_321_samsonschains_item",
                            () -> new collectibles321samsonschains(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles322mongobaby> COLLECTIBLES_322_MONGOBABY_ITEM = ITEMS
            .register
                    ("collectibles_322_mongobaby_item",
                            () -> new collectibles322mongobaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles323isaacstears> COLLECTIBLES_323_ISAACSTEARS_ITEM = ITEMS
            .register
                    ("collectibles_323_isaacstears_item",
                            () -> new collectibles323isaacstears(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles324undefined> COLLECTIBLES_324_UNDEFINED_ITEM = ITEMS
            .register
                    ("collectibles_324_undefined_item",
                            () -> new collectibles324undefined(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles325scissors> COLLECTIBLES_325_SCISSORS_ITEM = ITEMS
            .register
                    ("collectibles_325_scissors_item",
                            () -> new collectibles325scissors(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles326breathoflife> COLLECTIBLES_326_BREATHOFLIFE_ITEM = ITEMS
            .register
                    ("collectibles_326_breathoflife_item",
                            () -> new collectibles326breathoflife(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles327thepolaroid> COLLECTIBLES_327_THEPOLAROID_ITEM = ITEMS
            .register
                    ("collectibles_327_thepolaroid_item",
                            () -> new collectibles327thepolaroid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles328thenegative> COLLECTIBLES_328_THENEGATIVE_ITEM = ITEMS
            .register
                    ("collectibles_328_thenegative_item",
                            () -> new collectibles328thenegative(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles329theludovicotechnique> COLLECTIBLES_329_THELUDOVICOTECHNIQUE_ITEM = ITEMS
            .register
                    ("collectibles_329_theludovicotechnique_item",
                            () -> new collectibles329theludovicotechnique(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles330soymilk> COLLECTIBLES_330_SOYMILK_ITEM = ITEMS
            .register
                    ("collectibles_330_soymilk_item",
                            () -> new collectibles330soymilk(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles331godhead> COLLECTIBLES_331_GODHEAD_ITEM = ITEMS
            .register
                    ("collectibles_331_godhead_item",
                            () -> new collectibles331godhead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles332lazarusrags> COLLECTIBLES_332_LAZARUSRAGS_ITEM = ITEMS
            .register
                    ("collectibles_332_lazarusrags_item",
                            () -> new collectibles332lazarusrags(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles333mind> COLLECTIBLES_333_MIND_ITEM = ITEMS
            .register
                    ("collectibles_333_mind_item",
                            () -> new collectibles333mind(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles334body> COLLECTIBLES_334_BODY_ITEM = ITEMS
            .register
                    ("collectibles_334_body_item",
                            () -> new collectibles334body(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles335soul> COLLECTIBLES_335_SOUL_ITEM = ITEMS
            .register
                    ("collectibles_335_soul_item",
                            () -> new collectibles335soul(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles336deadonion> COLLECTIBLES_336_DEADONION_ITEM = ITEMS
            .register
                    ("collectibles_336_deadonion_item",
                            () -> new collectibles336deadonion(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles337brokenwatch> COLLECTIBLES_337_BROKENWATCH_ITEM = ITEMS
            .register
                    ("collectibles_337_brokenwatch_item",
                            () -> new collectibles337brokenwatch(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles338boomerang> COLLECTIBLES_338_BOOMERANG_ITEM = ITEMS
            .register
                    ("collectibles_338_boomerang_item",
                            () -> new collectibles338boomerang(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles339safetypin> COLLECTIBLES_339_SAFETYPIN_ITEM = ITEMS
            .register
                    ("collectibles_339_safetypin_item",
                            () -> new collectibles339safetypin(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles340caffeinepill> COLLECTIBLES_340_CAFFEINEPILL_ITEM = ITEMS
            .register
                    ("collectibles_340_caffeinepill_item",
                            () -> new collectibles340caffeinepill(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles341tornphoto> COLLECTIBLES_341_TORNPHOTO_ITEM = ITEMS
            .register
                    ("collectibles_341_tornphoto_item",
                            () -> new collectibles341tornphoto(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles342bluecap> COLLECTIBLES_342_BLUECAP_ITEM = ITEMS
            .register
                    ("collectibles_342_bluecap_item",
                            () -> new collectibles342bluecap(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles343latchkey> COLLECTIBLES_343_LATCHKEY_ITEM = ITEMS
            .register
                    ("collectibles_343_latchkey_item",
                            () -> new collectibles343latchkey(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles344matchbook> COLLECTIBLES_344_MATCHBOOK_ITEM = ITEMS
            .register
                    ("collectibles_344_matchbook_item",
                            () -> new collectibles344matchbook(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles345synthoil> COLLECTIBLES_345_SYNTHOIL_ITEM = ITEMS
            .register
                    ("collectibles_345_synthoil_item",
                            () -> new collectibles345synthoil(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles346asnack> COLLECTIBLES_346_ASNACK_ITEM = ITEMS
            .register
                    ("collectibles_346_asnack_item",
                            () -> new collectibles346asnack(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles347diplopia> COLLECTIBLES_347_DIPLOPIA_ITEM = ITEMS
            .register
                    ("collectibles_347_diplopia_item",
                            () -> new collectibles347diplopia(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles348placebo> COLLECTIBLES_348_PLACEBO_ITEM = ITEMS
            .register
                    ("collectibles_348_placebo_item",
                            () -> new collectibles348placebo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles349woodennickel> COLLECTIBLES_349_WOODENNICKEL_ITEM = ITEMS
            .register
                    ("collectibles_349_woodennickel_item",
                            () -> new collectibles349woodennickel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles350toxicshock> COLLECTIBLES_350_TOXICSHOCK_ITEM = ITEMS
            .register
                    ("collectibles_350_toxicshock_item",
                            () -> new collectibles350toxicshock(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles351megabean> COLLECTIBLES_351_MEGABEAN_ITEM = ITEMS
            .register
                    ("collectibles_351_megabean_item",
                            () -> new collectibles351megabean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles352glasscannon> COLLECTIBLES_352_GLASSCANNON_ITEM = ITEMS
            .register
                    ("collectibles_352_glasscannon_item",
                            () -> new collectibles352glasscannon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles353bomberboy> COLLECTIBLES_353_BOMBERBOY_ITEM = ITEMS
            .register
                    ("collectibles_353_bomberboy_item",
                            () -> new collectibles353bomberboy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles354crackjacks> COLLECTIBLES_354_CRACKJACKS_ITEM = ITEMS
            .register
                    ("collectibles_354_crackjacks_item",
                            () -> new collectibles354crackjacks(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles355momspearls> COLLECTIBLES_355_MOMSPEARLS_ITEM = ITEMS
            .register
                    ("collectibles_355_momspearls_item",
                            () -> new collectibles355momspearls(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles356carbattery> COLLECTIBLES_356_CARBATTERY_ITEM = ITEMS
            .register
                    ("collectibles_356_carbattery_item",
                            () -> new collectibles356carbattery(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles357pandorasbox> COLLECTIBLES_357_PANDORASBOX_ITEM = ITEMS
            .register
                    ("collectibles_357_pandorasbox_item",
                            () -> new collectibles357pandorasbox(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles358thewiz> COLLECTIBLES_358_THEWIZ_ITEM = ITEMS
            .register
                    ("collectibles_358_thewiz_item",
                            () -> new collectibles358thewiz(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles3598inchnails> COLLECTIBLES_359_8INCHNAILS_ITEM = ITEMS
            .register
                    ("collectibles_359_8inchnails_item",
                            () -> new collectibles3598inchnails(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles360incubus> COLLECTIBLES_360_INCUBUS_ITEM = ITEMS
            .register
                    ("collectibles_360_incubus_item",
                            () -> new collectibles360incubus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles361fatesreward> COLLECTIBLES_361_FATESREWARD_ITEM = ITEMS
            .register
                    ("collectibles_361_fatesreward_item",
                            () -> new collectibles361fatesreward(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles362lilchest> COLLECTIBLES_362_LILCHEST_ITEM = ITEMS
            .register
                    ("collectibles_362_lilchest_item",
                            () -> new collectibles362lilchest(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles363swornprotector> COLLECTIBLES_363_SWORNPROTECTOR_ITEM = ITEMS
            .register
                    ("collectibles_363_swornprotector_item",
                            () -> new collectibles363swornprotector(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles364friendzone> COLLECTIBLES_364_FRIENDZONE_ITEM = ITEMS
            .register
                    ("collectibles_364_friendzone_item",
                            () -> new collectibles364friendzone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles365lostfly> COLLECTIBLES_365_LOSTFLY_ITEM = ITEMS
            .register
                    ("collectibles_365_lostfly_item",
                            () -> new collectibles365lostfly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles366scatterbombs> COLLECTIBLES_366_SCATTERBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_366_scatterbombs_item",
                            () -> new collectibles366scatterbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles367stickybombs> COLLECTIBLES_367_STICKYBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_367_stickybombs_item",
                            () -> new collectibles367stickybombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles368epiphora> COLLECTIBLES_368_EPIPHORA_ITEM = ITEMS
            .register
                    ("collectibles_368_epiphora_item",
                            () -> new collectibles368epiphora(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles369continuum> COLLECTIBLES_369_CONTINUUM_ITEM = ITEMS
            .register
                    ("collectibles_369_continuum_item",
                            () -> new collectibles369continuum(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles370mrdolly> COLLECTIBLES_370_MRDOLLY_ITEM = ITEMS
            .register
                    ("collectibles_370_mrdolly_item",
                            () -> new collectibles370mrdolly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles371curseofthetower> COLLECTIBLES_371_CURSEOFTHETOWER_ITEM = ITEMS
            .register
                    ("collectibles_371_curseofthetower_item",
                            () -> new collectibles371curseofthetower(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles372chargedbaby> COLLECTIBLES_372_CHARGEDBABY_ITEM = ITEMS
            .register
                    ("collectibles_372_chargedbaby_item",
                            () -> new collectibles372chargedbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles373deadeye> COLLECTIBLES_373_DEADEYE_ITEM = ITEMS
            .register
                    ("collectibles_373_deadeye_item",
                            () -> new collectibles373deadeye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles374holylight> COLLECTIBLES_374_HOLYLIGHT_ITEM = ITEMS
            .register
                    ("collectibles_374_holylight_item",
                            () -> new collectibles374holylight(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles375hosthat> COLLECTIBLES_375_HOSTHAT_ITEM = ITEMS
            .register
                    ("collectibles_375_hosthat_item",
                            () -> new collectibles375hosthat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles376restock> COLLECTIBLES_376_RESTOCK_ITEM = ITEMS
            .register
                    ("collectibles_376_restock_item",
                            () -> new collectibles376restock(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles377burstingsack> COLLECTIBLES_377_BURSTINGSACK_ITEM = ITEMS
            .register
                    ("collectibles_377_burstingsack_item",
                            () -> new collectibles377burstingsack(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles378numbertwo> COLLECTIBLES_378_NUMBERTWO_ITEM = ITEMS
            .register
                    ("collectibles_378_numbertwo_item",
                            () -> new collectibles378numbertwo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles379pupuladuplex> COLLECTIBLES_379_PUPULADUPLEX_ITEM = ITEMS
            .register
                    ("collectibles_379_pupuladuplex_item",
                            () -> new collectibles379pupuladuplex(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles380paytoplay> COLLECTIBLES_380_PAYTOPLAY_ITEM = ITEMS
            .register
                    ("collectibles_380_paytoplay_item",
                            () -> new collectibles380paytoplay(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles381edensblessing> COLLECTIBLES_381_EDENSBLESSING_ITEM = ITEMS
            .register
                    ("collectibles_381_edensblessing_item",
                            () -> new collectibles381edensblessing(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles382friendlyball> COLLECTIBLES_382_FRIENDLYBALL_ITEM = ITEMS
            .register
                    ("collectibles_382_friendlyball_item",
                            () -> new collectibles382friendlyball(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles383teardetonator> COLLECTIBLES_383_TEARDETONATOR_ITEM = ITEMS
            .register
                    ("collectibles_383_teardetonator_item",
                            () -> new collectibles383teardetonator(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles384lilgurdy> COLLECTIBLES_384_LILGURDY_ITEM = ITEMS
            .register
                    ("collectibles_384_lilgurdy_item",
                            () -> new collectibles384lilgurdy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles385bumbo> COLLECTIBLES_385_BUMBO_ITEM = ITEMS
            .register
                    ("collectibles_385_bumbo_item",
                            () -> new collectibles385bumbo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles386d12> COLLECTIBLES_386_D12_ITEM = ITEMS
            .register
                    ("collectibles_386_d12_item",
                            () -> new collectibles386d12(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles387censer> COLLECTIBLES_387_CENSER_ITEM = ITEMS
            .register
                    ("collectibles_387_censer_item",
                            () -> new collectibles387censer(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles388keybum> COLLECTIBLES_388_KEYBUM_ITEM = ITEMS
            .register
                    ("collectibles_388_keybum_item",
                            () -> new collectibles388keybum(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles389runebag> COLLECTIBLES_389_RUNEBAG_ITEM = ITEMS
            .register
                    ("collectibles_389_runebag_item",
                            () -> new collectibles389runebag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles390seraphim> COLLECTIBLES_390_SERAPHIM_ITEM = ITEMS
            .register
                    ("collectibles_390_seraphim_item",
                            () -> new collectibles390seraphim(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles391betrayal> COLLECTIBLES_391_BETRAYAL_ITEM = ITEMS
            .register
                    ("collectibles_391_betrayal_item",
                            () -> new collectibles391betrayal(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles392zodiac> COLLECTIBLES_392_ZODIAC_ITEM = ITEMS
            .register
                    ("collectibles_392_zodiac_item",
                            () -> new collectibles392zodiac(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles393serpentskiss> COLLECTIBLES_393_SERPENTSKISS_ITEM = ITEMS
            .register
                    ("collectibles_393_serpentskiss_item",
                            () -> new collectibles393serpentskiss(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles394marked> COLLECTIBLES_394_MARKED_ITEM = ITEMS
            .register
                    ("collectibles_394_marked_item",
                            () -> new collectibles394marked(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles395techx> COLLECTIBLES_395_TECHX_ITEM = ITEMS
            .register
                    ("collectibles_395_techx_item",
                            () -> new collectibles395techx(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles396ventriclerazor> COLLECTIBLES_396_VENTRICLERAZOR_ITEM = ITEMS
            .register
                    ("collectibles_396_ventriclerazor_item",
                            () -> new collectibles396ventriclerazor(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles397tractorbeam> COLLECTIBLES_397_TRACTORBEAM_ITEM = ITEMS
            .register
                    ("collectibles_397_tractorbeam_item",
                            () -> new collectibles397tractorbeam(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles398godsflesh> COLLECTIBLES_398_GODSFLESH_ITEM = ITEMS
            .register
                    ("collectibles_398_godsflesh_item",
                            () -> new collectibles398godsflesh(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles399mawofthevoid> COLLECTIBLES_399_MAWOFTHEVOID_ITEM = ITEMS
            .register
                    ("collectibles_399_mawofthevoid_item",
                            () -> new collectibles399mawofthevoid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles400spearofdestiny> COLLECTIBLES_400_SPEAROFDESTINY_ITEM = ITEMS
            .register
                    ("collectibles_400_spearofdestiny_item",
                            () -> new collectibles400spearofdestiny(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles401explosivo> COLLECTIBLES_401_EXPLOSIVO_ITEM = ITEMS
            .register
                    ("collectibles_401_explosivo_item",
                            () -> new collectibles401explosivo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles402chaos> COLLECTIBLES_402_CHAOS_ITEM = ITEMS
            .register
                    ("collectibles_402_chaos_item",
                            () -> new collectibles402chaos(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles403spidermod> COLLECTIBLES_403_SPIDERMOD_ITEM = ITEMS
            .register
                    ("collectibles_403_spidermod_item",
                            () -> new collectibles403spidermod(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles404fartbaby> COLLECTIBLES_404_FARTBABY_ITEM = ITEMS
            .register
                    ("collectibles_404_fartbaby_item",
                            () -> new collectibles404fartbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles405gbbug> COLLECTIBLES_405_GBBUG_ITEM = ITEMS
            .register
                    ("collectibles_405_gbbug_item",
                            () -> new collectibles405gbbug(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles406d8> COLLECTIBLES_406_D8_ITEM = ITEMS
            .register
                    ("collectibles_406_d8_item",
                            () -> new collectibles406d8(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles407purity> COLLECTIBLES_407_PURITY_ITEM = ITEMS
            .register
                    ("collectibles_407_purity_item",
                            () -> new collectibles407purity(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles408athame> COLLECTIBLES_408_ATHAME_ITEM = ITEMS
            .register
                    ("collectibles_408_athame_item",
                            () -> new collectibles408athame(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles409emptyvessel> COLLECTIBLES_409_EMPTYVESSEL_ITEM = ITEMS
            .register
                    ("collectibles_409_emptyvessel_item",
                            () -> new collectibles409emptyvessel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles410evileye> COLLECTIBLES_410_EVILEYE_ITEM = ITEMS
            .register
                    ("collectibles_410_evileye_item",
                            () -> new collectibles410evileye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles411lustyblood> COLLECTIBLES_411_LUSTYBLOOD_ITEM = ITEMS
            .register
                    ("collectibles_411_lustyblood_item",
                            () -> new collectibles411lustyblood(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles412cambionconception> COLLECTIBLES_412_CAMBIONCONCEPTION_ITEM = ITEMS
            .register
                    ("collectibles_412_cambionconception_item",
                            () -> new collectibles412cambionconception(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles413immaculateconception> COLLECTIBLES_413_IMMACULATECONCEPTION_ITEM = ITEMS
            .register
                    ("collectibles_413_immaculateconception_item",
                            () -> new collectibles413immaculateconception(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles414moreoptions> COLLECTIBLES_414_MOREOPTIONS_ITEM = ITEMS
            .register
                    ("collectibles_414_moreoptions_item",
                            () -> new collectibles414moreoptions(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles415crownoflight> COLLECTIBLES_415_CROWNOFLIGHT_ITEM = ITEMS
            .register
                    ("collectibles_415_crownoflight_item",
                            () -> new collectibles415crownoflight(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles416deeppockets> COLLECTIBLES_416_DEEPPOCKETS_ITEM = ITEMS
            .register
                    ("collectibles_416_deeppockets_item",
                            () -> new collectibles416deeppockets(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles417succubus> COLLECTIBLES_417_SUCCUBUS_ITEM = ITEMS
            .register
                    ("collectibles_417_succubus_item",
                            () -> new collectibles417succubus(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles418fruitcake> COLLECTIBLES_418_FRUITCAKE_ITEM = ITEMS
            .register
                    ("collectibles_418_fruitcake_item",
                            () -> new collectibles418fruitcake(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles419teleport20> COLLECTIBLES_419_TELEPORT20_ITEM = ITEMS
            .register
                    ("collectibles_419_teleport20_item",
                            () -> new collectibles419teleport20(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles420blackpowder> COLLECTIBLES_420_BLACKPOWDER_ITEM = ITEMS
            .register
                    ("collectibles_420_blackpowder_item",
                            () -> new collectibles420blackpowder(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles421kidneybean> COLLECTIBLES_421_KIDNEYBEAN_ITEM = ITEMS
            .register
                    ("collectibles_421_kidneybean_item",
                            () -> new collectibles421kidneybean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles422glowinghourglass> COLLECTIBLES_422_GLOWINGHOURGLASS_ITEM = ITEMS
            .register
                    ("collectibles_422_glowinghourglass_item",
                            () -> new collectibles422glowinghourglass(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles423circleofprotection> COLLECTIBLES_423_CIRCLEOFPROTECTION_ITEM = ITEMS
            .register
                    ("collectibles_423_circleofprotection_item",
                            () -> new collectibles423circleofprotection(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles424sackhead> COLLECTIBLES_424_SACKHEAD_ITEM = ITEMS
            .register
                    ("collectibles_424_sackhead_item",
                            () -> new collectibles424sackhead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles425nightlight> COLLECTIBLES_425_NIGHTLIGHT_ITEM = ITEMS
            .register
                    ("collectibles_425_nightlight_item",
                            () -> new collectibles425nightlight(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles426obsessedfan> COLLECTIBLES_426_OBSESSEDFAN_ITEM = ITEMS
            .register
                    ("collectibles_426_obsessedfan_item",
                            () -> new collectibles426obsessedfan(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles427minecrafter> COLLECTIBLES_427_MINECRAFTER_ITEM = ITEMS
            .register
                    ("collectibles_427_minecrafter_item",
                            () -> new collectibles427minecrafter(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles428pjs> COLLECTIBLES_428_PJS_ITEM = ITEMS
            .register
                    ("collectibles_428_pjs_item",
                            () -> new collectibles428pjs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles429headofthekeeper> COLLECTIBLES_429_HEADOFTHEKEEPER_ITEM = ITEMS
            .register
                    ("collectibles_429_headofthekeeper_item",
                            () -> new collectibles429headofthekeeper(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles430papafly> COLLECTIBLES_430_PAPAFLY_ITEM = ITEMS
            .register
                    ("collectibles_430_papafly_item",
                            () -> new collectibles430papafly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles431multidimensionalbaby> COLLECTIBLES_431_MULTIDIMENSIONALBABY_ITEM = ITEMS
            .register
                    ("collectibles_431_multidimensionalbaby_item",
                            () -> new collectibles431multidimensionalbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles432glitterbombs> COLLECTIBLES_432_GLITTERBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_432_glitterbombs_item",
                            () -> new collectibles432glitterbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles433myshadow> COLLECTIBLES_433_MYSHADOW_ITEM = ITEMS
            .register
                    ("collectibles_433_myshadow_item",
                            () -> new collectibles433myshadow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles434jarofflies> COLLECTIBLES_434_JAROFFLIES_ITEM = ITEMS
            .register
                    ("collectibles_434_jarofflies_item",
                            () -> new collectibles434jarofflies(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles435lilloki> COLLECTIBLES_435_LILLOKI_ITEM = ITEMS
            .register
                    ("collectibles_435_lilloki_item",
                            () -> new collectibles435lilloki(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles436milk> COLLECTIBLES_436_MILK_ITEM = ITEMS
            .register
                    ("collectibles_436_milk_item",
                            () -> new collectibles436milk(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles437d7> COLLECTIBLES_437_D7_ITEM = ITEMS
            .register
                    ("collectibles_437_d7_item",
                            () -> new collectibles437d7(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles438binky> COLLECTIBLES_438_BINKY_ITEM = ITEMS
            .register
                    ("collectibles_438_binky_item",
                            () -> new collectibles438binky(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles439momsbox> COLLECTIBLES_439_MOMSBOX_ITEM = ITEMS
            .register
                    ("collectibles_439_momsbox_item",
                            () -> new collectibles439momsbox(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles440kidneystone> COLLECTIBLES_440_KIDNEYSTONE_ITEM = ITEMS
            .register
                    ("collectibles_440_kidneystone_item",
                            () -> new collectibles440kidneystone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles441megasatansbreath> COLLECTIBLES_441_MEGASATANSBREATH_ITEM = ITEMS
            .register
                    ("collectibles_441_megasatansbreath_item",
                            () -> new collectibles441megasatansbreath(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles442darkprincescrown> COLLECTIBLES_442_DARKPRINCESCROWN_ITEM = ITEMS
            .register
                    ("collectibles_442_darkprincescrown_item",
                            () -> new collectibles442darkprincescrown(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles443apple> COLLECTIBLES_443_APPLE_ITEM = ITEMS
            .register
                    ("collectibles_443_apple_item",
                            () -> new collectibles443apple(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles444leadpencil> COLLECTIBLES_444_LEADPENCIL_ITEM = ITEMS
            .register
                    ("collectibles_444_leadpencil_item",
                            () -> new collectibles444leadpencil(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles445dogtooth> COLLECTIBLES_445_DOGTOOTH_ITEM = ITEMS
            .register
                    ("collectibles_445_dogtooth_item",
                            () -> new collectibles445dogtooth(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles446deadtooth> COLLECTIBLES_446_DEADTOOTH_ITEM = ITEMS
            .register
                    ("collectibles_446_deadtooth_item",
                            () -> new collectibles446deadtooth(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles447lingerbean> COLLECTIBLES_447_LINGERBEAN_ITEM = ITEMS
            .register
                    ("collectibles_447_lingerbean_item",
                            () -> new collectibles447lingerbean(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles448shardofglass> COLLECTIBLES_448_SHARDOFGLASS_ITEM = ITEMS
            .register
                    ("collectibles_448_shardofglass_item",
                            () -> new collectibles448shardofglass(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles449metalplate> COLLECTIBLES_449_METALPLATE_ITEM = ITEMS
            .register
                    ("collectibles_449_metalplate_item",
                            () -> new collectibles449metalplate(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles450eyeofgreed> COLLECTIBLES_450_EYEOFGREED_ITEM = ITEMS
            .register
                    ("collectibles_450_eyeofgreed_item",
                            () -> new collectibles450eyeofgreed(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles451tarotcloth> COLLECTIBLES_451_TAROTCLOTH_ITEM = ITEMS
            .register
                    ("collectibles_451_tarotcloth_item",
                            () -> new collectibles451tarotcloth(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles452varicoseveins> COLLECTIBLES_452_VARICOSEVEINS_ITEM = ITEMS
            .register
                    ("collectibles_452_varicoseveins_item",
                            () -> new collectibles452varicoseveins(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles453compoundfracture> COLLECTIBLES_453_COMPOUNDFRACTURE_ITEM = ITEMS
            .register
                    ("collectibles_453_compoundfracture_item",
                            () -> new collectibles453compoundfracture(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles454polydactyly> COLLECTIBLES_454_POLYDACTYLY_ITEM = ITEMS
            .register
                    ("collectibles_454_polydactyly_item",
                            () -> new collectibles454polydactyly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles455dadslostcoin> COLLECTIBLES_455_DADSLOSTCOIN_ITEM = ITEMS
            .register
                    ("collectibles_455_dadslostcoin_item",
                            () -> new collectibles455dadslostcoin(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles456moldybread> COLLECTIBLES_456_MOLDYBREAD_ITEM = ITEMS
            .register
                    ("collectibles_456_moldybread_item",
                            () -> new collectibles456moldybread(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles457conehead> COLLECTIBLES_457_CONEHEAD_ITEM = ITEMS
            .register
                    ("collectibles_457_conehead_item",
                            () -> new collectibles457conehead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles458bellybutton> COLLECTIBLES_458_BELLYBUTTON_ITEM = ITEMS
            .register
                    ("collectibles_458_bellybutton_item",
                            () -> new collectibles458bellybutton(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles459sinusinfection> COLLECTIBLES_459_SINUSINFECTION_ITEM = ITEMS
            .register
                    ("collectibles_459_sinusinfection_item",
                            () -> new collectibles459sinusinfection(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles460glaucoma> COLLECTIBLES_460_GLAUCOMA_ITEM = ITEMS
            .register
                    ("collectibles_460_glaucoma_item",
                            () -> new collectibles460glaucoma(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles461parasitoid> COLLECTIBLES_461_PARASITOID_ITEM = ITEMS
            .register
                    ("collectibles_461_parasitoid_item",
                            () -> new collectibles461parasitoid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles462eyeofbelial> COLLECTIBLES_462_EYEOFBELIAL_ITEM = ITEMS
            .register
                    ("collectibles_462_eyeofbelial_item",
                            () -> new collectibles462eyeofbelial(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles463sulfuricacid> COLLECTIBLES_463_SULFURICACID_ITEM = ITEMS
            .register
                    ("collectibles_463_sulfuricacid_item",
                            () -> new collectibles463sulfuricacid(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles464glyphofbalance> COLLECTIBLES_464_GLYPHOFBALANCE_ITEM = ITEMS
            .register
                    ("collectibles_464_glyphofbalance_item",
                            () -> new collectibles464glyphofbalance(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles465analogstick> COLLECTIBLES_465_ANALOGSTICK_ITEM = ITEMS
            .register
                    ("collectibles_465_analogstick_item",
                            () -> new collectibles465analogstick(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles466contagion> COLLECTIBLES_466_CONTAGION_ITEM = ITEMS
            .register
                    ("collectibles_466_contagion_item",
                            () -> new collectibles466contagion(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles467finger> COLLECTIBLES_467_FINGER_ITEM = ITEMS
            .register
                    ("collectibles_467_finger_item",
                            () -> new collectibles467finger(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles468shade> COLLECTIBLES_468_SHADE_ITEM = ITEMS
            .register
                    ("collectibles_468_shade_item",
                            () -> new collectibles468shade(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles469depression> COLLECTIBLES_469_DEPRESSION_ITEM = ITEMS
            .register
                    ("collectibles_469_depression_item",
                            () -> new collectibles469depression(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles470hushy> COLLECTIBLES_470_HUSHY_ITEM = ITEMS
            .register
                    ("collectibles_470_hushy_item",
                            () -> new collectibles470hushy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles471lilmonstro> COLLECTIBLES_471_LILMONSTRO_ITEM = ITEMS
            .register
                    ("collectibles_471_lilmonstro_item",
                            () -> new collectibles471lilmonstro(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles472kingbaby> COLLECTIBLES_472_KINGBABY_ITEM = ITEMS
            .register
                    ("collectibles_472_kingbaby_item",
                            () -> new collectibles472kingbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles473bigchubby> COLLECTIBLES_473_BIGCHUBBY_ITEM = ITEMS
            .register
                    ("collectibles_473_bigchubby_item",
                            () -> new collectibles473bigchubby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles474brokenglasscannon> COLLECTIBLES_474_BROKENGLASSCANNON_ITEM = ITEMS
            .register
                    ("collectibles_474_brokenglasscannon_item",
                            () -> new collectibles474brokenglasscannon(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles475planc> COLLECTIBLES_475_PLANC_ITEM = ITEMS
            .register
                    ("collectibles_475_planc_item",
                            () -> new collectibles475planc(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles476d1> COLLECTIBLES_476_D1_ITEM = ITEMS
            .register
                    ("collectibles_476_d1_item",
                            () -> new collectibles476d1(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles477void> COLLECTIBLES_477_VOID_ITEM = ITEMS
            .register
                    ("collectibles_477_void_item",
                            () -> new collectibles477void(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles478pause> COLLECTIBLES_478_PAUSE_ITEM = ITEMS
            .register
                    ("collectibles_478_pause_item",
                            () -> new collectibles478pause(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles479smelter> COLLECTIBLES_479_SMELTER_ITEM = ITEMS
            .register
                    ("collectibles_479_smelter_item",
                            () -> new collectibles479smelter(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles480compost> COLLECTIBLES_480_COMPOST_ITEM = ITEMS
            .register
                    ("collectibles_480_compost_item",
                            () -> new collectibles480compost(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles481dataminer> COLLECTIBLES_481_DATAMINER_ITEM = ITEMS
            .register
                    ("collectibles_481_dataminer_item",
                            () -> new collectibles481dataminer(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles482clicker> COLLECTIBLES_482_CLICKER_ITEM = ITEMS
            .register
                    ("collectibles_482_clicker_item",
                            () -> new collectibles482clicker(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles483mamamega> COLLECTIBLES_483_MAMAMEGA_ITEM = ITEMS
            .register
                    ("collectibles_483_mamamega_item",
                            () -> new collectibles483mamamega(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles484waitwhat> COLLECTIBLES_484_WAITWHAT_ITEM = ITEMS
            .register
                    ("collectibles_484_waitwhat_item",
                            () -> new collectibles484waitwhat(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles485crookedpenny> COLLECTIBLES_485_CROOKEDPENNY_ITEM = ITEMS
            .register
                    ("collectibles_485_crookedpenny_item",
                            () -> new collectibles485crookedpenny(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles486dullrazor> COLLECTIBLES_486_DULLRAZOR_ITEM = ITEMS
            .register
                    ("collectibles_486_dullrazor_item",
                            () -> new collectibles486dullrazor(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles487potatopeeler> COLLECTIBLES_487_POTATOPEELER_ITEM = ITEMS
            .register
                    ("collectibles_487_potatopeeler_item",
                            () -> new collectibles487potatopeeler(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles488metronome> COLLECTIBLES_488_METRONOME_ITEM = ITEMS
            .register
                    ("collectibles_488_metronome_item",
                            () -> new collectibles488metronome(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles489dinfinity> COLLECTIBLES_489_DINFINITY_ITEM = ITEMS
            .register
                    ("collectibles_489_dinfinity_item",
                            () -> new collectibles489dinfinity(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles490edenssoul> COLLECTIBLES_490_EDENSSOUL_ITEM = ITEMS
            .register
                    ("collectibles_490_edenssoul_item",
                            () -> new collectibles490edenssoul(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles491acidbaby> COLLECTIBLES_491_ACIDBABY_ITEM = ITEMS
            .register
                    ("collectibles_491_acidbaby_item",
                            () -> new collectibles491acidbaby(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles492yolisten> COLLECTIBLES_492_YOLISTEN_ITEM = ITEMS
            .register
                    ("collectibles_492_yolisten_item",
                            () -> new collectibles492yolisten(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles493adderline> COLLECTIBLES_493_ADDERLINE_ITEM = ITEMS
            .register
                    ("collectibles_493_adderline_item",
                            () -> new collectibles493adderline(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles494jacobsladder> COLLECTIBLES_494_JACOBSLADDER_ITEM = ITEMS
            .register
                    ("collectibles_494_jacobsladder_item",
                            () -> new collectibles494jacobsladder(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles495ghostpepper> COLLECTIBLES_495_GHOSTPEPPER_ITEM = ITEMS
            .register
                    ("collectibles_495_ghostpepper_item",
                            () -> new collectibles495ghostpepper(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles496euthanasia> COLLECTIBLES_496_EUTHANASIA_ITEM = ITEMS
            .register
                    ("collectibles_496_euthanasia_item",
                            () -> new collectibles496euthanasia(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles497camoundies> COLLECTIBLES_497_CAMOUNDIES_ITEM = ITEMS
            .register
                    ("collectibles_497_camoundies_item",
                            () -> new collectibles497camoundies(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles498duality> COLLECTIBLES_498_DUALITY_ITEM = ITEMS
            .register
                    ("collectibles_498_duality_item",
                            () -> new collectibles498duality(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles499eucharist> COLLECTIBLES_499_EUCHARIST_ITEM = ITEMS
            .register
                    ("collectibles_499_eucharist_item",
                            () -> new collectibles499eucharist(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles500sackofsacks> COLLECTIBLES_500_SACKOFSACKS_ITEM = ITEMS
            .register
                    ("collectibles_500_sackofsacks_item",
                            () -> new collectibles500sackofsacks(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles501greedsgullet> COLLECTIBLES_501_GREEDSGULLET_ITEM = ITEMS
            .register
                    ("collectibles_501_greedsgullet_item",
                            () -> new collectibles501greedsgullet(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles502largezit> COLLECTIBLES_502_LARGEZIT_ITEM = ITEMS
            .register
                    ("collectibles_502_largezit_item",
                            () -> new collectibles502largezit(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles503littlehorn> COLLECTIBLES_503_LITTLEHORN_ITEM = ITEMS
            .register
                    ("collectibles_503_littlehorn_item",
                            () -> new collectibles503littlehorn(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles504brownnugget> COLLECTIBLES_504_BROWNNUGGET_ITEM = ITEMS
            .register
                    ("collectibles_504_brownnugget_item",
                            () -> new collectibles504brownnugget(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles505pokego> COLLECTIBLES_505_POKEGO_ITEM = ITEMS
            .register
                    ("collectibles_505_pokego_item",
                            () -> new collectibles505pokego(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles506backstabber> COLLECTIBLES_506_BACKSTABBER_ITEM = ITEMS
            .register
                    ("collectibles_506_backstabber_item",
                            () -> new collectibles506backstabber(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles507sharpstraw> COLLECTIBLES_507_SHARPSTRAW_ITEM = ITEMS
            .register
                    ("collectibles_507_sharpstraw_item",
                            () -> new collectibles507sharpstraw(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles508momsrazor> COLLECTIBLES_508_MOMSRAZOR_ITEM = ITEMS
            .register
                    ("collectibles_508_momsrazor_item",
                            () -> new collectibles508momsrazor(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles509bloodshoteye> COLLECTIBLES_509_BLOODSHOTEYE_ITEM = ITEMS
            .register
                    ("collectibles_509_bloodshoteye_item",
                            () -> new collectibles509bloodshoteye(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles510delirious> COLLECTIBLES_510_DELIRIOUS_ITEM = ITEMS
            .register
                    ("collectibles_510_delirious_item",
                            () -> new collectibles510delirious(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles511angryfly> COLLECTIBLES_511_ANGRYFLY_ITEM = ITEMS
            .register
                    ("collectibles_511_angryfly_item",
                            () -> new collectibles511angryfly(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles512blackhole> COLLECTIBLES_512_BLACKHOLE_ITEM = ITEMS
            .register
                    ("collectibles_512_blackhole_item",
                            () -> new collectibles512blackhole(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles513bozo> COLLECTIBLES_513_BOZO_ITEM = ITEMS
            .register
                    ("collectibles_513_bozo_item",
                            () -> new collectibles513bozo(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles514brokenmodem> COLLECTIBLES_514_BROKENMODEM_ITEM = ITEMS
            .register
                    ("collectibles_514_brokenmodem_item",
                            () -> new collectibles514brokenmodem(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles515mysterygift> COLLECTIBLES_515_MYSTERYGIFT_ITEM = ITEMS
            .register
                    ("collectibles_515_mysterygift_item",
                            () -> new collectibles515mysterygift(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles516sprinkler> COLLECTIBLES_516_SPRINKLER_ITEM = ITEMS
            .register
                    ("collectibles_516_sprinkler_item",
                            () -> new collectibles516sprinkler(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles517fastbombs> COLLECTIBLES_517_FASTBOMBS_ITEM = ITEMS
            .register
                    ("collectibles_517_fastbombs_item",
                            () -> new collectibles517fastbombs(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles518buddybox> COLLECTIBLES_518_BUDDYBOX_ITEM = ITEMS
            .register
                    ("collectibles_518_buddybox_item",
                            () -> new collectibles518buddybox(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles519lildelirium> COLLECTIBLES_519_LILDELIRIUM_ITEM = ITEMS
            .register
                    ("collectibles_519_lildelirium_item",
                            () -> new collectibles519lildelirium(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles520jumpercable> COLLECTIBLES_520_JUMPERCABLE_ITEM = ITEMS
            .register
                    ("collectibles_520_jumpercable_item",
                            () -> new collectibles520jumpercable(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles521cerealcutout> COLLECTIBLES_521_CEREALCUTOUT_ITEM = ITEMS
            .register
                    ("collectibles_521_cerealcutout_item",
                            () -> new collectibles521cerealcutout(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles522telekinesis> COLLECTIBLES_522_TELEKINESIS_ITEM = ITEMS
            .register
                    ("collectibles_522_telekinesis_item",
                            () -> new collectibles522telekinesis(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles523movingbox> COLLECTIBLES_523_MOVINGBOX_ITEM = ITEMS
            .register
                    ("collectibles_523_movingbox_item",
                            () -> new collectibles523movingbox(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles524technologyzero> COLLECTIBLES_524_TECHNOLOGYZERO_ITEM = ITEMS
            .register
                    ("collectibles_524_technologyzero_item",
                            () -> new collectibles524technologyzero(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles525leprosy> COLLECTIBLES_525_LEPROSY_ITEM = ITEMS
            .register
                    ("collectibles_525_leprosy_item",
                            () -> new collectibles525leprosy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles5267seals> COLLECTIBLES_526_7SEALS_ITEM = ITEMS
            .register
                    ("collectibles_526_7seals_item",
                            () -> new collectibles5267seals(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles527mrme> COLLECTIBLES_527_MR_ME_ITEM = ITEMS
            .register
                    ("collectibles_527_mr_me_item",
                            () -> new collectibles527mrme(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles528angelicprism> COLLECTIBLES_528_ANGELICPRISM_ITEM = ITEMS
            .register
                    ("collectibles_528_angelicprism_item",
                            () -> new collectibles528angelicprism(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles529pop> COLLECTIBLES_529_POP_ITEM = ITEMS
            .register
                    ("collectibles_529_pop_item",
                            () -> new collectibles529pop(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles530deathslist> COLLECTIBLES_530_DEATHSLIST_ITEM = ITEMS
            .register
                    ("collectibles_530_deathslist_item",
                            () -> new collectibles530deathslist(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles531haemolacria> COLLECTIBLES_531_HAEMOLACRIA_ITEM = ITEMS
            .register
                    ("collectibles_531_haemolacria_item",
                            () -> new collectibles531haemolacria(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles532lachryphagy> COLLECTIBLES_532_LACHRYPHAGY_ITEM = ITEMS
            .register
                    ("collectibles_532_lachryphagy_item",
                            () -> new collectibles532lachryphagy(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles533trisagion> COLLECTIBLES_533_TRISAGION_ITEM = ITEMS
            .register
                    ("collectibles_533_trisagion_item",
                            () -> new collectibles533trisagion(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles534schoolbag> COLLECTIBLES_534_SCHOOLBAG_ITEM = ITEMS
            .register
                    ("collectibles_534_schoolbag_item",
                            () -> new collectibles534schoolbag(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles535blanket> COLLECTIBLES_535_BLANKET_ITEM = ITEMS
            .register
                    ("collectibles_535_blanket_item",
                            () -> new collectibles535blanket(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles536sacrificialaltar> COLLECTIBLES_536_SACRIFICIALALTAR_ITEM = ITEMS
            .register
                    ("collectibles_536_sacrificialaltar_item",
                            () -> new collectibles536sacrificialaltar(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles537lilspewer> COLLECTIBLES_537_LILSPEWER_ITEM = ITEMS
            .register
                    ("collectibles_537_lilspewer_item",
                            () -> new collectibles537lilspewer(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles538marbles> COLLECTIBLES_538_MARBLES_ITEM = ITEMS
            .register
                    ("collectibles_538_marbles_item",
                            () -> new collectibles538marbles(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles539mysteryegg> COLLECTIBLES_539_MYSTERYEGG_ITEM = ITEMS
            .register
                    ("collectibles_539_mysteryegg_item",
                            () -> new collectibles539mysteryegg(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles540flatstone> COLLECTIBLES_540_FLATSTONE_ITEM = ITEMS
            .register
                    ("collectibles_540_flatstone_item",
                            () -> new collectibles540flatstone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles541marrow> COLLECTIBLES_541_MARROW_ITEM = ITEMS
            .register
                    ("collectibles_541_marrow_item",
                            () -> new collectibles541marrow(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles542slippedrib> COLLECTIBLES_542_SLIPPEDRIB_ITEM = ITEMS
            .register
                    ("collectibles_542_slippedrib_item",
                            () -> new collectibles542slippedrib(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles543hallowedground> COLLECTIBLES_543_HALLOWEDGROUND_ITEM = ITEMS
            .register
                    ("collectibles_543_hallowedground_item",
                            () -> new collectibles543hallowedground(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles544pointyrib> COLLECTIBLES_544_POINTYRIB_ITEM = ITEMS
            .register
                    ("collectibles_544_pointyrib_item",
                            () -> new collectibles544pointyrib(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles545bookofthedead> COLLECTIBLES_545_BOOKOFTHEDEAD_ITEM = ITEMS
            .register
                    ("collectibles_545_bookofthedead_item",
                            () -> new collectibles545bookofthedead(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles546dadsring> COLLECTIBLES_546_DADSRING_ITEM = ITEMS
            .register
                    ("collectibles_546_dadsring_item",
                            () -> new collectibles546dadsring(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles547divorcepapers> COLLECTIBLES_547_DIVORCEPAPERS_ITEM = ITEMS
            .register
                    ("collectibles_547_divorcepapers_item",
                            () -> new collectibles547divorcepapers(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles548jawbone> COLLECTIBLES_548_JAWBONE_ITEM = ITEMS
            .register
                    ("collectibles_548_jawbone_item",
                            () -> new collectibles548jawbone(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles549brittlebones> COLLECTIBLES_549_BRITTLEBONES_ITEM = ITEMS
            .register
                    ("collectibles_549_brittlebones_item",
                            () -> new collectibles549brittlebones(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles550shovelpiece1> COLLECTIBLES_550_SHOVELPIECE1_ITEM = ITEMS
            .register
                    ("collectibles_550_shovelpiece1_item",
                            () -> new collectibles550shovelpiece1(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles551shovelpiece2> COLLECTIBLES_551_SHOVELPIECE2_ITEM = ITEMS
            .register
                    ("collectibles_551_shovelpiece2_item",
                            () -> new collectibles551shovelpiece2(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<collectibles552momsshovel> COLLECTIBLES_552_MOMSSHOVEL_ITEM = ITEMS
            .register
                    ("collectibles_552_momsshovel_item",
                            () -> new collectibles552momsshovel(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

    public static final RegistryObject<questionmark> QUESTIONMARK_ITEM = ITEMS
            .register
                    ("questionmark_item",
                            () -> new questionmark(new Item.Properties().group(TBOMMain
                                    .ITEM_GROUP)));

}
