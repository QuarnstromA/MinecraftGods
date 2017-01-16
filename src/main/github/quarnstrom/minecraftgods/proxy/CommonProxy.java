package github.quarnstrom.minecraftgods.proxy;

import github.quarnstrom.minecraftgods.block.CommonBlockInit;
import github.quarnstrom.minecraftgods.gods.CommonGodInit;
import github.quarnstrom.minecraftgods.item.init.CommonItemInit;
import github.quarnstrom.minecraftgods.piety.IPietyMap;
import github.quarnstrom.minecraftgods.player.CommonPlayerInit;
import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.PlayerPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.storage.PlayerPietyStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {

    public void preInit(){
        IPietyMap.register();
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
