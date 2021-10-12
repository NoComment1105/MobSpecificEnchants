package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class BaneOfEnders extends Enchantment implements IEnchantmentAndHelper {
    public BaneOfEnders(Enchantment.Rarity weight, EquipmentSlot... slots) {
        super(weight, EnchantmentTarget.WEAPON, slots);
    }

    @Override
    public int getMinPower(int level) {
        return 14 + (level - 1) * 9;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof DamageEnchantment) && !(other instanceof WitherWaster)
                && !(other instanceof BaneOfIllagers) && !(other instanceof BaneOfBacon) && !(other instanceof CubeSlicer);
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
        if (entity.getType() == EntityType.ENDERMAN || entity.getType() == EntityType.ENDERMITE || entity.getType() == EntityType.SHULKER) {
            return level * 3f;
        }
        if (entity instanceof EnderDragonPart) {
            return level * 3f;
        }
        return 0.0f;
    }

}
