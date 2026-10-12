package net.popapopa.tutorialmod.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.popapopa.tutorialmod.TutorialMod;
import net.popapopa.tutorialmod.item.ModItems;

@EventBusSubscriber(modid = TutorialMod.MODID, bus = EventBusSubscriber.Bus.GAME, value= Dist.CLIENT)
public class ModClientEvent {
    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event){
        if(event.getPlayer().isUsingItem() &&
                event.getPlayer().getUseItem().getItem() == ModItems.KAUPEN_BOW.get()){
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 20f;
            if(deltaTicks > 1f){
                deltaTicks = 1f;
            } else{
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
