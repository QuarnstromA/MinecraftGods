package github.quarnstrom.minecraftgods.piety;

public class Piety {
    public long pietyLevel;

    public Piety(long initialPietyLevel){
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
