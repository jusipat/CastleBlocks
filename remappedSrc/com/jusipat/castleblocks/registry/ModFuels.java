package com.jusipat.castleblocks.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuels {
	public static void registerFuels() {
		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(ModItems.PITCH, 2200);
		registry.add(ModItems.RESIN, 400);
	}
}
