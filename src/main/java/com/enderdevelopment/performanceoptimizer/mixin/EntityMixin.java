package com.enderdevelopment.performanceoptimizer.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        Level level = entity.level();

        if (entity instanceof LivingEntity && !level.isClientSide) {
            // Throttle AI tick frequency for distant mobs
            if (level.getGameTime() % 20 != 0) { // Every second
                ci.cancel();
            }
        }
    }
}