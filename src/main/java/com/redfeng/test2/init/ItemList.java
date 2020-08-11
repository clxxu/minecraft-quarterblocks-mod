package com.redfeng.test2.init;

import com.redfeng.test2.Test2;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sun.jvm.hotspot.opto.Block;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Test2.MOD_ID);
    public static final RegistryObject<Item> SMALL_STEAMER_ITEM = ITEMS.register("small_steamer",
            () -> new BlockItem(BlockList.SMALL_STEAMER.get(), new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> TEA_PLANT_SEEDS = ITEMS.register("tea_crop",
            () -> new BlockItem(BlockList.TEA_BUSH.get(), new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
            () -> new BlockItem(BlockList.EXAMPLE_BLOCK.get(), new Item.Properties().group(Test2.MOD_TAB)));

    public static final RegistryObject<Item> EXAMPLE_SLAB_ITEM = ITEMS.register("example_slab",
            () -> new BlockItem(BlockList.EXAMPLE_SLAB.get(), new Item.Properties().group(Test2.MOD_TAB)));

    //    public static final RegistryObject<Item> SMALL_STEAMER_SLAB_ITEM = ITEMS.register("small_steamer_slab",
//            () -> new BlockItem(BlockList.SMALL_STEAMER_SLAB.get(), new Item.Properties().group(ItemGroup.FOOD)));
}
