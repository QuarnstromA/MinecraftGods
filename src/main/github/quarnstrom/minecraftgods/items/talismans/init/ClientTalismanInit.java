package github.quarnstrom.minecraftgods.items.talismans.init;

import github.quarnstrom.minecraftgods.proxy.ClientProxy;
import net.minecraft.item.Item;

public class ClientTalismanInit {

    public static void preInit(){
        for(Item item : CommonTalismanInit.talismans){
            ClientProxy.registerRenders(item);
        }
    }

    public static void init(){

    }

    public static void postInit(){

    }


}
