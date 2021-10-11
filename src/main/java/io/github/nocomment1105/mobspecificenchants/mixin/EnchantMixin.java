package io.github.nocomment1105.mobspecificenchants.mixin;

import io.github.nocomment1105.mobspecificenchants.registry.enchantments.IEnchantmentAndHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Enchantment.class)
public abstract class EnchantMixin implements IEnchantmentAndHelper
{
    @Override
    public float getEntityAttackDamage(Entity entity, float level) {
        return IEnchantmentAndHelper.super.getEntityAttackDamage(entity, level);
    }
}
