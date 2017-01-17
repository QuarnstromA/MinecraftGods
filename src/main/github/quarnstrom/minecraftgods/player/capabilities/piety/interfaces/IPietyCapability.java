package github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces;

import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.piety.impl.PietyData;

public interface IPietyCapability
{

    void setGod(GodsEnum god);

    void setPietyLevel(long pietyLevel);

    PietyData getCurrentPiety();

    GodsEnum getCurrentGod();

    void decrementCurrentPiety(long decrease);

    void incrementCurrentPiety(long increase);
}
