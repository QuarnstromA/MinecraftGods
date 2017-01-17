package github.quarnstrom.minecraftgods.player;
import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PlayerPietyCapability;

public class CommonPlayerInit {

    public static void preInit(){

        PlayerPietyCapability.register();
    }

    public static void init(){

    }

    public static void postInit() {

    }

}
