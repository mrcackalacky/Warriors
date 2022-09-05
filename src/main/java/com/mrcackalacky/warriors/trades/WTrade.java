package com.mrcackalacky.warriors.trades;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class WTrade {


    public void initElements () {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void init(FMLCommonSetupEvent event) {}

    public void serverLoad(FMLServerStartingEvent event) {}
}
