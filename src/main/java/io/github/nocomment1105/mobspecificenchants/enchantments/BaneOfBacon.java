package io.github.nocomment1105.mobspecificenchants.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class BaneOfBacon extends Enchantment implements IEnchantmentAndHelper {

    public BaneOfBacon(Enchantment.Rarity weight, EquipmentSlot... slots) {
        super(weight, EnchantmentTarget.WEAPON, slots);
    }
    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getEntityAttackDamage(Entity entity, float level) {
        if (entity.getType() == EntityType.PIG || entity.getType() == EntityType.PIGLIN ||
                entity.getType() == EntityType.PIGLIN_BRUTE) {
            return level * 3f;
        }
        if (entity.getType() == EntityType.ZOMBIFIED_PIGLIN) {
            return level * 2.5f;
        }
        return 0.0f;
    }
}
