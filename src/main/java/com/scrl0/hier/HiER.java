package com.scrl0.hier;

import com.scrl0.hier.blocks.ModBlocks;
import com.scrl0.hier.setup.ClientProxy;
import com.scrl0.hier.setup.IProxy;
import com.scrl0.hier.setup.ModSetup;
import com.scrl0.hier.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("hier")
public class HiER {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public HiER() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> e) {
            e.getRegistry().register(new ModBlocks().copper_ore);
            e.getRegistry().register(new ModBlocks().tin_ore);
            e.getRegistry().register(new ModBlocks().aluminium_ore);
        }
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            Item.Properties properties = new Item.Properties().group(setup.itemGroup);
            e.getRegistry().register(new BlockItem(ModBlocks.copper_ore, properties).setRegistryName("copper_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.tin_ore, properties).setRegistryName("tin_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.aluminium_ore, properties).setRegistryName("aluminium_ore"));
        }
    }
}