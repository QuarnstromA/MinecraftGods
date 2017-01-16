package github.quarnstrom.minecraftgods.player;
import github.quarnstrom.minecraftgods.player.capabilities.handler.CapabilityHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonPlayerInit {

    public static void preInit(){
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }

    public static void init(){

    }

    public static void postInit() {

    }

}
