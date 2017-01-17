package github.quarnstrom.minecraftgods.proxy;

import github.quarnstrom.minecraftgods.blocks.init.CommonBlockInit;
import github.quarnstrom.minecraftgods.gods.CommonGodInit;
import github.quarnstrom.minecraftgods.items.init.CommonItemInit;
import github.quarnstrom.minecraftgods.player.CommonPlayerInit;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PlayerPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.storage.PlayerPietyStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {

    public void preInit(){
        //IPietyMap.register();
        CommonGodInit.preInit();
        CommonItemInit.preInit();
        CommonPlayerInit.preInit();
        CommonBlockInit.preInit();
    }

    public void init (){
        CapabilityManager.INSTANCE.register(IPietyCapability.class, new PlayerPietyStorage(), PlayerPietyCapability.class);
        CommonItemInit.init();
        CommonGodInit.init();
        CommonPlayerInit.init();
        CommonBlockInit.init();
    }

    public void postInit(){
        CommonItemInit.postInit();
        CommonGodInit.postInit();
        CommonPlayerInit.postInit();
        CommonBlockInit.postInit();
    }
}
