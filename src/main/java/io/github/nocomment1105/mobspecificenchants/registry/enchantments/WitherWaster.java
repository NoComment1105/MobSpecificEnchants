package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class WitherWaster extends Enchantment implements IEnchantmentAndHelper {

    public WitherWaster(Enchantment.Rarity weight, EquipmentSlot... slots) {
        super(weight, EnchantmentTarget.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment) && !(other instanceof BaneOfIllagers)
                && !(other instanceof BaneOfEnders) && !(other instanceof BaneOfBacon) && !(other instanceof CubeSlicer);
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
        if (entity.getType() == EntityType.WITHER || entity.getType() == EntityType.WITHER_SKELETON) {
            return level * 3.2f;
        }
        return 0.0f;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
