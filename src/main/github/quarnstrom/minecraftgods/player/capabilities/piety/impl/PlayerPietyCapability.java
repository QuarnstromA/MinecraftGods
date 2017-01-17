package github.quarnstrom.minecraftgods.player.capabilities.piety.impl;
import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.piety.handler.PietyCapabilityHandler;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import net.minecraftforge.common.MinecraftForge;

public class PlayerPietyCapability implements IPietyCapability
{
    GodsEnum currentlyWorshipped;
    PietyData currentPiety;

    public PlayerPietyCapability()
    {
        currentlyWorshipped = GodsEnum.NOONE;
        currentPiety = new PietyData(0);
    }

    @Override
    public void setGod(GodsEnum god)
    {
        currentlyWorshipped = god;
    }

    @Override
    public void setPietyLevel(long pietyLevel)
    {
        currentPiety.pietyLevel=pietyLevel;
    }

    @Override
    public PietyData getCurrentPiety()
    {
        return currentPiety;
    }

    @Override
    public GodsEnum getCurrentGod()
    {
        return currentlyWorshipped;
    }

    @Override
    public void decrementCurrentPiety(long decrease)
    {
        currentPiety.decrementPiety(decrease);
    }

    @Override
    public void incrementCurrentPiety(long increase)
    {
        currentPiety.incrementPiety(increase);
    }

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new PietyCapabilityHandler());
    }

}
