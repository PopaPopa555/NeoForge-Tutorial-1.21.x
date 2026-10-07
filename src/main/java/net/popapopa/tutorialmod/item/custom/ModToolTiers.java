package net.popapopa.tutorialmod.item.custom;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.popapopa.tutorialmod.item.ModItems;
import net.popapopa.tutorialmod.util.ModTags;

public class ModToolTiers {
    public static final Tier BISMUTH = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            1400, 4f, 3, 28, () -> Ingredient.of(ModItems.BISMUTH));
}
