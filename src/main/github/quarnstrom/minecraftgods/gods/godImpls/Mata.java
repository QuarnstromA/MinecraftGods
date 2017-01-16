package github.quarnstrom.minecraftgods.gods.godImpls;

import github.quarnstrom.minecraftgods.gods.God;
import github.quarnstrom.minecraftgods.piety.Piety;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class Mata extends God
{
    @Override
    public void answerPrayer(EntityPlayer player, Piety piety) {
            sendGodMessage(player, "Piety with Skorme: "+ piety.pietyLevel);
            if (piety.pietyLevel >= 0 && piety.pietyLevel < 100) {
                sendGodMessage(player, "Mata knows little of you.");
            } else if (piety.pietyLevel >= 100) {
                player.setHealth(player.getMaxHealth());
                player.addChatMessage(new TextComponentString("Mata protects."));
            }
    }

    @Override
    public void sacrificeToGod(EntityPlayer player, Object sacrifice) {

    }
}
