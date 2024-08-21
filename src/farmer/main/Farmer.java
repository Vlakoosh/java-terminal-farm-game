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
        seedInventory.put("Carrot", 0);
        seedInventory.put("Fertilizer", 0);
        seedInventory.put("Spray", 0);

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
        if (upgradeLevel == 2){
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
        String command = scanner.nextLine().toUpperCase();

        switch (command){
            case "PLANT" -> {
                System.out.println("- (plant) crops");
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

}
