package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public interface IEnchantmentAndHelper {
    default float getEntityAttackDamage(Entity entity, float level) {
        return 0.0f;
    }

    default float getEntityAttackDamageHelper(ItemStack stack, Entity entity) {
        return 0.0f;
    }
}
