package io.github.nocomment1105.mobspecificenchants.enchantments;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface IEnchantmentAndHelper
{
    default float getEntityAttackDamage(LivingEntity entity, int level)
    {
        return 0.0f;
    }

    default float getEntityAttackDamageHelper(ItemStack stack, LivingEntity entity)
    {
        return 0.0f;
    }
}
