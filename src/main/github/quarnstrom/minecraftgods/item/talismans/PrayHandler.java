package github.quarnstrom.minecraftgods.item.talismans;

import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.provider.PietyProvider;
import net.minecraft.entity.player.EntityPlayer;

public class PrayHandler {

    public static void pray(EntityPlayer player){
        IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
        piety.getCurrentGod().answerPrayer(player, piety.getCurrentPiety());
    }
}
