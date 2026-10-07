package net.popapopa.tutorialmod.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.popapopa.tutorialmod.TutorialMod;

import java.util.function.UnaryOperator;

public class ModDataComponent {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE =
            DeferredRegister.createDataComponents(TutorialMod.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES =
            register("coordinates", builder -> builder.persistent(BlockPos.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register
            (String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator){
        return DATA_COMPONENT_TYPE.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPE.register(eventBus);
    }
}
