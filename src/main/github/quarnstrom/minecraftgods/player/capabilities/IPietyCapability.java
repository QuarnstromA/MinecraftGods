package github.quarnstrom.minecraftgods.player.capabilities;

import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.piety.Piety;

public interface IPietyCapability
{

    void setGod(GodsEnum god);

    void setPietyLevel(long pietyLevel);

    Piety getCurrentPiety();

    GodsEnum getCurrentGod();

    void decrementCurrentPiety(long decrease);

    void incrementCurrentPiety(long increase);
}
