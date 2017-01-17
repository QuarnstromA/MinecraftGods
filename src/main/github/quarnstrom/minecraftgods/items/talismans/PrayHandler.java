package github.quarnstrom.minecraftgods.items.talismans;

import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.provider.PietyProvider;
import net.minecraft.entity.player.EntityPlayer;

public class PrayHandler {

    public static void pray(EntityPlayer player){
        IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
        piety.getCurrentGod().answerPrayer(player, piety.getCurrentPiety());
    }
}
