package github.quarnstrom.minecraftgods.gods.godImpls;

import github.quarnstrom.minecraftgods.gods.God;
import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PietyData;
import net.minecraft.entity.player.EntityPlayer;

public class Skorme extends God
{

    @Override
    public void answerPrayer(EntityPlayer player, PietyData piety ) {
            sendGodMessage(player, "PietyData with Skorme: "+ piety.pietyLevel);
            if (piety.pietyLevel >= 0 && piety.pietyLevel < 100) {
                player.setHealth(player.getHealth() - 1);
                sendGodMessage(player, "SKORME IS DISPLEASED.");
            } else if (piety.pietyLevel >= 100) {
                sendGodMessage(player, "Skorme's wrath strikes out.");
                player.capabilities.disableDamage = true;
                player.worldObj.createExplosion(player, player.posX, player.posY, player.posZ, 2.0F, false);
                player.capabilities.disableDamage = false;
            }
    }

    @Override
    public void sacrificeToGod(EntityPlayer player, Object sacrifice) {

    }
}
