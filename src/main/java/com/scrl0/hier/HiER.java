package com.scrl0.hier;

import com.scrl0.hier.blocks.ModBlocks;
import com.scrl0.hier.items.ModItems;
import com.scrl0.hier.setup.ClientProxy;
import com.scrl0.hier.setup.IProxy;
import com.scrl0.hier.setup.ModSetup;
import com.scrl0.hier.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HiER.MOD_ID)
public class HiER {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public static final String MOD_ID = "hier";

    private static final Logger LOGGER = LogManager.getLogger();

    public HiER() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

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
            e.getRegistry().register(new ModBlocks().silver_ore);
            e.getRegistry().register(new ModBlocks().zinc_ore);
            e.getRegistry().register(new ModBlocks().chrome_ore);
            e.getRegistry().register(new ModBlocks().lead_ore);
            e.getRegistry().register(new ModBlocks().platinum_ore);
            e.getRegistry().register(new ModBlocks().titanium_ore);
            e.getRegistry().register(new ModBlocks().nickel_ore);

            e.getRegistry().register(new ModBlocks().generator);

            LOGGER.debug("HiER just registered blocks");
        }
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            Item.Properties properties = new Item.Properties().group(setup.itemGroup);

            e.getRegistry().register(new BlockItem(ModBlocks.copper_ore, properties).setRegistryName("copper_ore"));
            /*e.getRegistry().register(new BlockItem(ModBlocks.tin_ore, properties).setRegistryName("tin_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.aluminium_ore, properties).setRegistryName("aluminium_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.silver_ore, properties).setRegistryName("silver_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.zinc_ore, properties).setRegistryName("zinc_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.chrome_ore, properties).setRegistryName("chrome_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.lead_ore, properties).setRegistryName("lead_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.platinum_ore, properties).setRegistryName("platinum_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.titanium_ore, properties).setRegistryName("titanium_ore"));
            e.getRegistry().register(new BlockItem(ModBlocks.nickel_ore, properties).setRegistryName("nickel_ore"));
             */

            e.getRegistry().register(new BlockItem(ModBlocks.generator, properties).setRegistryName("generator"));

            e.getRegistry().register(new ModItems().copper_ingot);
            /*e.getRegistry().register(new ModItems().tin_ingot);
            e.getRegistry().register(new ModItems().aluminium_ingot);
            e.getRegistry().register(new ModItems().silver_ingot);
            e.getRegistry().register(new ModItems().zinc_ingot);
            e.getRegistry().register(new ModItems().chrome_ingot);
            e.getRegistry().register(new ModItems().lead_ingot);
            e.getRegistry().register(new ModItems().platinum_ingot);
            e.getRegistry().register(new ModItems().titanium_ingot);
            e.getRegistry().register(new ModItems().nickel_ingot);
             */

            LOGGER.debug("HiER just registered items");
        }
    }
}