package main;

public class Weapon extends Loot{
    private int damage;

    public Weapon(String name, String rarity, int damage){
        super(name, rarity);
        this.damage = damage;
    }

    public String getEffectDescription(){
        return String.format("%s (%s): %d points of damage%n", super.getName(), super.getRarity(), this.damage);
    }

    @Override
    public String asCsvRow(){
        return String.format("Weapon,%s,%s,%d", super.getName(),  super.getRarity(), this.damage);
    }
}