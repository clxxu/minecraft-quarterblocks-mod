package com.redfeng.test2;

import com.redfeng.test2.init.BlockList;
import com.redfeng.test2.init.ItemList;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Test2.MOD_ID)
public class Test2
{

    public static final ItemGroup MOD_TAB = new Test2.TutorialItemGroup("mod_group");
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "test";
    public static Test2 instance;

    public Test2() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        BlockList.NO_ITEM_BLOCK.register(modEventBus);

    }

    /*public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockList.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(TutorialItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("Registered BlockItems!");
    }*/

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockList.TEA_BUSH.get(), RenderType.func_228643_e_());  //getCutout()
    }

    public static class TutorialItemGroup extends ItemGroup {
        private TutorialItemGroup(String label) {
            super(label);
        }
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockList.SMALL_STEAMER.get());
        }
    }
}
