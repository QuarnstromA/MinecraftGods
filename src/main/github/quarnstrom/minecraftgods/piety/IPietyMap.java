package github.quarnstrom.minecraftgods.piety;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.provider.PietyProvider;
import github.quarnstrom.minecraftgods.player.capabilities.storage.PlayerPietyStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class IPietyMap implements IPietyCapability, ICapabilityProvider{

    @CapabilityInject(IPietyCapability.class)
    public static final Capability<IPietyCapability> PLAYER_PIETY_CAPABILITY = null;

    public static final ResourceLocation ID = new ResourceLocation(Reference.MODID, ":IPietyCapability");

    HashMap<GodsEnum, Piety> pietyLevels;
    Piety currentPiety;
    GodsEnum currentGod;
    EntityPlayer player;

    public IPietyMap(EntityPlayer player){
        pietyLevels = new HashMap<GodsEnum, Piety>();
        for(GodsEnum god : GodsEnum.values()){
            pietyLevels.put(god, new Piety(0));
        }
        currentPiety = pietyLevels.get(GodsEnum.NOONE);
        currentGod = GodsEnum.NOONE;
        this.player = player;
    }

    public GodsEnum getCurrentGod(){
        return currentGod;
    }

    @Override
    public void setGod(GodsEnum god)
    {
        currentGod = god;
    }

    @Override
    public void setPietyLevel(long pietyLevel)
    {
        this.currentPiety.pietyLevel=pietyLevel;
    }

    public Piety getCurrentPiety(){
        return currentPiety;
    }

    public void changeWorship(GodsEnum newGod){
        currentGod = newGod;
        currentPiety = pietyLevels.get(newGod);
    }

    public void incrementCurrentPiety(long increase){
        currentPiety.incrementPiety(increase);
    }

    public void decrementCurrentPiety(long decrease){
        currentPiety.decrementPiety(decrease);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return PietyProvider.PIETY_CAP != null && capability == PietyProvider.PIETY_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (PietyProvider.PIETY_CAP != null && capability == PietyProvider.PIETY_CAP) return PietyProvider.PIETY_CAP.cast(this);
        return null;    }

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new PietyEventHandler());
    }

    public static class PietyEventHandler{
        @SubscribeEvent
        public void attachCapability(AttachCapabilitiesEvent event){
            if(event.getObject() instanceof EntityPlayer){
                event.addCapability(ID, new IPietyMap((EntityPlayer)event.getObject()));
            }
        }
    }
}
