package main;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    public static LootManager load(String filePath) throws FileNotFoundException{
        LootManager manager = new LootManager();

        Scanner fileScanner = new Scanner(new File(filePath));

        fileScanner.nextLine();

        while (fileScanner.hasNextLine()){
            String[] lootParts = fileScanner.nextLine().split(",");

            Loot loot = LootFactory.create(lootParts);
            manager.add(loot);
        }
        fileScanner.close();
        return manager;
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - " +
            item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    public void save(String filePath) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File(filePath));

        out.println("TYPE,NAME,RARITY,SPECIAL_1");

        for (Loot currLoot : inventory){
            out.println(currLoot.asCsvRow());
        }
        out.close();

    }

     public void add(Loot loot){
        if (loot != null){
            inventory.add(loot);
        }
    }
}