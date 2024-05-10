package me.spacety.standalonebeheading.enchantment;

import me.spacety.standalonebeheading.StandaloneBeheadingEnchantmentMod;
import me.spacety.standalonebeheading.enchantment.custom.BeheadingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEnchantments {
    public static final Enchantment BEHEADING_ENCHANT = new BeheadingEnchantment();

    @SubscribeEvent
    public static void onRegisterEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(BEHEADING_ENCHANT.setRegistryName(StandaloneBeheadingEnchantmentMod.MODID, "beheading_enchantment"));
    }
}
