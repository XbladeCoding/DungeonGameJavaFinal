/*
This is a simple dungeon crawler game made for the Final Java Project.
It consists of an n-by-n grid of Rooms, where a Player has to defeat Monsters and collect Items to use against those Monsters.
The Player starts with 3 healing Items, to increase playability.
The Player wins when it defeats the Boss (a high-HP and high-damage Monster) or when it collects more than 1000000000 points.
The Player loses when it falls below 0 HP. 

Author: Rohan Balasubramanian
Language: Java 24.0.2
DOC: 5/30/2026
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private boolean gameEnd = false;

    public void mainLoop() {
        System.out.println("Welcome to Simple Dungeon Crawler!");
        System.out.println("Enter a difficulty (1-5): ");
        int diff = readIntInRange(1, 5, "Invalid difficulty. Enter a number from 1 to 5.");
        Room[][] mainGrid = new Room[diff][diff];
        ArrayList<Item> inv = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inv.add(new Item("Basic Heal", 0, 16, 0));
        }

        Player player = new Player(100, 10, 0, 0, inv);
        Dungeon dungeon = new Dungeon(diff, mainGrid);
        dungeon.createDungeon(diff);

        player.setPosx(random.nextInt(diff));
        player.setPosy(random.nextInt(diff));


        while (gameEnd == false) {
            Room currentRoom = mainGrid[player.getPosy()][player.getPosx()];

            System.out.println("You are in a " + currentRoom.getRoomType() + " room.");
            switch (currentRoom.getRoomType()) {
                case "battle":
                    Battle(currentRoom, dungeon, player);
                    break;
                case "loot":
                    Loot(currentRoom, dungeon, player);
                    break;
                case "boss":
                    Boss(currentRoom, dungeon, player, diff);
                    break;
            }

            if (gameEnd) {
                System.exit(0);
            }
            System.out.println("Where would you like to move? (north/south/east/west)");
            String dir = scanner.nextLine();
            player.move(dir);
            if (player.getPosx() == diff) {
                player.setPosx(0);
            }
            if (player.getPosy() == diff) {
                player.setPosy(0);
            }
            if (player.getPosx() == -1) {
                player.setPosx(diff - 1);
            }
            if (player.getPosy() == -1) {
                player.setPosy(diff - 1);
            }
        }

        System.out.println("Thank you for playing the game!");
    }

    public void Battle(Room room, Dungeon dungeon, Player player) {
        boolean battleEnd = false;
        ArrayList<Monster> monsters = room.rollEnemies(room);
        System.out.print("The monster(s) in this room: ");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.print(monsters.get(i).getType() + ", ");
        }
        System.out.println("");

        while (battleEnd == false) {
            System.out.println("Which one to attack first? Enter an index from 0 to " + (monsters.size() - 1) + ".");
            int monsterInd = readIntInRange(0, monsters.size() - 1, "Invalid index.");

            monsters.get(monsterInd).takeDamage(player.getDmg());

            System.out.println("Monster " + monsterInd + " has " + monsters.get(monsterInd).getHp() + "HP left.");

            for (int i = monsters.size() - 1; i >= 0; i--) {
                if (monsters.get(i).getHp() <= 0) {
                    player.addPoints(monsters.get(i).getPoints());
                    monsters.remove(i);
                }
            }

            if (monsters.isEmpty()) {
                System.out.println("You won the battle!");
                System.out.println("");
                break;
            }

            for (int i = 0; i < monsters.size(); i++) {
                int damageTaken = Math.max(0, monsters.get(i).getDmg() - player.getDef());
                player.takeDmg(damageTaken);
                System.out.println("Monster " + i + " has done " + damageTaken + " HP of damage.");
                System.out.println("You have " + player.getHp() + "HP remaining.");
            }

            if (player.getHp() <= 0) {
                System.out.println("You died!");
                System.out.println("Your points: " + player.getPoints());
                endGame();
                gameEnd = true;
                break;
            }

            System.out.println("Would you like to heal? (Y/N)");
                if (readCommandChar("Invalid input.") == 'Y') {
                if (player.getInventory().isEmpty()) {
                        System.out.println("No items available.");
                } else {
                System.out.println("Here are the items available: ");
                for (int i = 0; i < player.getInventory().size(); i++) {
                    System.out.print(player.getInventory().get(i).getName());
                }
                System.out.println("Which one would you like to use? (Enter index)");
                int healind = readIntInRange(0, player.getInventory().size() - 1, "Invalid index.");
                player.heal(player.getInventory().get(healind));
                System.out.println("Your HP: " + player.getHp());
                }
            }
        }
    }

    public void Loot(Room room, Dungeon dungeon, Player player) {
        ArrayList<Item> loot = room.rollLoot(room);
        int turns = 0;

        while (turns < 6) {
            System.out.println("What would you like to do?");
            System.out.println("You can heal (H), loot (L), or equip (E).");
            switch (readCommandChar("Invalid input.")) {
                case 'H':
                    System.out.println("Would you like to heal? (Y/N)");
                    if (readCommandChar("Invalid input.") == 'Y') {
                        if (player.getInventory().isEmpty()) {
                                System.out.println("No items available.");
                        } else {
                        int healind;
                        System.out.println("Here are the items available: ");
                        for (int i = 0; i < player.getInventory().size(); i++) {
                            System.out.print(player.getInventory().get(i).getName());
                        }
                        System.out.println("Which one would you like to use? (Enter index)");
                        healind = readIntInRange(0, player.getInventory().size() - 1, "Invalid index.");
                        player.heal(player.getInventory().get(healind));
                        System.out.println("Your HP: " + player.getHp());
                        }
                    }
                    break;
                case 'L':
                    System.out.println("Here are the items in the room: ");
                    for (int i = 0; i < loot.size(); i++) {
                        System.out.print(loot.get(i).getName() + ", ");
                    }
                    System.out.println("Choose one: (enter index)");
                    int itemInd = readIntInRange(0, loot.size() - 1, "Invalid index.");
                    player.pickUpItem(loot.get(itemInd));
                    loot.remove(itemInd);
                    break;
                case 'E':
                    if (player.getInventory().isEmpty()) {
                        System.out.println("No items available.");
                        break;
                    } else {
                        System.out.println("Here is your current inventory: ");
                        for (int i = 0; i < player.getInventory().size(); i++) {
                            System.out.print(player.getInventory().get(i).getName() + ", ");
                        }
                        System.out.println("What shall you equip? (give an index)");
                        int equipind = readIntInRange(0, player.getInventory().size() - 1, "Invalid index.");
                        player.equip(player.getInventory().get(equipind));
                        System.out.println("New stats: Def " + player.getDef() + ", Dmg " + player.getDmg());
                        break;
                    }
                default:
                    System.out.println("Invalid input.");
                    continue;
            }
            turns++;
        }
    }

    public void Boss(Room room, Dungeon dungeon, Player player, int diff) {
        boolean gameOver = false;
        int bhp = 0;
        int bdmg = 0;
        switch (diff) {
            case 1:
                bhp = 100;
                bdmg = 20;
                break;
            case 2:
                bhp = 200;
                bdmg = 30;
                break;
            case 3:
                bhp = 250;
                bdmg = 35;
                break;
            case 4:
                bhp = 300;
                bdmg = 40;
                break;
            case 5:
                bhp = 500;
                bdmg = 50;
                break;
        }

        Monster boss = new Monster(bhp, bdmg, "Boss", 1000);

        System.out.println("This is the boss room. Defeat the boss to win.");

        while (gameOver == false) {
            System.out.println("Attack or Heal? (A/H)");
            char decision = readCommandChar("Invalid input.");
            if (decision == 'A') {
                boss.takeDamage(player.getDmg());
                System.out.println("The boss now has " + boss.getHp() + "HP.");
            } else if (decision == 'H') {
                if (player.getInventory().isEmpty()) {
                        System.out.println("No items available.");
                        break;
                } else {
                    int healind;
                    System.out.println("Here are the items available: ");
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        System.out.print(player.getInventory().get(i).getName());
                    }
                    System.out.println("Which one would you like to use? (Enter index 0-n)");
                    healind = readIntInRange(0, player.getInventory().size() - 1, "Invalid index.");
                    player.heal(player.getInventory().get(healind));
                    System.out.println("Your HP: " + player.getHp());
                }
            } else {
                System.out.println("Invalid input.");
                continue;
            }

            if (boss.getHp() <= 0) {
                gameEnd = true;
                System.out.println("You won the game!");
                System.out.println("Your score was: " + player.getPoints());
                System.exit(0);
            }

            int bossDamageTaken = Math.max(0, bdmg - player.getDef());
            System.out.println("The boss deals " + bossDamageTaken + "HP of damage to you.");
            player.takeDmg(bossDamageTaken);
            System.out.println("You now have " + player.getHp() + "HP left.");

            if (player.getHp() <= 0) {
                gameEnd = true;
                System.out.println("You died!");
                System.out.println("Your score was: " + player.getPoints());
                System.exit(0);
            }
        }
    }

    public void endGame() {
        System.out.println("The game has ended.");
    }

    private char readCommandChar(String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (!input.isEmpty()) {
                return input.charAt(0);
            }

            System.out.println(errorMessage);
        }
    }

    private int readIntInRange(int min, int max, String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println(errorMessage);
        }
    }
}