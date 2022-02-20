package io.github.nocomment1105.mobspecificenchants.mixin;

import io.github.nocomment1105.mobspecificenchants.registry.enchantments.IEnchantmentAndHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin implements IEnchantmentAndHelper {
    @Shadow
    private static void forEachEnchantment(EnchantmentHelper.Consumer consumer, ItemStack stack) { }

    public float getEntityAttackDamageHelper(ItemStack stack, Entity entity) {

        MutableFloat mutableFloat = new MutableFloat();
        forEachEnchantment((enchantment, level) -> {
            IEnchantmentAndHelper helper = (IEnchantmentAndHelper) enchantment;
            mutableFloat.add(helper.getEntityAttackDamage(entity, level));
        }, stack);

        return mutableFloat.floatValue();
    }
}

