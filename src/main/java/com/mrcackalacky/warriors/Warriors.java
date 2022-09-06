package com.mrcackalacky.warriors;

import com.mrcackalacky.warriors.entity.WEntityTypes;
import com.mrcackalacky.warriors.entity.client.WarriorRenderer;
import com.mrcackalacky.warriors.item.WItems;
import com.mrcackalacky.warriors.villager.WVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Warriors.MOD_ID)
public class Warriors
{
    public static final String MOD_ID = "warriors";


    private static final Logger LOGGER = LogManager.getLogger();


    public Warriors()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        WItems.register(eventBus);
        WVillagers.register(eventBus);
        WEntityTypes.register(eventBus);



        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        GeckoLib.initialize();
    }

    private void clientSetup(final FMLClientSetupEvent event){
        EntityRenderers.register(WEntityTypes.WARRIOR.get(), WarriorRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
