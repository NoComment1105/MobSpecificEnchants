package io.github.nocomment1105.mobspecificenchants.registry.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class FlySwatter extends Enchantment implements IEnchantmentAndHelper{

    public FlySwatter(Rarity weight, EquipmentSlot... slots) {
        super(weight, EnchantmentTarget.WEAPON, slots);
    }

    @Override
    public int getMinPower(int level) {
        return 15 + 10 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof BaneOfBacon) && !(other instanceof BaneOfEnders)
                && !(other instanceof CubeSlicer) && !(other instanceof WitherWaster);
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
        if (entity.getType() == EntityType.GHAST || entity.getType() == EntityType.PARROT || entity.getType() == EntityType.BEE
        || entity.getType() == EntityType.PHANTOM || entity.getType() == EntityType.BAT || entity.getType() == EntityType.BLAZE
        || entity.getType() == EntityType.VEX) {
            return level * 2.5f;
        }
        return 0.0f;
    }
}
