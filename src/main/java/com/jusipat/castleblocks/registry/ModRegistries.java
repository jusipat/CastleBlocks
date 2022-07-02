package com.jusipat.castleblocks.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
	public static void registerModFuels() {
		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(ModItems.PITCH, 2200);
	}
}
