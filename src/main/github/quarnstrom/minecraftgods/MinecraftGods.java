package github.quarnstrom.minecraftgods;

import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import github.quarnstrom.minecraftgods.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name=Reference.MODNAME, version = Reference.VERSION)
public class MinecraftGods
{
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    public static Logger logger;

    @Mod.Instance(value = Reference.MODID)
    public static MinecraftGods instance;



    @EventHandler
    public void preInit(FMLPreInitializationEvent preInit)
    {
        logger = preInit.getModLog();
        proxy.preInit();

    }

    @EventHandler
    public void init(FMLInitializationEvent init)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent postInit)
    {
        proxy.postInit();
    }

    @CapabilityInject(IPietyCapability.class)
    private static void capRegistered(Capability<IPietyCapability> cap)
    {
        System.out.println("IExampleCapability was registered wheeeeee!");
    }



}
