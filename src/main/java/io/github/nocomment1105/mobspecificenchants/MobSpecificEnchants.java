package io.github.nocomment1105.mobspecificenchants;

import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfEnders;
import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfIllagers;
import io.github.nocomment1105.mobspecificenchants.enchantments.BaneOfBacon;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MobSpecificEnchants implements ModInitializer {
    public static final String MOD_ID = "mobspecificenchants";

    private static final BaneOfIllagers BANE_OF_ILLAGERS = Registry.register(Registry.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_illagers"), new BaneOfIllagers(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    private static final BaneOfBacon BANE_OF_PIGS = Registry.register(Registry.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_bacon"), new BaneOfBacon(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    private static final BaneOfEnders BANE_OF_ENDERS = Registry.register(Registry.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_enders"), new BaneOfEnders(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));


    @Override
    public void onInitialize() {
    }
}
