package com.jusipat.castleblocks.registry;
import com.jusipat.castleblocks.CastleBlocksMod;
import com.jusipat.castleblocks.fluid.PitchFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
	public static final FlowableFluid PITCH_STILL = register("pitch_still", new PitchFluid.Still());
	public static final FlowableFluid PITCH_FLOWING = register("pitch_flowing", new PitchFluid.Flowing());

	private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
		return Registry.register(Registries.FLUID, new Identifier(CastleBlocksMod.MOD_ID, name), flowableFluid);
	}
}