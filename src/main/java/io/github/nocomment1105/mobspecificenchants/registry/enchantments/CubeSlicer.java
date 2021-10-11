package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class CubeSlicer extends Enchantment implements IEnchantmentAndHelper {

    public CubeSlicer(Enchantment.Rarity weight, EquipmentSlot... slots) {
        super(weight, EnchantmentTarget.WEAPON, slots);
    }
    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment) && !(other instanceof BaneOfIllagers)
                && !(other instanceof BaneOfEnders) && !(other instanceof BaneOfBacon) && !(other instanceof CubeSlicer);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getEntityAttackDamage(Entity entity, float level) {
        if (entity.getType() == EntityType.SLIME || entity.getType() == EntityType.MAGMA_CUBE) {
            return level * 3f;
        }
        return 0.0f;
    }
}
