package io.github.nocomment1105.mobspecificenchants;

import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfEnders;
import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfIllagers;
import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfPigs;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MobSpecificEnchants implements ModInitializer {
    public static String MOD_ID = "mobspecificenchants";

    private static final BaneOfIllagers BANE_OF_ILLAGERS = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_illagers"), new BaneOfIllagers(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
    private static final BaneOfPigs BaneOfPigs = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_pigs"), new BaneOfPigs(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
    private static final BaneOfEnders BaneOfEnders = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_enders"), new BaneOfEnders(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    //private static final Enchantment FISH = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "bane_of_guardians"), new DamageEnchantment(Enchantment.Rarity.UNCOMMON, 4, EquipmentSlot.MAINHAND));

    @Override
    public void onInitialize() {
    }
}
