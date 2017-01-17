package github.quarnstrom.minecraftgods.gods;

import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PietyData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public abstract class God{

    public void answerPrayer(EntityPlayer player, PietyData piety)
    {
        sendGodMessage(player, "No one hears your prayer.");
    }

    public void sacrificeToGod(EntityPlayer player, Object sacrifice)
    {
        sendGodMessage(player, "Your sacrifice goes unnoticed.");
    }

    public void sendGodMessage(EntityPlayer player, String message)
    {
        if(!player.worldObj.isRemote){
            player.addChatMessage(new TextComponentString(message));
        }
    }
}
