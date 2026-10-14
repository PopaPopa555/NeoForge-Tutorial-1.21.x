package net.popapopa.tutorialmod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier qCountPlacement, PlacementModifier qHeightRange){
        return List.of(qCountPlacement, InSquarePlacement.spread(), qHeightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int qCount, PlacementModifier qHeightRange){
        return orePlacement(CountPlacement.of(qCount), qHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int qCount, PlacementModifier qHeightRange){
        return orePlacement(RarityFilter.onAverageOnceEvery(qCount), qHeightRange);
    }
}
