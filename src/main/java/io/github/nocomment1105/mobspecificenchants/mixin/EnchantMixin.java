package io.github.nocomment1105.mobspecificenchants.mixin;

import io.github.nocomment1105.mobspecificenchants.enchantments.IEnchantmentAndHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Enchantment.class)
public abstract class EnchantMixin implements IEnchantmentAndHelper
{
    @Override
    public float getEntityAttackDamage(Entity entity, int level) {
        return IEnchantmentAndHelper.super.getEntityAttackDamage(entity, level);
    }
}
