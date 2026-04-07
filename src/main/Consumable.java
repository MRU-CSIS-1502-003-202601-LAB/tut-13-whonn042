package main;

public class Consumable extends Loot{
    private int restoreAmount;

    public Consumable(String name, String rarity, int restoreAmount){
        super(name, rarity);
        this.restoreAmount = restoreAmount;
    }

    public String getEffectDescription(){
        return String.format("%s (%s): %d uses left%n", super.getName(), super.getRarity(), this.restoreAmount);
    }

    @Override
    public String asCsvRow(){
        return String.format("Consumable,%s,%s,%d", super.getName(),  super.getRarity(), this.restoreAmount);
    }
}