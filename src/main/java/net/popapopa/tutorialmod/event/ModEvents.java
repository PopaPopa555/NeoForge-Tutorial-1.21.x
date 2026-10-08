package net.popapopa.tutorialmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.popapopa.tutorialmod.TutorialMod;
import net.popapopa.tutorialmod.item.custom.HammerItem;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    public static final Set<BlockPos> HARVESTED_BLOCK = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event){
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammerItem && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCK.contains(initialBlockPos)){
                return;
            }

            for (BlockPos pos : HammerItem.getBlockToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammerItem.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))){
                    continue;
                }

                HARVESTED_BLOCK.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCK.remove(pos);
            }
        }
    }
}
