package com.jusipat.castleblocks.block.fluid;
import com.jusipat.castleblocks.CastleBlocksMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
	public static final FlowableFluid PITCH_STILL = register("pitch_still", new PitchFluid.Still());
	public static final FlowableFluid PITCH_FLOWING = register("pitch_flowing", new PitchFluid.Flowing());

	private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
		return Registry.register(Registry.FLUID, new Identifier(CastleBlocksMod.MOD_ID, name), flowableFluid);
	}
}