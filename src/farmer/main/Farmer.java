package farmer.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Farmer {
    int money;
    int currentDay;
    ArrayList<Crop> crops;
    int maxCrops;

    Map<String, Integer> seedInventory;
    Map<String, Integer> itemInventory;


    int sprayAmount;
    int fertilizerAmount;

    int upgradeLevel;

    public Farmer() {
        this.money = 50;
        this.currentDay = 1;
        this.sprayAmount = 0;
        this.fertilizerAmount = 0;
        this.upgradeLevel = 1;

        seedInventory = new HashMap<>();
        seedInventory.put("carrot", 0);
        seedInventory.put("potato", 1);
        itemInventory = new HashMap<>();
        itemInventory.put("fertilizer", 0);
        itemInventory.put("spray", 0);

        this.maxCrops = 2;
        crops = new ArrayList<>();
    }


    public void chooseAction() {
        String prompt = "";
        ArrayList<Actions> options = new ArrayList<>();

        if (crops.size() < maxCrops) {
            options.add(Actions.PLANT);
        }
        if (!crops.isEmpty()) {
            options.add(Actions.WATER);
            options.add(Actions.INSPECT);
        }
        if (sprayAmount > 0) {
            options.add(Actions.SPRAY);
        }
        if (fertilizerAmount > 0) {
            options.add(Actions.FERTILIZE);
        }
        options.add(Actions.BUY);
        if (currentDay > 5) {
            options.add(Actions.UPGRADE);
        }
        options.add(Actions.SLEEP);

        if (upgradeLevel == 1) {
            System.out.println("""
                                                        .
                                                      .'.`.
                                                    .'.' `.`.
                                      %%          .'.' ___ `.`.
                                     %%%%       .'.'  |_|_|  `.`.
                                    %%%%%%    .'.'    |_|_|    `.`.
                                    %%%%%     '||     |_|_|     ||'
                                     %%%       ||               ||
                                      H        ||   ___     __  ||
                                      H        ||  |_|_|   |  | ||
                                      H        ||  |_|_|   |  | ||
                                      H        ||          |  | || \s
                    |\\//|\\/|/\\//\\||//|\\|||/\\//|//\\||\\//||//|\\\\|\\||\\/|/\\//\\||////|//\\/
                    """);
        }
        if (upgradeLevel == 2) {
            System.out.println("""
                                                        .
                                                      .'.`.
                                                    .'.' `.`.
                                      %%          .'.' ___ `.`.
                                     %%%%       .'.'  |_|_|  `.`.
                                    %%%%%%    .'.'    |_|_|    `.`.
                    __              %%%%%     '||     |_|_|     ||'
                     /\\              %%%       ||               ||
                    /  \\              H        ||   ___     __  ||
                    ||||              H        ||  |_|_|   |  | ||
                    ||||              H        ||  |_|_|   |  | ||
                    ||||              H        ||          |  | || \s
                    |\\//|\\/|/\\//\\||//|\\|||/\\//|//\\||\\//||//|\\\\|\\||\\/|/\\//\\||////|//\\/
                    """);
        }

        System.out.println("It's day #" + currentDay);
        System.out.println("What would you like to do today?\n");

        for (Actions action : options) {
            switch (action) {
                case PLANT -> {
                    System.out.println("- (plant) crops");
                }
                case WATER -> {
                    System.out.println("- (water) crops");
                }
                case INSPECT -> {
                    System.out.println("- (inspect) crops");
                }
                case SPRAY -> {
                    System.out.println("- (spray) crops");
                }
                case FERTILIZE -> {
                    System.out.println("- (fertilize) crops");
                }
                case BUY -> {
                    System.out.println("- (buy) items and seeds");
                }
                case UPGRADE -> {
                    System.out.println("- (upgrade) your farm");
                }
                case SLEEP -> {
                    System.out.println("- (sleep) until the next day");
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        String commands = scanner.nextLine().toUpperCase();
        String command = commands.split(" ")[0];
        String[] args = commands.toLowerCase().split(" ");

        switch (command) {
            case "PLANT" -> {
                if (crops.size() == maxCrops){
                    System.out.println("You don't have enough space to plant anything. \nEither harvest or destroy a plant to make space, or buy more land in upgrades store");
                    break;
                }
                if (!hasSeeds()) {
                    System.out.println("You do not have any seeds in your inventory. Buy some at the store");
                } else if (args.length > 1) {
                    if (seedInventory.get(args[1]) != null && seedInventory.get(args[1]) > 0) {
                        System.out.println("You planted " + args[1]);
                        crops.add(new Crop());
                    } else {
                        System.out.println("You cannot plant " + args[1] + ". Either this crop doesn't exist or you don't have enough of it");
                    }

                } else {
                    System.out.println("\nWhat would you like to plant?\n");
                    for (Map.Entry<String, Integer> seed : seedInventory.entrySet()) {
                        if (seed.getValue() > 0) {
                            System.out.println("- " + seed.getKey().toLowerCase() + " (you have " + seed.getValue() + " left)");
                        }
                    }
                    String cropChoice = scanner.nextLine().toLowerCase();
                    if (seedInventory.get(cropChoice) != null && seedInventory.get(cropChoice) > 0) {
                        System.out.println("You planted " + cropChoice);
                        crops.add(new Crop());
                    } else {
                        System.out.println("You cannot plant " + cropChoice + ". Either this crop doesn't exist or you don't have enough of it");
                    }

                }
            }
            case "WATER" -> {
                System.out.println("- (water) crops");
            }
            case "INSPECT" -> {
                System.out.println("- (inspect) crops");
            }
            case "SPRAY" -> {
                System.out.println("- (spray) crops");
            }
            case "FERTILIZE" -> {
                System.out.println("- (fertilize) crops");
            }
            case "BUY" -> {
                System.out.println("- (buy) items and seeds");
            }
            case "UPGRADE" -> {
                System.out.println("- (upgrade) your farm");
            }
            case "SLEEP" -> {
                System.out.println("- (sleep) until the next day");
            }
        }

    }

    public void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public boolean hasSeeds() {
        for (Map.Entry<String, Integer> seed : seedInventory.entrySet()) {
            if (seed.getValue() > 0) return true;
        }
        return false;
    }

}
