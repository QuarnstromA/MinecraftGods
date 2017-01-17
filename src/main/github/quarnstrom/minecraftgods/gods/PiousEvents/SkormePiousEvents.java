package github.quarnstrom.minecraftgods.gods.PiousEvents;

import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.provider.PietyProvider;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SkormePiousEvents {

    public static void registerEvent(){
        MinecraftForge.EVENT_BUS.register(new SkormeEventHandler());
    }

    public static class SkormeEventHandler
    {
        @SubscribeEvent
        public void mobKill(LivingDeathEvent event){
            if(event.getSource().getSourceOfDamage() instanceof EntityPlayer){
                long pietyValue = 10;
                if(event.getEntity().isCreatureType(EnumCreatureType.CREATURE, false))
                {
                    pietyValue = 50;
                }
                //Player responsible, check worship
                EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
                IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
                if(piety.getCurrentGod() == GodsEnum.SKORME){
                    piety.incrementCurrentPiety(pietyValue);
                    if(!player.worldObj.isRemote) {
                        player.addChatMessage(new TextComponentString(GodsEnum.SKORME.getDisplayName() + " is pleased."));
                    }
                }
            }
        }

    }

}
