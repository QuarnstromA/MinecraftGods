package github.quarnstrom.minecraftgods.player.capabilities.piety.handler;
import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.items.talismans.impl.ItemTalismanMata;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.provider.PietyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PietyCapabilityHandler
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
        giveInfoBookIfFirstLogin(player);
        initializePlayerPiety(player);
    }

    private void giveInfoBookIfFirstLogin(EntityPlayer player)
    {
        NBTTagCompound playerData = player.getEntityData();
        if(!playerData.getBoolean(Reference.MODID+"seenBefore"))
        {
            playerData.setBoolean(Reference.MODID+"seenBefore", true);
            //player.inventory.addItemStackToInventory();
        }
    }

    private void initializePlayerPiety(EntityPlayer player) {
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
