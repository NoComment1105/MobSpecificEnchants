package io.github.nocomment1105.mobspecificenchants;

import io.github.nocomment1105.mobspecificenchants.registry.enchantments.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class MobSpecificEnchants implements ModInitializer {
    public static final String MOD_ID = "mobspecificenchants";

    private static final BaneOfIllagers BANE_OF_ILLAGERS = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_illagers"), new BaneOfIllagers(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    private static final BaneOfBacon BANE_OF_BACON = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_bacon"), new BaneOfBacon(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));

    private static final BaneOfEnders BANE_OF_ENDERS = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "bane_of_enders"), new BaneOfEnders(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    private static final CubeSlicer CUBE_SLICER = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "cube_slicer"), new CubeSlicer(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));

    private static final WitherWaster WITHER_WASTER = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "wither_waster"), new WitherWaster(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    private static final FlySwatter FLY_SWATTER = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "fly_swatter"), new FlySwatter(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

    private static final IcyEdge ICY_EDGE = Registry.register(Registries.ENCHANTMENT, new Identifier(
            MOD_ID, "icy_edge"), new IcyEdge(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));


    @Override
    public void onInitialize() {
    }
}
