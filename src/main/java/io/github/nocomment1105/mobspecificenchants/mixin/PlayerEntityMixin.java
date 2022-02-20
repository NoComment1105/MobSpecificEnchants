package io.github.nocomment1105.mobspecificenchants.mixin;

import io.github.nocomment1105.mobspecificenchants.registry.enchantments.IEnchantmentAndHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements IEnchantmentAndHelper {
    @Shadow
    public abstract void addEnchantedHitParticles(Entity target);

    //Casting interface to EnchantmentHelper so it can actually use these methods.
    IEnchantmentAndHelper enchantHelp = (IEnchantmentAndHelper) (new EnchantmentHelper());
    //what adds the damage to the entity
    private float entityDamageAdder;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    //Mixin into attack so it can add a value to entityDamageAdder
    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F", shift = At.Shift.AFTER))
    private void mixinAttackForEnchant(Entity target, CallbackInfo ci) {
        entityDamageAdder = enchantHelp.getEntityAttackDamageHelper(this.getMainHandStack(), target);
    }

    //Mixin into attack but after the resetLastAttackedTicks method is called as this gives access to float i which is used for sweeping damage and stuff.
    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;resetLastAttackedTicks()V"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void mixinMultiplyingToEntityDamage(Entity target, CallbackInfo ci, float i) {
        entityDamageAdder *= i;

    }

    //Adding entityDamageAdder to float f which contains the generic attack damage attribute.
    @ModifyVariable(method = "attack", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/player/PlayerEntity;getAttackCooldownProgress(F)F"), index = 2)
    private float mixinValueAdder(float f) {
        return f + entityDamageAdder;
    }


    @Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;onAttacking(Lnet/minecraft/entity/Entity;)V"))
    private void mixinParticleAdder(Entity target, CallbackInfo ci) {
        if (entityDamageAdder > 0.0f) {
            this.addEnchantedHitParticles(target);
        }
    }
}
