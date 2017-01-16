package github.quarnstrom.minecraftgods.player.capabilities.handler;
import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.provider.PietyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CapabilityHandler
{
    public static final ResourceLocation PIETY_CAP = new ResourceLocation(Reference.MODID, "piety");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event)
    {
        if(!(event.getObject() instanceof EntityPlayer))
        {
            return;
        }
        event.addCapability(PIETY_CAP, new PietyProvider());
    }

    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event)
    {
        EntityPlayer player = event.player;
        IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
        System.out.println("PLAYER: " + player.getUniqueID());
        Capability<IPietyCapability> pietyCap = PietyProvider.PIETY_CAP;
        player.addChatMessage(new TextComponentString("You are currently worshipping " + piety.getCurrentGod().getDisplayName()
                + " with a piety of " + piety.getCurrentPiety().pietyLevel));
    }

    @SubscribeEvent
    public void onPlayerLogsOut(PlayerEvent.PlayerLoggedOutEvent event)
    {
        EntityPlayer player = event.player;
        IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
        Capability<IPietyCapability> pietyCap = PietyProvider.PIETY_CAP;
    }
}
