package io.github.nocomment1105.mobspecificenchants;

import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfIllagers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MobSpecificEnchants implements ModInitializer {
    public static String MOD_ID = "mobspecificenchants";

    public static final BaneOfIllagers BANE_OF_ILLAGERS = new BaneOfIllagers(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND);



    //private static final Enchantment BaneOfPigs = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_pigs"), new DamageEnchantment(Enchantment.Rarity.UNCOMMON, 4, EquipmentSlot.MAINHAND));
    //private static final Enchantment BaneOfEnders = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_enders"), new DamageEnchantment(Enchantment.Rarity.UNCOMMON, 5, EquipmentSlot.MAINHAND));
    //private static final Enchantment FISH = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_guardians"), new DamageEnchantment(Enchantment.Rarity.UNCOMMON, 4, EquipmentSlot.MAINHAND));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_illagers"), BANE_OF_ILLAGERS);
    }
}
