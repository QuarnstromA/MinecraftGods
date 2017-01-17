package github.quarnstrom.minecraftgods.player.capabilities.piety.impl;

public class PietyData {
    public long pietyLevel;

    public PietyData(long initialPietyLevel){
        this.pietyLevel = initialPietyLevel;
    }

    public void incrementPiety(long increase){
        pietyLevel=pietyLevel+increase;
    }

    public void decrementPiety(long decrease){
        pietyLevel=pietyLevel-decrease;
        if(pietyLevel < 0){
            pietyLevel = 0;
        }
    }
}
