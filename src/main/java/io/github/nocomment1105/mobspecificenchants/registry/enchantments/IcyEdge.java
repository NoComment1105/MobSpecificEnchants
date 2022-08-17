package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class IcyEdge extends Enchantment implements IEnchantmentAndHelper {
    public IcyEdge(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 12 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof FireAspectEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        // This can be a null check because target is already an instanceof Entity
        if (target != null) {
            // Using the Vanilla freeze allows automatic applying of mechanics such as freeze weakness and immunity which certain mobs have
            if (level == 1) {
                target.setFrozenTicks(240);
            } else {
                target.setFrozenTicks(320);
            }
            if (target.getType() == EntityType.BLAZE || target.getType() == EntityType.GHAST || target.getType() == EntityType.MAGMA_CUBE
                    || target.getType() == EntityType.HOGLIN || target.getType() == EntityType.PIGLIN || target.getType() == EntityType.PIGLIN_BRUTE
                    || target.getType() == EntityType.ZOMBIFIED_PIGLIN || target.getType() == EntityType.STRIDER || target.getType() == EntityType.ZOGLIN) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 4 * level, level));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 2 * level, level - 1));
            } else {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level - 1));
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getEntityAttackDamage(Entity entity, float level) {
        if (entity.getType() == EntityType.BLAZE || entity.getType() == EntityType.GHAST || entity.getType() == EntityType.MAGMA_CUBE
                || entity.getType() == EntityType.HOGLIN || entity.getType() == EntityType.PIGLIN || entity.getType() == EntityType.PIGLIN_BRUTE
                || entity.getType() == EntityType.ZOMBIFIED_PIGLIN || entity.getType() == EntityType.STRIDER || entity.getType() == EntityType.ZOGLIN) {
            return level;
        }
        return 0.0f;
    }
}
