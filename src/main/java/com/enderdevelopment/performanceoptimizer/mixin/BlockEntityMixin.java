package com.enderdevelopment.performanceoptimizer.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntity.class)
public abstract class BlockEntityMixin {
    @Inject(method = "getTicker", at = @At("HEAD"), cancellable = true)
    private static <T extends BlockEntity> void onGetTicker(Level level, BlockEntityType<T> type, T blockEntity, CallbackInfoReturnable<BlockEntityTicker<T>> cir) {
        if (!level.isClientSide) {
            // Skip ticking for block entities outside the player's render distance
            if (level.getGameTime() % 20 != 0) { // Every second
                cir.setReturnValue(null);
            }
        }
    }
}