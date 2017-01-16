package github.quarnstrom.minecraftgods.player.capabilities;
import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.piety.Piety;

public class PlayerPietyCapability implements IPietyCapability
{
    GodsEnum currentlyWorshipped;
    Piety currentPiety;

    public PlayerPietyCapability()
    {
        currentlyWorshipped = GodsEnum.NOONE;
        currentPiety = new Piety(0);
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
    public Piety getCurrentPiety()
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
}
