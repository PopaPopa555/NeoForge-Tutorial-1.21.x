package net.popapopa.tutorialmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.popapopa.tutorialmod.TutorialMod;
import net.popapopa.tutorialmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(TutorialMod.MODID + ":bloodwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
