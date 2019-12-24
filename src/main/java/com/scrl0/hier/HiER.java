package com.scrl0.hier;

import com.scrl0.hier.setup.ClientProxy;
import com.scrl0.hier.setup.IProxy;
import com.scrl0.hier.setup.ModSetup;
import com.scrl0.hier.setup.ServerProxy;
import com.scrl0.hier.utility.MaterialType;
import net.minecraft.block.Block;
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

    static MaterialType[] copy = MaterialType.values().clone();

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

            for(int i = 0; i < MaterialType.values().length; i++) {
                e.getRegistry().register(copy[i].getOre());
                LOGGER.debug(MOD_ID + " just registered " + copy[i].getOre());
            }

            LOGGER.debug(MOD_ID + " just registered blocks");
        }
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {


            for(int i = 0; i < MaterialType.values().length; i++) {
                e.getRegistry().register(copy[i].getOreItem());
                LOGGER.debug(MOD_ID + " just registered " + copy[i].getOreItem());
            }

            for(int i = 0; i < MaterialType.values().length; i++) {
                e.getRegistry().register(copy[i].getItem());
                LOGGER.debug(MOD_ID + " just registered " + copy[i].getItem());
            }

            LOGGER.debug(MOD_ID + " just registered items");
        }
    }
}