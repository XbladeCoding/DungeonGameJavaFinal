import java.util.ArrayList;
import java.util.Random;

public class Room {
    int posx;
    int posy;
    String roomType;
    private static final Random random = new Random();

    public Room(int posx, int posy, String roomType) {
        this.posx = posx;
        this.posy = posy;
        this.roomType = roomType;
    }

    public int getPosx() {
        return this.posx;
    }

    public int getPosy() {
        return this.posy;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public ArrayList<Item> rollLoot(Room room) {
        ArrayList<Item> loot = new ArrayList<>();

        //NOTE: All loot rooms will have 4 chests.

        if (room.getRoomType().equals("loot")) {
            while (loot.size() < 4) {
                // 1. Shield (50%)
                if (random.nextDouble() < 0.50) {
                    loot.add(new Item("Shield", 0, 0, 5));
                }
                // 2. Bulwark (12.5%)
                if (random.nextDouble() < 0.125) {
                    loot.add(new Item("Bulwark", 0, 0, 15));
                }
                // 3. Diamond Sword (25%)
                if (random.nextDouble() < 0.25) {
                    loot.add(new Item("Diamond Sword", 20, 0, 0));
                }
                // 4. Excalibur (6.25%)
                if (random.nextDouble() < 0.0625) {
                    loot.add(new Item("Excalibur", 40, 0, 0));
                }
                // 5. Small Heal (100%)
                if (random.nextDouble() < 1.00) {
                    loot.add(new Item("Small Heal", 0, 15, 0));
                }
                // 6. Large Heal (35%)
                if (random.nextDouble() < 0.35) {
                    loot.add(new Item("Large Heal", 0, 50, 0));
                }
                // 7. Revive (10%)
                if (random.nextDouble() < 0.10) {
                    loot.add(new Item("Revive", 0, 100, 0));
                }
            }
        }

        return loot;
    }

    public ArrayList<Monster> rollEnemies(Room room) {
        ArrayList<Monster> monsters = new ArrayList<>();

        //NOTE: Monsters will never be more than 3.
        int numMonsters = random.nextInt(1,4);

        if (room.roomType.equals("battle")) {
            while (monsters.size() < numMonsters) {
                double roll = random.nextDouble() * 100.0;
                // 1. Garfield (1% chance: 0.0 to 1.0)
                if (roll < 1.0) {
                    monsters.add(new Monster(1, 0, "Garfield", 1000000000));
                } 
                // 2. Tank (49.5% chance: 1.0 to 50.5)
                else if (roll < 50.5) {
                    monsters.add(new Monster(150, 10, "Tank", 20));
                } 
                // 3. Light (49.5% chance: 50.5 to 100.0)
                else {
                    monsters.add(new Monster(50, 5, "Light", 10));
                }
            }
        }

        return monsters;
    }
}
