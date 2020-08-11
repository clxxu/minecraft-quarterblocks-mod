package com.redfeng.test2.init;

import com.redfeng.test2.Test2;
import com.redfeng.test2.blocks.MySlabBlock;
import com.redfeng.test2.blocks.QSlabBlock;
import com.redfeng.test2.blocks.SmallSteamerBlock;
import com.redfeng.test2.blocks.TeaCropsBlock;
import net.minecraft.block.BedrockBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockList {

    public static final DeferredRegister<Block> NO_ITEM_BLOCK = new DeferredRegister<>(ForgeRegistries.BLOCKS,
            Test2.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Test2.MOD_ID);

    public static final RegistryObject<Block> TEA_BUSH = NO_ITEM_BLOCK.register("tea_crop",
            () -> new TeaCropsBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));

    public static final RegistryObject<Block> SMALL_STEAMER = NO_ITEM_BLOCK.register("small_steamer",
            () -> new SmallSteamerBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.NETHER_WART)));

    public static final RegistryObject<Block> EXAMPLE_SLAB = BLOCKS.register("example_slab",
            () -> new QSlabBlock(Block.Properties.from(EXAMPLE_BLOCK.get())));

    /*public static final RegistryObject<Block> SMALL_STEAMER_SLAB = BLOCKS.register("small_steamer_slab",
            () -> new QSlabBlock(Block.Properties.from(SMALL_STEAMER.get())));*/
}
