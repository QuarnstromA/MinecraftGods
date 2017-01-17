package github.quarnstrom.minecraftgods.gods.enums;

import github.quarnstrom.minecraftgods.gods.God;
import github.quarnstrom.minecraftgods.gods.godImpls.Mata;
import github.quarnstrom.minecraftgods.gods.godImpls.NoGod;
import github.quarnstrom.minecraftgods.gods.godImpls.Skorme;
import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PietyData;
import net.minecraft.entity.player.EntityPlayer;

public enum GodsEnum {
    MATA("Mata", new Mata()),
    SKORME("Skorme", new Skorme()),
    NOONE("Noone", new NoGod())
    ;

    private final String displayName;
    private final God godClass;

    GodsEnum(String displayName, God godClass){
        this.displayName = displayName;
        this.godClass = godClass;
    }

    public static GodsEnum toGod(String string){
        if(string.toLowerCase().contains("mata")){
            return MATA;
        }else if(string.toLowerCase().contains("skorme")){
            return SKORME;
        }
        //Add new gods
        else
        {
            return NOONE;
        }
    }


    public String getDisplayName(){
        return displayName;
    }

    public void answerPrayer(EntityPlayer player, PietyData pietyLevel) {
        godClass.answerPrayer(player, pietyLevel);
    }
}
