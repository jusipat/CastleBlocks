package com.jusipat.castleblocks.mixin;


import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;

@Mixin(Blocks.class)
public class BlocksMixin {

	@Inject(at = @At("HEAD"), method = "")
	private void tick(CallbackInfo info) {

	}
}
