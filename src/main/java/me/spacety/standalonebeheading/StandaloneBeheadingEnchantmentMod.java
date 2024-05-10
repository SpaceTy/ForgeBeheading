package me.spacety.standalonebeheading;

import me.spacety.standalonebeheading.enchantment.ModEnchantments;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(StandaloneBeheadingEnchantmentMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class StandaloneBeheadingEnchantmentMod {
    public static final String MODID = "standalonebeheading";

    public StandaloneBeheadingEnchantmentMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(new ModEnchantments());
    }

    @SubscribeEvent
    public static void setupClient(final FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
    }

}
