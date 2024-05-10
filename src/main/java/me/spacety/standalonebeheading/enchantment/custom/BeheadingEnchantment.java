package me.spacety.standalonebeheading.enchantment.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class BeheadingEnchantment extends Enchantment {
    public BeheadingEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
